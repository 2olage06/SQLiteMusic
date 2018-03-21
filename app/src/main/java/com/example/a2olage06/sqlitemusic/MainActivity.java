    package com.example.a2olage06.sqlitemusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add= (Button)findViewById(R.id.add);
        add.setOnClickListener((View.OnClickListener) this);
    }


        public void onClick(View view){

        EditText title= (EditText)findViewById(R.id.title);
        String Title = title.getText().toString();

        EditText artist= (EditText)findViewById(R.id.artist);
        String Artist= artist.getText().toString();

        EditText year= (EditText)findViewById(R.id.year);
        double Year= Double.parseDouble(year.getText().toString());







    }


}
