package oneiros.muj.oneiros.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
               Snackbar snackbar =  Snackbar.make(imageView,"GLAD YOU COULD MAKE IT TO THE EASTER EGG MENU ;D",Snackbar.LENGTH_LONG);
                View view = snackbar.getView();
                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

                view.setBackgroundColor(Color.BLACK);
                TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                if(textView!=null) {
                    view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    textView.setGravity(Gravity.CENTER_HORIZONTAL);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                }

                    snackbar.show();

            }
        };handler.postDelayed(runnable,1000);



    }
}
