package oneiros.muj.oneiros.activities;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.AddData;
import oneiros.muj.oneiros.backend.pagerAdapter;
import oneiros.muj.oneiros.fragments.events;


/**
 * Created by aesher on 9/8/2017.
 * This activity provides the base UI for the pagers
 */



public class MainActivity extends AppCompatActivity {

    TabLayout top;
    ViewPager Pagerfragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top = (TabLayout) findViewById(R.id.tab);
        Pagerfragments = (ViewPager) findViewById(R.id.viewpager);

        Pagerfragments.setOffscreenPageLimit(2);
        top.setupWithViewPager(Pagerfragments);

        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager());
        Pagerfragments.setAdapter(adapter);
        Pagerfragments.setCurrentItem(1);


        top.getTabAt(0).setIcon(R.drawable.ic_event);
        top.getTabAt(1).setIcon(R.drawable.ic_home);
        top.getTabAt(2).setIcon(R.drawable.ic_grade);




    }

    @Override
    public void onBackPressed() {
        if(events.ispanelEnabled()){
            events.setPanelState();
        }
        else{
            finish();
        }
    }
}
