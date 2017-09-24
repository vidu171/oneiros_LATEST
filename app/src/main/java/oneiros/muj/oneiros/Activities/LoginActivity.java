package oneiros.muj.oneiros.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

import oneiros.muj.oneiros.R;

/**
 * Created by vidu on 10/9/17.
 */

public class LoginActivity extends AppCompatActivity {
    Button login;
    LinearLayout layout;
    Boolean isOpen=true;
    EditText ONO_username, ONO_email,ONO_registration,ONO_university,ONO_phonenumber,ONO_password;
    TextView textView;
    private FirebaseDatabase mFirebaseData;
    private DatabaseReference mMessagesDatabaseReference;
    private FirebaseAuth mAuth;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ONO_username = findViewById(R.id.UserName);
        ONO_email = findViewById(R.id.Email);
        ONO_registration = findViewById(R.id.Rid);
        ONO_university = findViewById(R.id.University);
        ONO_phonenumber = findViewById(R.id.PhoneNumber);
        ONO_password = findViewById(R.id.Password);
        layout = findViewById(R.id.login_to_register);
        login = findViewById(R.id.Login);
        textView = findViewById(R.id.hint_text);




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


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen){
                    isOpen= false;
                    ONO_username.setVisibility(View.GONE);
                    ONO_registration.setVisibility(View.GONE);
                    ONO_university.setVisibility(View.GONE);
                    ONO_phonenumber.setVisibility(View.GONE);
                    login.setText("SignIn");
                    textView.setText("Don't have an account? SignUp ");
                }
                else{
                    isOpen = true;
                    ONO_username.setVisibility(View.VISIBLE);
                    ONO_registration.setVisibility(View.VISIBLE);
                    ONO_university.setVisibility(View.VISIBLE);
                    ONO_phonenumber.setVisibility(View.VISIBLE);
                    login.setText("Signup");
                    textView.setText("Already have an account? SignIn ");
                }
            }
        });





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String NName = ONO_username.getText().toString();
                final String RRegistration = ONO_registration.getText().toString();
                final String UUniversity = ONO_university.getText().toString();
                final String PPhone = ONO_phonenumber.getText().toString();
                String EEmail = ONO_email.getText().toString();
                String PPassword = ONO_password.getText().toString();


                if(isOpen){

                    if(Expanded_check(NName,RRegistration,UUniversity,PPhone)&&Collapsed_check(EEmail,PPassword)){
                        //Todo Signup
                        PPassword = PPassword.trim();
                        EEmail = EEmail.trim();
                        final String finalEEmail1 = EEmail;
                        final String finalEEmail2 = EEmail;
                        mAuth.createUserWithEmailAndPassword(EEmail, PPassword)
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
                                            editor.putString("Name",NName).commit();
                                            editor.putString("EmailId", finalEEmail1).commit();
                                            editor.putString("Contact",PPhone).commit();
                                            editor.putString("RegNo.",RRegistration).commit();
                                            editor.putString("University",UUniversity).commit();
                                            editor.putString("UserId",task.getResult().getUser().getUid()).commit();

                                            UserCreds user = new UserCreds(NName, finalEEmail2.trim(), PPhone.trim(), RRegistration,UUniversity);
                                            mMessagesDatabaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);

                                            startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                                            finish();
                                        }
                                    }
                                });
                    }


                }




                else {
                    if(Collapsed_check(EEmail,PPassword)){

                        //Todo Login
                       PPassword = PPassword.trim();
                        EEmail = EEmail.trim().toLowerCase();

                        final String finalEEmail = EEmail;
                        mAuth.signInWithEmailAndPassword(EEmail, PPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    // there was an error
                                    Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    editor.putString("Name",NName).commit();
                                    editor.putString("EmailId", finalEEmail.trim().toLowerCase()).commit();
                                    editor.putString("Contact",PPhone).commit();
                                    editor.putString("RegNo.",RRegistration).commit();
                                    editor.putString("University",UUniversity).commit();
                                    editor.putString("UserId",task.getResult().getUser().getUid()).commit();
                                    startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                                    finish();
                                }
                            }
                        });
                    }


                }
            }
        });



    }



    public Boolean Expanded_check(String Name, String Registration, String University, String Phone){
        if(TextUtils.isEmpty(Name))
        {
            ONO_username.setError("Name cannot be left empty");
            return false;
        }

        else
        if (TextUtils.isEmpty(Registration)){
            ONO_registration.setError("Registration number cannot be left empty");
            return false;
        }

        else
        if (TextUtils.isEmpty(University)){
            ONO_university.setError("University Name cannot be left empty");
            return false;
        }



        else
        if(Phone.length()!=10){
            ONO_phonenumber.setError("Phone Number invalid");
            return false;
        }

        else {return true;}

    }


    public Boolean Collapsed_check(String Email, String Password){
        if(TextUtils.isEmpty(Email))
        {
            ONO_email.setError("Email cannot be left empty");
            return false;
        }

        else
        if (TextUtils.isEmpty(Password)){
            ONO_password.setError("Password cannot be left empty");
            return false;
        }

        else
        if(!Email.contains("@")){
            ONO_email.setError("Please enter a valid emain");
            return false;
        }


        else
        if(Password.length()<6){
            ONO_password.setError("Password should be a minimum of 6 characters");
            return false;
        }

        else {return true;}



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

}
