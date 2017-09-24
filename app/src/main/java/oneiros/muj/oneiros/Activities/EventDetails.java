package oneiros.muj.oneiros.Activities;

import android.content.Intent;
import android.graphics.Color;
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
    TextView Name, Fees, Participation, JudgingCriteria, Details, Contacts;
    Button Register;
    WebView EventRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventlayout);

        final Intent i = getIntent();
        Name = (TextView) findViewById(R.id.Name);
        Fees = (TextView) findViewById(R.id.Fees);
        Participation = (TextView) findViewById(R.id.participation);
        EventRule = (WebView) findViewById(R.id.Rules);
        EventRule.setBackgroundColor(Color.parseColor("#000000"));

        JudgingCriteria = (TextView) findViewById(R.id.JudgingCriteria);
        Details = (TextView) findViewById(R.id.Details);
        Contacts = (TextView) findViewById(R.id.Contact);
        Register = (Button) findViewById(R.id.register);
        Name.setText(i.getStringExtra("Name"));
        if(i.getIntExtra("FeesMode",-1)==0) {
            Fees.setText("Rs. "+i.getIntExtra("Fees", -1)+" per Person");
        }
        else{
            Fees.setText("Rs. "+i.getIntExtra("Fees", -1)+" per Team");
        }
        if(i.getIntExtra("MinParticipant",-1)>1){
            Participation.setText("Team");
        }
//        To
        else{
            Participation.setText("Single");
        }
        if(i.getStringExtra("EventKey").equals("-KtrYxH1JXCGmHicczIw")){
            Fees.setText("Rs. 800 for first 10 pesron\nAnd then Rs. 100 per person");
            Participation.setText("Team");
        }

        if (Build.VERSION.SDK_INT >= 24) {
            JudgingCriteria.setText(Html.fromHtml(i.getStringExtra("JudgingCriteria"), Html.FROM_HTML_MODE_COMPACT));
        } else {
            JudgingCriteria.setText(Html.fromHtml(i.getStringExtra("JudgingCriteria")));
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Details.setText(Html.fromHtml(i.getStringExtra("Details"), Html.FROM_HTML_MODE_COMPACT));
        }else
            Details.setText(Html.fromHtml(i.getStringExtra("Details")));
        EventRule.loadDataWithBaseURL(null, "<font color='white'>"+i.getStringExtra("Rules")+"</font>", "text/html", "utf-8", null);
        try{
            Contacts.setText(i.getStringExtra("Contact"));
        }catch (Exception es){}

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I =  new Intent(EventDetails.this, RegisterActivity.class);
                I.putExtra("EventKey",i.getStringExtra("EventKey"));
                I.putExtra("Name",i.getStringExtra("Name"));
                I.putExtra("Fees",i.getIntExtra("Fees", -1));
                I.putExtra("MinParticipant",i.getIntExtra("MinParticipant", -1));
                I.putExtra("MaxParticipant",i.getIntExtra("MaxParticipant", -1));
                Log.w("Fees", String.valueOf(i.getIntExtra("Fees",-1)));
                I.putExtra("FeesMode",i.getIntExtra("FeesMode", -1));
                startActivity(I);
            }
        });

    }

}
