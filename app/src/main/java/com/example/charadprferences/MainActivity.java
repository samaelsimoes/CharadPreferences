package com.example.charadprferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button   buttonSave;
    private TextView textViewResulta;

    private static final String PREFERENCES_FILE = "preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        editTextName    = findViewById( R.id.editTextName );
        buttonSave      = findViewById( R.id.buttonSave );
        textViewResulta = findViewById( R.id.textViewResult );

        SharedPreferences preferences = getSharedPreferences(
                PREFERENCES_FILE,
                MODE_PRIVATE
        );

        if (preferences.contains("name")) {
            String name = preferences.getString( "name", "VAZIO" );
            textViewResulta.setText( name );
        }

        buttonSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                textViewResulta.setText(name);

                SharedPreferences preferences = getSharedPreferences(
                        PREFERENCES_FILE,
                        MODE_PRIVATE
                );
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", name);
                editor.commit();
            }
        } );
    }
}
