  package com.example.covicare.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.covicare.model.Blood;
import com.example.covicare.params.Blood_params;

import java.util.ArrayList;
import java.util.List;

  public class Blood_db extends SQLiteOpenHelper {
      public Blood_db(Context context){
          super(context, Blood_params.DB_NAME,null, Blood_params.DB_VERSION);
      }

       @Override
       public void onCreate(SQLiteDatabase db) {
          String create  = "CREATE TABLE "+ Blood_params.TABLE_NAME+
                  " ("+
                  Blood_params.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                  Blood_params.KEY_NAME+" TEXT, "+
                  Blood_params.KEY_MAIL+" TEXT, "+
                  Blood_params.KEY_PHONE+" TEXT, "+
                  Blood_params.KEY_CITY+" TEXT, "+
                  Blood_params.KEY_STREET+ " TEXT " +
                  ")";
          Log.d("test_blood","Query being run : "+ create);

          db.execSQL(create);
       }

       @Override
       public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       }

       public void addDetails(Blood blood){
           SQLiteDatabase db = this.getWritableDatabase();
           ContentValues values = new ContentValues();
           values.put(Blood_params.KEY_NAME, blood.getName());
           values.put(Blood_params.KEY_PHONE, blood.getPhonenumber());
           values.put(Blood_params.KEY_MAIL, blood.getMail());
           values.put(Blood_params.KEY_CITY, blood.getCity());
           values.put(Blood_params.KEY_STREET, blood.getStreet());

           db.insert(Blood_params.TABLE_NAME,null, values);
           Log.d("mg","mg vacchi");
           db.close();
       }
      public List<Blood> getAllBloodDeatails(){
          List<Blood> bloodList = new ArrayList<>();
          SQLiteDatabase db = this.getReadableDatabase();

          //generating the query to read from the database
          String getAllTableValues = "SELECT * FROM "+ Blood_params.TABLE_NAME;
          Cursor cursor = db.rawQuery(getAllTableValues,null);

          //loop through now
          if(cursor.moveToFirst()) {
              do {
                  Blood blood = new Blood();
                  blood.setId(Integer.parseInt(cursor.getString(0)));
                  blood.setName(cursor.getString(1));
                  blood.setPhonenumber(cursor.getString(2));
                  blood.setMail(cursor.getString(3));
                  blood.setCity(cursor.getString(4));
                  blood.setStreet(cursor.getString(5));

                  bloodList.add(blood);
                  Log.d("colCount", " " + cursor.getColumnNames());
              } while (cursor.moveToNext());
          }
          Log.d("test",""+ cursor.getCount());
          return bloodList;
      }


       public int updateBloodDetails(Blood blood ){
          SQLiteDatabase db = this.getWritableDatabase();

          ContentValues values = new ContentValues();
          values.put(Blood_params.KEY_NAME,blood.getName());
           values.put(Blood_params.KEY_PHONE, blood.getPhonenumber());
           values.put(Blood_params.KEY_MAIL, blood.getMail());
           values.put(Blood_params.KEY_CITY, blood.getCity());
           values.put(Blood_params.KEY_STREET, blood.getStreet());

           // update now
           return db.update(Blood_params.TABLE_NAME,values,Blood_params.KEY_ID +"=?",
                   new String[]{String.valueOf(blood.getId())});
       }

       public void deleteBloodDetailsbyid(int id){
          SQLiteDatabase db = this.getWritableDatabase();
          db.delete(Blood_params.TABLE_NAME, Blood_params.KEY_ID+"=?", new String[]{String.valueOf(id)});
          db.close();
       }
        public void deleteBloodDetailsbyName(Blood blood){
          SQLiteDatabase db = this.getWritableDatabase();
          db.delete(Blood_params.TABLE_NAME, Blood_params.KEY_ID+"=?", new String[]{String.valueOf(blood.getId())});
          db.close();
       }

   }
