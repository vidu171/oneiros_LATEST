package oneiros.muj.oneiros.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import oneiros.muj.oneiros.Database.EventdbHelper;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.Event;
import oneiros.muj.oneiros.backend.RetrivedEvent;


/**
 * Created by aesher on 9/8/2017.
 */

public class SplashScreen extends AppCompatActivity {


    private FirebaseDatabase mFirebaseData;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;
    ArrayList<RetrivedEvent> mEvents;
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
        mFirebaseData = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseData.getReference().child("Events");
        mChildEventListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Event EventData  = dataSnapshot.getValue(Event.class);

                String ContactVal = "";
                if(dataSnapshot.hasChild("Contact")){
                    DataSnapshot contactSnapshot = dataSnapshot.child("Contact");
                    for (DataSnapshot Contact : contactSnapshot.getChildren()) {
                        ContactVal+="Name: "+Contact.child("Name").getValue()+"\n";
                        ContactVal+="Number: "+Contact.child("Number").getValue()+"\n\n";
                    }
                }
                Log.w("Name-->",EventData.Name);
                mEvents.add(new RetrivedEvent(EventData.Name,EventData.Details,EventData.Rules,EventData.MinParticipant,EventData.MaxParticipant,EventData.Fees,EventData.FeesMode,EventData.JudgingCriteria,EventData.Duration,EventData.Club,dataSnapshot.getKey(), ContactVal, EventData.Time, EventData.Location));

                if(mEvents.size()==39) {
                    EventdbHelper dbHelper = new EventdbHelper(SplashScreen.this);
                    dbHelper.reset_data_list(mEvents);
                    successful = true;
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, transactionimage,transactionimage.getTransitionName()).toBundle();
                    startActivity(i, bundle);

                }
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
        mMessagesDatabaseReference.addChildEventListener(mChildEventListener);

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(!successful){
                final Runnable runi = this;
                final Snackbar snackbar = Snackbar
                        .make(layout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });
                handler.postDelayed(runi,8000);
                snackbar.setActionTextColor(getColor(R.color.One));
                try {
                    snackbar.show();
                }
                catch (Exception E){
                    
                }
            }
        }
    };
}
