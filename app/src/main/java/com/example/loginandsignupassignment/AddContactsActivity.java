package com.example.loginandsignupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandsignupassignment.ContactsDB.ContactsDB;
import com.example.loginandsignupassignment.ContactsDB.ContactsDao;
import com.example.loginandsignupassignment.ContactsDB.FamilyEntity;

public class AddContactsActivity extends AppCompatActivity {
    Button add;
    EditText contactName, contactNumber;
    ContactsDao contactsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        getSupportActionBar().hide();

        contactName = findViewById(R.id.contact_name);
        contactNumber = findViewById(R.id.contact_number);
        ContactsDB database = ContactsDB.getContactsDB(getApplicationContext());
        contactsDao = database.contactsDao();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FamilyEntity entity = new FamilyEntity(0, contactName.getText().toString(), contactNumber.getText().toString());
                insertContact(entity);
                Toast.makeText(AddContactsActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void insertContact(FamilyEntity entity) {
        new InsertContactAsyncTask(contactsDao).execute(entity);

        Toast.makeText(getApplication(), "Added contact", Toast.LENGTH_SHORT).show();
    }

    private static class InsertContactAsyncTask extends AsyncTask<FamilyEntity, Void, Void> {
        private ContactsDao contactsDao;

        public InsertContactAsyncTask(ContactsDao contactsDao) {
            this.contactsDao = contactsDao;
        }

        @Override
        protected Void doInBackground(FamilyEntity... familyEntities) {
            contactsDao.addContacts(familyEntities[0]);
            return null;
        }
    }
}