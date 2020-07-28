package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebaseauth.databinding.ActivityEmailpasswordBinding;

public class EMailPasswordActivity extends BasicActivity implements View.OnClickListener {
    private static final String TAG = "EmailPassword";
    private ActivityEmailpasswordBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityEmailpasswordBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setProgressBar(mBinding.progressBar);

        mBinding.emailSignInButton.setOnClickListener(this);
        mBinding.emailCreateAccountButton.setOnClickListener(this);
        mBinding.signOutButton.setOnClickListener(this);
        mBinding.verifyEmailButton.setOnClickListener(this);
        mBinding.reloadButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.emailCreateAccountButton:

                break;
            case R.id.emailSignInButton:

                break;
            case R.id.signOutButton:

                break;
            case R.id.verifyEmailButton:

                break;
            case R.id.reloadButton:

                break;
        }
    }

//    private void updateUI(FirebaseUser user) {
//        hideProgressBar();
//        if (user != null) {
//            mBinding.status.setText(getString(R.string.emailpassword_status_fmt,
//                    user.getEmail(), user.isEmailVerified()));
//            mBinding.detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));
//
//            mBinding.emailPasswordButtons.setVisibility(View.GONE);
//            mBinding.emailPasswordFields.setVisibility(View.GONE);
//            mBinding.signedInButtons.setVisibility(View.VISIBLE);
//
//            if (user.isEmailVerified()) {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                mBinding.verifyEmailButton.setVisibility(View.GONE);
//            } else {
//                mBinding.verifyEmailButton.setVisibility(View.VISIBLE);
//            }
//        } else {
//            mBinding.status.setText(R.string.signed_out);
//            mBinding.detail.setText(null);
//
//            mBinding.emailPasswordButtons.setVisibility(View.VISIBLE);
//            mBinding.emailPasswordFields.setVisibility(View.VISIBLE);
//            mBinding.signedInButtons.setVisibility(View.GONE);
//        }
//    }
}