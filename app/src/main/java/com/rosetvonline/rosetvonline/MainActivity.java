package com.rosetvonline.rosetvonline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.circularreveal.CircularRevealRelativeLayout;
import com.rosetvonline.rosetvonline.Home.HomeContainerActivity;


public class MainActivity extends AppCompatActivity {
    private CircularRevealRelativeLayout relativeLayout_title,relativeLayout_process;
    private ContentLoadingProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // for full screen------------------
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);*/
        /*Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/
        //---------end full screen code----

        setContentView(R.layout.activity_main);
        relativeLayout_title = findViewById(R.id.rl_title);
        relativeLayout_process = findViewById(R.id.rl_progress);
        progressBar = findViewById(R.id.processBar);

        checkConnection();//Check Internet Connection

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,1000);
                showProcessBar();
                gotoNExtFragment();
            }
        });
        thread.start();

        //off splash screen
        //startActivity(new Intent(this, HomeContainerActivity.class));//for direct access
    }
    private void gotoNExtFragment() {
        startActivity(new Intent(this, HomeContainerActivity.class));
        finish();
    }

    private void showProcessBar() {
        for (process = 0; process<100; process+=24) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(process);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkConnection() {
        boolean wifiConnection;
        boolean mobileConnection;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){
           /* wifiConnection = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnection = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if (wifiConnection){
                Toast.makeText(this, "wifiConnection", Toast.LENGTH_SHORT).show();
            }else if (mobileConnection){
                Toast.makeText(this, "mobileConnection", Toast.LENGTH_SHORT).show();
            }*/
        }else {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setTitle("Internet Connection Alart!")
                    .setMessage("Please Check Your Internet Connection")
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayout_title.setVisibility(View.VISIBLE);
            relativeLayout_process.setVisibility(View.VISIBLE);
        }
    };

    private int process;
    Runnable runnableProcess = new Runnable() {
        @Override
        public void run() {
            for (process = 40; process<=100; process+=20)
                try {
                    Thread.sleep(2000);
                    progressBar.setProgress(process);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    };
}
