package oneiros.muj.oneiros.backend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import oneiros.muj.oneiros.fragments.events;
import oneiros.muj.oneiros.fragments.home;
import oneiros.muj.oneiros.fragments.misc;

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
            case 0 : return new events();
            case 1:  return new home();
            case 2:  return new misc();
            default: return  new home();
        }
    }

    @Override
    public int getCount() {
        return 3;
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
