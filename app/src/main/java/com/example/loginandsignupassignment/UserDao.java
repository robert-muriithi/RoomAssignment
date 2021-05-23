package com.example.loginandsignupassignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM users where email=(:email) and password=(:password)")
    UserEntity login(String email, String password);


}
