package oneiros.muj.oneiros.Backend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import oneiros.muj.oneiros.Fragments.Events;
import oneiros.muj.oneiros.Fragments.Home;
import oneiros.muj.oneiros.Fragments.MainEvents;
import oneiros.muj.oneiros.Fragments.Misc;

/**
 * Created by aesher on 9/12/2017.
 */

public class pagerAdapter extends FragmentStatePagerAdapter {

  //  private String [] title = {"EVENTS","HOME","Misc"};


    public pagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 : return new Events();
            case 1:  return new Home();
            case 2:  return new Misc();
            case 3: return  new MainEvents();
            default: return  new Home();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }



}
