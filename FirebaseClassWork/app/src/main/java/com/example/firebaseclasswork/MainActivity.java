package com.example.firebaseclasswork;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Realtime Database
        database = FirebaseDatabase.getInstance().getReference();

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToDatabase();
            }
        });

        Button buttonShowData = findViewById(R.id.buttonShowData);
        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity2
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }

    private void saveDataToDatabase() {
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);

        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        // Save data to Firebase Realtime Database
        String key = database.child("data").push().getKey();
        database.child("data").child(key).child("name").setValue(name);
        database.child("data").child(key).child("email").setValue(email);

        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();

        editTextName.setText("");
        editTextEmail.setText("");
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }
}
