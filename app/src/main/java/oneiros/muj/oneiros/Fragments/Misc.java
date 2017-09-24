package oneiros.muj.oneiros.Fragments;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oneiros.muj.oneiros.BuildConfig;
import oneiros.muj.oneiros.R;
import oneiros.muj.oneiros.Activities.Developers;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by aesher on 9/12/2017.
 */

public class Misc extends Fragment {
    View v;
    @OnClick(R.id.footer)
    public void open_dev(){
        startActivity(new Intent(getContext(), Developers.class));
    }
    @OnClick(R.id.RateUs)
    public void appRateCardClick(View view) {
        String appPackageName = v.getContext().getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_misc,container,false);

        ButterKnife.bind(this,v);
        return v;
    }


    @OnClick(R.id.miscsubmit)
    public void submitFeedback() {
        try {
            InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        } catch (Exception e) {
        }
        String SUBJECT = ((TextView) v.findViewById(R.id.feedback_subject)).getText().toString();
        String MESSAGE = ((TextView) v.findViewById(R.id.feedback_message)).getText().toString();
        String NAME = ((TextView) v.findViewById(R.id.feedback_name)).getText().toString();
        String CONTACT = ((TextView) v.findViewById(R.id.feedback_contact)).getText().toString();
        if (SUBJECT.equals(BuildConfig.FLAVOR) || MESSAGE.equals(BuildConfig.FLAVOR)|| NAME.equals(BuildConfig.FLAVOR)|| CONTACT.equals(BuildConfig.FLAVOR)) {
            Toast.makeText(v.getContext(), "Subject, Message, Name & Contact fields cannot be blank!", 1).show();
            return;
        }
        Toast.makeText(v.getContext(), "Sending feedback", 0).show();
        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        requestQueue.add(new msgcheck(1, "http://mitas.esy.es/test.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                if(response.equals("success")) {
                    Toast.makeText(v.getContext(), "We have received your feedback!", 1).show();
                    ((TextView) v.findViewById(R.id.feedback_subject)).setText(BuildConfig.FLAVOR);
                    ((TextView) v.findViewById(R.id.feedback_message)).setText(BuildConfig.FLAVOR);
                    ((TextView) v.findViewById(R.id.feedback_name)).setText(BuildConfig.FLAVOR);
                    ((TextView) v.findViewById(R.id.feedback_contact)).setText(BuildConfig.FLAVOR);
                }
                else{
                    Toast.makeText(v.getContext(), "Your feedback could not be submitted due to an error.", 1).show();
                    ((TextView) v.findViewById(R.id.feedback_subject)).setText(BuildConfig.FLAVOR);
                    ((TextView) v.findViewById(R.id.feedback_message)).setText(BuildConfig.FLAVOR);
                    ((TextView) v.findViewById(R.id.feedback_name)).setText(BuildConfig.FLAVOR);
                    ((TextView) v.findViewById(R.id.feedback_contact)).setText(BuildConfig.FLAVOR);
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(v.getContext(), "Your feedback could not be submitted due to an error.", 1).show();
            }
        }, SUBJECT, MESSAGE,NAME,CONTACT));
    }

    class msgcheck extends StringRequest {
        final String val$MESSAGE;
        final String val$SUBJECT;
        final String val$NAME;
        final String val$CONTACT;
        msgcheck(int x0, String x1, Response.Listener x2, Response.ErrorListener x3, String str, String str2, String str3, String str4) {
            super(x0, x1, x2, x3);
            this.val$SUBJECT = str;
            this.val$MESSAGE = str2;
            this.val$NAME = str3;
            this.val$CONTACT = str4;
        }
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> params = new HashMap();
            params.put("Content-Type", "application/x-www-form-urlencoded");
            return params;
        }

        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap();
            params.put("subject", this.val$SUBJECT);
            params.put("message", this.val$MESSAGE);
            params.put("name", this.val$NAME);
            params.put("contact", this.val$CONTACT);
            return params;
        }
    }

}
