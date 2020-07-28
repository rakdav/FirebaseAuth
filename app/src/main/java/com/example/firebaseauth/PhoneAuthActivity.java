package com.example.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.firebaseauth.databinding.ActivityPhoneAuthBinding;

import java.util.concurrent.TimeUnit;

public class PhoneAuthActivity extends BasicActivity implements View.OnClickListener {
    private static final String TAG = "PhoneAuthActivity";

    private static final String KEY_VERIFY_IN_PROGRESS = "key_verify_in_progress";

    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_CODE_SENT = 2;
    private static final int STATE_VERIFY_FAILED = 3;
    private static final int STATE_VERIFY_SUCCESS = 4;
    private static final int STATE_SIGNIN_FAILED = 5;
    private static final int STATE_SIGNIN_SUCCESS = 6;

    private boolean mVerificationInProgress = false;
    private String mVerificationId;

    private ActivityPhoneAuthBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }

        mBinding.buttonStartVerification.setOnClickListener(this);
        mBinding.buttonVerifyPhone.setOnClickListener(this);
        mBinding.buttonResend.setOnClickListener(this);
        mBinding.signOutButton.setOnClickListener(this);
    }


//    private void updateUI(int uiState) {
//        updateUI(uiState, mAuth.getCurrentUser(), null);
//    }
//
//    private void updateUI(FirebaseUser user) {
//        if (user != null) {
//            updateUI(STATE_SIGNIN_SUCCESS, user);
//        } else {
//            updateUI(STATE_INITIALIZED);
//        }
//    }
//
//    private void updateUI(int uiState, FirebaseUser user) {
//        updateUI(uiState, user, null);
//    }
//
//    private void updateUI(int uiState, PhoneAuthCredential cred) {
//        updateUI(uiState, null, cred);
//    }
//
//    private void updateUI(int uiState, FirebaseUser user, PhoneAuthCredential cred) {
//        switch (uiState) {
//            case STATE_INITIALIZED:
//                enableViews(mBinding.buttonStartVerification, mBinding.fieldPhoneNumber);
//                disableViews(mBinding.buttonVerifyPhone, mBinding.buttonResend, mBinding.fieldVerificationCode);
//                mBinding.detail.setText(null);
//                break;
//            case STATE_CODE_SENT:
//                enableViews(mBinding.buttonVerifyPhone, mBinding.buttonResend, mBinding.fieldPhoneNumber, mBinding.fieldVerificationCode);
//                disableViews(mBinding.buttonStartVerification);
//                mBinding.detail.setText(R.string.status_code_sent);
//                break;
//            case STATE_VERIFY_FAILED:
//                enableViews(mBinding.buttonStartVerification, mBinding.buttonVerifyPhone, mBinding.buttonResend, mBinding.fieldPhoneNumber,
//                        mBinding.fieldVerificationCode);
//                mBinding.detail.setText(R.string.status_verification_failed);
//                break;
//            case STATE_VERIFY_SUCCESS:
//                disableViews(mBinding.buttonStartVerification, mBinding.buttonVerifyPhone, mBinding.buttonResend, mBinding.fieldPhoneNumber,
//                        mBinding.fieldVerificationCode);
//                mBinding.detail.setText(R.string.status_verification_succeeded);
//
//                if (cred != null) {
//                    if (cred.getSmsCode() != null) {
//                        mBinding.fieldVerificationCode.setText(cred.getSmsCode());
//                    } else {
//                        mBinding.fieldVerificationCode.setText(R.string.instant_validation);
//                    }
//                }
//
//                break;
//            case STATE_SIGNIN_FAILED:
//                mBinding.detail.setText(R.string.status_sign_in_failed);
//                break;
//            case STATE_SIGNIN_SUCCESS:
//                break;
//        }
//
//        if (user == null) {
//            mBinding.phoneAuthFields.setVisibility(View.VISIBLE);
//            mBinding.signedInButtons.setVisibility(View.GONE);
//
//            mBinding.status.setText(R.string.signed_out);
//
//        } else {
//            mBinding.phoneAuthFields.setVisibility(View.GONE);
//            mBinding.signedInButtons.setVisibility(View.VISIBLE);
//
//            enableViews(mBinding.fieldPhoneNumber, mBinding.fieldVerificationCode);
//            mBinding.fieldPhoneNumber.setText(null);
//            mBinding.fieldVerificationCode.setText(null);
//
//            mBinding.status.setText(R.string.signed_in);
//            mBinding.detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//        }
//    }

    private boolean validatePhoneNumber() {
        String phoneNumber = mBinding.fieldPhoneNumber.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            mBinding.fieldPhoneNumber.setError("Invalid phone number.");
            return false;
        }

        return true;
    }

    private void enableViews(View... views) {
        for (View v : views) {
            v.setEnabled(true);
        }
    }

    private void disableViews(View... views) {
        for (View v : views) {
            v.setEnabled(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStartVerification:
                if (!validatePhoneNumber()) {
                    return;
                }

                break;
            case R.id.buttonVerifyPhone:
                String code = mBinding.fieldVerificationCode.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    mBinding.fieldVerificationCode.setError("Cannot be empty.");
                    return;
                }

                break;
            case R.id.buttonResend:

                break;
            case R.id.signOutButton:

                break;
        }
    }


}