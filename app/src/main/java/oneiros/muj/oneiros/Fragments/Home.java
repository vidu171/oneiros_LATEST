package oneiros.muj.oneiros.Fragments;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.Activities.SplashScreen;
import oneiros.muj.oneiros.Backend.Registered;
import oneiros.muj.oneiros.Backend.RegistrationAdapter;
import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;

import static android.content.Context.MODE_PRIVATE;

public class Home extends Fragment {

    public  Boolean isCollapsed = false;
    FirebaseAuth mFirebaseAuth;
    private RegistrationAdapter rAdapter;
    SharedPreferences pref;
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

    @OnClick(R.id.recycler_event)
    public void COllapsed(View v){

        if(!isCollapsed){
            isCollapsed = true;
            recycle.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,470,getResources().getDisplayMetrics());
            recycle.requestLayout();
        }

        else {
            isCollapsed = false;
            recycle.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            recycle.requestLayout();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        mFirebaseAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this,view);
        isCollapsed = true;
        recycle.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,470,getResources().getDisplayMetrics());
        recycle.requestLayout();
        pref = view.getContext().getSharedPreferences("UserCredentials", MODE_PRIVATE);
        uName.setText(pref.getString("Name",null));
        uReg.setText(pref.getString("RegNo.",null));
        uUni.setText(pref.getString("University",null));
        uEmail.setText(mFirebaseAuth.getCurrentUser().getEmail());
        uID.setText(mFirebaseAuth.getCurrentUser().getUid());
        RegisteredEvent dbHelper = new RegisteredEvent(getContext());
        ArrayList<Registered> list = dbHelper.getRegisteredList();
        rListView = view.findViewById(R.id.rEventList);
        rListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rAdapter = new RegistrationAdapter(getActivity(),list);
        rListView.setAdapter(rAdapter);
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
