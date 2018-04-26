package tris.parkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPassword extends AppCompatActivity implements View.OnClickListener{
EditText email;
Button forgetsubmitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgetsubmitbutton=findViewById(R.id.forgetsubmitbutton);
        forgetsubmitbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.forgetsubmitbutton)
        {
            Intent i=new Intent(ForgetPassword.this,PasswordUpdate.class);
            startActivity(i);
        }
    }
}
