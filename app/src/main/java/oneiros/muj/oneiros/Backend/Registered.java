package oneiros.muj.oneiros.Backend;

/**
 * Created by vidu on 11/9/17.
 */

public class Registered {
    public String EventId;
    public String Event;
    public String UserId;
    public int FeesStatus;
    public int TotalFees;
    public String Time;
    public String RegKey;
    public Registered(){}
    public Registered(String EventId , int PaidStatus, String UserId, String Event, String Time, int TotalFees, String RegKey){
        this.EventId=EventId;
        this.FeesStatus = PaidStatus;
        this.UserId = UserId;
        this.Event = Event;
        this.Time = Time;
        this.TotalFees = TotalFees;
        this.RegKey = RegKey;
    }
}
