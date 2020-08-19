package com.muradismayilov.api_json_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadData downloadData = new DownloadData();

                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + editText.getText().toString() + "&appid=0afe4b849a02440229c8ac5e00332b51";
                downloadData.execute(url);
            }
        });
    }
}
