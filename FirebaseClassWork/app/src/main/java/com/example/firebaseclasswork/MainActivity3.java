package com.example.firebaseclasswork;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView textViewName;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String email = extras.getString("email");
            displayDataDetails(name, email);
        }
    }

    private void displayDataDetails(String name, String email) {
        textViewName.setText(name);
        textViewEmail.setText(email);
    }
}
