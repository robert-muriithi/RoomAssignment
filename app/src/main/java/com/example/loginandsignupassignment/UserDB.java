package com.example.loginandsignupassignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 4)
public abstract class UserDB extends RoomDatabase {

    private static final String DATABASE_NAME = "userDB";
    private static UserDB userDB;

    public static synchronized UserDB getUserDB(Context context){
        if (userDB == null){
            userDB = Room.databaseBuilder(context,UserDB.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDB;
    }

    public  abstract  UserDao userDao();
}
