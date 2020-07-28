package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooserActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        findViewById(R.id.email).setOnClickListener(this);
        findViewById(R.id.phone).setOnClickListener(this);
        findViewById(R.id.google).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.email:
                startActivity(new Intent(this,EMailPasswordActivity.class));
                break;
            case R.id.phone:
               startActivity(new Intent(this, PhoneAuthActivity.class));
                break;
            case R.id.google:
                startActivity(new Intent(this, GoogleSignInActivity.class));
                break;
        }
    }
}