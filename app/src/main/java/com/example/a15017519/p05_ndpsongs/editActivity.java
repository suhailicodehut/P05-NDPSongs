package com.example.a15017519.p05_ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by 15017452 on 19/5/2017.
 */

public class editActivity extends AppCompatActivity {

    TextView tvID;
    EditText etTitle,etSinger,etYear;
    RadioGroup rgStars;
    Button btnUpdate, btnDelete,btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        //initialize the variables with UI here
        tvID = (TextView)findViewById(R.id.tvID);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etSinger = (EditText)findViewById(R.id.etSinger);
        etYear = (EditText)findViewById(R.id.etYear);

        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        rgStars = (RadioGroup)findViewById(R.id.rgStars);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSinger());
        etYear.setText(data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                RadioButton rgStars = (RadioButton) findViewById(selectedButtonId);
                DBHelper dbh = new DBHelper(editActivity.this);
                data.setSinger(etSinger.getText().toString());
                data.setTitle(etTitle.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setStars(Integer.parseInt(rgStars.getText().toString()));
                dbh.updateNote(data);
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                DBHelper dbh = new DBHelper(editActivity.this);
                dbh.deleteNote(data.getId());
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });
    btnCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(editActivity.this,
                    MainActivity.class);

            startActivity(i);
        }
    });
    }


}

