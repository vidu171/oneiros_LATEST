package oneiros.muj.oneiros.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.RequestPreferences.TeamMemberAdapter;
import oneiros.muj.oneiros.RequestPreferences.TeamMembers;
import oneiros.muj.oneiros.backend.Registered;
import oneiros.muj.oneiros.backend.Registraion;

/**
 * Created by vidu on 9/9/17.
 */

public class RegisterActivity extends AppCompatActivity {


    TeamMemberAdapter mAdapter;
    FloatingActionButton mAdd;
    RelativeLayout Hidden, NotHidden;
    ArrayList<TeamMembers> memberList;
    public static DatabaseReference mDatabase;
    TextView Fees ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Hidden = (RelativeLayout) findViewById(R.id.hidden);
        NotHidden = (RelativeLayout) findViewById(R.id.notHidden);
        Hidden.setVisibility(View.INVISIBLE);
        NotHidden.setVisibility(View.VISIBLE);
        Fees = (TextView) findViewById(R.id.Totalfees);
        Button registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < memberList.size(); i++) {
                    Log.w("ArrayList Data", memberList.get(i).Name+" "+memberList.get(i).RegNum);
                }
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Registration");
                DatabaseReference eventData;
                eventData=mDatabase.push();
                Registraion newRegistration = new Registraion();
                // TODO Add THe Correct Details to the New Registration
                newRegistration.UserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                newRegistration.EventId = getIntent().getStringExtra("EventKey");
                if(getIntent().getIntExtra("FeesMode",-1)==0) {
                    newRegistration.TotalFees = getIntent().getIntExtra("Fees", -1)*memberList.size();
//                    Fees.setText(newRegistration.TotalFees);
                }
                else{

                }
                newRegistration.FeesStatus = 0;
                newRegistration.PaymentMode = "Paytm";
                if(isNetworkAvailable()) {

                    eventData.setValue(newRegistration);

                    Log.w("Register Activity", eventData.getKey());
                    for (int i = 0; i < memberList.size(); i++) {
                        eventData.child("TeamMates").push().setValue(memberList.get(i));
                    }
                    RegisteredEvent dbHelper = new RegisteredEvent(RegisterActivity.this);
                    dbHelper.add_data(new Registered(getIntent().getStringExtra("Name"),getIntent().getStringExtra("EventKey"),getIntent().getStringExtra("Club")));
                    Hidden.setVisibility(View.VISIBLE);
                    NotHidden.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Check Connection\nand try again", Toast.LENGTH_LONG).show();
                }
            }
        });
        mAdd = (FloatingActionButton) findViewById(R.id.add);

        memberList = new ArrayList<>();
        mAdapter = new TeamMemberAdapter(memberList, RegisterActivity.this);

        RecyclerView members = (RecyclerView) findViewById(R.id.team_members);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        members.setLayoutManager(mLayoutManager);
        members.setItemAnimator(new DefaultItemAnimator());
        members.setAdapter(mAdapter);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memberList.add(new TeamMembers("",""));
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
