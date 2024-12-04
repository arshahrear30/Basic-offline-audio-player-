package com.timeforschool.problem;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.BlockedNumberContract;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import soup.neumorphism.NeumorphButton;

public class MainActivity extends AppCompatActivity {

//----------------------------------------------------------------------------------------------

    MediaPlayer mediaPlayer;

///////////////////কোনো class অথবা
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //////////// findViewById কে onCreate এর মধ্যে ইনিশিয়ালাইজ করুন
        Button buttons1=findViewById(R.id.button1);
        Button buttons2=findViewById(R.id.button2);

        //////////// প্রথম বাটনের ক্লিক লিসেনার
        buttons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer != null)mediaPlayer.release(); //best use for audio
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mulk);
                    mediaPlayer.start();
            }
        });

//////////////////////////////////////////////////

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
//----------------------------------------------------------------------------------------------

}
