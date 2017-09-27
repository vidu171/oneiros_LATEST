package oneiros.muj.oneiros.Fragments;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.Backend.Registered;
import oneiros.muj.oneiros.Backend.RegistrationAdapter;
import oneiros.muj.oneiros.Constants;
import oneiros.muj.oneiros.DAO.FetchRegistrationDAO;
import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;

import static android.content.Context.MODE_PRIVATE;

public class Home extends Fragment {



    SharedPreferences prefs;
    int rotationAngle = 0;
    public  Boolean isCollapsed = false;
    FirebaseAuth mFirebaseAuth;
    private RegistrationAdapter rAdapter;
    SharedPreferences pref;
    ArrayList<Registered> list;
    View view;
    RecyclerView rListView;
    @BindView(R.id.uName)
    TextView uName;
    @BindView(R.id.uEmail)
    TextView uEmail;
    @BindView(R.id.uID)
    TextView uID;
    @BindView(R.id.uUni)
    TextView uUni;
    @BindView(R.id.uReg)
    TextView uReg;
    @BindView(R.id.recycler_event)
    LinearLayout recycle;
    @BindView(R.id.arrow)
    ImageView arrow_collapse;

    @BindView(R.id.focus)
    ImageView FOCUS;

    @BindView(R.id.scrollableContents)
    ScrollView scrollView;

    @OnClick(R.id.recycler_event)
    public void COllapsed(View v){

        if(!isCollapsed){
            isCollapsed = true;
            ObjectAnimator anim = ObjectAnimator.ofFloat(arrow_collapse, "rotation",rotationAngle, rotationAngle + 180);
            anim.setDuration(500);
            anim.start();
            rotationAngle += 180;
            rotationAngle = rotationAngle%360;
            int height = prefs.getInt("Height", 172);
            if (height != 0) {
                System.out.println("height"+height);
                rListView.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,(height/ getContext().getResources().getDisplayMetrics().density)*2,getResources().getDisplayMetrics());
            }
            rListView.requestLayout();
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(View.FOCUS_UP);
                }
            });

        }

        else {

            isCollapsed = false;
            ObjectAnimator anim = ObjectAnimator.ofFloat(arrow_collapse, "rotation",rotationAngle, rotationAngle + 180);
            anim.setDuration(500);
            anim.start();
            rotationAngle += 180;
            rotationAngle = rotationAngle%360;
            rListView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            rListView.requestLayout();
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            });
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        mFirebaseAuth = FirebaseAuth.getInstance();
        isCollapsed = true;
        ButterKnife.bind(this,view);
        rListView = view.findViewById(R.id.rEventList);
        pref = view.getContext().getSharedPreferences("UserCredentials", MODE_PRIVATE);
        uName.setText(pref.getString("Name",null));
        uReg.setText(pref.getString("RegNo.",null));
        uUni.setText(pref.getString("University",null));
        uEmail.setText(mFirebaseAuth.getCurrentUser().getEmail());
        uID.setText(mFirebaseAuth.getCurrentUser().getUid());
        RegisteredEvent dbHelper = new RegisteredEvent(getContext());
        list = dbHelper.getRegisteredList();
        rListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rAdapter = new RegistrationAdapter(getActivity(),list);
        rListView.setAdapter(rAdapter);
        prefs =getContext().getSharedPreferences("HeightPref", MODE_PRIVATE);
        int height = prefs.getInt("Height", 172);
        if (height != 0) {
            System.out.println("height"+height);
            rListView.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,(height/ getContext().getResources().getDisplayMetrics().density)*2,getResources().getDisplayMetrics());
        }
        rListView.requestLayout();

        if(list.size()<2){
            arrow_collapse.setVisibility(View.INVISIBLE);
            rListView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        return view;
    }

    @OnClick(R.id.ScanQR)
    public void Scan_qr(View v){
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setPrompt("Place the event's QR code inside the viewfinder to register \n\n");
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }
    @OnClick(R.id.ViewQR)
    public void View_qr(){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogueView = inflater.inflate(R.layout.dialogue_view_qr,null);
        builder.setView(dialogueView);
        ImageView imageView = dialogueView.findViewById(R.id.Qr_view_holder);
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(mFirebaseAuth.getCurrentUser().getUid(), BarcodeFormat.QR_CODE,300,300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        builder.create().show();
    }

    @Override
    public void onResume() {
        super.onResume();
        RegisteredEvent dbHelper = new RegisteredEvent(getContext());
        ArrayList<Registered> list = dbHelper.getRegisteredList();
        rAdapter = new RegistrationAdapter(getActivity(),list);
        rListView.setAdapter(rAdapter);

    }
}
