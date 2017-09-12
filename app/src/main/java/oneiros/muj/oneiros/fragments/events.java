package oneiros.muj.oneiros.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.backend.recyclerViewAdapter;
import oneiros.muj.oneiros.backend.recyclerViewProvider;

/**
 * Created by aesher on 9/12/2017.
 */

public class events extends Fragment {



    RecyclerView recyclerView;
    recyclerViewAdapter Adapter;
    List<recyclerViewProvider> List;



    private SlidingUpPanelLayout mLayout;

    @OnClick(R.id.cini)
        public void CINIFI(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

    }

    @OnClick(R.id.shabd)
        public void SHABD(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }

    @OnClick(R.id.Litmus)
        public void LITMUS(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }
    @OnClick(R.id.TMC)
        public void TMC(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }
    @OnClick(R.id.scribbles)
        public void SCRIBBLES(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }
    @OnClick(R.id.SOPHIA)
        public void SOPHIA(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }
    @OnClick(R.id.Aperture)
        public void Aperture(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }

    @OnClick(R.id.coreoe)
        public void coreoe(){
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events,container,false);
        mLayout = v.findViewById(R.id.sliding_layout);

        List = new ArrayList<>();
        Adapter = new recyclerViewAdapter(getContext(),List);
        recyclerView = v.findViewById(R.id.RECYCLE);
        demoVALUES();
        LinearLayoutManager layoutManager =  new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(Adapter);
        recyclerView.setNestedScrollingEnabled(false);

        ButterKnife.bind(this,v);

        return v;
    }


    public void demoVALUES(){


        recyclerViewProvider p1 = new recyclerViewProvider("MY NAME IS");
        List.add(p1);


    }


}
