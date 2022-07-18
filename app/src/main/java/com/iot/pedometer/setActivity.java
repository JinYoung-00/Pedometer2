package com.iot.pedometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Button;

public class setActivity extends AppCompatActivity {
    private EditText editText;
    public static Context context_main;
    public String goal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        editText=(EditText)findViewById(R.id.editText);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goal = editText.getText().toString();
                Integer.parseInt(editText.getText().toString());
                finish();
            }
        });
        context_main = this;

    }
}