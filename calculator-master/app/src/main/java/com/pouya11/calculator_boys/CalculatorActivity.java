package com.pouya11.calculator_boys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    Button[] btnNumbers = new Button[10];
    Button btnDot;
    Button btnClear;
    Button btnClearEverything;
    Button btnSum;
    Button btnSub;
    Button btnDivide;
    Button btnMultiply;
    Button btnResult;
    Button btnExit;
    EditText txtNumber;

    double dMemory = 0;
    int iState = CalculatorActivity.STATE_NA;

    protected static final int STATE_NA = 0;
    protected static final int STATE_SUM = 1;
    protected static final int STATE_SUB = 2;
    protected static final int STATE_MULTIPLY = 3;
    protected static final int STATE_DIVIDE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btnNumbers[0] = (Button) findViewById(R.id.btn0);
        btnNumbers[1] = (Button) findViewById(R.id.btn1);
        btnNumbers[2] = (Button) findViewById(R.id.btn2);
        btnNumbers[3] = (Button) findViewById(R.id.btn3);
        btnNumbers[4] = (Button) findViewById(R.id.btn4);
        btnNumbers[5] = (Button) findViewById(R.id.btn5);
        btnNumbers[6] = (Button) findViewById(R.id.btn6);
        btnNumbers[7] = (Button) findViewById(R.id.btn7);
        btnNumbers[8] = (Button) findViewById(R.id.btn8);
        btnNumbers[9] = (Button) findViewById(R.id.btn9);
        btnDot = (Button) findViewById(R.id.btn_dot);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnClearEverything = (Button) findViewById(R.id.btn_clear_everything);
        btnSum = (Button) findViewById(R.id.btn_sum);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnDivide = (Button) findViewById(R.id.btn_divide);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        btnResult = (Button) findViewById(R.id.btn_result);
        btnExit = (Button) findViewById(R.id.btn_exit);
        txtNumber = (EditText) findViewById(R.id.txtNumber);

        for(Button b: btnNumbers) {
            b.setOnClickListener(new BtnNumbersClicked());
        }
        btnClear.setOnClickListener(new BtnClearClicked());
        btnSum.setOnClickListener(new BtnOperationClicked());
        btnSub.setOnClickListener(new BtnOperationClicked());
        btnMultiply.setOnClickListener(new BtnOperationClicked());
        btnDivide.setOnClickListener(new BtnOperationClicked());
    }

    protected void clear(){
        txtNumber.setText("");
    }

    protected double getNumberAndClear(){
        double result = 0;
        try {
            result = Double.parseDouble(txtNumber.getText().toString());
            CalculatorActivity.this.clear();
        }catch (Exception e){
            Toast.makeText(CalculatorActivity.this,
                    R.string.something_wrong,
                    Toast.LENGTH_SHORT)
                    .show();
        }
        return result;
    }

    protected class BtnNumbersClicked implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            CalculatorActivity.this.txtNumber.append(((Button) v).getText());
        }
    }

    protected class BtnClearClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_clear_everything:
                    CalculatorActivity.this.iState = CalculatorActivity.STATE_NA;
                    CalculatorActivity.this.dMemory = 0;
                case R.id.btn_clear:
                    CalculatorActivity.this.clear();
            }
        }
    }

    protected class BtnOperationClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_sum:
                    CalculatorActivity.this.iState = CalculatorActivity.STATE_SUM;
                    break;
                case R.id.btn_sub:
                    CalculatorActivity.this.iState = CalculatorActivity.STATE_SUB;
                    break;
                case R.id.btn_multiply:
                    CalculatorActivity.this.iState = CalculatorActivity.STATE_MULTIPLY;
                    break;
                case R.id.btn_divide:
                    CalculatorActivity.this.iState = CalculatorActivity.STATE_DIVIDE;
                    break;
                default:
                    CalculatorActivity.this.iState = CalculatorActivity.STATE_NA;
            }

            CalculatorActivity.this.dMemory = CalculatorActivity.this.getNumberAndClear();


        }

        protected class BtnResultClicked implements View.OnClickListener{

            @Override
            public void onClick(View v) {
                double result = 0;
                switch (CalculatorActivity.this.iState){
                    case CalculatorActivity.STATE_SUM:
                        result = CalculatorActivity.this.getNumberAndClear()
                                + CalculatorActivity.this.dMemory;
                        break;
                    case CalculatorActivity.STATE_SUB:
                        result = CalculatorActivity.this.dMemory
                                - CalculatorActivity.this.getNumberAndClear();
                        break;
                    case CalculatorActivity.STATE_MULTIPLY:
                        result = CalculatorActivity.this.getNumberAndClear()
                                * CalculatorActivity.this.dMemory;
                        break;
                    case CalculatorActivity.STATE_DIVIDE:
                        result = CalculatorActivity.this.dMemory
                                / CalculatorActivity.this.getNumberAndClear();
                        break;
                    default:
                        Toast.makeText(CalculatorActivity.this,
                                R.string.something_wrong,
                                Toast.LENGTH_LONG)
                                .show();
                }

                txtNumber.setText(result + "");
            }
        }
    }
}
