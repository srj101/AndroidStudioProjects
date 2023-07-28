package com.example.firebaseassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private DatabaseReference database;
    private ListView listViewData;
    private List<DataEntry> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize Firebase Realtime Database
        database = FirebaseDatabase.getInstance().getReference("data");

        listViewData = findViewById(R.id.listViewData);
        dataList = new ArrayList<>();

        // Fetch data from Firebase Realtime Database and populate the ListView
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String name = snapshot.child("name").getValue(String.class);
                    String email = snapshot.child("email").getValue(String.class);
                    DataEntry dataEntry = new DataEntry(name, email);
                    dataList.add(dataEntry);
                }
                DataEntryAdapter adapter = new DataEntryAdapter(MainActivity2.this, dataList);
                listViewData.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity2.this, "Error retrieving data", Toast.LENGTH_SHORT).show();
            }
        });

        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataEntry selectedData = dataList.get(position);
                showDataDetails(selectedData);
            }
        });
    }

    private void showDataDetails(DataEntry dataEntry) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        intent.putExtra("name", dataEntry.getName());
        intent.putExtra("email", dataEntry.getEmail());
        startActivity(intent);
    }
}
