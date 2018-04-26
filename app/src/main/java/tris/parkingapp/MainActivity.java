package tris.parkingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password,name,mobile;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.useremailsignup);
        password=findViewById(R.id.userpassword);
        name=findViewById(R.id.username);
        mobile=findViewById(R.id.usermobileno);
        button=findViewById(R.id.signup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                String Pass=password.getText().toString();

                SharedPreferences sp=getSharedPreferences("My_Data",MODE_PRIVATE);
                SharedPreferences.Editor et=sp.edit();
                et.putString("A",Email);
                et.putString("B",Pass);
                et.commit();

                //et.commit();
                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });

    }


}
