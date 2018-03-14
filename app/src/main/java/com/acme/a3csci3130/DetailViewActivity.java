package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField,numberField;
    private Spinner primary_businessField,provinceField;
    Business receivedPersonInfo;
    private MyApplicationData appState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business) getIntent().getSerializableExtra("Business");


        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText) findViewById(R.id.address);
        numberField=(EditText) findViewById(R.id.number);
        primary_businessField=(Spinner) findViewById(R.id.primary_business);
        provinceField=(Spinner) findViewById(R.id.province);


        if (receivedPersonInfo != null) {
            nameField.setText(receivedPersonInfo.name);
            addressField.setText(receivedPersonInfo.address);
            numberField.setText(receivedPersonInfo.number);
            primary_businessField.setSelection(getIndex(primary_businessField, receivedPersonInfo.primary_business));
            provinceField.setSelection(getIndex(provinceField, receivedPersonInfo.province));
        }
    }

    public void updateBusiness(View v) {
        //TODO: Update contact functionality
        appState = ((MyApplicationData) getApplicationContext());

        String name = nameField.getText().toString();
        String address = addressField.getText().toString();
        String number=numberField.getText().toString();
        String primary_business=primary_businessField.getSelectedItem().toString();
        String province=provinceField.getSelectedItem().toString();
        appState.firebaseReference.child(receivedPersonInfo.uid).child("name").setValue(name);
        appState.firebaseReference.child(receivedPersonInfo.uid).child("address").setValue(address);
        appState.firebaseReference.child(receivedPersonInfo.uid).child("number").setValue(number);
        appState.firebaseReference.child(receivedPersonInfo.uid).child("primary_business").setValue(primary_business);
        appState.firebaseReference.child(receivedPersonInfo.uid).child("province").setValue(province);

        finish();


    }

    public void eraseBusiness(View v) {
        //TODO: Erase contact functionality

        appState = ((MyApplicationData) getApplicationContext());
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();

    }

    public int getIndex(Spinner spinner, String myString)
    {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }
}