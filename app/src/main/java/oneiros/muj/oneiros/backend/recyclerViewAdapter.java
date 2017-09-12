package oneiros.muj.oneiros.backend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 9/12/2017.
 */

public class recyclerViewAdapter extends RecyclerView.Adapter <recyclerViewAdapter.MyViewHolder>  {

    private Context myContext;
    private List<recyclerViewProvider> myProvider;


    public  recyclerViewAdapter(Context mContext, List<recyclerViewProvider> mProvider){
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
        recyclerViewProvider pro= myProvider.get(position);
        holder.TITLE.setText(pro.getMyname());
    }

    @Override
    public int getItemCount() {
        return myProvider.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView TITLE;

        MyViewHolder(View itemView) {
            super(itemView);
            TITLE = itemView.findViewById(R.id.text);
        }

        @Override
        public void onClick(View view) {


        }
    }
}
