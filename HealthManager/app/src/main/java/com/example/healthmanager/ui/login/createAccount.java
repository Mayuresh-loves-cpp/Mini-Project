package com.example.healthmanager.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthmanager.MainActivity;
import com.example.healthmanager.R;

public class createAccount extends AppCompatActivity {
    public Button gotoHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        gotoHome = findViewById(R.id.button);
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createAccount.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}