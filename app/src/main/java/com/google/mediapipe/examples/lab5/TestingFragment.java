package com.google.mediapipe.examples.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TestingFragment extends Fragment {

    public TestingFragment() {
        super(R.layout.fragment_testing);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btnChoose = view.findViewById(R.id.buttonChoose);
        btnChoose.setOnClickListener(v -> {
            String[] animals = {"Треугольник", "Квадрат", "Круг"};

            int correctAnswerIndex = 1;

            final int[] selectedAnswer = {-1};

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle("У какой фигуры 4 угла?")
                    .setSingleChoiceItems(animals, -1, (dialog, which) -> {
                        selectedAnswer[0] = which;
                    })
                    .setPositiveButton("Ответить", (dialog, which) -> {
                        if (selectedAnswer[0] == correctAnswerIndex) {
                            Toast.makeText(requireContext(), "Верно!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(requireContext(), "Неверно!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Отмена", null)
                    .show();
        });
    }
}