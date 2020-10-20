package edu.rdonoghue.bmicalc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class bmi_result extends AppCompatActivity {

    //class variables
    int kg = 0;
    int cm = 0;
    TextView local_weight, local_height, bmi_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        //link class variables to text views from previous pages
        local_height = findViewById(R.id.exitText_height);
        local_weight = findViewById(R.id.exitText_weight);
        bmi_display = findViewById(R.id.txtV_bmi_result);

        //waking up
        //look into pipe, grab values and assign them to class variables
        //default to -1 if none are found
        kg = getIntent().getIntExtra("kg", -1);
        cm = getIntent().getIntExtra("cm", -1);

        //display BMI result
        double bmi = calcBMI(cm, kg);
        bmi_display.setText(String.valueOf(bmi));

    }


    public int calcBMI(int cmIn, int kgIn)
    {
        //vars
        double bmi = 0;
        double meters;
        meters = (cmIn/100.00);
        double m2= meters*meters;

        //calc bmi
         bmi = kgIn /m2;
        return (int)bmi;
    }

    public void do_Close(View view){
        //local_weight.setText(0);
        //local_height.setText("Testing reset");
        finish();
    }
}