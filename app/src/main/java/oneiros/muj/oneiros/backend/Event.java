package oneiros.muj.oneiros.backend;

/**
 * Created by Siddharth on 30-08-2017.
 */

public class Event {
    public String Name;
    public String Details;
    public String Rules;
    public int MinParticipant;
    public int MaxParticipant;
    public int Fees;
    public int FeesMode;
    public String JudgingCriteria;
    public String Duration;
    public String Club;
    public String Time;
    public String Location;
    public Event(){}
    public Event(String Name, String Details, String Rules, int MinParticipant, int MaxParticipant, int Fees, int FeesMode, String JudgingCriteria, String Duration, String Club, String Time, String Location){
        this.Name=Name;
        this.Details=Details;
        this.Rules=Rules;
        this.MinParticipant=MinParticipant;
        this.MaxParticipant=MaxParticipant;
        this.Fees=Fees;
        this.FeesMode=FeesMode;
        this.JudgingCriteria=JudgingCriteria;
        this.Duration=Duration;
        this.Club=Club;
        this.Time = Time;
        this.Location = Location;
    }

//    public String getName() {
//        return Name;
//    }
//    public String getDetails(){
//        return Details;
//    }
//
//    public String getRules() {
//        return Rules;
//    }
//
//    public int getMinParticipant() {
//        return MinParticipant;
//    }
//
//    public int getMaxParticipant() {
//        return MaxParticipant;
//    }
//
//    public int getFees() {
//        return Fees;
//    }
//
//    public int getFeesMode() {
//        return FeesMode;
//    }
//
//    public String getDuration() {
//        return Duration;
//    }
//
//    public String getJudgingCriteria() {
//        return JudgingCriteria;
//    }
//
//    public String getClub() {
//        return Club;
//    }
}
