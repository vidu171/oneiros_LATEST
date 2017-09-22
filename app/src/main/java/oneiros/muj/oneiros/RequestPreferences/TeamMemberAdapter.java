package oneiros.muj.oneiros.RequestPreferences;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import oneiros.muj.oneiros.R;

public class TeamMemberAdapter extends RecyclerView.Adapter<TeamMemberAdapter.MemberViewHolder> {
    ArrayList<TeamMembers> memberlist;
    Context context;

    public TeamMemberAdapter(ArrayList<TeamMembers> memberlist, Context context){
        this.memberlist = memberlist;
        this.context = context;
    }


    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card,parent,false);
        return new MemberViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {
            final TeamMembers currentMember = memberlist.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    // Todo Submit the user details to firebase
            }
        });
        holder.memberName.setText(currentMember.Name);
        holder.memberRegNo.setText(currentMember.RegNum);

        holder.memberName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentMember.Name = editable.toString();
            }
        });
        holder.memberRegNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentMember.RegNum = editable.toString();
            }
        });



    }

    @Override
    public int getItemCount() {
        return memberlist.size();
    }

    public static class MemberViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView memberName,memberRegNo;

        public MemberViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.memberCard);
            memberName = (TextView)itemView.findViewById(R.id.memberName);
            memberRegNo = (TextView) itemView.findViewById(R.id.memberRegNo);
            }
    }
}
