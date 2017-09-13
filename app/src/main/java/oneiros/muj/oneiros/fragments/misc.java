package oneiros.muj.oneiros.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.activities.DEvelopers;

/**
 * Created by aesher on 9/12/2017.
 */

public class misc extends Fragment {

    @OnClick(R.id.footer)
    public void open_dev(){
        startActivity(new Intent(getContext(), DEvelopers.class));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_misc,container,false);

        ButterKnife.bind(this,v);
        return v;
    }


    //Todo: DElete this from the linear layout when a proper shit is made

}
