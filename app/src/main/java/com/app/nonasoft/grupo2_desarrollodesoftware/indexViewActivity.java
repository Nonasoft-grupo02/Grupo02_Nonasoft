package com.app.nonasoft.grupo2_desarrollodesoftware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by adara on 06/09/2016.
 */
public class IndexViewActivity extends Activity {

    EditText editTxt;
    Button btnRegistrar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_view);

        editTxt = (EditText) findViewById(R.id.txtName);
        editTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTxt.setText("");
            }
        });


        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnComenzar = new Intent(IndexViewActivity.this, Menu.class);
                startActivity(btnComenzar);
            }
        });

    }


}