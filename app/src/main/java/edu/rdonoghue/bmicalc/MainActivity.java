package edu.rdonoghue.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void doCalc(View view) {
        //switching activity
        Intent resultActivity = new Intent(view.getContext(), bmi_result.class);

        double weight_kg = Double.valueOf(weight.getText().toString());
        double height_cm = Double.valueOf(height.getText().toString());

        resultActivity.putExtra("kg", weight_kg);
        resultActivity.putExtra("cm", height_cm);

        if (weight_kg >= 50 && weight_kg <= 635 && height_cm >= 100 && height_cm <= 250)
        {
            startActivity(resultActivity);
        }
        else {
            Toast.makeText(this, "Please enter realistic values", Toast.LENGTH_LONG).show();
        }

    }

    public void doManualReset(View view) {
        weight.setText(null);
        height.setText(null);
    }
}

