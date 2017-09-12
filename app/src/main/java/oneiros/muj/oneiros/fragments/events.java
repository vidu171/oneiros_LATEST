package oneiros.muj.oneiros.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import oneiros.muj.oneiros.Database.EventdbHelper;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.RetrivedEvent;
import oneiros.muj.oneiros.backend.recyclerViewAdapter;

/**
 * Created by aesher on 9/12/2017.
 */

public class events extends Fragment {


    static String clubs[]="Aperture#Cinefilia#Coreographia#Litmus#Scribbles#Shabd#Sophia#The Music Club".split("#");
    static String clubUniqueIds[]="-KtNY1ZLdhpVMvj_sFMx#-KtNY1ZTH2f8oV9miI28#-KtNY1ZTH2f8oV9miI29#-KtNY1ZTH2f8oV9miI2A#-KtNY1ZTH2f8oV9miI2B#-KtNY1ZU0kplfYYgVEOf#-KtNY1ZU0kplfYYgVEOg#-KtNY1ZU0kplfYYgVEOh".split("#");

    RecyclerView recyclerView;
    recyclerViewAdapter mAdapter;
    ArrayList<RetrivedEvent> List;
    LinearLayout Cinefilia, Aperture, Coreographia, Litmus, Scribbles, Shabd, Sophia, MusicClub ;



    private static SlidingUpPanelLayout mLayout;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_events,container,false);
        mLayout = v.findViewById(R.id.sliding_layout);

        List = new ArrayList<>();
        List.add(new RetrivedEvent("adaf","asda","fassa",1,2,3,4,"afaf","sfaf","fafaf","afsf","asfas","fsaf","asfasf"));
        List.add(new RetrivedEvent("adaf","asda","fassa",1,2,3,4,"afaf","sfaf","fafaf","afsf","asfas","fsaf","asfasf"));
        List.add(new RetrivedEvent("adaf","asda","fassa",1,2,3,4,"afaf","sfaf","fafaf","afsf","asfas","fsaf","asfasf"));
        List.add(new RetrivedEvent("adaf","asda","fassa",1,2,3,4,"afaf","sfaf","fafaf","afsf","asfas","fsaf","asfasf"));
        List.add(new RetrivedEvent("adaf","asda","fassa",1,2,3,4,"afaf","sfaf","fafaf","afsf","asfas","fsaf","asfasf"));


        mAdapter = new recyclerViewAdapter(getContext(),List);
        recyclerView = v.findViewById(R.id.RECYCLE);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
//        recyclerView.setNestedScrollingEnabled(false);

        ButterKnife.bind(this,v);

        Cinefilia = (LinearLayout) v.findViewById(R.id.cini);
        Aperture = (LinearLayout) v.findViewById(R.id.Aperture);
        Coreographia = (LinearLayout) v.findViewById(R.id.coreoe);
        Litmus = (LinearLayout) v.findViewById(R.id.Litmus);
        Scribbles = (LinearLayout) v.findViewById(R.id.scribbles);
        Shabd = (LinearLayout) v.findViewById(R.id.shabd);
        Sophia = (LinearLayout) v.findViewById(R.id.SOPHIA);
        MusicClub = (LinearLayout) v.findViewById(R.id.TMC);

        final EventdbHelper eventdbHelper = new EventdbHelper(getContext());
        Cinefilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[1]);
//                mAdapter.notifyDataSetChanged();
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        Aperture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[0]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        Coreographia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[2]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        Litmus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[3]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        Scribbles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[4]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        Shabd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[5]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        Sophia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[6]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });
        MusicClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List = eventdbHelper.getEventList(clubUniqueIds[7]);
                mAdapter = new recyclerViewAdapter(getContext(),List);
                recyclerView.setAdapter(mAdapter);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                mLayout.setTouchEnabled(false);
            }
        });



        return v;
    }
public static boolean ispanelEnabled(){
    return mLayout.getPanelState().equals(SlidingUpPanelLayout.PanelState.EXPANDED) || mLayout.getPanelState().equals(SlidingUpPanelLayout.PanelState.ANCHORED);
}

    public static void setPanelState(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

    }


}
