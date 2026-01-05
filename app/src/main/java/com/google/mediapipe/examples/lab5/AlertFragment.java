package com.google.mediapipe.examples.lab5;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class AlertFragment extends Fragment {

    private static final int NOTIFICATION_PERMISSION_CODE = 100;
    private Button btn;

    public AlertFragment() {
        super(R.layout.fragment_alert);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert, container, false);
        btn = view.findViewById(R.id.btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, NOTIFICATION_PERMISSION_CODE);
            }
        }

        MyPushNotification myPushNotification = new MyPushNotification(requireContext());

        btn.setOnClickListener(view1 -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(requireContext(), "Разрешение на уведомления не предоставлено", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            myPushNotification.sendNotify("Данные студента","Эргашев Сардарбек Шухратович Т-423901-НТ");
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == NOTIFICATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(requireContext(), "Разрешение получено", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Разрешение отклонено", Toast.LENGTH_SHORT).show();
            }
        }
    }
}