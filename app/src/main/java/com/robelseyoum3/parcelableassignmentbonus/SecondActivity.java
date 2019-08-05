package com.robelseyoum3.parcelableassignmentbonus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button btn_go2_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Vehicle vehicle = new Vehicle("Toyota", "Silver", 5);

        btn_go2_second = findViewById(R.id.btn_goto_2);

        btn_go2_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //here we will send the vehicle object back to activity one with its value
                Intent intent = new Intent();
                intent.putExtra("result", vehicle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
