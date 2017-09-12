package oneiros.muj.oneiros.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import oneiros.muj.oneiros.R;


/**
 * Created by vidu on 7/9/17.
 */

public class EventDetails extends AppCompatActivity {
    TextView Name, Duration, Min, Max, Fees, FeesMode, JudgingCriteria, Details, Contacts;
    Button Register;
    WebView EventRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventlayout);

        final Intent i = getIntent();
        Name = (TextView) findViewById(R.id.Name);
        Duration = (TextView) findViewById(R.id.duration);
        Min = (TextView) findViewById(R.id.Min);
        Max = (TextView) findViewById(R.id.Max);
        Fees = (TextView) findViewById(R.id.Fees);
        FeesMode = (TextView) findViewById(R.id.FeesMode);
        EventRule = (WebView) findViewById(R.id.Rules);
        JudgingCriteria = (TextView) findViewById(R.id.JudgingCriteria);
        Details = (TextView) findViewById(R.id.Details);
        Contacts = (TextView) findViewById(R.id.Contacts);
        Register = (Button) findViewById(R.id.register);
        Name.setText("Event Name: "+i.getStringExtra("Name")+" "+i.getStringExtra("EventKey"));
        Duration.setText("Time: "+i.getStringExtra("Time")+" "+i.getStringExtra("Location"));
        Fees.setText("Fees: "+i.getIntExtra("Fees", -1));
        FeesMode.setText("Fees Mode: "+i.getIntExtra("FeesMode",-1));
        if (Build.VERSION.SDK_INT >= 24) {
            JudgingCriteria.setText(Html.fromHtml("Judging Criteria:<br>"+i.getStringExtra("JudgingCriteria"), Html.FROM_HTML_MODE_COMPACT));
        } else {
            JudgingCriteria.setText(Html.fromHtml("Judging Criteria:<br>"+i.getStringExtra("JudgingCriteria")));
        }
        Min.setText("Min Participant: "+i.getIntExtra("MinParticipent",-1));
        Max.setText("Max Participant: "+i.getIntExtra("MaxParticipent", -1));
        if (Build.VERSION.SDK_INT >= 24) {
            Details.setText(Html.fromHtml("Details:<br>" + i.getStringExtra("Details"), Html.FROM_HTML_MODE_COMPACT));
        }else
            Details.setText(Html.fromHtml("Details:<br>" + i.getStringExtra("Details")));
        EventRule.loadDataWithBaseURL(null, "Rules:<br>"+i.getStringExtra("Rules"), "text/html", "utf-8", null);
//        EventRule.setText("Rules: \n"+i.getStringExtra("Rules"));
        try{
            Contacts.setText("Contacts:\n"+ i.getStringExtra("Contact"));
        }catch (Exception es){}

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent I =  new Intent(EventDetails.this, RegisterActivity.class);
//                I.putExtra("EventKey",i.getStringExtra("EventKey"));
//                I.putExtra("Name",i.getStringExtra("Name"));
//                I.putExtra("Fees",i.getIntExtra("Fees", -1));
//                Log.w("Fees", String.valueOf(i.getIntExtra("Fees",-1)));
//                I.putExtra("FeesMode",i.getIntExtra("FeesMode", -1));
//                startActivity(I);
            }
        });

    }

}
