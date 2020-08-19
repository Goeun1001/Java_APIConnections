package com.muradismayilov.api_json_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    static TextView textView;
    public static EditText emailText;
    public static EditText passwordText;
    public static EditText usernameText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        emailText = findViewById(R.id.emailField);
        passwordText = findViewById(R.id.passwordField);
        usernameText = findViewById(R.id.usernameField);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadData downloadData = new DownloadData();

                String url = "https://mini-avocat-1.herokuapp.com/users/create/";
                downloadData.execute(url);
            }
        });
    }
}
