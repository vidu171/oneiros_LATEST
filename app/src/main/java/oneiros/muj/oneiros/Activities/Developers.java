package oneiros.muj.oneiros.Activities;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
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
    Bitmap largeIcon;
    HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager;
    int images[]= {R.drawable.sid_sid,R.drawable.vineet_vinnet,R.drawable.nibble_nibble,R.drawable.vidu  ,R.drawable.tushar_tushar, R.drawable.sha_sha,R.drawable.mad_mad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);
        frameLayout = findViewById(R.id.background_changer);

        horizontalInfiniteCycleViewPager = findViewById(R.id.hicvp);
        horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter_developers(getApplicationContext()));
//        int cx = horizontalInfiniteCycleViewPager.getWidth();
//        int cy = horizontalInfiniteCycleViewPager.getHeight();
//        float finalRadius = (float) Math.hypot(cx, cy)+100;
//        int CX = cx-80;
//        Animator anim = ViewAnimationUtils.createCircularReveal(horizontalInfiniteCycleViewPager,CX,0,0,finalRadius);
//        horizontalInfiniteCycleViewPager.setVisibility(View.VISIBLE);
//        anim.start();
    }


    private class HorizontalPagerAdapter_developers extends PagerAdapter {





        String aashis = "I really have no idea what to put here. I really don't know what to say lol. I am just filling up the space. hahah Hope you like it. Oh and that on the top is my dog, Nibble. I love dogs. Are you a dog?";
        String siddhart = "The wizard of Manipal University. He can do magic with his laptop. Need help? Stuck at code? Knock at his place. He'll be keen to help........ Didn't answer? Must be sleeping ;D.";
        String vidyanshu = "CS engineer in making. Loves SpongeBob for no reason. Or maybe there is one. No one would ever know. And yeah Algorithms turns him on!";

        String vineet = "One of the most hard working lad you'll get to meet in Manipal University. Age 20, Working as Student, Human. We thank our EC for working day and night for the website setup.";
        String sadana = "Error 404. ";
        String sasank = "Error 404. ";
        String Parth =  "Error 404. ";


        private final HorizontalPager_utilities.LibraryObject[] LIBRARIES = new HorizontalPager_utilities.LibraryObject[]{

                new HorizontalPager_utilities.LibraryObject(R.drawable.sid, R.drawable.sid_sid,"Siddhart Jaidka","Advisory"
                        ,siddhart),

                new HorizontalPager_utilities.LibraryObject(R.drawable.vineet, R.drawable.vineet_vinnet,"Vineet Sharma","Executive Committee"
                        ,vineet),

                new HorizontalPager_utilities.LibraryObject(R.drawable.aashis, R.drawable.nibble_nibble,"Aashis Kumar","Core Committee: App Development"
                        ,aashis),

                new HorizontalPager_utilities.LibraryObject(R.drawable.team_vidyanshu, R.drawable.vidu,"Vidhyanshu Jain","Core Committee: App Development"
                        ,vidyanshu),

                new HorizontalPager_utilities.LibraryObject(R.drawable.tushar, R.drawable.tushar_tushar,"Tushar Sadana","Core Committee: Web Development"
                        ,sadana),

                new HorizontalPager_utilities.LibraryObject(R.drawable.sha_sha, R.drawable.sha_sha,"Shashank Singh Solanki","Core Committee: Web Development"
                        ,sasank),

                new HorizontalPager_utilities.LibraryObject(R.drawable.mad, R.drawable.mad_mad,"Suyash Mandhana","Core Committee: Web Development"
                        ,Parth),



        };


        private LayoutInflater mLayoutInflater;


        HorizontalPagerAdapter_developers(final Context context) {
            mLayoutInflater = LayoutInflater.from(context);

        }

        @Override
        public int getCount() {
            return 7;
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

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void SET_BACKGROUND(){
        largeIcon = BitmapFactory.decodeResource(getResources(), images[horizontalInfiniteCycleViewPager.getRealItem()]);
        frameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Blurry.with(Developers.this).animate(200).radius(13).async().from(largeIcon).into(frameLayout);

    }


}
