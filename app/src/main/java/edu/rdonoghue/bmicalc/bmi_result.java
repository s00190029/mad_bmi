package edu.rdonoghue.bmicalc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class bmi_result extends AppCompatActivity {

    //class variables
    double kg = 0;
    double cm = 0;
    TextView local_weight, local_height, bmi_display, judgement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        //link class variables to text views from previous pages
        local_height = findViewById(R.id.exitText_height);
        local_weight = findViewById(R.id.exitText_weight);
        bmi_display = findViewById(R.id.txtV_bmi_result);
        judgement = findViewById(R.id.txtV_judge);
        //waking up
        //look into pipe, grab values and assign them to class variables

        // validation attempt
        String num = null;
        try {
            num = "1";
            String fakenum = "1";
            double realnum;
            realnum = Double.parseDouble(fakenum);
            }
        catch (Error e) { Toast.makeText(this, "value was invalid", Toast.LENGTH_LONG).show(); }

        kg = getIntent().getDoubleExtra("kg", -1);
        cm = getIntent().getDoubleExtra("cm", -1);

        double bmi = 1;
        //get bmi & round it
        if (cm != -1 && kg != -1){
            bmi = calcBMI(cm, kg);
            bmi = Math.round(bmi * 100.0) / 100.0;

            //display BMI result
            bmi_display.setText(String.valueOf(bmi));

            //calc and display judgement
            if (bmi < 18.5) {
                judgement.setText("UNDERWEIGHT");
            }
            if (bmi >= 18.5 && bmi <= 24.9) {
                judgement.setText("HEALTHY");
            }
            if (bmi > 25) {
                judgement.setText("OVERWEIGHT");
            }
        }
        else {
            Toast.makeText(this, "DEFAULT VALUES", Toast.LENGTH_SHORT).show();
        }

    }

    public double calcBMI(double cmIn, double kgIn)
    {
        //vars
        double bmi = 0;
        double meters;
        meters = (cmIn/100.00);
        double m2= meters*meters;

        //calc bmi
        bmi = kgIn /m2;
        return bmi;
    }

    public void do_Close(View view){
        //local_height.setText(null);
        //local_weight.setText(null);
        //setting to null or reset causes crashes
        finish();
    }
}