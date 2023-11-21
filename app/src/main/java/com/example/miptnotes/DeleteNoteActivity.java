package com.example.miptnotes;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {
    private static final String FILE_NAME = "notes.txt";

    public static Intent getIntent(Context context, ArrayList<String> noteList) {
        Intent intent = new Intent(context, DeleteNoteActivity.class);
        intent.putStringArrayListExtra("noteList", noteList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        Spinner spinnerNotes = findViewById(R.id.spinnerNotes);
        Button buttonDeleteNote = findViewById(R.id.buttonDeleteNote);

        ArrayList<String> noteList = getIntent().getStringArrayListExtra("noteList");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, noteList);
        spinnerNotes.setAdapter(adapter);

        buttonDeleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedNote = spinnerNotes.getSelectedItem().toString();
                deleteNoteFromFile(selectedNote);
                Log.d("DeleteNoteActivity", "Note deleted: " + selectedNote);
                finish();
            }
        });
    }

    private void deleteNoteFromFile(String noteToDelete) {
       
      
    }
}
