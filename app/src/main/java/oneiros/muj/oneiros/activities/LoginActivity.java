package oneiros.muj.oneiros.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import oneiros.muj.oneiros.R;

/**
 * Created by vidu on 10/9/17.
 */

public class LoginActivity extends AppCompatActivity {
    EditText Name, RegNum, Contact, Password, EmailId, University;
    Button SignUp, SignIn;
    TextView ForgetPassword;

    private FirebaseDatabase mFirebaseData;
    private DatabaseReference mMessagesDatabaseReference;

    private FirebaseAuth mAuth;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Name = (EditText) findViewById(R.id.formName);
        RegNum = (EditText) findViewById(R.id.formRegNo);
        Contact = (EditText) findViewById(R.id.formPhoneNo);
        University = (EditText) findViewById(R.id.formUniversity);
        Password = (EditText) findViewById(R.id.formpassword);
        SignUp = (Button) findViewById(R.id.SignUpButton);
        SignIn = (Button) findViewById(R.id.SignInButton);
        EmailId = (EditText) findViewById(R.id.form_Email);
        ForgetPassword = (TextView) findViewById(R.id.resetpassword);
        mAuth = FirebaseAuth.getInstance();
        pref = getSharedPreferences("UserCredentials", MODE_PRIVATE);
        editor = pref.edit();
        mFirebaseData = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseData.getReference().child("Users");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                    finish();
                } else {
                    // User is signed out
                    Log.d("FAIL ", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        mAuth.addAuthStateListener(mAuthListener);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   String pass = Password.getText().toString().trim();
                    String email = EmailId.getText().toString().trim();
                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        editor.putString("Name",Name.getText().toString()).commit();
                                        editor.putString("EmailId",EmailId.getText().toString()).commit();
                                        editor.putString("Contact",Contact.getText().toString()).commit();
                                        editor.putString("RegNo.",RegNum.getText().toString()).commit();
                                        editor.putString("University",University.getText().toString()).commit();
                                        editor.putString("UserId",task.getResult().getUser().getUid()).commit();
                                        startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                                        finish();
                                 }
                                }
                            });

            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String pass = Password.getText().toString().trim();
                    String email = EmailId.getText().toString().trim();
                    mAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Log.w("LoginActivity",task.getException());
                                        Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(LoginActivity.this, "Successs" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                        editor.putString("Name",Name.getText().toString()).commit();
                                        editor.putString("EmailId",EmailId.getText().toString()).commit();
                                        editor.putString("Contact",Contact.getText().toString()).commit();
                                        editor.putString("RegNo.",RegNum.getText().toString()).commit();
                                        editor.putString("University",University.getText().toString()).commit();
                                        editor.putString("UserId",task.getResult().getUser().getUid()).commit();

                                        UserCreds user = new UserCreds(Name.getText().toString(),EmailId.getText().toString().trim(), Contact.getText().toString().trim(), RegNum.getText().toString(),University.getText().toString());
                                        mMessagesDatabaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);

                                        startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                                        finish();
                                    }
                                }
                            });

            }
        });

        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.sendPasswordResetEmail(EmailId.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }



    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public class UserCreds {
        public String Name;
        public String EmailId;
        public String Contact;
        public String RegNum;
        public String University;


        public UserCreds(String Name, String EmailId, String Contact, String RegNum, String University){

            this.Name = Name;
            this.EmailId = EmailId;
            this.RegNum = RegNum;
            this.Contact = Contact;
            this.University = University;
        }

    }

}
