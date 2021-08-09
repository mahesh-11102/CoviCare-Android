package com.example.covicare.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.covicare.model.Oxygen;
import com.example.covicare.params.Oxygen_params;

import java.util.ArrayList;
import java.util.List;


public class Oxygen_db extends SQLiteOpenHelper {
    public Oxygen_db(Context context){
        super(context, Oxygen_params.DB_NAME,null, Oxygen_params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create2  = "CREATE TABLE "+ Oxygen_params.TABLE_NAME+
                "("+
                Oxygen_params.KEY_ID+" INTEGER PRIMARY KEY, "+
                Oxygen_params.KEY_NAME+" TEXT, "+
                Oxygen_params.KEY_MAIL+" TEXT, "+
                Oxygen_params.KEY_PHONE+" TEXT, "+
                Oxygen_params.KEY_CITY+" TEXT, "+
                Oxygen_params.KEY_STREET+ " TEXT " +
                ")";
        Log.d("test_oxygen","Query being run :"+ create2);

        db.execSQL(create2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addDetails(Oxygen oxygen){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Oxygen_params.KEY_NAME, oxygen.getdealer_name());
        values.put(Oxygen_params.KEY_PHONE, oxygen.getPhonenumber());
        values.put(Oxygen_params.KEY_MAIL, oxygen.getMail());
        values.put(Oxygen_params.KEY_CITY, oxygen.getCity());
        values.put(Oxygen_params.KEY_STREET, oxygen.getStreet());

        db.insert(Oxygen_params.TABLE_NAME,null, values);
        Log.d("mg","mg vacchi");
        db.close();
    }

    public List<Oxygen> getAllOxygenDeatails(){
        List<Oxygen> oxygenList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //generating the query to read from the database
        String getAllTableValues = "SELECT * FROM "+ Oxygen_params.TABLE_NAME;
        Cursor cursor = db.rawQuery(getAllTableValues,null);

        //loop through now
        if(cursor.moveToFirst()) {
            do {
                Oxygen oxygen = new Oxygen();
                oxygen.setId(Integer.parseInt(cursor.getString(0)));
                oxygen.setdealer_name(cursor.getString(1));
                oxygen.setPhonenumber(cursor.getString(2));
                oxygen.setMail(cursor.getString(3));
                oxygen.setCity(cursor.getString(4));
                oxygen.setStreet(cursor.getString(5));

                oxygenList.add(oxygen);
                Log.d("colCount", " " + cursor.getColumnNames());
            } while (cursor.moveToNext());
        }
        Log.d("test",""+ cursor.getCount());
        return oxygenList;
    }
}
