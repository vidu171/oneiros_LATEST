package oneiros.muj.oneiros.Backend;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shiavngi Pandey on 29-08-2017.
 */

public class Session {

    SharedPreferences sharedPreferences;
    Context context;
    SharedPreferences.Editor editor;

    Session(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (!sharedPreferences.contains("club")) {
            addClubs();
            addEventString();
            addClubDetails();
        }
    }

    //setters
    public void setEdited(boolean isEdited) {
        editor.putBoolean("edited", isEdited);
        editor.apply();
    }

    private void addClubs() {
        String clubs = "aperture#cinefilia#Coreographia#Litmus#Scribbles#Shabd#Sophia#The Music Club";
        editor.putString("club", clubs);
        editor.apply();
    }

    public void addEvent(String event, String clubName) {
        String[] clubs = getClubs();
    }


    //getters
    public boolean getEdited() {
        return sharedPreferences.getBoolean("edited", true);
    }

    public String[] getClubs() {
        return sharedPreferences.getString("club", "").split("#");
    }

    public void addEventString() {

        String Aperture = "The Annual Photography Exhibition- FOCUS #Flare -The On-the-Spot Photography Competition #" +
                "Showdown Of Societies - The Inter-College Photography Competition #InstAperture - The Mobile Photography Competition #";
        String Cinefilia = "Aawaz (Street Play Compettion) #Rangmanch (Stage Play Competition) #MONO ACT #Humor Us #Ad-mak #UNO..DOS… ACT!!!";
        String Coreographia = "Nextar: Solo / Duet Dance Competition #GROUND ZERO: All Style Hip – Hop Battle #Showcase: Impromptu Solo/Duet";
        String Litmus = "JUST A MINUTE #QUIZNOS #SPELL BEE #VOICE OVER #(To Be decided)#VOICE OVER";
        String Scribbles = "STYLE THE STAMP #PAINT-O-NECK #BEST OUT OF WASTE ";
        String Shabbd = "Izhaar #Chakravyuh";
        String Sophia = "Battleground #Sophia Circle #Relive & Revamp ";
        String TMC = "RAP WARS #WOODSTOCK #FUNTAKSHARI #TWICE THE VOICE #ENSEMBLE #BOLLYWOOD #OCTAVES #SAPTAK";

        String AllEvents = Aperture + "^" + Cinefilia + "^" + Coreographia + "^" + Litmus + "^" + Scribbles + "^" + Shabbd + "^" + Sophia + "^" + TMC;

        editor.putString("allevents", AllEvents);
        editor.apply();
    }

    public String[] getClubEvents(String clubName) {

        String clubs[] = getClubs();
        for (int i = 0; i < clubs.length; i++) {
            if (clubName.equalsIgnoreCase(clubs[i]))
                break;
        }
        return sharedPreferences.getString("allevents", "").split("^");
    }

    public String[] getClubDetails(String details){

        return null;
    }

    //0 - Description, 1 - Duration, 2 - Registration Fee, 3 -Category, 4 - Rules, 5 - jidging criteri, 6 - contact details,7 - starting time
    // | - main delimeter ^ - sub delimeter + inner delimeter : for contacts and numbers
    public void addClubDetails(){
        String Aperture = "";
        String Cinefilia = "";
        String Coreographia = "";
        String Litmus = "";
        String Scribbles = "";
        String Shabbd = "";
        String Sophia = "";
        String TMC = "";
    }
}