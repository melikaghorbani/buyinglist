package com.pouya11.buyinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BuyingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying);
    }

    public void btnStartClicked(View view) {
        startActivity(new Intent(this,ChooseActivity.class));
    }
}
