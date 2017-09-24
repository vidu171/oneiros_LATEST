package oneiros.muj.oneiros.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import oneiros.muj.oneiros.Database.EventdbHelper;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.Backend.RetrivedEvent;
import oneiros.muj.oneiros.Backend.recyclerViewAdapter;

/**
 * Created by aesher on 9/12/2017.
 */

public class Events extends Fragment {


    static String clubs[]="Aperture#Cinefilia#Coreographia#Litmus#Scribbles#Shabd#Sophia#The Music Club".split("#");
    static String clubUniqueIds[]="-KtNY1ZLdhpVMvj_sFMx#-KtNY1ZTH2f8oV9miI28#-KtNY1ZTH2f8oV9miI29#-KtNY1ZTH2f8oV9miI2A#-KtNY1ZTH2f8oV9miI2B#-KtNY1ZU0kplfYYgVEOf#-KtNY1ZU0kplfYYgVEOg#-KtNY1ZU0kplfYYgVEOh".split("#");

    RecyclerView recyclerView;
    recyclerViewAdapter mAdapter;
    ArrayList<RetrivedEvent> List;
    LinearLayout Cinefilia, Aperture, Coreographia, Litmus, Scribbles, Shabd, Sophia, MusicClub;

    CircleImageView one,two,three,four,five,six,seven,eight;



    private static SlidingUpPanelLayout mLayout;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_events,container,false);
        mLayout = v.findViewById(R.id.sliding_layout);

        List = new ArrayList<>();
        mAdapter = new recyclerViewAdapter(getContext(),List);
        recyclerView = v.findViewById(R.id.RECYCLE);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        one = v.findViewById(R.id.ONE);
        two = v.findViewById(R.id.TWO);
        three = v.findViewById(R.id.THREE);
        four = v.findViewById(R.id.FOUR);
        five = v.findViewById(R.id.FIVE);
        six = v.findViewById(R.id.SIX);
        seven = v.findViewById(R.id.SEVEN);
        eight = v.findViewById(R.id.EIGHT);
//        recyclerView.setNestedScrollingEnabled(false);

        Glide.with(getActivity()).load(R.drawable.ono_cini).into(one);
        Glide.with(getActivity()).load(R.drawable.ono_shabd).into(two);
        Glide.with(getActivity()).load(R.drawable.ono_litmus).into(three);
        Glide.with(getActivity()).load(R.drawable.ono_tmc).into(four);
        Glide.with(getActivity()).load(R.drawable.scr).fitCenter().into(five);
        Glide.with(getActivity()).load(R.drawable.ono_sophia).into(six);
        Glide.with(getActivity()).load(R.drawable.ono_aper).into(seven);
        Glide.with(getActivity()).load(R.drawable.ono_coreo).into(eight);

        ButterKnife.bind(this,v);

        Cinefilia = v.findViewById(R.id.cini);
        Aperture = v.findViewById(R.id.Aperture);
        Coreographia = v.findViewById(R.id.coreoe);
        Litmus = v.findViewById(R.id.Litmus);
        Scribbles = v.findViewById(R.id.scribbles);
        Shabd = v.findViewById(R.id.shabd);
        Sophia = v.findViewById(R.id.SOPHIA);
        MusicClub = v.findViewById(R.id.TMC);

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
