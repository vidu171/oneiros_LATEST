package oneiros.muj.oneiros.DAO;

/**
 * Created by Siddharth on 24-09-2017.
 */

import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import oneiros.muj.oneiros.Backend.Registered;
import oneiros.muj.oneiros.Constants;

public class FetchRegistrationDAO {
    private static FetchRegistrationDAO instance;
    private static DatabaseReference registrationTable;
    private FetchRegistrationDAO() {
        registrationTable = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.REGISTRATION_TABLE_REFERENCE);
    }

    public static FetchRegistrationDAO getInstance() {
        if (instance == null) {
            instance = new FetchRegistrationDAO();
        }
        return instance;
    }

    public Future<Map<String, Registered>> getRegistrations(final String UID) {
        final SettableFuture<Map<String, Registered>> matchedRegistrationsFuture = SettableFuture.create();
        registrationTable.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Map<String, Registered> retrievedRegistrations = new HashMap<>();
                        for (DataSnapshot registeration : dataSnapshot.getChildren()) {
                            Registered registerationValue =  registeration.getValue(Registered.class);
                                if (registerationValue.UserId.trim().equals(UID))
                                    retrievedRegistrations.put(registeration.getKey(), registerationValue);
                        }
                        matchedRegistrationsFuture.set(retrievedRegistrations);
                    } else {
                        matchedRegistrationsFuture.set(null);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    matchedRegistrationsFuture.set(null);
                }
            });

        return matchedRegistrationsFuture;
    }

}
