package com.google.mediapipe.examples.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackFragment extends Fragment {


    public FeedbackFragment() {
        super(R.layout.fragment_feedback);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText etFIO = view.findViewById(R.id.editTextFIO);
        EditText etEmail = view.findViewById(R.id.editTextEmail);
        Button btnSend = view.findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(v -> {
            String fio = etFIO.getText().toString();
            String email = etEmail.getText().toString();

            etFIO.setText("");
            etEmail.setText("");

            Toast.makeText(getContext(), "Ваша заявка отправлена!", Toast.LENGTH_SHORT).show();
        });
    }
}