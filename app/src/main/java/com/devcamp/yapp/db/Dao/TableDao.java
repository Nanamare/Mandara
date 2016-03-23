package com.devcamp.yapp.db.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.devcamp.yapp.db.DB.DBAdapter;
import com.devcamp.yapp.db.Dto.MainTableDto;
import com.devcamp.yapp.db.Dto.TableDto;

import java.util.ArrayList;

/**
 * Created by Beomjun on 2016-02-27.
 */
public class TableDao {
    public static SQLiteDatabase mDB;

    public TableDao(SQLiteDatabase DB){
        this.mDB = DB;
    }

    public TableDto getData(String table, int id){
        TableDto temp= null;
        Cursor cursor = mDB.rawQuery("SELECT *FROM "+table+" WHERE id ="+id+";",null);
        cursor.moveToFirst();
        Log.d("tag", cursor.getCount() + "");
        temp = new TableDto();

        if(cursor.getCount() == 0){
            return temp;
        }
        if(table == DBAdapter.MAIN_TABLE){
            MainTableDto t = new MainTableDto();
            t.setTitle(cursor.getString(19));
            t.setImage_resource(cursor.getInt(20));
            temp = (TableDto)t;
        }
        temp.setId(cursor.getInt(0));
        temp.setMainText(cursor.getString(1));
        temp.setMain_state(cursor.getInt(2));
        temp.setSubText1(cursor.getString(3));
        temp.setSub1_state(cursor.getInt(4));
        temp.setSubText2(cursor.getString(5));
        temp.setSub2_state(cursor.getInt(6));
        temp.setSubText3(cursor.getString(7));
        temp.setSub3_state(cursor.getInt(8));
        temp.setSubText4(cursor.getString(9));
        temp.setSub4_state(cursor.getInt(10));
        temp.setSubText5(cursor.getString(11));
        temp.setSub5_state(cursor.getInt(12));
        temp.setSubText6(cursor.getString(13));
        temp.setSub6_state(cursor.getInt(14));
        temp.setSubText7(cursor.getString(15));
        temp.setSub7_state(cursor.getInt(16));
        temp.setSubText8(cursor.getString(17));
        temp.setSub8_state(cursor.getInt(18));
        return temp;
    }
    public void insertData(String table, String m, String s1, String s2, String s3, String s4,
                           String s5, String s6, String s7, String s8){
        ContentValues cv = new ContentValues();

        cv.put(DBAdapter.MAIN_OBJECT, m);
        cv.put(DBAdapter.SUB_OBJECT1, s1);
        cv.put(DBAdapter.SUB_OBJECT2, s2);
        cv.put(DBAdapter.SUB_OBJECT3, s3);
        cv.put(DBAdapter.SUB_OBJECT4, s4);
        cv.put(DBAdapter.SUB_OBJECT5, s5);
        cv.put(DBAdapter.SUB_OBJECT6, s6);
        cv.put(DBAdapter.SUB_OBJECT7, s7);
        cv.put(DBAdapter.SUB_OBJECT8, s8);

        mDB.insert(table, null, cv);
    }
    public void insertData(String table, String m, String s1, String s2, String s3, String s4,
                           String s5, String s6, String s7, String s8, String title, int img_resource){
        ContentValues cv = new ContentValues();

        cv.put(DBAdapter.MAIN_OBJECT, m);
        cv.put(DBAdapter.SUB_OBJECT1, s1);
        cv.put(DBAdapter.SUB_OBJECT2, s2);
        cv.put(DBAdapter.SUB_OBJECT3, s3);
        cv.put(DBAdapter.SUB_OBJECT4, s4);
        cv.put(DBAdapter.SUB_OBJECT5, s5);
        cv.put(DBAdapter.SUB_OBJECT6, s6);
        cv.put(DBAdapter.SUB_OBJECT7, s7);
        cv.put(DBAdapter.SUB_OBJECT8, s8);
        cv.put(DBAdapter.TITLE, title);
        cv.put(DBAdapter.IMAGE, img_resource);

        mDB.insert(table, null, cv);
    }

    public ArrayList<TableDto> getAllData(int id){
        ArrayList<TableDto> allData = new ArrayList<TableDto>();
        allData.add(getData(DBAdapter.MAIN_TABLE,id));
        allData.add(getData(DBAdapter.SUB_TABLE1,id));
        allData.add(getData(DBAdapter.SUB_TABLE2,id));
        allData.add(getData(DBAdapter.SUB_TABLE3,id));
        allData.add(getData(DBAdapter.SUB_TABLE4,id));
        allData.add(getData(DBAdapter.SUB_TABLE5,id));
        allData.add(getData(DBAdapter.SUB_TABLE6,id));
        allData.add(getData(DBAdapter.SUB_TABLE7,id));
        allData.add(getData(DBAdapter.SUB_TABLE8,id));
        return allData;
    }


    public Cursor getAllUser() {
        Cursor all = mDB.query(DBAdapter.MAIN_TABLE, null, null, null, null, null, null);
        return all;
    }

}
