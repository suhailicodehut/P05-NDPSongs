package com.example.a15017519.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showSong extends AppCompatActivity {
    Button btn5Star;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        btn5Star = (Button)findViewById(R.id.buttonShowSong);
        lv = (ListView)findViewById(R.id.lv);

        DBHelper db = new DBHelper(showSong.this);
        ArrayList<Song> data = db.getAllSongs();

        db.close();
        aa = new CustomAdapter(showSong.this, R.layout.row, al);
        aa.notifyDataSetChanged();
        lv.setAdapter(aa);
    }
}
