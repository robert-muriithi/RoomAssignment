package com.example.loginandsignupassignment.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginandsignupassignment.R;

import java.util.ArrayList;

public class ContactCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_category);

        initializeRecycler();
    }

    private void initializeRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.add("Family");
        arrayList.add("Friends");
        arrayList.add("Students");
        arrayList.add("Tutors");
        arrayList.add("Colleagues");
        arrayList.add("Teachers");
        arrayList.add("Lecturers");

        RecyclerAdapter adapter = new RecyclerAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}