package oneiros.muj.oneiros.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gordonwong.materialsheetfab.MaterialSheetFab;

import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.samples.Fab;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;


/**
 * Created by aesher on 9/12/2017.
 */

public class home extends Fragment {
    private static MaterialSheetFab materialSheetFab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
//        Fab floatingActionButton = view.findViewById(R.id.main);
//        View sheetView = view.findViewById(R.id.fab_sheet);
//        View overlay = view.findViewById(R.id.overlay);
//
//
//        Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                new MaterialTapTargetPrompt.Builder(getActivity())
//                        .setBackgroundColour(ContextCompat.getColor(getContext(),R.color.One))
//                        .setPrimaryTextColour(ContextCompat.getColor(getContext(),R.color.main))
//                        .setTarget(view.findViewById(R.id.main))
//                        .setPrimaryText("Start your club registrations")
//                        .setSecondaryText("Tap the envelop to do shit")
//                        .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
//                        {
//                            @Override
//                            public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state)
//                            {
//                                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
//                                {
//                                    // User has pressed the prompt target
//                                }
//                                // just for fun
//                            }
//                        })
//                        .show();
////kjkl
//            }
//        };handler.postDelayed(runnable,1000);
//
//
//
//
//
//        int sheetColor = ContextCompat.getColor(getContext(),R.color.white);
//        int fabColor = ContextCompat.getColor(getContext(),R.color.colorAccent);
//
//        materialSheetFab = new MaterialSheetFab<>(floatingActionButton, sheetView, overlay, sheetColor, fabColor);
//
        return view;
    }
//
//
//
//
//    public static boolean isFab()
//    {
//        return materialSheetFab.isSheetVisible();
//    }
//
//
//    public static void CLOSE_FAB(){
//        materialSheetFab.hideSheet();
//    }

}
