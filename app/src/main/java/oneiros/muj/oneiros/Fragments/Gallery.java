package oneiros.muj.oneiros.Fragments;

import java.util.Arrays;
import java.util.List;

import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 10/5/2017.
 */

public class Gallery {

    public static Gallery get() {
        return new Gallery();
    }

    private Gallery() {
    }

    public List<Image> getData() {
        return Arrays.asList(
                new Image(R.drawable.poster1),
                new Image(R.drawable.poster1),
                new Image(R.drawable.poster1),
                new Image(R.drawable.poster1),
                new Image(R.drawable.poster1),
                new Image(R.drawable.poster1));
    }
}