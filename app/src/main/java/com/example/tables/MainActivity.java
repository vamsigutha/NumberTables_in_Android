package com.example.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);

        seekBar.setProgress(5);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){



            @Override
            public void onStartTrackingTouch(SeekBar seekBar){};

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){};

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){

                int min=1;
                int timesTable;

                if(progress<min){
                    timesTable=min;
                    seekBar.setProgress(min);
                }
                else{
                    timesTable = progress;
                }

                Log.i("SeekBar value", Integer.toString(timesTable));

                ListView listView = (ListView) findViewById(R.id.listVew);
                ArrayList<Integer> tables = new ArrayList<Integer>();

                for(int i=1; i<11;i++){
                    tables.add(i*timesTable);
                }

                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1,tables);
                listView.setAdapter(arrayAdapter);
            }

        });
    }
}