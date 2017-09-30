package oneiros.muj.oneiros.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by vidu on 26/9/17.
 */

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getSharedPreferences("UserCredentials",MODE_PRIVATE);
        String s = pref.getString("Name",null);
        if(FirebaseAuth.getInstance().getCurrentUser()!=null && s != null  ){
            Log.w("-->", "I am being called");
            startActivity(new Intent(FirstActivity.this, SplashScreen.class));
            finish();
        }
        else {
            // User is signed out
            startActivity(new Intent(FirstActivity.this, LoginActivity.class));
            finish();
            Log.w("-->", "I am being called s = "+s+ "<---");
        }


    }


}
