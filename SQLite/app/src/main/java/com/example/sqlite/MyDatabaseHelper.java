package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String DATABASE_NAME = "db_mahasiswa";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "mahasiswa";
    private static final String FIELD_ID = "id_mhs";
    private static final String FIELD_NAMA = "nama";
    private static final String FIELD_EMAIL = "email";
    private static final String FIELD_FAKULTAS = "fakultas";
    private static final String FIELD_PRODI = "prodi";
    private static final String FIELD_NIM = "nim";
    private static final String FIELD_ANGKATAN = "angkatan";
    private static final String FIELD_SEMESTER = "semester";
    private static final String FIELD_STATUS = "status";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_NAMA + " TEXT, " +
                FIELD_EMAIL + " TEXT, " +
                FIELD_FAKULTAS + " TEXT, " +
                FIELD_PRODI + " TEXT, " +
                FIELD_STATUS + " TEXT, " +
                FIELD_NIM + " TEXT, " +
                FIELD_ANGKATAN + " TEXT, " +
                FIELD_SEMESTER + " TEXT ); " ;

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long tambahMahasiswa(String nama, String email, String fakultas, String prodi, String status, String nim, String angkatan, String semester) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIELD_NAMA, nama);
        cv.put(FIELD_EMAIL, email);
        cv.put(FIELD_FAKULTAS, fakultas);
        cv.put(FIELD_PRODI, prodi);
        cv.put(FIELD_STATUS, status);
        cv.put(FIELD_NIM, nim);
        cv.put(FIELD_ANGKATAN, angkatan);
        cv.put(FIELD_SEMESTER, semester);

        long eksekusi = db.insert(TABLE_NAME, null, cv);

        return eksekusi;
    }

    public Cursor bacaSemuaData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

}
