package oneiros.muj.oneiros.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import oneiros.muj.oneiros.Backend.HorizontalPager_utilities;
import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 9/13/2017.
 */

public class Developers extends AppCompatActivity {


    ImageView frameLayout;
    HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager;
    int images2[]= {R.drawable.asid_sid,R.drawable.avineet_vinnet,R.drawable.anibble_nibble,R.drawable.avidu  ,R.drawable.atushar_tushar, R.drawable.asha_sha,R.drawable.amad_mad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);
        frameLayout = findViewById(R.id.background_changer);
        frameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        horizontalInfiniteCycleViewPager = findViewById(R.id.hicvp);
        horizontalInfiniteCycleViewPager.setAdapter(new HorizontalPagerAdapter_developers(getApplicationContext()));

    }


    private class HorizontalPagerAdapter_developers extends PagerAdapter {





        String aashis = "I really have no idea what to put here. I really don't know what to say lol. I am just filling up the space. hahah Hope you like it. Oh and that on the top is my dog, Nibble. I love dogs. Are you a dog?";
        String siddhart = "The wizard of Manipal University. He can do magic with his laptop. Need help? Stuck at code? Knock at his place. He'll be keen to help........ Didn't answer? Must be sleeping ;D.";
        String vidyanshu = "CS engineer in making. Loves SpongeBob for no reason. Or maybe there is one. No one would ever know. And yeah Algorithms turns him on!";
        String vineet = "One of the most hard working lad you'll get to meet in Manipal University. Age 20, Working as Student, Human. We thank our EC for working day and night for the website setup.";
        String sadana = "Developer, Coder and Designer combined, Mr.Sadana played a key role in everything. Team Web and App Dev would forever be thankful to you for those popcorns and late night shelters.";
        String sasank = "Chilled personality with a 'ye to aaj rat hi ho jeaga' motto. But honestly the star performer of the committee";
        String Parth = "Being a student of CSE, he has a inquisitive personality and a zeal to learn more with inclination towards Android Development and Cyber Security.";


        private final HorizontalPager_utilities.LibraryObject[] LIBRARIES = new HorizontalPager_utilities.LibraryObject[]{

                new HorizontalPager_utilities.LibraryObject(R.drawable.sid, R.drawable.sid_sid,"Siddharth Jaidka","Advisory"
                        ,siddhart,"https://www.facebook.com/sidjaidka"),

                new HorizontalPager_utilities.LibraryObject(R.drawable.vineet, R.drawable.vineet_vinnet,"Vineet Sharma","Executive Committee"
                        ,vineet,"https://www.facebook.com/Vineetthesharma"),

                new HorizontalPager_utilities.LibraryObject(R.drawable.aashis, R.drawable.nibble_nibble,"Aashis Kumar","Core Committee: App Development"
                        ,aashis,"https://www.facebook.com/echoMeAesher"),

                new HorizontalPager_utilities.LibraryObject(R.drawable.team_vidyanshu, R.drawable.vidu,"Vidhyanshu Jain","Core Committee: App Development"
                        ,vidyanshu,"https://www.facebook.com/vidu.jain.3"),

                new HorizontalPager_utilities.LibraryObject(R.drawable.tushar, R.drawable.tushar_tushar,"Tushar Sadana","Core Committee: Web Development"
                        ,sadana,"https://www.facebook.com/Tushar94900"),

                new HorizontalPager_utilities.LibraryObject(R.drawable.sha_sha, R.drawable.sha_sha,"Shashank Singh Solanki","Core Committee: Web Development"
                        ,sasank,"https://www.facebook.com/sforshashank"),

                new HorizontalPager_utilities.LibraryObject(R.drawable.mad, R.drawable.mad_mad,"Suyash Mandhana","Core Committee: Web Development"
                        ,Parth,"https://www.facebook.com/suyash.mandhana.5"),



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
            SET_BACKGROUND(view);
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

    public void SET_BACKGROUND(View v){
        Glide.with(v.getContext()).load(images2[horizontalInfiniteCycleViewPager.getRealItem()]).into(frameLayout);
    }


}
