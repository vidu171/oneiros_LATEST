package oneiros.muj.oneiros.Backend;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.Date;

import oneiros.muj.oneiros.Constants;
import oneiros.muj.oneiros.Database.RegisteredEvent;
import oneiros.muj.oneiros.R;

/**
     * Created by aesher on 9/12/2017.
     */

    public class RegistrationAdapter extends RecyclerView.Adapter <oneiros.muj.oneiros.Backend.RegistrationAdapter.MyViewHolder>  {
    int notifyVal;
        private Context myContext;
        private ArrayList<Registered> registrationList;
        int count=0;
        public  RegistrationAdapter(Context mContext, ArrayList<Registered> registrationList){
            this.myContext= mContext;
            this.registrationList = registrationList;
        }



        @Override
        public oneiros.muj.oneiros.Backend.RegistrationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.r_event_list_item,parent,false);
            return new oneiros.muj.oneiros.Backend.RegistrationAdapter.MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final oneiros.muj.oneiros.Backend.RegistrationAdapter.MyViewHolder holder, int position) {
            final Registered currentReg= registrationList.get(position);
            holder.eventTitle.setText(currentReg.Event);
            holder.totalFees.setText("Total Fees: "+currentReg.TotalFees);
            holder.time.setText(currentReg.Time);
            holder.rID.setText("Event ID: " + currentReg.RegKey);
            if(currentReg.FeesStatus==1)
                holder.fees_status.setBackgroundColor(Color.parseColor("#8cc152"));//green
            else
                holder.fees_status.setBackgroundColor(Color.parseColor("#da4453"));//red
//            holder.itemView.post(new Runnable()
//            {
//                @Override
//                public void run()
//                {   try{
//                    if(count==0) {
//                        int Height = holder.itemView.getHeight();
//                        SharedPreferences.Editor editor = myContext.getSharedPreferences("HeightPref", MODE_PRIVATE).edit();
//                        editor.putInt("Height", Height);
//                        editor.apply();
//                        count++;
//                    }}
//                catch (Exception e){}
//
//                }
//            });
            holder.viewQR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
                    LayoutInflater inflater = LayoutInflater.from(view.getContext());
                    View dialogueView = inflater.inflate(R.layout.dialogue_view_qr,null);
                    builder.setView(dialogueView);
                    ImageView imageView = dialogueView.findViewById(R.id.Qr_view_holder);
                    try{
                        BitMatrix bitMatrix = multiFormatWriter.encode(currentReg.RegKey, BarcodeFormat.QR_CODE,300,300);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        imageView.setImageBitmap(bitmap);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    builder.create().show();
                }
            });
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child(Constants.REGISTRATION_TABLE_REFERENCE).child(currentReg.RegKey);
            ref.addChildEventListener(new ChildEventListener() {
                public void onChildAdded(DataSnapshot dataSnapshot, String previousKey) {}
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Long feesVal;
                    try {
                        feesVal    = dataSnapshot.getValue(Long.class);
                    }
                    catch (Exception e){
                        feesVal = null;
                    }
                    if(feesVal!=null) {
                        if (feesVal == 1) {
                            holder.fees_status.setBackgroundColor(Color.parseColor("#8cc152"));//green
                            new RegisteredEvent(myContext).confirmUpdate(holder.rID.getText().toString().trim().replace("Event ID: ", ""));
                            Bitmap icon = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.ono_notify);
                            Notification notification = new NotificationCompat.Builder(myContext)
                                    .setContentTitle("Event Fee Receipt")
                                    .setContentText("Payment for event "+holder.eventTitle.getText().toString().toLowerCase()+" received successfully!")
                                    .setLargeIcon(icon)
                                    .setSmallIcon(R.drawable.ic_snotify)
                                    .setWhen(System.currentTimeMillis())
                                    .setOngoing(false)
                                    .setVibrate(new long[]{1000, 1000})
                                    .build();
                            try {
                                notification.contentView.setViewVisibility(myContext.getResources().getIdentifier("right_icon", "id", android.R.class.getPackage().getName()), View.INVISIBLE);
                            }catch(Exception es){}
                            NotificationManager mNotificationManager = (NotificationManager) myContext.getSystemService(Context.NOTIFICATION_SERVICE);
                            notifyVal = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
                            mNotificationManager.notify(notifyVal, notification);
                        } else {
                            holder.fees_status.setBackgroundColor(Color.parseColor("#da4453"));//red
                            new RegisteredEvent(myContext).RefundUpdate(holder.rID.getText().toString().trim().replace("Event ID: ", ""));
                        }
                    }
                }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {}
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
                @Override
                public void onCancelled(DatabaseError databaseError) {}

            });
        }

        @Override
        public int getItemCount() {
            return registrationList.size();
        }

        static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView eventTitle;
            TextView totalFees;
            TextView time;
            TextView rID;
            ImageView viewQR;
            LinearLayout fees_status;

            MyViewHolder(View itemView) {
                super(itemView);
                eventTitle = itemView.findViewById(R.id.eventTitle);
                totalFees = itemView.findViewById(R.id.totalFees);
                time = itemView.findViewById(R.id.time);
                rID = itemView.findViewById(R.id.rID);
                viewQR = itemView.findViewById(R.id.viewQR);
                fees_status = itemView.findViewById(R.id.fees_status);
            }

        }
    }
