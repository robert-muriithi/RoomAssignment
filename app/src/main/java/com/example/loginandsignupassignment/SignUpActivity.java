package com.example.loginandsignupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginandsignupassignment.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
 ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUserName(binding.nameEditText.getText().toString());
                userEntity.setUserEmail(binding.signUpEmailEditText.getText().toString());
                userEntity.setPassword(binding.signUpPasswordEditText.getText().toString());
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
                                    Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();

                }else {
                    Toast.makeText(SignUpActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateInputs(UserEntity userEntity){
        if (userEntity.getUserName().isEmpty()
                || userEntity.getUserEmail().isEmpty()
                || userEntity.getPassword().isEmpty()
                || userEntity.getConfPassword().isEmpty())
        {
            return false;
        }
        return true;
    }

    private Boolean validatePasswords(){
        if (binding.signUpPasswordEditText.getText().toString().equals(binding.confirmPasswordEditText.getText().toString())){
            return true;
        }
        return false;
    }
}