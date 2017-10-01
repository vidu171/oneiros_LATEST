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

import oneiros.muj.oneiros.Database.RegisteredEvent;
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
        Name = findViewById(R.id.Name);
        Fees = findViewById(R.id.Fees);
        Participation = findViewById(R.id.participation);
        EventRule = findViewById(R.id.Rules);
        EventRule.setBackgroundColor(Color.parseColor("#000000"));

        JudgingCriteria = findViewById(R.id.JudgingCriteria);
        Details = findViewById(R.id.Details);
        Contacts = findViewById(R.id.Contact);
        Register = findViewById(R.id.register);
        Name.setText(i.getStringExtra("Name"));
        if(i.getIntExtra("FeesMode",-1)==0) {
            Fees.setText("Rs. "+i.getIntExtra("Fees", -1)+" per Person");
        }
        else{
            Fees.setText("Rs. "+i.getIntExtra("Fees", -1)+" per Team");
        }
        if(i.getIntExtra("MaxParticipant",-1)>1){
            Participation.setText("Team \nMinimum : "+i.getIntExtra("MinParticipant",-1)+"\nMaximum : "+i.getIntExtra("MaxParticipant",-1));
        }

        if(i.getIntExtra("MaxParticipant",-1)==i.getIntExtra("MinParticipant",-1)){
            Participation.setText(i.getIntExtra("MaxParticipant",-1) + " Participants");
        }
        if(i.getIntExtra("MaxParticipant",-1)==1){
            Fees.setText("Rs. "+i.getIntExtra("Fees", -1)+" per Person");
            Participation.setText("Single");
        }

        if(i.getStringExtra("EventKey").equals("-KtrYxGHWjtAOWTR3u_A")){
            Fees.setText("Rs. 300 per Team ");
            Participation.setText("Team\nPlease Give the Details of\nthe members in the Email");
        }
        if(!getIntent().getBooleanExtra("RegistrationOpen",true)){
            Register.setEnabled(false);
            Register.setText("Registration Closed");
            Register.setTextColor(getResources().getColor(R.color.half_black));
            Register.setBackground(getDrawable(R.drawable.button_shape));
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
        RegisteredEvent db = new RegisteredEvent(EventDetails.this);
        if(db.isAlreadyRegistered(i.getStringExtra("EventKey"))){
            Register.setEnabled(false);
            Register.setText("Already Registered");
            Register.setTextColor(getResources().getColor(R.color.half_black));
            Register.setBackground(getDrawable(R.drawable.button_shape));
        }
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
