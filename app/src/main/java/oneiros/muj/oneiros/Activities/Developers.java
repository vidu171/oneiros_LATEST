package oneiros.muj.oneiros.Activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.Backend.HorizontalPagerAdapter_developers;

/**
 * Created by aesher on 9/13/2017.
 */

public class Developers extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);

        final HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.hicvp);
        horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter_developers(this));

    }
}
