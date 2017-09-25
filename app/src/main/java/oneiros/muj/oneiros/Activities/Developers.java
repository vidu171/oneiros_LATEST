package oneiros.muj.oneiros.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import jp.wasabeef.blurry.Blurry;
import oneiros.muj.oneiros.Backend.HorizontalPager_utilities;
import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 9/13/2017.
 */

public class Developers extends AppCompatActivity {


    ImageView frameLayout;
    HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);
        frameLayout = findViewById(R.id.background_changer);


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                horizontalInfiniteCycleViewPager = findViewById(R.id.hicvp);
                horizontalInfiniteCycleViewPager.setVisibility(View.INVISIBLE);
                horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter_developers(getApplicationContext()));
            }
        };handler.postDelayed(runnable,37);


        Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                horizontalInfiniteCycleViewPager.setVisibility(View.VISIBLE);

            }
        };handler2.postDelayed(runnable2,41);

    }


    private class HorizontalPagerAdapter_developers extends PagerAdapter {





        String aashis = "I really have no idea what to put here. I really don't know what to say lol. I am just filling up the space. hahah Hope you like it. Oh and that on the top is my dog, Nibble. I love dogs. Are you a dog?";
        String siddhart = "The wizard of Manipal University. He can do magic with his laptop. Need help? Stuck at code? Knock at his place. He'll be keen to help........ Didn't answer? Must be sleeping ;D.";
        String vidyanshu = "CS engineer in making. Loves SpongeBob for no reason. Or maybe there is one. No one would ever know. And yeah Algorithms turns him on!";
        String akhil = "Dashing enthusiast and Dashing. Add one more of that Dashing. Also a survivor... Team Oneiros would know <3 ";
        String hodor = "Being a student of Information Technology, he has a inquisitive personality and a zeal to learn more with inclination towards Android Development and Cyber Security.";
        private final HorizontalPager_utilities.LibraryObject[] LIBRARIES = new HorizontalPager_utilities.LibraryObject[]{

                new HorizontalPager_utilities.LibraryObject(R.drawable.sid, R.drawable.sid_sid,"Siddhart Jaidka","Advisory"
                        ,siddhart),

                new HorizontalPager_utilities.LibraryObject(R.drawable.aashis, R.drawable.nibble_nibble,"Aashis Kumar","Core Committee"
                        ,aashis),

                new HorizontalPager_utilities.LibraryObject(R.drawable.team_vidyanshu, R.drawable.vidu,"Vidhyanshu Jain","Core Committee"
                        ,vidyanshu),

                new HorizontalPager_utilities.LibraryObject(R.drawable.akhil, R.drawable.akhil_akhil,"Akhil Gupta","Organizing Committee"
                        ,akhil),
                new HorizontalPager_utilities.LibraryObject(R.drawable.hodor, R.drawable.hodor_hodor,"Sanidhya Kumar","Volunteer"
                        ,hodor),

        };


        private LayoutInflater mLayoutInflater;


        public HorizontalPagerAdapter_developers(final Context context) {
            mLayoutInflater = LayoutInflater.from(context);

        }

        @Override
        public int getCount() {
            return 5;
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
            SET_BACKGROUND();
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


    public void SET_BACKGROUND(){
        int images[]= {R.drawable.sid_sid,R.drawable.nibble_nibble,R.drawable.vidu  ,R.drawable.akhil_akhil, R.drawable.hodor_hodor};
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), images[horizontalInfiniteCycleViewPager.getRealItem()]);
        frameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Blurry.with(Developers.this).animate(200).radius(13).async().from(largeIcon).into(frameLayout);

    }


}
