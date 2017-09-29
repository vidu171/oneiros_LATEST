package oneiros.muj.oneiros.DAO;

/**
 * Created by Siddharth on 24-09-2017.
 */

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Future;

import oneiros.muj.oneiros.Activities.UserCreds;
import oneiros.muj.oneiros.Constants;

public class FetchCounterDAO {
    private static FetchCounterDAO instance;
    public static DatabaseReference counterRef;
    public long val = 0;
    private FetchCounterDAO() {
        counterRef = FirebaseDatabase
                .getInstance()
                .getReference().child("WalkInCounter");
    }

    public static FetchCounterDAO getInstance() {
        if (instance == null) {
            instance = new FetchCounterDAO();
        }
        return instance;
    }


    public String getCounter(){
        counterRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    val = Long.valueOf(dataSnapshot.getValue().toString());
                    Log.w("thossd", ""+val);

                }
                else{
                    val = 0;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return  ""+val;

    }

//    public Future<Integer> getUserData(final String UID) {
//        final SettableFuture<Integer> CounterFuture = SettableFuture.create();
//        counterRef.runTransaction(new Transaction.Handler() {
//            @Override
//            public Transaction.Result doTransaction(final MutableData currentData) {
//                if (currentData.getValue() == null) {
//                    currentData.setValue(10000);
//                } else {
//                    currentData.setValue((Long) currentData.getValue() + 1);
////                    Log.w("Time", String.valueOf(System.currentTimeMillis()));
//                }
//
//                return Transaction.success(currentData);
//        return null;
//    }
//


}
