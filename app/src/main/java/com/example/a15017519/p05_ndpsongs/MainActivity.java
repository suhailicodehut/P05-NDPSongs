package com.example.a15017519.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle,etSinger,etYear;
    RadioGroup rgStars;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSinger = (EditText)findViewById(R.id.etSinger);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etYear = (EditText)findViewById(R.id.etYear);
        rgStars = (RadioGroup)findViewById(R.id.rgStars);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnShow = (Button)findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int years = Integer.parseInt(etYear.getText().toString());
                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                int stars = Integer.parseInt(rb.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSongs(title,singer,years,stars);
                dbh.close();

                if (row_affected != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ShowSong.class);
                startActivity(i);
            }
        });
    }
}
