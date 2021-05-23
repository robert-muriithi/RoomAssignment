package com.example.loginandsignupassignment.ContactsDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactsDao {

    @Query("SELECT * FROM familyEntity")

    List<FamilyEntity> getAllContacts();

    @Insert
    void addContacts (FamilyEntity... familyEntities);
}
