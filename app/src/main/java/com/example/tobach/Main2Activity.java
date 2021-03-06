package com.example.tobach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private List<String> playerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        playerList = intent.getStringArrayListExtra("playerList");

        setRandomText();
    }

    public String getRandomPlayer() {
        Random rand = new Random();
        return playerList.get(rand.nextInt(playerList.size()));
    }

    public String getRandomText() {
        String[] gameTextList = getResources().getStringArray(R.array.game_text_list);
        Random rand = new Random();
        return gameTextList[rand.nextInt(gameTextList.length)];
    }

    public void setRandomTextView(View view) {
        setRandomText();
    }

    public void setRandomText() {
        TextView gameView = findViewById(R.id.game_view);
        String gameText = getRandomText();
        String playerOne = getRandomPlayer();
        Random rand = new Random();
        int amount = rand.nextInt(5 - 2 + 1) + 2;
        gameText = gameText.replace("{{ name }}", playerOne);
        gameText = gameText.replace("{{ amount }}", Integer.toString(amount));
        gameView.setText(gameText);
    }
}
