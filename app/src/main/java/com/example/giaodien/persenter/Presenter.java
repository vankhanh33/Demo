package com.example.giaodien.persenter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.giaodien.Constract;
import com.example.giaodien.Database;
import com.example.giaodien.MainActivity;

public class Presenter implements Constract.IPresenter {
    private Constract.IView mview;
    private String database_name="mvp.db";
    SQLiteDatabase database;
    public Presenter(Constract.IView view){
        mview = view;
    }
    @Override
    public void dologin(String email, String pass, MainActivity l) {
        database=Database.initDatabase(l,database_name);
        Cursor cursor=database.rawQuery("Select * from Accout", null);
        for(int i = 0; i < cursor.getCount(); i++ ){
            cursor.moveToPosition(i);
            if (email.equals(cursor.getString(0)) && pass.equals(cursor.getString(1))) {
                mview.showloginsuccess();
            }else {
                mview.showloginFailed();
            }
        }
    }

    @Override
    public void forgotpass() {

    }
}
