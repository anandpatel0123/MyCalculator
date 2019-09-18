package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private enum Operators{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    //Instance Variable

    private String curretNumber;
    private String StringNumberAtLeft;
    private String StringNumberAtRight;
    private Operators currentOperator;
    private int calcualtions;
    private String calculationsString;

    TextView txtCalculctions;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curretNumber = "";
        calcualtions = 0;
        calculationsString = "";

        txtCalculctions = (TextView)findViewById(R.id.txtCalculations);
        txtResult = (TextView)findViewById(R.id.txtResult);


        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnNine).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEight).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSeven).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSix).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFive).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFour).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnThree).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnAdd).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnTwo).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnOne).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnZero).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnEqual:
                operatorIsTapped(Operators.EQUAL);
                break;
            case R.id.btnSeven:
                numberIsTapped(7);
                break;
            case R.id.btnEight:
                numberIsTapped(8);
                break;
            case R.id.btnNine:
                numberIsTapped(9);
                break;
            case R.id.btnDivide:
                operatorIsTapped(Operators.DIVIDE);
                calculationsString += " / ";
                break;
            case R.id.btnFour:
                numberIsTapped(4);
                break;
            case R.id.btnFive:
                numberIsTapped(5);
                break;
            case R.id.btnSix:
                numberIsTapped(6);
                break;
            case R.id.btnAdd:
                operatorIsTapped(Operators.ADD);
                calculationsString += " + ";
                break;
            case R.id.btnOne:
                numberIsTapped(1);
                break;
            case R.id.btnTwo:
                numberIsTapped(2);
                break;
            case R.id.btnThree:
                numberIsTapped(3);
                break;
            case R.id.btnSubtract:
                operatorIsTapped(Operators.SUBTRACT);
                calculationsString += " - ";
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnZero:
                numberIsTapped(0);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(Operators.MULTIPLY);
                calculationsString += " * ";
                break;



        }
        txtCalculctions.setText(calculationsString);

    }

    private void numberIsTapped(int tappedNumber){
        curretNumber = curretNumber + String.valueOf(tappedNumber);
        txtResult.setText(curretNumber);
        calculationsString = curretNumber;
        txtCalculctions.setText(calculationsString);
    }

    private void operatorIsTapped(Operators tappedOperator) {

        if (currentOperator != null) {
            if(curretNumber != ""){
            StringNumberAtRight = curretNumber;
            curretNumber = "";

            switch (currentOperator) {

                case ADD:
                    calcualtions = Integer.parseInt(StringNumberAtLeft) +
                            Integer.parseInt(StringNumberAtRight);
                    break;
                case SUBTRACT:
                    calcualtions = Integer.parseInt(StringNumberAtLeft) -
                            Integer.parseInt(StringNumberAtRight);
                    break;
                case MULTIPLY:
                    calcualtions = Integer.parseInt(StringNumberAtLeft) *
                            Integer.parseInt(StringNumberAtRight);
                    break;
                case DIVIDE:
                    calcualtions = Integer.parseInt(StringNumberAtLeft) /
                            Integer.parseInt(StringNumberAtRight);
                    break;

            }
            StringNumberAtLeft = String.valueOf(calcualtions);
            txtResult.setText(StringNumberAtLeft);
            calculationsString = StringNumberAtLeft;

        }
    }
        else {
            StringNumberAtLeft = curretNumber;
            curretNumber = "";
        }

        currentOperator = tappedOperator;

    }

    private void clearTapped(){
        StringNumberAtRight="";
        StringNumberAtLeft="";
        calcualtions=0;
        curretNumber="";
        currentOperator=null;
        txtResult.setText("0");
        calculationsString="0";
        txtCalculctions.setText("0");



    }

}
