package com.example.admin.FinalExam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    loginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginDataBaseAdapter=new  loginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        final EditText editTextUserName=(EditText) findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText) findViewById(R.id.editTextPasswordToLogin);
        Button btnSignIn=(Button) findViewById(R.id.buttonSignIn);
        Button btnreg = (Button)findViewById(R.id.button_reg);
        btnreg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intentSignUP);
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName= editTextUserName.getText().toString();
                String password= editTextPassword.getText().toString();

                String storedUsername= loginDataBaseAdapter.getSinlgeEntry(userName);
                String storedPassword= loginDataBaseAdapter.getSinlgeEntry(password);
                Intent intentReg = new Intent(getApplicationContext(),MainActivity.class);

                if (userName.equals(storedUsername)&& password.equals(storedPassword))
                {
                    startActivity(intentReg);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Username Or Password", Toast.LENGTH_LONG).show();
                }
            }
        });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
