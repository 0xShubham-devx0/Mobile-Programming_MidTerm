package com.example.mp_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText;
    RadioGroup genderRadioGroup;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();

                int selectedId = genderRadioGroup.getCheckedRadioButtonId();

                String gender = "";

                if (selectedId != -1) {
                    RadioButton selectedRadioButton =
                            findViewById(selectedId);

                    gender = selectedRadioButton.getText().toString();
                }

                Intent intent = new Intent(MainActivity.this,
                        MainActivity2.class);

                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("gender", gender);

                startActivity(intent);
            }
        });
    }
}