package oneiros.muj.oneiros.Backend;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import oneiros.muj.oneiros.R;


public class HorizontalPager_utilities {

    public static void setupItem(final View view, final LibraryObject libraryObject) {


        final ImageView back_image = view.findViewById(R.id.back_image);
         Glide.with(view.getContext()).load(libraryObject.getBack()).centerCrop().into(back_image);

        final CircleImageView profile = view.findViewById(R.id.profile_image);
        Glide.with(view.getContext()).load(libraryObject.getRes()).into(profile);

        final TextView Name = view.findViewById(R.id.name);
        Name.setText(libraryObject.getTitle());

        final  TextView DESC = view.findViewById(R.id.desc);
        DESC.setText(libraryObject.getDeig());


        final TextView Description = view.findViewById(R.id.description);
        Description.setText(libraryObject.getDescription());

    }






    public static class LibraryObject {
        private String mTitle;
        private int mRes;
        private int mBack;
        private String mDesig;
        private String mDescription;

        public LibraryObject(final int res, final int back, final String title, final String desig, final String description) {
            mRes = res;
            mBack = back;
            mTitle = title;
            mDesig = desig;
            mDescription = description;
        }




        String getTitle() {
            return mTitle;
        }

        public int getRes() {
            return mRes;
        }

        public int getBack(){return mBack;}

        String getDeig(){return  mDesig;}

        String getDescription() {return  mDescription;}





        public void setRes(final int res) {
            mRes = res;
        }

        public void setBack(final int back){
            mBack = back;
        }

    }
}
