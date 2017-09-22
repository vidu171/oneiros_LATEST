package oneiros.muj.oneiros.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.pagerAdapter;
import oneiros.muj.oneiros.fragments.events;
import oneiros.muj.oneiros.fragments.home;

import static java.security.AccessController.getContext;


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
        else if(home.isFab()){
            home.CLOSE_FAB();
        }
        else{
            finish();
        }
    }


    //Todo View Qr code goes here
    public void View_qr(View V){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogue_view_qr,null));
        builder.setCancelable(false);
       /*
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"THIS",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel",null);

        */
        builder.create().show();
    }

    //Todo Scan Qr code goes here
    public void Scan_qr(View v){
        Toast.makeText(this,"The shit was clicked",Toast.LENGTH_SHORT).show();
    }

}
