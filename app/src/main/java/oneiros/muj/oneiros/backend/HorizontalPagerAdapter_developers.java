package oneiros.muj.oneiros.backend;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import oneiros.muj.oneiros.R;



/**
 * Created by aesher on 9/13/2017.
 */

public class HorizontalPagerAdapter_developers extends PagerAdapter {



    private final HorizontalPager_utilities.LibraryObject[] LIBRARIES = new HorizontalPager_utilities.LibraryObject[]{

            new HorizontalPager_utilities.LibraryObject(R.drawable.team_sid,
                    "Advisor Dubeldore"),
            new HorizontalPager_utilities.LibraryObject(R.drawable.team_aashis,
                    "CC L"),
            new HorizontalPager_utilities.LibraryObject(R.drawable.team_vidyanshu,
                    "CC SpongeBob"),
            new HorizontalPager_utilities.LibraryObject(R.drawable.oneiros_glow,
                    "OC Tom"),
            new HorizontalPager_utilities.LibraryObject(R.drawable.team_akhil,
                    "OC Joney Bravo"),
            new HorizontalPager_utilities.LibraryObject(R.drawable.team_ankita,
                    "Volunteer Chip"),


    };


    private LayoutInflater mLayoutInflater;


    public HorizontalPagerAdapter_developers(final Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;
            view = mLayoutInflater.inflate(R.layout.developer_item, container, false);
            HorizontalPager_utilities.setupItem(view, LIBRARIES[position]);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}



