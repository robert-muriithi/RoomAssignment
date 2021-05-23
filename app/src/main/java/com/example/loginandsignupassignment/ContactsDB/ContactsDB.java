package com.example.loginandsignupassignment.ContactsDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FamilyEntity.class}, version = 1)
public abstract class ContactsDB extends RoomDatabase {
    public static final String DATABASE_NAME = "userDatabase";
    public static ContactsDB userDatabase;
    public static ContactsDB getContactsDB(Context context){
        if (userDatabase == null){
            userDatabase = Room.databaseBuilder(context,ContactsDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }
    public abstract ContactsDao contactsDao();
}
