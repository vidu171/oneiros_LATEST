package oneiros.muj.oneiros.DAO;

/**
 * Created by Siddharth on 24-09-2017.
 */

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
    private static DatabaseReference counterRef;

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

    public void incrementCounter(DatabaseReference counterRef) {
        counterRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(final MutableData currentData) {
                if (currentData.getValue() == null) {
                    currentData.setValue(1000);
                } else {
                    currentData.setValue((Long) currentData.getValue() + 1);
                }

                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    System.out.println("Firebase counter increment failed.");
                } else {
                    System.out.println("Firebase counter increment succeeded.");
                }
            }
        });
    }

}
