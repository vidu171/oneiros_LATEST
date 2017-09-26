package oneiros.muj.oneiros.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
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
    }
}
