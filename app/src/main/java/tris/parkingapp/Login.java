package tris.parkingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity  implements View.OnClickListener{
Button button;
EditText email,password;
TextView forgetpassword,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button=findViewById(R.id.loginbutton);
        email=findViewById(R.id.useremail);
        password=findViewById(R.id.userpassword);
        forgetpassword=findViewById(R.id.forgetpassword);
        signup=findViewById(R.id.signup);

        button.setOnClickListener(this);
        signup.setOnClickListener(this);
        forgetpassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.signup)
        {
            Intent i=new Intent(Login.this,MainActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.forgetpassword)
        {
            Intent i=new Intent(Login.this,ForgetPassword.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.loginbutton)
        {

/*
            Intent i=new Intent(Login.this,MapsActivity.class);
            startActivity(i);
*/
           SharedPreferences sp=getSharedPreferences("My_Data",MODE_PRIVATE);
            // SharedPreferences.Editor et=sp.edit();

            String Email=email.getText().toString();
            String Pass=password.getText().toString();
            if (Email.equals(sp.getString("A",null))&& Pass.equals(sp.getString("B",null))){
                startActivity(new Intent(Login.this,MapsActivity.class));
            }



        }

        }
    }

