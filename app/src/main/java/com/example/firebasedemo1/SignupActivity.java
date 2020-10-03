package com.example.firebasedemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signupemailtext,signuppasswordtext;
    private TextView signintext;
    private Button signupbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setTitle("Sign Up Activity");

        mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.upprogressbar);
        signupemailtext=findViewById(R.id.uptextemailid);
        signuppasswordtext=findViewById(R.id.uptextpassid);
        signintext=findViewById(R.id.signintextviewid);
        signupbutton=findViewById(R.id.signupbuttonid);

        signintext.setOnClickListener(this);
        signupbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.signupbuttonid:

                userRegister();

                break;

            case R.id.signintextviewid:
                Intent intent=new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void userRegister() {

        String email=signupemailtext.getText().toString().trim();
        String password=signuppasswordtext.getText().toString().trim();

        if(email.isEmpty())
        {
            signupemailtext.setError("Enter a valid email");
            signupemailtext.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupemailtext.setError("Enter valid email addrrss");
            signupemailtext.requestFocus();
        }
        if(password.isEmpty())
        {
            signuppasswordtext.setError("Enter a valid password ");
            signuppasswordtext.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signuppasswordtext.setError("Minimum length 6");
            signuppasswordtext.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);

                    Toast.makeText(SignupActivity.this, "Sign Up successful", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(SignupActivity.this, "Sign up unsuccessful", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
