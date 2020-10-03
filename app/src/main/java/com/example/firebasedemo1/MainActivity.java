package com.example.firebasedemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signInEmailtext,signinpasswordtext;
    private TextView signUptext;
    private Button signinbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In Activity");

        signInEmailtext=findViewById(R.id.intextemailid);
        signinpasswordtext=findViewById(R.id.intextpassid);
        signUptext=findViewById(R.id.signuptextviewid);
        signinbutton=findViewById(R.id.signinbuttonid);

        signUptext.setOnClickListener(this);
        signinbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.signinbuttonid:

                break;

            case R.id.signuptextviewid:

                Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);

                break;


        }
    }
}
