package com.example.myapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.R;

public class FirstFragment extends Fragment {

    private EditText emailEditText;
    private EditText passwordEditText;
    private OnLoginFormSubmitListener callback;

    public interface OnLoginFormSubmitListener {
        void onLoginFormSubmit(String email, String password);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        emailEditText = view.findViewById(R.id.emailEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if (callback != null) {
                callback.onLoginFormSubmit(email, password);
            }
        });

        return view;
    }

    public void setOnLoginFormSubmitListener(OnLoginFormSubmitListener callback) {
        this.callback = callback;
    }
}
