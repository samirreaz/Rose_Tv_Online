package com.rosetvonline.rosetvonline.Youtube;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.rosetvonline.rosetvonline.R;

public class YoutubeActivity extends YouTubeBaseActivity {
    private TextView textView,titleView,discriptionView;
    private static final String API_KEY ="AIzaSyCFc5G-i_hM66FEYj0wWIVDpk0ZoMRqdXw";

    YouTubePlayerView youTubePlayerView;
    Button playBtn;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        //textView = findViewById(R.id.txtYoutube);
        titleView = findViewById(R.id.video_title);
        discriptionView = findViewById(R.id.video_description);
        youTubePlayerView = findViewById(R.id.youtube_player);
        playBtn = findViewById(R.id.btn_play);


        final String videoURL = getIntent().getExtras().getString("videoURL");
        String title = getIntent().getExtras().getString("videoTitle");
        String description = getIntent().getExtras().getString("videoDescription");

        //textView.setText(videoURL);
        titleView.setText(title);
        discriptionView.setText(description);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoURL);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(YoutubeActivity.this, "youtube Load Error", Toast.LENGTH_SHORT).show();
            }
        };


        youTubePlayerView.initialize(API_KEY,mOnInitializedListener);

    }
}
