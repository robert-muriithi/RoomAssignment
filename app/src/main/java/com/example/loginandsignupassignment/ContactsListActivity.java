package com.example.loginandsignupassignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandsignupassignment.Adapters.ListRecyclerAdapter;
import com.example.loginandsignupassignment.ContactsDB.ContactsDao;
import com.example.loginandsignupassignment.ContactsDB.FamilyEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactsListActivity extends AppCompatActivity {
    FloatingActionButton FAB;
    ListRecyclerAdapter adapter;
    ContactsDao contactsDao;
    List<FamilyEntity> list = new ArrayList<>();
    private static final String TAG = "ContactsListActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        Intent intent = getIntent();
        String string = intent.getStringExtra("CATEGORY_NAME");
        getSupportActionBar().setTitle(string);

        FAB = findViewById(R.id.FAB);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddContactsActivity.class));
            }
        });

        loadContacts();
        initializeRecycler();
    }

    private void initializeRecycler() {
        RecyclerView recyclerView = findViewById(R.id.contact_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);

    }

    private void loadContacts() {

        list = contactsDao.getAllContacts();
        Log.d(TAG, "loadContacts: " + list.get(0).getName());
        adapter = new ListRecyclerAdapter(list);

    }
}
