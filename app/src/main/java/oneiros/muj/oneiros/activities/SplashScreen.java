package oneiros.muj.oneiros.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import oneiros.muj.oneiros.R;



/**
 * Created by aesher on 9/8/2017.
 */

public class SplashScreen extends AppCompatActivity {



ImageView imageView,transactionimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        imageView = (ImageView) findViewById(R.id.moto);
        transactionimage = (ImageView) findViewById(R.id.OHNO);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.blink);
        imageView.startAnimation(animation);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, transactionimage,transactionimage.getTransitionName()).toBundle();
                startActivity(i,bundle);

            }
        }; handler.postDelayed(runnable,1000);


    }
}
