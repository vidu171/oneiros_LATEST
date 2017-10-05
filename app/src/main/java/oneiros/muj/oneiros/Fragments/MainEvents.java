package oneiros.muj.oneiros.Fragments;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.List;

import oneiros.muj.oneiros.R;

/**
 * Created by aesher on 10/5/2017.
 */

public class MainEvents extends Fragment implements DiscreteScrollView.ScrollListener<GalleryAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<GalleryAdapter.ViewHolder>,View.OnClickListener {

    private ArgbEvaluator evaluator;
    private int currentOverlayColor;
    private int overlayColor;
    DiscreteScrollView itemPicker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_maineve,container,false);


        evaluator = new ArgbEvaluator();
        currentOverlayColor = ContextCompat.getColor(getContext(), R.color.galleryCurrentItemOverlay);
        overlayColor = ContextCompat.getColor(getContext(), R.color.galleryItemOverlay);

        Gallery gallery = Gallery.get();
        List<Image> data = gallery.getData();
         itemPicker = v.findViewById(R.id.item_picker);
        itemPicker.setAdapter(new GalleryAdapter(data));
        itemPicker.addScrollListener(this);
        itemPicker.addOnItemChangedListener(this);
        itemPicker.scrollToPosition(0);

        v.findViewById(R.id.fab_share).setOnClickListener(this);
        return v;
    }

    @Override
    public void onScroll(
            float currentPosition,
            int currentIndex, int newIndex,
            @Nullable GalleryAdapter.ViewHolder currentHolder,
            @Nullable GalleryAdapter.ViewHolder newCurrent) {
        if (currentHolder != null && newCurrent != null) {
            float position = Math.abs(currentPosition);
            currentHolder.setOverlayColor(interpolate(position, currentOverlayColor, overlayColor));
            newCurrent.setOverlayColor(interpolate(position, overlayColor, currentOverlayColor));
        }
    }

    @Override
    public void onCurrentItemChanged(@Nullable GalleryAdapter.ViewHolder viewHolder, int adapterPosition) {
        if (viewHolder != null) {
            viewHolder.setOverlayColor(currentOverlayColor);
        }
    }

    private int interpolate(float fraction, int c1, int c2) {
        return (int) evaluator.evaluate(fraction, c1, c2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fab_share:
                share(v);
                break;
        }

    }

    /*
    https://oneiros.co.in/major_event/requiem
    https://oneiros.co.in/major_event/destival
    https://oneiros.co.in/major_event/fashion_show
     */



    private void share(View view) {


        switch (itemPicker.getCurrentItem()){
            case 0:
                        GOTONET("https://oneiros.co.in/major_event/fashion_show");
                        break;

            case 1:
                         GOTONET("https://oneiros.co.in");
                        break;

            case 2:
                         GOTONET("https://oneiros.co.in/major_event/requiem");
                        break;

            case 3:
                GOTONET("https://oneiros.co.in/major_event/destival");
                break;

            case 4:

                GOTONET("https://oneiros.co.in");
                break;

        }

    }

    public  void GOTONET(String net){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(net));
        getContext().startActivity(i);
    }
}
