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
    private Button deleteButton;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business) getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);

        if (receivedPersonInfo != null) {
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
        }
    }

    public void updateBusiness(View v) {
        //TODO: Update contact functionality
        appState = ((MyApplicationData) getApplicationContext());

        updateButton = (Button) findViewById(R.id.updateButton);
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        appState.firebaseReference.child(receivedPersonInfo.uid).child("name").setValue(name);
        appState.firebaseReference.child(receivedPersonInfo.uid).child("email").setValue(email);

        setContentView(R.layout.activity_main);

    }

    public void eraseBusiness(View v) {
        //TODO: Erase contact functionality

        appState = ((MyApplicationData) getApplicationContext());

        deleteButton = (Button) findViewById(R.id.deleteButton);
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        setContentView(R.layout.activity_main);

    }
}