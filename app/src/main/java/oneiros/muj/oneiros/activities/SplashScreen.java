package oneiros.muj.oneiros.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import oneiros.muj.oneiros.Database.EventdbHelper;
import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.Event;
import oneiros.muj.oneiros.backend.Registered;
import oneiros.muj.oneiros.backend.RetrivedEvent;


/**
 * Created by aesher on 9/8/2017.
 * Its a splash screen only c'mon now
 */

public class SplashScreen extends AppCompatActivity {


    private FirebaseDatabase mFirebaseData;
    private DatabaseReference mMessagesDatabaseReferenceEvent, mMessagesDatabaseReferenceRegistered;
    private ChildEventListener mChildEventListener, mChildEventListenerRegistered;
    ArrayList<RetrivedEvent> mEvents;
    ArrayList<Registered>mRegistered;
    boolean successful;
    Handler handler = new Handler();
    LinearLayout layout;
    ImageView imageView,transactionimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        layout = (LinearLayout) findViewById(R.id.layoutsplash);

        imageView = (ImageView) findViewById(R.id.moto);
        transactionimage = (ImageView) findViewById(R.id.OHNO);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.blink);
        imageView.startAnimation(animation);

        handler.postDelayed(runnable,5000);

        mEvents = new ArrayList<>();
        mRegistered = new ArrayList<>();
        mFirebaseData = FirebaseDatabase.getInstance();
        mMessagesDatabaseReferenceEvent = mFirebaseData.getReference().child("Events");
        mMessagesDatabaseReferenceRegistered = mFirebaseData.getReference().child("Registration");

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Event EventData  = dataSnapshot.getValue(Event.class);
                String ContactVal = "";
                if(dataSnapshot.hasChild("Contact")){
                    DataSnapshot contactSnapshot = dataSnapshot.child("Contact");
                    for (DataSnapshot Contact : contactSnapshot.getChildren()) {
                        ContactVal+=Contact.child("Name").getValue()+"- ";
                        ContactVal+=Contact.child("Number").getValue()+"\n\n";
                    }
                }
                mEvents.add(new RetrivedEvent(EventData.Name,EventData.Details,EventData.Rules,EventData.MinParticipant,EventData.MaxParticipant,EventData.Fees,EventData.FeesMode,EventData.JudgingCriteria,EventData.Duration,EventData.Club,dataSnapshot.getKey(), ContactVal, EventData.Time, EventData.Location, EventData.RegistrationOn));

//                if(mEvents.size()==37 && mRegistered.size()>0){
//                    EventdbHelper dbHelper = new EventdbHelper(SplashScreen.this);
//                    dbHelper.reset_data_list(mEvents);
//                    successful = true;
//                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
//                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, transactionimage,transactionimage.getTransitionName()).toBundle();
//                    startActivity(i,bundle);
//                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };

        mChildEventListenerRegistered = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Registered registered =  dataSnapshot.getValue(Registered.class);
                SharedPreferences pref = getSharedPreferences("UserCredentials", MODE_PRIVATE);

                if(registered.EmailId.equals(pref.getString("EmailId",null))){
                    mRegistered.add(registered);
                    Log.w("reistered-->", registered.Event);
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        mMessagesDatabaseReferenceRegistered.addChildEventListener(mChildEventListenerRegistered);
        mMessagesDatabaseReferenceEvent.addChildEventListener(mChildEventListener);
    }

//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            if(!successful){
//                final Runnable runi = this;
//                final Snackbar snackbar = Snackbar
//                        .make(layout, "No internet connection!", Snackbar.LENGTH_LONG)
//                        .setAction("RETRY", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                            }
//                        });
//                handler.postDelayed(runi,8000);
//
//                snackbar.setActionTextColor(getColor(R.color.One));
//                try {
//                    snackbar.show();
//                }
//                catch (Exception E){
//                }
//            }
//        }
//    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mEvents.size()==37 && mRegistered.size()>0) {
                EventdbHelper dbHelper = new EventdbHelper(SplashScreen.this);
                dbHelper.reset_data_list(mEvents);
                RegisteredEvent dbHelper2 = new RegisteredEvent(SplashScreen.this);
                dbHelper2.reset_data_list(mRegistered);
                successful = true;
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, transactionimage, transactionimage.getTransitionName()).toBundle();
                try {
                    startActivity(i, bundle);
                    mMessagesDatabaseReferenceRegistered.removeEventListener(mChildEventListenerRegistered);
                    mMessagesDatabaseReferenceEvent.removeEventListener(mChildEventListener);
                }
                catch (Exception E) {
                }
            }
            else{
                final Runnable runi = this;
                if(!successful) {
//                    final Snackbar snackbar = Snackbar
//                            .make(layout, "No internet connection!", Snackbar.LENGTH_LONG)
//                            .setAction("RETRY", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                }
//                            });
                    handler.postDelayed(runi, 700);
//                    snackbar.setActionTextColor(getColor(R.color.One));
//                    try {
//                        snackbar.show();
//                    } catch (Exception E) {
//                    }
                }
                else{
                    handler.postDelayed(runi, 400);

                }
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        mMessagesDatabaseReferenceRegistered.removeEventListener(mChildEventListenerRegistered);
        mMessagesDatabaseReferenceEvent.removeEventListener(mChildEventListener);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mMessagesDatabaseReferenceRegistered.removeEventListener(mChildEventListenerRegistered);
        mMessagesDatabaseReferenceEvent.removeEventListener(mChildEventListener);
        finishAffinity();
    }

}
