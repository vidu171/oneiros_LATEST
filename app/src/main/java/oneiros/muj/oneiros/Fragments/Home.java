package oneiros.muj.oneiros.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.R;
public class Home extends Fragment {
    FirebaseAuth mFirebaseAuth;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        mFirebaseAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.ScanQR)
    public void Scan_qr(View v){
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setPrompt("Place the event's QR code inside the viewfinder to register ");
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

}
