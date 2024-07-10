package com.example.midterm;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapp.ui.fragment.FirstFragment;
import com.example.myapp.ui.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnLoginFormSubmitListener {

    private EditText editText;
    private TextView textView;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        Button buttonSend = findViewById(R.id.buttonSend);
        Button buttonAlert = findViewById(R.id.buttonAlert);

        FirstFragment firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer1, firstFragment);
        transaction.replace(R.id.fragmentContainer2, secondFragment);
        transaction.commit();

        firstFragment.setOnLoginFormSubmitListener(this);

        buttonSend.setOnClickListener(v -> {
            String data = editText.getText().toString();
            secondFragment.updateText(data);
        });

        buttonAlert.setOnClickListener(v -> showAlertDialog());
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Navigate to new activity?")
                .setPositiveButton("OK", (dialog, which) -> {
                    Intent intent = new Intent(MainActivity.this, NewActivity.class);
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoginFormSubmit(String email, String password) {
        textView.setText("Email: " + email + "\nPassword: " + password);
    }
}
