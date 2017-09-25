package oneiros.muj.oneiros.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import oneiros.muj.oneiros.Backend.Registered;

/**
 * Created by vidu on 11/9/17.
 */

public class RegisteredEvent extends SQLiteOpenHelper {
    private static final int DATATBASE_VERSION = 1;
    private static final String DATABASE_NAME= "Registered_EVENTS";
    private static final String TABLE_NAME = "Registered_Event";
    private static final String COLOUMN_ID = "id";
    private static final String COLOUMN_EVENT = "Event";
    private static final String COLOUMN_STATUS = "status";
    private static final String COLOUMN_EVENT_ID = "eventId";
    private static final String COLOUMN_USER_ID = "user_Id";
    private static final String COLOUMN_TIME = "time";
    private static final String COLOUMN_FEES = "Fees";



    public RegisteredEvent(Context context) {
        super(context, DATABASE_NAME, null, DATATBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLOUMN_ID+" INTEGER PRIMARY KEY, "+ COLOUMN_EVENT+
                " TEXT,"+COLOUMN_STATUS+" INTEGER,"+COLOUMN_EVENT_ID+" TEXT,"+COLOUMN_USER_ID+" TEXT,"+COLOUMN_TIME+" TEXT,"+
                COLOUMN_FEES+" INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void reset_data_list(ArrayList<Registered> eventList){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        int count =0;
        for(Registered x: eventList){
            Log.w("x->", x.Event+"\n"+x.FeesStatus+"\n"+x.EventId+"\n"+x.UserId);
            ContentValues values = new ContentValues();
            values.put(COLOUMN_EVENT, x.Event);
            values.put(COLOUMN_STATUS, x.FeesStatus);
            values.put(COLOUMN_EVENT_ID, x.EventId);
            values.put(COLOUMN_USER_ID, x.UserId);
            values.put(COLOUMN_TIME, x.Time);
            values.put(COLOUMN_FEES, x.TotalFees);
            db.insert(TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Registered> getRegisteredList(){
        ArrayList<Registered> eventList = new ArrayList<>();
        String select_query = "SELECT *FROM "+TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if(cursor.moveToFirst()){
            do {
                    String name = cursor.getString(1);
                    String UserId = cursor.getString(4);
                    int status = cursor.getInt(2);
                    String EventKey = cursor.getString(3);
                    String Time = cursor.getString(5);
                    int Fees = cursor.getInt(6);
                    Log.w("while filling", name+"\n"+status+"\n"+EventKey);
                    eventList.add(new Registered(EventKey, status,UserId, name,Time,Fees));
                }
            while (cursor.moveToNext());
        }

        db.close();
        return eventList;

    }

    public void dropTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
//    public void add_data(Registered x){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLOUMN_NAME, x.Name);
//        values.put(COLOUMN_CLUB, x.Club);
//        values.put(COLOUMN_EVENT_KEY, x.EventKey);
//        db.insert(TABLE_NAME, null, values);
//        db.close();
//    }
}
