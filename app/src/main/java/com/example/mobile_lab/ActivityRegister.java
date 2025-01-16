package com.example.mobile_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.mobile_lab.databinding.ActivityRegisterBinding;

public class ActivityRegister extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonRegister.setOnClickListener(this::fnCalculateAge);
        binding.buttonExpense.setOnClickListener(this::fnGoExpense);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        Intent intent = getIntent();
        binding.editTextUsername.setText(intent.getStringExtra("username"));
        binding.editTextPassword.setText(intent.getStringExtra("password"));
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void fnCalculateAge(View view) {
        Integer age;

        try {
            age = Integer.parseInt(binding.editTextDOB.getText().toString());

            age = 2024 - age;

            binding.editTextDOB.setText("Your age is " + age);
        } catch (Exception e) {
            e.printStackTrace();
            binding.editTextDOB.setText("Please enter year in number");
        }

    }

    public void fnGoExpense(View view){
        Intent intent = new Intent(this, ActivityExpense.class);
        startActivity(intent);
    }
}