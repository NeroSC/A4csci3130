package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField;
    Business receivedPersonInfo;
    private MyApplicationData appState;
    private Button updateButton;
    private Button deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business) getIntent().getSerializableExtra("Business");

        deleteButton = (Button) findViewById(R.id.deleteButton);
        updateButton = (Button) findViewById(R.id.updateButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.address);

        if (receivedPersonInfo != null) {
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.address);
        }
    }

    public void updateBusiness(View v) {
        //TODO: Update contact functionality
        appState = ((MyApplicationData) getApplicationContext());

        String name = nameField.getText().toString();
        String address = emailField.getText().toString();
        appState.firebaseReference.child(receivedPersonInfo.uid).child("name").setValue(name);
        appState.firebaseReference.child(receivedPersonInfo.uid).child("address").setValue(address);

        finish();


    }

    public void eraseBusiness(View v) {
        //TODO: Erase contact functionality

        appState = ((MyApplicationData) getApplicationContext());
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();

    }
}