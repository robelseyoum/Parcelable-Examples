package com.robelseyoum3.parcelableassignmentbonus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_start_activity;
    private TextView tv_make, tv_color, tv_num_door;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_activity = findViewById(R.id.btn_main2_second);
        tv_make = findViewById(R.id.tv_make);
        tv_color = findViewById(R.id.tv_color);
        tv_num_door = findViewById(R.id.tv_door_num);


        btn_start_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //here we send the object between two activities
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    //here overides the acitvity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //here is for a code to recieve it

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Vehicle vehicle = data.getParcelableExtra("result");

                //here we store the value for each textView
                tv_make.setText(vehicle.getMake());
                tv_color.setText(vehicle.getColour());
                tv_num_door.setText(String.valueOf(vehicle.getNumOfDoors()));

            }
            if(resultCode == RESULT_CANCELED){
                //here we can handle the error values
            }
        }
    }
}
