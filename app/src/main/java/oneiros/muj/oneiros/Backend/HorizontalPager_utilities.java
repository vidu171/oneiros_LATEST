package oneiros.muj.oneiros.Backend;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import oneiros.muj.oneiros.R;


/**
 * Created by GIGAMOLE on 8/18/16.
 */
class HorizontalPager_utilities {

    static void setupItem(final View view, final LibraryObject libraryObject) {
        final TextView txt = view.findViewById(R.id.txt_item);
        txt.setText(libraryObject.getTitle());

        final ImageView img = view.findViewById(R.id.img_item);
        img.setImageResource(libraryObject.getRes());

        final  TextView desc = view.findViewById(R.id.description);
        desc.setText(libraryObject.getDescription());

    }

    static class LibraryObject {

        private String mTitle;
        private int mRes;
        private String mDescription;

        LibraryObject(final int res, final String title, final String description) {
            mRes = res;
            mTitle = title;
            mDescription = description;
        }


        String getDescription() {return  mDescription;}

        String getTitle() {
            return mTitle;
        }

        public int getRes() {
            return mRes;
        }

        public void setRes(final int res) {
            mRes = res;
        }
    }
}
