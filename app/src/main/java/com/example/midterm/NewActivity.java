package com.example.midterm;

import static com.example.midterm.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        layout = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                layout.setBackgroundColor(getResources().getColor(R.color.red));
                return true;
            case R.id.menu_green:
                layout.setBackgroundColor(getResources().getColor(R.color.green));
                return true;
            case R.id.menu_yellow:
                layout.setBackgroundColor(getResources().getColor(R.color.yellow));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

