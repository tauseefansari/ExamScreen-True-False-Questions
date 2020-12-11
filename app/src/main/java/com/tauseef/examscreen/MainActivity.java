package com.tauseef.examscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        Spinner topics = findViewById(R.id.spinnertopic);
        Button submit = findViewById(R.id.submit);

        String[] topic = {"Python", "Java"};
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_item, topic);
        topics.setAdapter(mAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().matches(""))
                {
                    if(topics.getSelectedItem().toString() == "Python")
                    {
                        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                        intent.putExtra("name", name.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this, QuizActivitySecond.class);
                        intent.putExtra("name", name.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}