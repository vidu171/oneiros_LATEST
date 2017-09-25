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

import java.util.concurrent.Future;

import oneiros.muj.oneiros.Activities.UserCreds;
import oneiros.muj.oneiros.Constants;

public class FetchUserDAO {
    private static FetchUserDAO instance;
    private static DatabaseReference userTable;

    private FetchUserDAO() {
        userTable = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.USER_TABLE_REFERENCE);
    }

    public static FetchUserDAO getInstance() {
        if (instance == null) {
            instance = new FetchUserDAO();
        }
        return instance;
    }

    public Future<UserCreds> getUserData(final String UID) {
        final SettableFuture<UserCreds> matchedUserFuture = SettableFuture.create();
        userTable.addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        if (dataSnapshot.hasChild(UID)) {
                            UserCreds matchedUser = dataSnapshot.child(UID).getValue(UserCreds.class);
                            matchedUserFuture.set(matchedUser);
                        } else {
                            matchedUserFuture.set(null);
                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    matchedUserFuture.set(null);
                }
            });

        return matchedUserFuture;
    }

}
