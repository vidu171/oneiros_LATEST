package oneiros.muj.oneiros.Backend;

/**
 * Created by vidu on 10/9/17.
 */

public class Registraion {

    public String UserId;
    public String EventId;
    public String Event;
    public String EmailId;
    public int TotalFees;
    public int FeesStatus;
    public String FinanceId;
    public String Time;
    public Registraion(){}
    Registraion(String UserId, String EventId, String Event, int TotalFees, int FeesStatus, String FinanceId, String Time){
        this.UserId=UserId;
        this.TotalFees=TotalFees;
        this.FeesStatus=FeesStatus;
        this.FinanceId=FinanceId;
        this.EventId = EventId;
        this.Event = Event;
        this.Time = Time;
    }
}