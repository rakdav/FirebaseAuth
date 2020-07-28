package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebaseauth.databinding.ActivityGoogleSignInBinding;
import com.google.firebase.auth.FirebaseUser;

public class GoogleSignInActivity extends BasicActivity implements View.OnClickListener {
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    private ActivityGoogleSignInBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGoogleSignInBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setProgressBar(mBinding.progressBar);

        mBinding.signInButton.setOnClickListener(this);
        mBinding.signOutButton.setOnClickListener(this);
        mBinding.disconnectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    private void updateUI(FirebaseUser user) {
        hideProgressBar();
        if (user != null) {
            mBinding.status.setText(getString(R.string.google_status_fmt, user.getEmail()));
            mBinding.detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            mBinding.signInButton.setVisibility(View.GONE);
            mBinding.signOutAndDisconnect.setVisibility(View.VISIBLE);
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        } else {
            mBinding.status.setText(R.string.signed_out);
            mBinding.detail.setText(null);

            mBinding.signInButton.setVisibility(View.VISIBLE);
            mBinding.signOutAndDisconnect.setVisibility(View.GONE);
        }
    }
}