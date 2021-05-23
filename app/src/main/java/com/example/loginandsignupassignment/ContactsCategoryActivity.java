package com.example.loginandsignupassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.loginandsignupassignment.Adapters.CategoryRecyclerAdapter;
import com.example.loginandsignupassignment.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class  ContactsCategoryActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initRecycler();
    }

    private void initRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        ArrayList<String > contacts = new ArrayList<>();
                contacts.add("Family");
                contacts.add("Friends");
                contacts.add("Colleages");
                contacts.add("Lecturers");
                contacts.add("Tutors");
                contacts.add("Classmates");

        CategoryRecyclerAdapter adapter = new CategoryRecyclerAdapter(contacts, this);
        recyclerView.setAdapter(adapter);

    }
}