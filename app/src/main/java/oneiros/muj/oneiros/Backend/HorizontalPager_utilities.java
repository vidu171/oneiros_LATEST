package oneiros.muj.oneiros.Backend;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        final  ImageView faceBook = view.findViewById(R.id.facebook);

        faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(libraryObject.getLink()));
                view.getContext().startActivity(i);
            }
        });

    }






    public static class LibraryObject {
        private String mTitle;
        private int mRes;
        private int mBack;
        private String mDesig;
        private String mDescription;
        private String mLink;

        public LibraryObject(final int res, final int back, final String title, final String desig, final String description, final String Link) {
            mRes = res;
            mBack = back;
            mTitle = title;
            mDesig = desig;
            mDescription = description;
            mLink = Link;

        }


        String getLink() {return  mLink;}

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
