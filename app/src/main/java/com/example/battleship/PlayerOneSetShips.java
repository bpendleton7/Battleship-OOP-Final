package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class PlayerOneSetShips extends AppCompatActivity implements View.OnClickListener{
    private PopupMenu popupMenu;
    private Button[][] buttons = new Button[10][10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_one_set_ships);

        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                String buttonID = "button_" + row + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[row][col] = findViewById(resID);
                buttons[row][col].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
//        startActivity(new Intent(this,Pop.class));
        if (((Button) v).getText().toString().equals("")) {
            ((Button) v).setBackgroundColor(Color.GRAY);
        }
    }

    public void doneOnClick(View v) {
        Intent intent = new Intent(this,PlayerTwoSetShips.class);
        startActivity(intent);
    }

    public void exitOnClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
