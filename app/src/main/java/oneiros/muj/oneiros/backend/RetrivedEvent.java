package oneiros.muj.oneiros.backend;

/**
 * Created by vidu on 11/9/17.
 */

public class RetrivedEvent {

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
    public String EventKey;
    public String Contact;
    public String Time;
    public String Location;
    public boolean RegistrationOpen;
    public RetrivedEvent(){}
    public RetrivedEvent(String Name, String Details, String Rules, int MinParticipant, int MaxParticipant, int Fees, int FeesMode, String JudgingCriteria, String Duration, String Club, String EventKey, String Contact, String Time, String Location, boolean RegistrationOpen){
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
        this.EventKey = EventKey;
        this.Contact = Contact;
        this.Time = Time;
        this.Location = Location;
        this.RegistrationOpen = RegistrationOpen;
    }
}
