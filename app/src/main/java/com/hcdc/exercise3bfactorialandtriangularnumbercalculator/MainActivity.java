package com.hcdc.exercise3bfactorialandtriangularnumbercalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

// Author: John Henly A. Montera    BSIT-3rd-Year
// CC106[01527]
// [Exercise 3B] Factorial and Triangular Number Calculator

public class MainActivity extends AppCompatActivity {

    TextView factorialanswer,triangleanswer,mode;
    EditText FactorialInput,TriangularInput;
    ToggleButton swap;
    Button reset,equals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mode = findViewById(R.id.modechanger);
        mode.setText("Triangular Mode");

        FactorialInput = findViewById(R.id.factorialinput);
        TriangularInput = findViewById(R.id.triangleinput);

        swap = findViewById(R.id.swap);

        factorialanswer = findViewById(R.id.factorialanswer);
        triangleanswer = findViewById(R.id.triangularanswer);

        reset = findViewById(R.id.reseted);
        equals = findViewById(R.id.result);

        swap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (swap.isChecked()){
                    mode.setText("Factorial Mode");
                }
                if (!swap.isChecked()){
                    mode.setText("Triangular Mode");
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(swap.isChecked()){ // == *
                    int temp = Integer.parseInt(FactorialInput.getText().toString());
                    long factorial = 1;
                    for(int i = 1;i<=temp;i++) {
                        factorial = factorial * i;
                    }
                    factorialanswer.setText(String.valueOf(factorial));
                }

                if(!swap.isChecked()){ // == +

                    int temp = Integer.parseInt(TriangularInput.getText().toString());
                    int triangular = 0;
                    for(int i=1;i<=temp;i++){
                        triangular = triangular + i;
                    }

                    triangleanswer.setText(Integer.toString(triangular));
                }
            }


        });

        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FactorialInput.setText("0");
                TriangularInput.setText("0");
                factorialanswer.setText("0");
                triangleanswer.setText("0");
            }
        });
    }





}