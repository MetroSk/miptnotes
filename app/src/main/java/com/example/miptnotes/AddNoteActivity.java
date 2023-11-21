package com.example.miptnotes;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class AddNoteActivity extends AppCompatActivity {
    private static final String FILE_NAME = "notes.txt";

    public static Intent getIntent(Context context) {
        return new Intent(context, AddNoteActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextContent = findViewById(R.id.editTextContent);
        Button buttonCreateNote = findViewById(R.id.buttonCreateNote);

        buttonCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteName = editTextName.getText().toString().trim();
                String noteContent = editTextContent.getText().toString().trim();

                if (!noteName.isEmpty() && !noteContent.isEmpty()) {
                    saveNoteToFile(noteName, noteContent);
                    Log.d("AddNoteActivity", "Note created: " + noteName);
                    finish();
                }
            }
        });
    }

    private void saveNoteToFile(String name, String content) {
        try (FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND)) {
            String note = name + ": " + content + "\n";
            fos.write(note.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
