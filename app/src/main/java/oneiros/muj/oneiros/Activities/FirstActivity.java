package oneiros.muj.oneiros.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by vidu on 26/9/17.
 */

public class FirstActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(FirstActivity.this, SplashScreen.class));
            finish();
        }
        else {
            // User is signed out
            startActivity(new Intent(FirstActivity.this, LoginActivity.class));
            finish();
        }


    }
}
