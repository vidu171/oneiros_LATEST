package oneiros.muj.oneiros.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 9/12/2017.
 */

public class events extends Fragment {

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
        ButterKnife.bind(this,v);
        mLayout = v.findViewById(R.id.sliding_layout);
        return v;
    }


}
