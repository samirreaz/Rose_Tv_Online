package com.rosetvonline.rosetvonline.Home.Profile;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rosetvonline.rosetvonline.R;
import com.rosetvonline.rosetvonline.RoseC.Admin;
import com.rosetvonline.rosetvonline.Youtube.YoutubeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_viewFragment extends Fragment {
    private Button btn_Admin;
    private LinearLayoutCompat phone, web, youtube, facebook, mail, twitter;
    private WebView webView;


    public Profile_viewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate (R.layout.fragment_profile_view, container, false);
        btn_Admin = view.findViewById (R.id.btn_admin);
        phone = view.findViewById (R.id.phone);
        web = view.findViewById (R.id.web);
        youtube = view.findViewById (R.id.youtube);
        facebook = view.findViewById (R.id.facebook);
        mail = view.findViewById (R.id.mail);
        twitter = view.findViewById (R.id.twiter);
        //map = view.findViewById (R.id.map);
        //webView = view.findViewById (R.)


        btn_Admin.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (getContext (), Admin.class));
            }
        });


        phone.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String phone = "01888737020";
                Intent intent = new Intent (Intent.ACTION_DIAL, Uri.fromParts ("tel", phone, null));
                startActivity (intent);
            }
        });

        web.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String url = "http://rosetvonline.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        youtube.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/rosetvonline";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        facebook.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/rosetvonline";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        twitter.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/rosetvonline";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        mail.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String addresses ="rosetvonlinebd@gmail.com";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "RoseTvApp");
                if (intent.resolveActivity(getActivity ().getPackageManager ()) != null) {
                    startActivity(intent);
                }
            }
        });

        /*map.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        });*/
        return view;
    }

}
