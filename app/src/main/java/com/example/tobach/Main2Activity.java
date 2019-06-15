package com.example.tobach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {
    private Toolbar mToolbar;
    private List<String> playerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.PLAYER_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        playerList.add("Toby");
        playerList.add("Bach");
        playerList.add("Test user 0");
        playerList.add("Test user 1");
        playerList.add("Test user 2");
        playerList.add("Test user 3");

        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new UserAdapter(playerList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lobby_menu, menu);
        return true;
    }

    /** Called when the user taps the Send button */
    public void addUser(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_user);
        String user = editText.getText().toString();
        if (!(user.equals(""))) {
            playerList.add(user);
            editText.getText().clear();

            mAdapter.notifyDataSetChanged();
        } else {
            editText.setError("Name fehlt!");
        }

        recyclerView.scrollToPosition(playerList.size() - 1);
    }

    public void startGame(MenuItem item) {
        Intent intend = new Intent(this, Main3Activity.class);
        intend.putStringArrayListExtra("playerList", new ArrayList<>(playerList));
        startActivity(intend);
    }
}
