package oneiros.muj.oneiros.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;

import oneiros.muj.oneiros.backend.Registered;

/**
 * Created by vidu on 11/9/17.
 */

public class RegisteredEvent extends SQLiteOpenHelper {
    private static final int DATATBASE_VERSION = 1;
    private static final String DATABASE_NAME= "Registered_EVENTS";
    private static final String TABLE_NAME = "Registered_Event";
    private static final String COLOUMN_ID = "id";
    private static final String COLOUMN_NAME = "Name";
    private static final String COLOUMN_CLUB = "club";
    private static final String COLOUMN_EVENT_KEY = "eventkey";



    public RegisteredEvent(Context context) {
        super(context, DATABASE_NAME, null, DATATBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLOUMN_ID+" INTEGER PRIMARY KEY, "+ COLOUMN_NAME+
                " TEXT,"+" TEXT,"+COLOUMN_CLUB+" TEXT,"+
                COLOUMN_EVENT_KEY+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public ArrayList<Registered> getEventList(){
        ArrayList<Registered> eventList = new ArrayList<>();
        String select_query = "SELECT *FROM "+TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if(cursor.moveToFirst()){
            do {
                    String name = cursor.getString(1);
                    String club = cursor.getString(2);
                    String EventKey = cursor.getString(3);
                    Log.w("while filling", EventKey);
                    eventList.add(new Registered(name, club,EventKey ));

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
    public void add_data(Registered x){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLOUMN_NAME, x.Name);
        values.put(COLOUMN_CLUB, x.Club);
        values.put(COLOUMN_EVENT_KEY, x.EventKey);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
