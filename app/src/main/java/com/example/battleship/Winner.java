package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.battleship.R;

import static com.example.battleship.MainActivity.game;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        TextView winner = findViewById(R.id.txt_winner);
        winner.setTextColor(Color.rgb(0, 152, 53));
        winner.setText(game.players[game.getTurn()==0?1:1].getName() + " has Won");
    }

    public void onPlayAgain(View v){
        setContentView(R.layout.activity_main);
    }

}
