package oneiros.muj.oneiros.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 9/27/2017.
 */

public class Easter_egg extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easter_egg);

        imageView = findViewById(R.id.easter);


        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(getApplicationContext()).load(R.drawable.easteregg).into(imageViewTarget);


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Snackbar.make(imageView,"Glad you could make it to the Easter Egg menu ;D",Snackbar.LENGTH_LONG).show();
            }
        };handler.postDelayed(runnable,1000);



    }
}
