package com.example.android.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotesTaking extends AppCompatActivity {

    static String notes = "";
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taking);
        e = findViewById(R.id.note_text);
        if(!notes.equals("")){
            e.setText(notes);
        }
    }

    public void saveData(View view) {
        notes = String.valueOf(e.getText());
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void go_back_toCal(View view) {
        Intent intent = new Intent(NotesTaking.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
