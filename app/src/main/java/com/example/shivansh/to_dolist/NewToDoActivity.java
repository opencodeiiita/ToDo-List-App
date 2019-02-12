package com.example.shivansh.to_dolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class NewToDoActivity extends AppCompatActivity {
    EditText date;
    DatePickerDialog datePickerDialog;
    //Assigning key/Id pairs
    String T="taskName_editText_view";
    String D="description_editText_view";
    String P="priority_editText_view";
    String B="radio";

    String taskName;
    String description;
    String priority;
    boolean checked;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        EditText edit1 = (EditText)findViewById(R.id.taskName_editText_view);
        taskName = edit1.getText().toString();

        EditText edit2 = (EditText)findViewById(R.id.description_editText_view);
        description = edit2.getText().toString();

        EditText edit3 = (EditText)findViewById(R.id.priority_editText_view);
        priority = edit3.getText().toString();

        RadioButton rb1= (RadioButton)findViewById(R.id.radio);
        checked = ((RadioButton) rb1).isChecked();

        //saving the user's input
        savedInstanceState.putString(T, taskName);
        savedInstanceState.putString(D, description);
        savedInstanceState.putString(P, priority);
        savedInstanceState.putBoolean(B, checked);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state from saved instance
        taskName = savedInstanceState.getString(T);
        description = savedInstanceState.getString(D);
        priority = savedInstanceState.getString(P);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtodoactivity);
         date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(NewToDoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
