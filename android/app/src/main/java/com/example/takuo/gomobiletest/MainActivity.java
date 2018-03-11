package com.example.takuo.gomobiletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import golib.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonGo;
    private EditText edittextMessage;
    private TextView textviewAnswer;
    private Golib_ golib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGo = findViewById(R.id.go);
        buttonGo.setOnClickListener(this);

        edittextMessage = findViewById(R.id.message);
        textviewAnswer = findViewById(R.id.answer);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go:
                golib = Golib.newClient();
                String msg = null;
                try {
                    msg = golib.foo(edittextMessage.getText().toString());
                } catch (Exception e) {
                    msg = e.getMessage();
                }
                textviewAnswer.setText(msg);
                edittextMessage.setText("");
                break;
        }
    }
}
