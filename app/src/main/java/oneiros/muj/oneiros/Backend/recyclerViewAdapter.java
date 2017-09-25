package oneiros.muj.oneiros.Backend;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import oneiros.muj.oneiros.Activities.EventDetails;
import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 9/12/2017.
 */

public class recyclerViewAdapter extends RecyclerView.Adapter <recyclerViewAdapter.MyViewHolder>  {

    private Context myContext;
    private ArrayList<RetrivedEvent> myProvider;


    public  recyclerViewAdapter(Context mContext, ArrayList<RetrivedEvent> mProvider){
        this.myContext= mContext;
        this.myProvider = mProvider;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_recycle_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final RetrivedEvent currentEvent= myProvider.get(position);
        holder.TITLE.setText(currentEvent.Name);
        holder.TITLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(myContext,EventDetails.class);
                i.putExtra("Name",currentEvent.Name);
                i.putExtra("Duration",currentEvent.Duration);
                i.putExtra("Fees",currentEvent.Fees);
                i.putExtra("FeesMode",currentEvent.FeesMode);
                i.putExtra("JudgingCriteria",currentEvent.JudgingCriteria);
                i.putExtra("MaxParticipant",currentEvent.MaxParticipant);
                i.putExtra("MinParticipant",currentEvent.MinParticipant);
                i.putExtra("Details",currentEvent.Details);
                i.putExtra("Rules",currentEvent.Rules);
                i.putExtra("EventKey",currentEvent.EventKey);
                i.putExtra("Time",currentEvent.Time);
                i.putExtra("RegistrationOpen",currentEvent.RegistrationOpen);
                Log.w("RegistrationOpen", String.valueOf(currentEvent.RegistrationOpen));
                i.putExtra("Location",currentEvent.Location);
                i.putExtra("Contact",currentEvent.Contact);
                Log.w("Check 123", currentEvent.EventKey);
                myContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myProvider.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        Button TITLE;

        MyViewHolder(View itemView) {
            super(itemView);
            TITLE = itemView.findViewById(R.id.Name);
        }

    }
}
