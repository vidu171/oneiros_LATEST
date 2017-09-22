package oneiros.muj.oneiros.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import oneiros.muj.oneiros.backend.RetrivedEvent;

/**
 * Created by vidu on 10/9/17.
 */

public class EventdbHelper extends SQLiteOpenHelper {


    private static final int DATATBASE_VERSION = 1;
    private static final String DATABASE_NAME= "EVENTS";
    private static final String TABLE_NAME = "Event";
    private static final String COLOUMN_ID = "id";
    private static final String COLOUMN_NAME = "Name";
    private static final String COLOUMN_DETAILS = "details";
    private static final String COLOUMN_RULES = "rules";
    private static final String COLOUMN_MIN_PARTICIPANT = "min_participant";
    private static final String COLOUMN_MAX_PARTICIPANT = "max_participant";
    private static final String COLOUMN_FEES = "fees";
    private static final String COLOUMN_FEES_MODE = "fees_mode";
    private static final String COLOUMN_JUDGING_CRITERIA = "judging_criteria";
    private static final String COLOUMN_DURATION = "duration";
    private static final String COLOUMN_CLUB = "club";
    private static final String COLOUMN_EVENT_KEY = "eventkey";
    private static final String COLOUMN_CONTACT = "contact";
    private static final String COLOUMN_TIME = "time";
    private static final String COLOUMN_LOCATION = "location";
    private static final String COLOUMN_RegistrationOpen = "registrtion_open";



    public EventdbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATATBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLOUMN_ID+" INTEGER PRIMARY KEY, "+ COLOUMN_NAME+
                " TEXT,"+COLOUMN_DETAILS+" TEXT,"+COLOUMN_RULES+" TEXT,"+COLOUMN_MIN_PARTICIPANT+" TEXT,"+COLOUMN_MAX_PARTICIPANT+ " TEXT,"+COLOUMN_FEES+" TEXT,"+
                COLOUMN_FEES_MODE+" TEXT,"+COLOUMN_JUDGING_CRITERIA+" TEXT,"+COLOUMN_DURATION+" TEXT,"+COLOUMN_CLUB+" TEXT,"+COLOUMN_CONTACT+" TEXT,"+COLOUMN_TIME+" TEXT,"+COLOUMN_LOCATION+" TEXT,"+COLOUMN_EVENT_KEY+" TEXT,"+
                COLOUMN_RegistrationOpen+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void reset_data_list(ArrayList<RetrivedEvent> eventList){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        int count =0;
        for(RetrivedEvent x: eventList){
                ContentValues values = new ContentValues();
                values.put(COLOUMN_NAME, x.Name);
                values.put(COLOUMN_DETAILS, x.Details);
                values.put(COLOUMN_RULES, x.Rules);
                values.put(COLOUMN_MIN_PARTICIPANT, x.MinParticipant);
                values.put(COLOUMN_MAX_PARTICIPANT, x.MaxParticipant);
                values.put(COLOUMN_FEES, x.Fees);
                values.put(COLOUMN_FEES_MODE, x.FeesMode);
                values.put(COLOUMN_JUDGING_CRITERIA, x.JudgingCriteria);
                values.put(COLOUMN_DURATION, x.Duration);
                values.put(COLOUMN_CLUB, x.Club);
                values.put(COLOUMN_EVENT_KEY, x.EventKey);
                values.put(COLOUMN_CONTACT, x.Contact);
                values.put(COLOUMN_TIME, x.Time);
                values.put(COLOUMN_LOCATION, x.Location);
                values.put(COLOUMN_RegistrationOpen, x.RegistrationOpen);
                db.insert(TABLE_NAME, null, values);
            }
        db.close();
    }
    public ArrayList<RetrivedEvent> getEventList(String ClubKey){
        ArrayList<RetrivedEvent> eventList = new ArrayList<>();
        String select_query = "SELECT *FROM "+TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if(cursor.moveToFirst()){
            do {
                if (cursor.getString(10).equals(ClubKey)) {
                    String name = cursor.getString(1);
                    String Details = cursor.getString(2);
                    String Rules = cursor.getString(3);
                    String minParticipant = cursor.getString(4);
                    String maxParticipant = cursor.getString(5);
                    String fees = cursor.getString(6);
                    String feesMode = cursor.getString(7);
                    String judgingCriteria = cursor.getString(8);
                    String duration = cursor.getString(9);
                    String club = cursor.getString(10);
                    String EventKey = cursor.getString(14);
                    String Contact = cursor.getString(11);
                    String Time = cursor.getString(12);
                    String Location = cursor.getString(13);
//                    Boolean RegistrationOpen = Boolean.valueOf(cursor.getString(15));
                    Log.w("->", String.valueOf(Boolean.valueOf(cursor.getString(15))));
                    Log.w("->", cursor.getString(15));
                    boolean RegistrationOpen = Integer.valueOf(cursor.getString(15))==1?true:false;
                    Log.w("while filling", EventKey);
                    eventList.add(new RetrivedEvent(name, Details, Rules, Integer.parseInt(minParticipant), Integer.parseInt(maxParticipant), Integer.parseInt(fees), Integer.parseInt(feesMode), judgingCriteria, duration, club,EventKey, Contact,Time,Location,RegistrationOpen));
                }
            }
            while (cursor.moveToNext());
        }

        db.close();
        return eventList;

    }
    public RetrivedEvent getEventFromKey(String eventKey){
        RetrivedEvent event = new RetrivedEvent();
        String select_query = "SELECT *FROM "+TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if(cursor.moveToFirst()){
            do {
                if (cursor.getString(14).equals(eventKey)) {
                    String name = cursor.getString(1);
                    String Details = cursor.getString(2);
                    String Rules = cursor.getString(3);
                    String minParticipant = cursor.getString(4);
                    String maxParticipant = cursor.getString(5);
                    String fees = cursor.getString(6);
                    String feesMode = cursor.getString(7);
                    String judgingCriteria = cursor.getString(8);
                    String duration = cursor.getString(9);
                    String club = cursor.getString(10);
                    String EventKey = cursor.getString(14);
                    String Contact = cursor.getString(11);
                    String Time = cursor.getString(12);
                    String Location = cursor.getString(13);
//                    Boolean RegistrationOpen = Boolean.valueOf(cursor.getString(15));
                    Log.w("->", String.valueOf(Boolean.valueOf(cursor.getString(15))));
                    Log.w("->", cursor.getString(15));
                    boolean RegistrationOpen = Integer.valueOf(cursor.getString(15))==1?true:false;
                    Log.w("while filling", EventKey);
                    event = new RetrivedEvent(name, Details, Rules, Integer.parseInt(minParticipant), Integer.parseInt(maxParticipant), Integer.parseInt(fees), Integer.parseInt(feesMode), judgingCriteria, duration, club,EventKey, Contact,Time,Location,RegistrationOpen);
                }
            }
            while (cursor.moveToNext());
        }

        db.close();
        return event;

    }
}
