package com.app.nonasoft.grupo2_desarrollodesoftware.HelpersDatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.nonasoft.grupo2_desarrollodesoftware.R;

/**
 * Created by Adara on 9/16/2016.
 */
public class User extends Activity {

    private EditText txtName;
    private  static String db_name = "usuariosDB.sqlite";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_view);

        txtName = (EditText) findViewById(R.id.txtName);
    }

    public void insertUser(View v){



    }
}
