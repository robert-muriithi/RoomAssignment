package com.example.loginandsignupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class SigningUpActivity extends AppCompatActivity {

    EditText userName, userEmail, userPassword;
    Button register;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        register = findViewById(R.id.signUpBtn);
        login = findViewById(R.id.loginTextView);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUserName(userName.getText().toString());
                userEntity.setUserEmail(userEmail.getText().toString());
                userEntity.setPassword(userPassword.getText().toString());
                if (validateInputs(userEntity)){
                    UserDB userDB = UserDB.getUserDB(getApplicationContext());
                    UserDao userDao = userDB.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Registered Successfully\n Proceed to Login", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();
                }else {
                    Snackbar.make(view,"Fill all the fields", BaseTransientBottomBar.LENGTH_SHORT).show();
                }
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(SigningUpActivity.this,LoginActivity.class));
           }
       });
    }
    private Boolean validateInputs(UserEntity userEntity){
        if (userEntity.getUserName().isEmpty()
                || userEntity.getUserEmail().isEmpty()
                || userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}