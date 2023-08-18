package com.bitcodetech.customdialogs3;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    public interface OnLoginListener {
        void onSuccess(LoginDialog loginDialog);
        void onFail(LoginDialog loginDialog);
    }

    private OnLoginListener onLoginListener = null;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(Context context) {
        super(context);

        setContentView(R.layout.login_dialog);
        initViews();

        btnSignIn.setOnClickListener(new BtnSignInClickListener());
    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                onLoginListener.onSuccess(LoginDialog.this);
//                dismiss(); //not good
            } else {
                onLoginListener.onFail(LoginDialog.this);
            }
        }
    }

    private void mt(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
    }
}
