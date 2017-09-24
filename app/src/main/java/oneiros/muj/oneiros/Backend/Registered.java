package oneiros.muj.oneiros.Backend;

/**
 * Created by vidu on 11/9/17.
 */

public class Registered {
    public String EventId;
    public String Event;
    public String EmailId;
    public String UserId;
    public int FeesStatus;
    public Registered(){}
    public Registered(String EventId , int PaidStatus, String UserId, String Event, String EmailId){
        this.EventId=EventId;
        this.FeesStatus = PaidStatus;
        this.UserId = UserId;
        this.Event = Event;
        this.EmailId = EmailId;
    }
}
