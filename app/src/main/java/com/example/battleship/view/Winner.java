package com.example.battleship.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.battleship.R;

import static com.example.battleship.view.MainActivity.game;

/**This class is used to display the final winner.*/

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        TextView winner = findViewById(R.id.txt_winner);
        winner.setTextColor(Color.rgb(255, 255, 255));
        winner.setText(game.players[game.getTurn()==0?1:0].getName() + " has Won");
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.winner);
        mediaPlayer.start();
    }

    public void onPlayAgain(View v){
        setContentView(R.layout.activity_main);
    }

}
