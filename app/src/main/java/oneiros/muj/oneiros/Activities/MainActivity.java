package oneiros.muj.oneiros.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import oneiros.muj.oneiros.Database.EventdbHelper;
import oneiros.muj.oneiros.Fragments.Events;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.Backend.RetrivedEvent;
import oneiros.muj.oneiros.Backend.pagerAdapter;


/**
 * Created by aesher on 9/8/2017.
 * This activity provides the base UI for the pagers
 */

public class MainActivity extends AppCompatActivity {

    TabLayout top;
    ViewPager Pagerfragments;

    String Generate_name;

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
        Generate_name = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    @Override
    public void onBackPressed() {
        if(Events.ispanelEnabled()){
            Events.setPanelState();
        }
        else{
            finishAffinity();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
        //        Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                EventdbHelper eventdbHelper = new EventdbHelper(getBaseContext());
                RetrivedEvent currentEvent = eventdbHelper.getEventFromKey(result.getContents());
                if(currentEvent!=null) {
                    Intent i = new Intent(MainActivity.this, EventDetails.class);
                    Log.w("this", result.getContents());
                    i.putExtra("Name", currentEvent.Name);
                    i.putExtra("Duration", currentEvent.Duration);
                    i.putExtra("Fees", currentEvent.Fees);
                    i.putExtra("FeesMode", currentEvent.FeesMode);
                    i.putExtra("JudgingCriteria", currentEvent.JudgingCriteria);
                    i.putExtra("MaxParticipant", currentEvent.MaxParticipant);
                    i.putExtra("MinParticipant", currentEvent.MinParticipant);
                    i.putExtra("Details", currentEvent.Details);
                    i.putExtra("Rules", currentEvent.Rules);
                    i.putExtra("EventKey", currentEvent.EventKey);
                    i.putExtra("Time", currentEvent.Time);
                    i.putExtra("RegistrationOpen", currentEvent.RegistrationOpen);
                    Log.w("RegistrationOpen", String.valueOf(currentEvent.RegistrationOpen));
                    i.putExtra("Location", currentEvent.Location);
                    i.putExtra("Contact", currentEvent.Contact);
                    Log.w("Check 123", currentEvent.EventKey);
                    startActivity(i);

                }
                else{
                    Toast.makeText(this, "Incorrect Qr Code", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    public void DEvelopers(View v){
        Intent i = new Intent(MainActivity.this, Developers.class);
        startActivity(i);
    }

}
