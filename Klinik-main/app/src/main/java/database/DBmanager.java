package database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmanager extends SQLiteOpenHelper{

    public DBmanager(@Nullable Context context) {
        super(context, "klinik1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table antrean(id INTEGER PRIMARY KEY AUTOINCREMENT , nama_pasien TEXT, jenis_kelamin TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists antrean");
    }

    public Boolean insert(String nama_pasien, String jenis_kelamin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_pasien", nama_pasien);
        contentValues.put("jenis_kelamin", jenis_kelamin);
        long result = db.insert("antrean", null, contentValues);
        if (result == 1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("Select * from antrean", null);
        return data;
    }

/*    public Boolean update(String nama_pasien, String jenis_kelamin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_pasien", nama_pasien);
        contentValues.put("jenis_kelamin", jenis_kelamin);
        Cursor cursor = db.rawQuery("Select * from antrean where nama_pasien=?", new String[]{nama_pasien});
        if (cursor.getCount() > 0) {
            long result = db.update("antrean", contentValues, "nama_pasien=?", new String[]{nama_pasien});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }*/
}
