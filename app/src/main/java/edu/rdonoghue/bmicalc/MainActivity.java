package edu.rdonoghue.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // global variables
    EditText weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link global vars to XML content
        weight = findViewById(R.id.exitText_weight);
        height = findViewById(R.id.exitText_height);
    }

    public void doBMIResult (View view) {

    }

    public void doCalc(View view) {
        //switching activity
        Intent resultActivity = new Intent(view.getContext(), bmi_result.class);
        int weight_kg = Integer.valueOf(weight.getText().toString());
        int height_cm = Integer.valueOf(height.getText().toString());

        resultActivity.putExtra("kg", weight_kg);
        resultActivity.putExtra("cm", height_cm);

        startActivity(resultActivity);

   }

 }

