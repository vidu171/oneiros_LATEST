package oneiros.muj.oneiros.Activities;

/**
 * Created by aesher on 9/25/2017.
 */

public class UserCreds {
    public String Name;
    public String EmailId;
    public String Contact;
    public String RegNum;
    public String University;


    public UserCreds(String Name, String EmailId, String Contact, String RegNum, String University){
        this.Name = Name;
        this.EmailId = EmailId;
        this.RegNum = RegNum;
        this.Contact = Contact;
        this.University = University;
    }
    public UserCreds(){}

}

