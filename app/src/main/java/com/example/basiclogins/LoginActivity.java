package com.example.basiclogins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private EditText username;
    private EditText password;
    private Button login;
    private TextView createAccount;

    public static final String EXTRA_MESSAGE = "the message";
    public static final int REQUEST_CREATE_ACCOUNT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        wireWidgets();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "under construction", Toast.LENGTH_SHORT).show();
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameInput = username.getText().toString();
                Intent intentSendUsername = new Intent(LoginActivity.this, CreateAccountActivity.class);
                intentSendUsername.putExtra(EXTRA_MESSAGE, usernameInput);
                startActivityForResult(intentSendUsername, REQUEST_CREATE_ACCOUNT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == REQUEST_CREATE_ACCOUNT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String username1 = data.getStringExtra("username");
                String password2 = data.getStringExtra("password");
                username.setText(username1);
                password.setText(password2);
            }
        }
    }


    private void wireWidgets()
    {
        username = findViewById(R.id.editText_login_username);
        password = findViewById(R.id.editText_login_password);
        login = findViewById(R.id.button_login_login);
        createAccount = findViewById(R.id.textView_login_createAccount);
    }
}
