package com.bitcodetech.customdialogs3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                        loginDialog.setOnLoginListener(new MyLoginListener());
                        loginDialog.show();
                    }
                }
        );
    }

    private class MyLoginListener implements LoginDialog.OnLoginListener {
        @Override
        public void onSuccess() {
            mt("My Success Action");
        }

        @Override
        public void onFail() {
            mt("My Fail Action");
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}