package com.example.basiclogins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity
{
    private EditText name;
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;
    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        wireWidgets();

        username.setText(getIntent().getStringExtra(LoginActivity.EXTRA_MESSAGE));

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().length() == 0)
                {
                    Toast.makeText(CreateAccountActivity.this, "Please type your name in the corresponding line.", Toast.LENGTH_SHORT).show();
                }
                else if(username.getText().toString().length() == 0)
                {
                    Toast.makeText(CreateAccountActivity.this, "Please type your username in the corresponding line.", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().length() == 0)
                {
                    Toast.makeText(CreateAccountActivity.this, "Please type your password in the corresponding line.", Toast.LENGTH_SHORT).show();
                }
                else if(confirmPassword.getText().toString().length() == 0)
                {
                    Toast.makeText(CreateAccountActivity.this, "Please type your password in the confirm password line.", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().length() == 0)
                {
                    Toast.makeText(CreateAccountActivity.this, "Please type your email in the corresponding line.", Toast.LENGTH_SHORT).show();
                }
                else if(!password.getText().toString().equals(confirmPassword.getText().toString()))
                {
                    Toast.makeText(CreateAccountActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("password", password.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private void wireWidgets()
    {
        name = findViewById(R.id.editText_createAccount_name);
        username = findViewById(R.id.editText_createAccount_username);
        password = findViewById(R.id.editText_createAccount_password);
        confirmPassword = findViewById(R.id.editText_createAccount_confirmPassword);
        email = findViewById(R.id.editText_createAccount_email);
        createAccount = findViewById(R.id.button_createAccount_create);
    }
}
