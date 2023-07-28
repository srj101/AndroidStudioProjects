package com.example.classwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2;
    private Spinner spinner;
    private Button submitButton1,submitButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        spinner = findViewById(R.id.spinner);
        submitButton1 = findViewById(R.id.submitButton1);
        submitButton2 = findViewById(R.id.submitButton2);

        submitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == radioButton1.getId() ) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else if (selectedRadioButtonId == radioButton2.getId()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                }
            }
        });

        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedSpinnerPosition = spinner.getSelectedItemPosition();

                if (selectedSpinnerPosition == 0) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else if ( selectedSpinnerPosition == 1) {
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                }
            }
        });

    }
}
