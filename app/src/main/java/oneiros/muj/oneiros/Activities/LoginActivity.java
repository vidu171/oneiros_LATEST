package oneiros.muj.oneiros.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.katepratik.msg91api.MSG91;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import oneiros.muj.oneiros.DAO.FetchCounterDAO;
import oneiros.muj.oneiros.DAO.FetchUserDAO;
import oneiros.muj.oneiros.R;

/**
 * Created by vidu on 10/9/17.
 */

public class LoginActivity extends AppCompatActivity {
    Button login;
    LinearLayout layout;
    MSG91 msg91;
    long value;
    boolean valueC;
    FrameLayout focus_master;
    String errorMsg;
    Boolean isOpen=true;

    EditText ONO_username, ONO_email,ONO_registration,ONO_university,ONO_phonenumber,ONO_password;
    TextView textView, ForgetPassword;
    MaterialDialog progressDialog;
    private FirebaseDatabase mFirebaseData;
    private DatabaseReference mMessagesDatabaseReference;
    private FirebaseAuth mAuth;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;
    private FirebaseAuth.AuthStateListener mAuthListener;


    String NName = new String();
    String RRegistration = new String() ;
    String UUniversity = new String();
    String PPhone = new String();
    String EEmail = new String();
    String PPassword = new String();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        focus_master = findViewById(R.id.layout_l);
        msg91 = new MSG91("176579Aj3z4wdz9g59ca63b3");
        ONO_username = findViewById(R.id.UserName);
        ONO_email = findViewById(R.id.Email);
        ONO_registration = findViewById(R.id.Rid);
        ONO_university = findViewById(R.id.University);
        ONO_phonenumber = findViewById(R.id.PhoneNumber);
        textView = findViewById(R.id.hint_text);
        ONO_password = findViewById(R.id.Password);
        layout = findViewById(R.id.login_to_register);
        login = findViewById(R.id.Login);
        progressDialog= new MaterialDialog.Builder(this)
                .progress(true, 0)
                .cancelable(false)
                .build();
        ForgetPassword = findViewById(R.id.forgot_password);

        focus_master.requestFocus();

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
//                    startActivity(new Intent(LoginActivity.this, SplashScreen.class));
//                    finish();
                } else {
                    // User is signed out
                    Log.d("FAIL ", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
//

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen){
                    isOpen= false;
                    ForgetPassword.setVisibility(View.VISIBLE);
                    ONO_username.setVisibility(View.GONE);
                    ONO_registration.setVisibility(View.GONE);
                    ONO_university.setVisibility(View.GONE);
                    ONO_phonenumber.setVisibility(View.GONE);
                    login.setText("SignIn");
                    ONO_email.requestFocus();
                    textView.setText("Don't have an account? SignUp ");

                    if (ONO_email.hasFocus()) {
                        ONO_password.requestFocus();
                    }
                }

                else{
                    isOpen = true;
                    ForgetPassword.setVisibility(View.INVISIBLE);
                    ONO_username.setVisibility(View.VISIBLE);
                    ONO_registration.setVisibility(View.VISIBLE);
                    ONO_university.setVisibility(View.VISIBLE);
                    ONO_phonenumber.setVisibility(View.VISIBLE);
                    ONO_username.requestFocus();
                    login.setText("SignUp");
                    textView.setText("Already have an account? SignIn ");

                    if (ONO_username.hasFocus()) {
                        ONO_email.requestFocus();
                    }

                    if (ONO_email.hasFocus()) {
                        ONO_registration.requestFocus();
                    }

                    if (ONO_registration.hasFocus()) {
                        ONO_university.requestFocus();
                    }

                    if (ONO_university.hasFocus()) {
                        ONO_phonenumber.requestFocus();
                    }

                    if (ONO_phonenumber.hasFocus())
                        ONO_password.requestFocus();
                        }
                if (ONO_password.hasFocus()) {
                    ONO_password.requestFocus();
                }

            }
        });





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NName = ONO_username.getText().toString();
                RRegistration = ONO_registration.getText().toString();
                 UUniversity = ONO_university.getText().toString();
                PPhone = ONO_phonenumber.getText().toString();
                EEmail = ONO_email.getText().toString();
                 PPassword = ONO_password.getText().toString();


                if(isOpen){

                    if(Expanded_check(NName,RRegistration,UUniversity,PPhone)&&Collapsed_check(EEmail,PPassword)){
                        //Todo SignUp
                        PPassword = PPassword.trim();
                        EEmail = EEmail.trim();
                        final String finalEEmail1 = EEmail;
                        final String finalEEmail2 = EEmail;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.setContent("Signing Up");
                                progressDialog.show();
                            }
                        });
                        mAuth.createUserWithEmailAndPassword(EEmail, PPassword)
                                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Log.w("LoginActivity", task.getException());
                                        try {
                                            errorMsg = task.getException().getMessage();
                                        } catch (Exception e) {
                                        }
                                        if (!task.isSuccessful()) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    progressDialog.dismiss();
                                                    Toast.makeText(LoginActivity.this, "" + errorMsg,
                                                            Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                        } else {
                                            Log.w("Status", "Entered");
                                            incrementCounter(FetchCounterDAO.getInstance().counterRef);
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
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.setContent("Signing In");
                                progressDialog.show();
                            }
                        });
                        mAuth.signInWithEmailAndPassword(EEmail, PPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull final Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            progressDialog.dismiss();
                                        }
                                    });
                                    Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    final Future<UserCreds> listFutureForUserData = FetchUserDAO
                                            .getInstance()
                                            .getUserData(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                    AsyncTask.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                while(!listFutureForUserData.isDone()) {
                                                    Thread.sleep(500);
                                                }
                                                final UserCreds User = listFutureForUserData.get();
                                                if (User != null) {
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Log.w("-->", mMessagesDatabaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Name").toString());
                                                            editor.putString("Name", User.Name).commit();
                                                            editor.putString("EmailId", User.EmailId.trim().toLowerCase()).commit();
                                                            editor.putString("Contact", User.Contact).commit();
                                                            editor.putString("RegNo.", User.RegNum).commit();
                                                            editor.putString("University", User.University).commit();
                                                            editor.putString("WalkinId", String.valueOf(User.WalkinId));
                                                            editor.putString("UserId", task.getResult().getUser().getUid()).commit();
                                                            progressDialog.dismiss();
                                                            startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                                                            finish();
                                                        }
                                                    });
                                                }

                                            } catch (InterruptedException e) {

                                            } catch (ExecutionException e) {

                                            }
                                        }
                                    });

                                }
                            }
                        });
                    }


                }
            }
        });



        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Collapsed_check(ONO_email.getText().toString().trim().toLowerCase(), "nullnull")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setContent("Please Wait");
                            progressDialog.show();
                        }
                    });
                    mAuth.sendPasswordResetEmail(ONO_email.getText().toString().trim().toLowerCase())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                progressDialog.dismiss();
                                                Toast.makeText(LoginActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
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
            ONO_university.setError("University name cannot be left empty");
            return false;
        }



        else
        if(Phone.length()!=10){
            ONO_phonenumber.setError("Phone number invalid");
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
            ONO_email.setError("Please enter a valid email");
            return false;
        }


        else
        if(Password.length()<6){
            ONO_password.setError("Password should be a minimum of 6 characters");
            return false;
        }

        else {return true;}



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
    public void incrementCounter(DatabaseReference counterRef) {
        counterRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(final MutableData currentData) {
                if (currentData.getValue() == null) {
                    currentData.setValue(10000);
                    value=(Long) currentData.getValue();
                } else {
                    value=(Long) currentData.getValue() + 1;
                    currentData.setValue(value);
//                    Log.w("Time", String.valueOf(System.currentTimeMillis()));
                }
//
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    System.out.println("Firebase counter increment failed.");
                } else {
                    new MyTask().execute();
                }
            }
        });
    }

    private class MyTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            UserCreds user = new UserCreds(NName, EEmail.trim(), PPhone.trim(), RRegistration, UUniversity, (int) value);
            mMessagesDatabaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
            editor.putString("Name", NName);
            editor.putString("EmailId", EEmail);
            editor.putString("Contact", PPhone);
            editor.putString("RegNo.", RRegistration);
            editor.putString("University", UUniversity);
            editor.putString("UserId", FirebaseAuth.getInstance().getCurrentUser().getUid());
            editor.putString("WalkinId", String.valueOf(value));
            editor.commit();

        }

        @Override
        protected String doInBackground(Void... params) {//new
            String smsString = "Thank you for registering with Oneiros '17. Your credentials are: %0AEmail: " + EEmail + "%0APassword: " + PPassword + "%0AWalk-In Id: " + String.valueOf(value);
            Connection.Response res = null;
            try {
                res = Jsoup.connect("http://api.msg91.com/api/sendhttp.php?authkey=176579Aj3z4wdz9g59ca63b3&mobiles=" + PPhone + "&message=" + smsString + "&sender=ONODGT&route=4&unicode=1")
                        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                        .timeout(10000)
                        .execute();
                System.out.println(res.parse().toString());
                res = Jsoup.connect("http://siddharthjaidka.me/ono/signup.php")
                        .userAgent("Chrome/19.0.1042.0")
                        .timeout(1000000)
                        .validateTLSCertificates(false)
                        .followRedirects(true)
                        .data("email", EEmail, "password", PPassword, "walkin", String.valueOf(value), "qr", FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .method(Connection.Method.POST)
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String result = "";
            try {
                if (res.parse().toString().toLowerCase().contains("success"))
                    result = "success";
                else
                    result = "failed";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            if (result.equals("success")) {
                progressDialog.dismiss();
                startActivity(new Intent(LoginActivity.this, SplashScreen.class));
                finishAffinity();
            }
        }
    }
}
