package myapp.com.android_youtubeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;


//Implementing the on onlick listener will make so only 1 onClick button method can be
//  used for both the play and playlist buttons
public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener{



    //for a google api key need to go to https://console.developers.google.com
    private String GOOGLE_API_KEY = "PLACEHOLDER PUT YOUR KEY HERE";
    private String YOUTUBE_VIDEO_ID = "E5O7COyG1SI";
    private String YOUTUBE_PLAYLIST = "PLYhWuvAbCH8llykXc2dLguYbT6A_L7K2w";

    private Button btnPlayVideo,btnPlayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayList = (Button) findViewById(R.id.btnPlayList);

        //the buttons are now set so it can use the button listener of THIS class
        //no need to have on click listeners for each one
        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);

    }


    // This on click method is now wired to be used by the buttons defined above
    // using this method for a youtube player does not have or allow for toast messages
    @Override
    public void onClick(View v) {
        Intent intent = null;

        //will determine the ID of the button being clicked, and depending on which one it is, the action will be different
        switch (v.getId()){
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST);

                break;
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                break;
        }

        if (intent != null){
            startActivity(intent);
        }
    }
}
