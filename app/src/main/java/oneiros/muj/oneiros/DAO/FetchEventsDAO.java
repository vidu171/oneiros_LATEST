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

import oneiros.muj.oneiros.Backend.Event;
import oneiros.muj.oneiros.Constants;

public class FetchEventsDAO {
    private static FetchEventsDAO instance;
    private static DatabaseReference eventsTable;

    private FetchEventsDAO() {
        eventsTable = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.EVENTS_TABLE_REFERENCE);
    }

    public static FetchEventsDAO getInstance() {
        if (instance == null) {
            instance = new FetchEventsDAO();
        }
        return instance;
    }

    public Future<Map<String, Event>> getEvents() {
        final SettableFuture<Map<String, Event>> matchedEventsFuture = SettableFuture.create();
            eventsTable.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Map<String, Event> retrievedEvents = new HashMap<>();
                        for (DataSnapshot event : dataSnapshot.getChildren()) {
                            Event eventValue = event.getValue(Event.class);
                            retrievedEvents.put(event.getKey(), eventValue);
                        }
                        matchedEventsFuture.set(retrievedEvents);
                    } else {
                        matchedEventsFuture.set(null);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    matchedEventsFuture.set(null);
                }
            });

        return matchedEventsFuture;
    }

}
