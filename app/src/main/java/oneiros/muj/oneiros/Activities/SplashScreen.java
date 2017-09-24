package oneiros.muj.oneiros.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import oneiros.muj.oneiros.Backend.Contact;
import oneiros.muj.oneiros.DAO.FetchEventsDAO;
import oneiros.muj.oneiros.DAO.FetchRegistrationDAO;
import oneiros.muj.oneiros.Database.EventdbHelper;
import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.Backend.Event;
import oneiros.muj.oneiros.Backend.Registered;
import oneiros.muj.oneiros.Backend.RetrivedEvent;


/**
 * Created by aesher on 9/8/2017.
 * Its a splash screen only c'mon now
 */

public class SplashScreen extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    ArrayList<RetrivedEvent> mEvents;
    ArrayList<Registered>mRegistered;
    boolean successful;
    Handler handler = new Handler();
    LinearLayout layout;
    ImageView imageView,transactionimage;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        layout = (LinearLayout) findViewById(R.id.layoutsplash);

        imageView = (ImageView) findViewById(R.id.moto);
        transactionimage = (ImageView) findViewById(R.id.OHNO);
        animation = AnimationUtils.loadAnimation(this,R.anim.blink);
        mEvents = new ArrayList<>();
        mRegistered = new ArrayList<>();
        mFirebaseAuth = FirebaseAuth.getInstance();
        tryFetching();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    private class FetchData extends AsyncTask<String, Void, String> {
        final Future<Map<String, Event>> listFutureForEvents = FetchEventsDAO
                .getInstance()
                .getEvents();
        final Future<Map<String, Registered>> listFutureForRegistrations = FetchRegistrationDAO
                .getInstance()
                .getRegistrations(mFirebaseAuth.getCurrentUser().getUid());
        @Override
        protected String doInBackground(String... params) {
            try {
                while(!listFutureForEvents.isDone() && !listFutureForRegistrations.isDone()) {
                    Thread.sleep(500);
                }
                final Map<String, Event> events = new HashMap<String, Event>();
                final Map<String, Registered> registerations = new HashMap<String, Registered>();
                Map EventMatches = listFutureForEvents.get();
                Map RegisterationMatches = listFutureForRegistrations.get();
                if (EventMatches != null) {
                    events.putAll(EventMatches);
                    String ContactVal;
                    for (Map.Entry<String, Event> entry : events.entrySet())
                    {
                        ContactVal="";
                        for (Map.Entry<String, Contact> contactEntry : entry.getValue().Contact.entrySet())
                        {
                            ContactVal+=contactEntry.getValue().Name+"- ";
                            ContactVal+=contactEntry.getValue().Number+"\n\n";
                        }
                        mEvents.add(new RetrivedEvent(entry.getValue().Name,entry.getValue().Details,entry.getValue().Rules,entry.getValue().MinParticipant,entry.getValue().MaxParticipant,entry.getValue().Fees,entry.getValue().FeesMode,entry.getValue().JudgingCriteria,entry.getValue().Duration,entry.getValue().Club,entry.getKey(), ContactVal, entry.getValue().Time, entry.getValue().Location, entry.getValue().RegistrationOn));
                    }
                }
                if (RegisterationMatches != null) {
                    registerations.putAll(RegisterationMatches);
                    for (Map.Entry<String, Registered> entry : registerations.entrySet())
                    {
                        Log.w("Retrived Registration","-->"+entry.getValue()+" "+entry.getValue().Time);
                        mRegistered.add(entry.getValue());
                    }
                }
                Log.v("Tag",events.keySet().toString());

            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if(mEvents.size()==37) {
                try{animation.cancel();}catch (Exception e){}
                EventdbHelper dbHelper = new EventdbHelper(SplashScreen.this);
                dbHelper.reset_data_list(mEvents);
                RegisteredEvent dbHelper2 = new RegisteredEvent(SplashScreen.this);
                dbHelper2.reset_data_list(mRegistered);
                successful = true;
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, transactionimage, transactionimage.getTransitionName()).toBundle();
                try {
                    startActivity(i, bundle);
                }
                catch (Exception E) {
                }
            }
            else{
                    try{animation.cancel();}catch (Exception e){}
                    showSnackBar("Fetching Data Failed !","Retry");
            }
        }

        @Override
        protected void onPreExecute() {
            imageView.startAnimation(animation);

        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void showSnackBar(String Message,String Option){
        final Snackbar snackbar = Snackbar
                .make(layout,Message.toUpperCase(), Snackbar.LENGTH_LONG)
                .setAction(Option.toUpperCase(), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tryFetching();
                    }
                });
        snackbar.setActionTextColor(getResources().getColor(R.color.One));
        try {
            snackbar.setDuration(Snackbar.LENGTH_INDEFINITE);
            snackbar.show();
        } catch (Exception E) {
        }
    }
    public void tryFetching(){
        if(isNetworkAvailable())
            new FetchData().execute("");
        else
            showSnackBar("no internet connection !","Retry");
    }

}

