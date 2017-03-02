package com.sashakhyzhun.wearexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ListView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        updateUI();

    }


    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            displaySpeechScreen();
        } else {
            Note note = (Note) parent.getItemAtPosition(position);
            Intent intent = new Intent(getApplicationContext(), DeleteActivity.class);
            intent.putExtra("id", note.getId());
            startActivity(intent);
        }
    }





    private void updateUI() {
        ArrayList<Note> notes = NoteHelper.getAllNotes(this);
        notes.add(0, new Note("", ""));
        listView.setAdapter(new ListViewAdapter(this, 0, notes));
    }

    private void displaySpeechScreen() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1001) {
                List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                String message = results.get(0);
                String id = String.valueOf(System.currentTimeMillis());
                Note note = new Note(message, id);
                NoteHelper.saveNote(note, this);
                NoteHelper.displayConfirmation("Note saved", this);

                updateUI();
            }
            else {
                NoteHelper.displayConfirmation("Please try again", this);
            }
        }
    }


}
