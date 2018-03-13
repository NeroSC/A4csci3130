package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class CreateBusinessActivity extends Activity {

    private Button submitButton;
    private EditText nameField, addressField,numberField;
    private Spinner primary_businessField,provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_activity);
        //Get the app wide shared variables
        appState = (MyApplicationData) getApplicationContext();

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText) findViewById(R.id.address);
        numberField=(EditText) findViewById(R.id.number);
        primary_businessField=(Spinner) findViewById(R.id.primary_business);
        provinceField=(Spinner) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID

        String businessID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String address = addressField.getText().toString();
        String number=numberField.getText().toString();
        String primary_business=primary_businessField.getSelectedItem().toString();
        String province=provinceField.getSelectedItem().toString();

        Business company = new Business(businessID, name, address,number,primary_business,province);

        appState.firebaseReference.child(businessID).setValue(company);

        finish();

    }
}