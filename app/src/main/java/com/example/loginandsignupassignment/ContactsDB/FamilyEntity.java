package com.example.loginandsignupassignment.ContactsDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "familyEntity")
public class FamilyEntity implements Serializable {

    public FamilyEntity(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    @PrimaryKey(autoGenerate = true)
    int id = 0;

    @ColumnInfo(name = "Name")
    String name;

    @ColumnInfo(name = "Number")
    String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
