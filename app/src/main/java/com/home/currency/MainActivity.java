package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static float rate = 30.9f;
    private EditText et_ntd;
    private TextView us;
    private TextView jp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        et_ntd = findViewById(R.id.ntd);
        us = findViewById(R.id.us);
        jp = findViewById(R.id.jp);
    }

    public void go(View view) {
        String str_ntd = et_ntd.getText().toString();
        String title;
        String message;

        if (str_ntd.isEmpty()) {
            title = getString(R.string.problem);
            message = getString(R.string.please_enter_ntd);
        } else {
            float f_us = Float.parseFloat(str_ntd) / rate;
            title = getString(R.string.result);
            message = getString(R.string.usd_is) + f_us;
            us.setText(Float.toString(f_us));
        }

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null)
                .show();
    }
}
