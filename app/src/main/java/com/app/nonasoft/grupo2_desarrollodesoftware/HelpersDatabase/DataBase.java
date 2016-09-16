package com.app.nonasoft.grupo2_desarrollodesoftware.HelpersDatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Adara on 9/16/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    private static String db_path = "/data/data/com.app.nonasoft.grupo2_desarrollodesoftware/databases/";
    private  static String db_name = "usuariosDB.sqlite";
    private final Context context;
    private SQLiteDatabase myBd;

    public DataBase(Context context){
        //contexto, nombre de la bd, factory null y version
        super(context, db_name, null, 1 );
        this.context = context;
    }

    public void createDb()
    throws IOException{
        boolean existDb = checkDatabase();
        SQLiteDatabase dbRead = null;

        if(existDb){

        }else{
            dbRead = this.getReadableDatabase();
            dbRead.close();

            try{
                copyDatabase();
            } catch (IOException e){
                throw new Error("ERROR AL COPIAR LA DDBB");
            }
        }

    }

    public boolean checkDatabase() {
        SQLiteDatabase dbCheck = null;

        try {
            String generalPath = db_path + db_name;
            dbCheck = SQLiteDatabase.openDatabase(generalPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch (Exception e){
            File fileDb = new File(db_path+db_name);
            return fileDb.exists();
        }

        if(dbCheck != null){
            dbCheck.close();
            //si dbCheck es diferente a null es verdaddero y si no se cumple pasa a ser falso
            return dbCheck != null ? true : false;
        }

        return false;
    }

    private void copyDatabase() throws IOException{
        InputStream in = context.getAssets().open(db_name);
        String outFile = db_path+db_name;
        OutputStream ou = new FileOutputStream(outFile);

        byte[] buffer = new byte[1024];
        int length;

        //copia de todo lo que tiene
        while((length = in.read(buffer)) != -1){
            if(length > 0){
                ou.write(buffer, 0, length);
            }
        }

        ou.flush();
        ou.close();
        in.close();
     }

    public void openDatabase() throws SQLException{
        String generalPath = db_path + db_name;
        myBd = SQLiteDatabase.openDatabase(generalPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public synchronized void close(){
        if(myBd != null){
            myBd.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
