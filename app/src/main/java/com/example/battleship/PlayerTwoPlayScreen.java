package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.battleship.MainActivity.game;

public class PlayerTwoPlayScreen extends AppCompatActivity implements View.OnClickListener{

    private Button[][] buttons = new Button[10][10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_two_play_screen);
        setUpButtonArray();
        updateBoard(0);
    }

    @Override
    public void onClick(View v) {
        if (((Button) v).getText().toString().equals("")) {
            String[] strTag = v.getTag().toString().split("_");
            int row = Integer.parseInt(strTag[0]);
            int col = Integer.parseInt(strTag[1]);
            Player curPlayer = game.players[0];
            Board curBoard = curPlayer.getBoard();
            curBoard.checkForHit(row,col);
            switch (curBoard.board[row][col]) {
                case 1:
                    ((Button) v).setBackgroundColor(Color.BLUE);
                    break;
                case 2:
                    ((Button) v).setBackgroundColor(Color.rgb(255,165,0));
                    break;
            }
        }
        v.setEnabled(false);
        disableAllButtons(false);
    }

    //View own board with contentview
    public void viewPlayer2BoardOnClick(View v) {
        setContentView(R.layout.playertwoownboard);
        setUpButtonArray();
        disableAllButtons(false);
        updateBoard(1);
        Board pBoard = game.players[1].getBoard();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (pBoard.board[row][col] == 4){
                    buttons[row][col].setBackgroundColor(Color.GREEN);
                }
            }
        }
    }

    //Return to play screen
    public void returnOnClick(View v) {
        setContentView(R.layout.activity_player_two_play_screen);
        setUpButtonArray();
        updateBoard(0);
    }

    public void doneOnClick(View v) {
        disableAllButtons(true);
        Intent intent = new Intent(this,Transition.class);
        startActivity(intent);
    }

    public void updateBoard(int player){
        Player curPlayer = game.players[player];
        Board board  = curPlayer.getBoard();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                switch (board.board[row][col]){
                    case 1:
                        buttons[row][col].setBackgroundColor(Color.BLUE);
                        break;
                    case 2:
                        buttons[row][col].setBackgroundColor(Color.rgb(255,165,0));
                        break;
                    case 3:
                        buttons[row][col].setBackgroundColor(Color.rgb(195,0,22));
                        break;
                }

            }
        }
    }

    public void setUpButtonArray(){
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                String buttonID = "button_" + row + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[row][col] = findViewById(resID);
                buttons[row][col].setOnClickListener(this);
            }
        }
    }

    public void disableAllButtons(boolean boo){
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                buttons[row][col].setClickable(boo);
            }
        }
    }
}
