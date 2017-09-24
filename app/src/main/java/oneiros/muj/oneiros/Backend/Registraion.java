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
    public String PaymentMode;
    public String RandomKey;
    public Registraion(){}
    Registraion(String UserId, String EventId, String Event, int TotalFees, int FeesStatus, String PaymentMode, String RandomKey){
        this.UserId=UserId;
        this.TotalFees=TotalFees;
        this.FeesStatus=FeesStatus;
        this.PaymentMode=PaymentMode;
        this.EventId = EventId;
        this.Event = Event;
        this.RandomKey = RandomKey;
    }
}