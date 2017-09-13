package oneiros.muj.oneiros.backend;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import oneiros.muj.oneiros.R;


/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class HorizontalPager_utilities {

    public static void setupItem(final View view, final LibraryObject libraryObject) {
        final TextView txt = (TextView) view.findViewById(R.id.txt_item);
        txt.setText(libraryObject.getTitle());

        final ImageView img = (ImageView) view.findViewById(R.id.img_item);
        img.setImageResource(libraryObject.getRes());
    }

    public static class LibraryObject {

        private String mTitle;
        private int mRes;

        public LibraryObject(final int res, final String title) {
            mRes = res;
            mTitle = title;
        }

        public String getTitle() {
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
