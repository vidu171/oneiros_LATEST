package oneiros.muj.oneiros.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.lang.reflect.Array;

import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.HorizontalPagerAdapter_developers;

/**
 * Created by aesher on 9/13/2017.
 */

public class DEvelopers extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);

        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.background_changer);

        final HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.hicvp);
        horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter_developers(this));

        horizontalInfiniteCycleViewPager.startAutoScroll(true);
    }
}
