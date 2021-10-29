package com.example.cutecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double input1 = 0 , input2 = 0;
    double result = 0;
    int lastOperation = 0;
    final int PLUS = 1;
    final int MINUS = 2;
    final int PRODUCT = 3;
    final int DIVISION = 4;
    final int PERCENT = 5;

    //Textviews declaration
    public TextView txtInput;
    public TextView txtResult;
    public TextView txtOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Variables to actual buttons association

        txtInput = (TextView) findViewById(R.id.txtv_input);
        txtResult = (TextView) findViewById(R.id.txtv_result);
        txtOperation = (TextView) findViewById(R.id.txtv_operation);

    }

    public void buttonZero(View view) {
        txtInput.setText(txtInput.getText()+"0");
    }

    public void buttonOne(View view) {
        txtInput.setText(txtInput.getText()+"1");
    }

    public void buttonTwo(View view) {
        txtInput.setText(txtInput.getText()+"2");
    }

    public void ButtonThree(View view) {
        txtInput.setText(txtInput.getText()+"3");
    }

    public void ButtonFour(View view) {
        txtInput.setText(txtInput.getText()+"4");
    }

    public void buttonFive(View view) {
        txtInput.setText(txtInput.getText()+"5");
    }

    public void buttonSix(View view) {
        txtInput.setText(txtInput.getText()+"6");
    }

    public void buttonSeven(View view) {
        txtInput.setText(txtInput.getText()+"7");
    }

    public void buttonEight(View view) {
        txtInput.setText(txtInput.getText()+"8");
    }

    public void buttonNine(View view) {
        txtInput.setText(txtInput.getText()+"9");
    }
    public void buttonComma(View view) {
        txtInput.setText(txtInput.getText()+".");
    }

    public void buttonC(View view) {
        txtInput.setText("");
        txtResult.setText("");
        result =0;
        input1=0;
        input2=0;
        lastOperation=0;
        setOperation();
    }

    public void buttonDel(View view) {

        if(!txtInput.getText().toString().equals("")){
            String init = (String) txtInput.getText();
            String result = init.substring(0,init.length()-1);
            txtInput.setText(result);
        }
    }

    public void buttonPlus(View view) {

        try {
            if (!(txtInput.getText().toString().equals(""))) {

                if (lastOperation == 0) {
                    input1 = Double.parseDouble(txtInput.getText().toString());
                    txtResult.setText(txtInput.getText().toString());
                    txtInput.setText("");
                    lastOperation = PLUS;
                    setOperation();
                } else {
                    input1 = Double.parseDouble(txtResult.getText().toString());
                    execute();
                    lastOperation = PLUS;
                    setOperation();
                }
            }

        }catch(Exception e){txtInput.setText("Error");}


    }

    public void buttonMinus(View view) {

        try{
            if (!(txtInput.getText().toString().equals(""))) {

                if (lastOperation == 0) {
                    input1 = Double.parseDouble(txtInput.getText().toString());
                    txtResult.setText(txtInput.getText().toString());
                    txtInput.setText("");
                    lastOperation = MINUS;
                    setOperation();
                } else {
                    input1 = Double.parseDouble(txtResult.getText().toString());
                    execute();
                    lastOperation = MINUS;
                    setOperation();
                }
            }
        }catch(Exception e){txtInput.setText("Error");}

    }

    public void execute(){

        input2 = Double.parseDouble(txtInput.getText().toString());

        switch (lastOperation){
            case PLUS:
                result = input1 + input2;
                break;
            case MINUS:
                result = input1 - input2;
                break;
            case PRODUCT:
                result = input1 * input2;
                break;
            case DIVISION:
                result = input1 / input2;
        }

        txtResult.setText(String.valueOf(result));
        txtInput.setText("");
    }

    public void buttonEqual(View view) {
        try {
            input1 = Double.parseDouble(txtResult.getText().toString());
            execute();
            lastOperation = 0;
            setOperation();
        }catch (Exception e){
            e.printStackTrace();
            txtInput.setText("Error");
        }

    }

    public void buttonProduct(View view) {

        try {

            if  (!(txtInput.getText().toString().equals(""))) {

                if (lastOperation == 0) {
                    input1 = Double.parseDouble(txtInput.getText().toString());
                    txtResult.setText(txtInput.getText().toString());
                    txtInput.setText("");
                    lastOperation = PRODUCT;
                    setOperation();
                } else {
                    input1 = Double.parseDouble(txtResult.getText().toString());
                    execute();
                    lastOperation = PRODUCT;
                    setOperation();
                }
            }
        }catch(Exception e){txtInput.setText("Error");}
    }

    public void buttonDivide(View view) {

        try {

            if (!(txtInput.getText().toString().equals(""))) {

                if (lastOperation == 0) {
                    input1 = Double.parseDouble(txtInput.getText().toString());
                    txtResult.setText(txtInput.getText().toString());
                    txtInput.setText("");
                    lastOperation = DIVISION;
                    setOperation();
                } else {
                    input1 = Double.parseDouble(txtResult.getText().toString());
                    execute();
                    lastOperation = DIVISION;
                    setOperation();
                }
            }
        }catch(Exception e){txtInput.setText("Error");}
    }

    public void setOperation(){

        String operation="";

        switch (lastOperation){
            case PLUS:
                operation = "+";
                break;
            case MINUS:
                operation = "-";
                break;
            case PRODUCT:
                operation = "*";
                break;
            case DIVISION:
                operation = "/";
                break;
            case 0:
                operation = "";
                break;
        }

        txtOperation.setText(operation);
    }

}