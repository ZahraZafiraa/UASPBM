package com.example.literashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class LoginActivity extends AppCompatActivity {

    private RadioButton adminRadio, userRadio;
    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private String selectedRole = "USER"; // Default

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        adminRadio = findViewById(R.id.adminRadio);
        userRadio = findViewById(R.id.userRadio);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Toggle role selection
        adminRadio.setOnClickListener(v -> selectedRole = "ADMIN");
        userRadio.setOnClickListener(v -> selectedRole = "USER");

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedRole.equals("ADMIN")) {
                // Arahkan ke halaman admin
                Intent intent = new Intent(this, AdminDashboardActivity.class);
                startActivity(intent);
            } else {
                // Arahkan ke halaman user
                Intent intent = new Intent(this, UserDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}