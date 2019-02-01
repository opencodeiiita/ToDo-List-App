package com.example.shivansh.to_dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        RecyclerView todoList = findViewById(R.id.todoList);
        todoList.setLayoutManager(new LinearLayoutManager(this));
        String[] taskname = {"Task1", "Task2", "Task3", "Task4", "Task5","Task6","Task7","Task8","Task9","Task10"};
        todoList.setAdapter(new ToDoTaskAdapter(taskname));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newtask = new Intent(getApplicationContext(), NewToDoActivity.class);
                startActivity(newtask);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
