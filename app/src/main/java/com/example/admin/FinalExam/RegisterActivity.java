package com.example.admin.FinalExam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText Editname, Edit_Uname, Edit_password;
    Button button_create;
    loginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        loginDataBaseAdapter = new loginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();


        Editname = (EditText) findViewById(R.id.Edit_name);
        Edit_password = (EditText) findViewById(R.id.Edit_Password);
        Edit_Uname = (EditText) findViewById(R.id.Edit_Password);

        button_create = (Button) findViewById(R.id.button_create);
        button_create.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String name = Editname.getText().toString();
                String username = Edit_Uname.getText().toString();
                String password = Edit_password.getText().toString();


                if (name.equals("") || username.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Failed to create", Toast.LENGTH_LONG).show();
                    return;
                }

                else {
                    loginDataBaseAdapter.insertEntry();
                    Toast.makeText(getApplicationContext(), " Created Account Successfully ", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
