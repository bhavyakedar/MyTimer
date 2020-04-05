package com.example.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button,button2;
    MediaPlayer mediaPlayer;
    TextView textView;
    int time;
    public void stop(View view){
        mediaPlayer.stop();
    }

    public void setTime(View view){
        mediaPlayer = MediaPlayer.create(this,R.raw.audio);
        time = Integer.parseInt(editText.getText().toString());
        long time_in_milli = time*1000;
        new CountDownTimer(time_in_milli, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("00:"+(millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {
                mediaPlayer.start();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button2 = (Button) findViewById(R.id.button2);
    }
}
