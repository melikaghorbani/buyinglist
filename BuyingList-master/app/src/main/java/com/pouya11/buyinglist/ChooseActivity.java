package com.pouya11.buyinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        txtName=(EditText) findViewById(R.id.txt_name);
        txtFactory=(EditText) findViewById(R.id.txt_factory);

    }
    public void btnSaveClicked(View view) {
        String name=txtName.getText().toString();
        String factory=txtFactory.getText().toString();

        PhoneRecord phoneRecord=new PhoneRecord();
        phoneRecord.setName(name);
        phoneRecord.setFactory(factory);


        phoneRecord.save(this);

        if (phoneRecord.getId()>0)
            Toast.makeText(this,"saved successfully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"ooops!!!something wrong",Toast.LENGTH_LONG).show();






    }

    public void btnCancelClicked(View view) {
        finish();
    }
}

