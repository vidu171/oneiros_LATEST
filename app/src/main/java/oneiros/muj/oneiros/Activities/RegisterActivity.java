package oneiros.muj.oneiros.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import oneiros.muj.oneiros.Backend.Registered;
import oneiros.muj.oneiros.Backend.Registraion;
import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.RequestPreferences.TeamMembers;

/**
 * Created by vidu on 9/9/17.
 */

public class RegisterActivity extends AppCompatActivity {

    TeamMemberAdapter mAdapter;
    FloatingActionButton mAdd;
    RecyclerView members;
    RelativeLayout Hidden, NotHidden;
    ArrayList<TeamMembers> memberList;
    SharedPreferences pref;
    RelativeLayout frameLayout;
    public static DatabaseReference mDatabase;
    AnimationDrawable anim;
    TextView Fees, EventName, Name, RegNum, Contact, University, MemberDetails;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        frameLayout = findViewById(R.id.image_container);
        Hidden = findViewById(R.id.hidden);
        NotHidden = findViewById(R.id.notHidden);
        Hidden.setVisibility(View.INVISIBLE);
        NotHidden.setVisibility(View.VISIBLE);
        Fees = findViewById(R.id.Totalfees);
        EventName = findViewById(R.id.event_name);
        Name = findViewById(R.id.Name);
        RegNum = findViewById(R.id.RegNum);
        Contact = findViewById(R.id.Contact);
        University = findViewById(R.id.University);
        MemberDetails = findViewById(R.id.MemberDetails);
        //
        dialog = new ProgressDialog(RegisterActivity.this);
        dialog.setMessage("Processing");

        anim = (AnimationDrawable) frameLayout.getBackground();
        anim.setEnterFadeDuration(1000);
        anim.setExitFadeDuration(1000);

        Fees.setText(String.valueOf(getIntent().getIntExtra("Fees", -1)));
        EventName.setText(getIntent().getStringExtra("Name"));
        pref = getSharedPreferences("UserCredentials",MODE_PRIVATE);
        Log.w("-->",pref.getString("Name",null));
        Name.setText(pref.getString("Name",null));
        RegNum.setText(pref.getString("RegNo.",null));
        Contact.setText(pref.getString("Contact",null));
        University.setText(pref.getString("University",null));
        mAdd = findViewById(R.id.add);
        Button registerButton = findViewById(R.id.register);
        Log.w("Fees", String.valueOf(getIntent().getIntExtra("Fees", -1)));
        memberList = new ArrayList<>();
        mAdapter = new TeamMemberAdapter(memberList, RegisterActivity.this);

        members = findViewById(R.id.team_members);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        members.setLayoutManager(mLayoutManager);
        members.setItemAnimator(new DefaultItemAnimator());

        members.setAdapter(mAdapter);
        if(getIntent().getIntExtra("MaxParticipant",-1)==1){
            mAdd.setVisibility(View.INVISIBLE);
            MemberDetails.setVisibility(View.INVISIBLE);

        }
        //
        if(getIntent().getIntExtra("MinParticipant",-1)>0){
            int n=getIntent().getIntExtra("MinParticipant",-1)-1;
            while(n-->0){
                memberList.add(new TeamMembers("", ""));
                mAdapter = new TeamMemberAdapter(memberList, RegisterActivity.this);
                members.setAdapter(mAdapter);
                Fees.setText(String.valueOf(getTotalFees()));
                //ss
            }
        }
        if(memberList.size()<1){
            MemberDetails.setVisibility(View.INVISIBLE);
        }

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bypass = true;
                for (int i = 0; i < memberList.size(); i++) {
                    if(memberList.get(i).Name.isEmpty() && memberList.get(i).RegNum.isEmpty())
                    bypass = false;
                }
                if(bypass) {
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Registration");
                    DatabaseReference eventData;
                    eventData = mDatabase.push();
                    Registraion newRegistration = new Registraion();
                    // TODO Add THe Correct Details to the New Registration
                    newRegistration.UserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    newRegistration.EventId = getIntent().getStringExtra("EventKey");
                    newRegistration.Event = getIntent().getStringExtra("Name");
                    SharedPreferences pref = getSharedPreferences("UserCredentials", MODE_PRIVATE);
                    newRegistration.EmailId = pref.getString("EmailId", null);
                    if (getIntent().getIntExtra("FeesMode", -1) == 0) {
                        newRegistration.TotalFees = getIntent().getIntExtra("Fees", -1) * (memberList.size() + 1);
                    } else {
                        newRegistration.TotalFees = getIntent().getIntExtra("Fees", -1);
                    }
                    if (newRegistration.EventId.equals("-KtrYxH1JXCGmHicczIw")) {
                        if (memberList.size() < 10) {
                            newRegistration.TotalFees = 800;
                        } else {
                            int n = memberList.size() - 10;
                            newRegistration.TotalFees = 800 + (100 * (n + 1));
                        }
                    }
                    // Todo Update Date And Time

                    Date todaysDate = new Date();
                    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy, hh:mm a");
                    newRegistration.Time = df.format(todaysDate);
                    newRegistration.FeesStatus = 0;
                    newRegistration.PaymentMode = "";
                    dialog.show();
                    if (isNetworkAvailable() && isOnline() ) {
                        eventData.setValue(newRegistration);

                        RegisteredEvent dbHelper = new RegisteredEvent(RegisterActivity.this);
                        dbHelper.add_data(new Registered(newRegistration.EventId, newRegistration.FeesStatus, newRegistration.UserId, newRegistration.Event, newRegistration.Time, newRegistration.TotalFees, eventData.getKey()));
                        Log.w("Register Activity", eventData.getKey());
                        for (int i = 0; i < memberList.size(); i++) {
                            eventData.child("TeamMates").push().setValue(memberList.get(i));
                        }
                        dialog.dismiss();
                        AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                        LayoutInflater inflater = getLayoutInflater();//
                        View dialogueView = inflater.inflate(R.layout.sucess_dialogue,null);
                        builder.setView(dialogueView);
                        builder.setCancelable(false);
                        builder.create().show();
                        Handler handler = new Handler();
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                Intent I = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(I);
                            }
                        };handler.postDelayed(runnable,650);


                    } else {
                        Toast.makeText(RegisterActivity.this, "Check Connection and try again", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this, "All the fields are compulsory", Toast.LENGTH_LONG).show();
                }
            }
        });


        //TODO inflate ->  sucess_dialogue inflate

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(memberList.size()+1<getIntent().getIntExtra("MaxParticipant",-1)) {
                    memberList.add(new TeamMembers("", ""));
                    mAdapter = new TeamMemberAdapter(memberList, RegisterActivity.this);
                    members.setAdapter(mAdapter);
                    MemberDetails.setVisibility(View.VISIBLE);
                    Fees.setText(String.valueOf(getTotalFees()));
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Only "+getIntent().getIntExtra("MaxParticipant",-1)+" participants allowed",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public class TeamMemberAdapter extends RecyclerView.Adapter<TeamMemberAdapter.MemberViewHolder> {
        ArrayList<TeamMembers> memberlist;
        Context context;

        public TeamMemberAdapter(ArrayList<TeamMembers> memberlist, Context context) {
            this.memberlist = memberlist;
            this.context = context;
        }
        @Override
        public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card, parent, false);
            return new MemberViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MemberViewHolder holder, final int position) {
            final TeamMembers currentMember = memberlist.get(position);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Todo Submit the user details to firebase
                }
            });
            holder.memberName.setText(currentMember.Name);
            if(position+1<getIntent().getIntExtra("MinParticipant",-1)){
                holder.Close.setVisibility(View.INVISIBLE);
            }
            if(currentMember.Name.isEmpty()){
                holder.memberName.setHint("Member "+(position +2)+" Name");
            }
            if(currentMember.RegNum.isEmpty()){
                holder.memberRegNo.setHint("Member "+(position+2)+" Registration Number");
            }
            holder.memberRegNo.setText(currentMember.RegNum);
            holder.Close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    memberList.remove(position);
                    mAdapter = new TeamMemberAdapter(memberList, RegisterActivity.this);
                    members.setAdapter(mAdapter);
                    Fees.setText(String.valueOf(getTotalFees()));
                    if(memberList.size()<1){
                        MemberDetails.setVisibility(View.INVISIBLE);
                    }
                }
            });

            holder.memberName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    currentMember.Name = editable.toString();
                }
            });
            holder.memberRegNo.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    currentMember.RegNum = editable.toString();
                }
            });


        }

        @Override
        public int getItemCount() {
            return memberlist.size();
        }

        public class MemberViewHolder extends RecyclerView.ViewHolder {

            CardView cardView;
            TextView memberName, memberRegNo;
            ImageView Close;

            public MemberViewHolder(View itemView) {
                super(itemView);
                Close = itemView.findViewById(R.id.close);
                cardView = itemView.findViewById(R.id.memberCard);
                memberName = itemView.findViewById(R.id.memberName);
                memberRegNo = itemView.findViewById(R.id.memberRegNo);
            }
        }

    }
    public int getTotalFees(){
        int TotalFees=0;

        if (getIntent().getIntExtra("FeesMode", -1) == 0) {
            TotalFees = getIntent().getIntExtra("Fees", -1) * (memberList.size() + 1);
        } else {
            TotalFees = getIntent().getIntExtra("Fees", -1);
        }
        if (getIntent().getStringExtra("EventKey").equals("-KtrYxH1JXCGmHicczIw")) {
            if (memberList.size() < 10) {
                TotalFees = 800;
            } else {
                int n = memberList.size() - 10;
                TotalFees = 800 + (100 * (n + 1));
            }
        }

        return TotalFees;
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
    public Boolean isOnline() {

        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal==0);
            return reachable;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
