package com.pouya11.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {
EditText txtGuess;
        int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        txtGuess = (EditText) findViewById(R.id.txt_guess);

        Random r = new Random();

        number =r.nextInt(9000 + 1000);
    }
    public void btnIClicked(View view){
        txtGuess.append("1");
        txtGuess.append("2");
        txtGuess.append("3");
        txtGuess.append("4");
        txtGuess.append("5");
        txtGuess.append("6");
        txtGuess.append("7");
        txtGuess.append("8");
        txtGuess.append("9");
        txtGuess.append("0");


    }
    public void btnGudseeClicked(View view){
        int gueseeNumer = Integer.parseInt(txtGuess.getText().toString());
        if(gueseeNumer == number) {
            Toast.makeText(this, " you win :) ", Toast.LENGTH_LONG).show();
        }else
        if(gueseeNumer > number) {
            Toast.makeText(this, " too high :| ", Toast.LENGTH_LONG).show();
        }else
        if(gueseeNumer < number) {
            Toast.makeText(this, " you low :| ", Toast.LENGTH_LONG).show();
        }else
        if(gueseeNumer != number) {
        Toast.makeText(this, " Game over :( ", Toast.LENGTH_LONG).show();
    }

}
}
