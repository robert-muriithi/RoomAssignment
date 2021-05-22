package com.example.loginandsignupassignment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {



    @PrimaryKey (autoGenerate = true)
    int id;

    @ColumnInfo(name = "userName")
    String userName;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "email")
    String userEmail;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
