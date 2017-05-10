package com.example.deepanshu.imagegallery.gallery.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 10/5/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "scapic";

    // Table Names
    private static final String DB_TABLE = "scapic_image";

    // column names
    private static final String KEY_ID = "image_id";
    private static final String KEY_IMAGE = "image_data";

    // Table create statement
    private static final String CREATE_TABLE_IMAGE = "CREATE TABLE " + DB_TABLE + "(" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_IMAGE + " BLOB);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating table
        db.execSQL(CREATE_TABLE_IMAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        // create new table
        onCreate(db);
    }

    // Adding new image
    public void addImage(byte[] bitmap) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE, bitmap); // Contact Name

        // Inserting Row
        db.insert(DB_TABLE, null, values);
        db.close(); // Closing database connection
    }

    // Getting single bitmap
    public byte[] getImage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB_TABLE, new String[]{KEY_ID,
                        KEY_IMAGE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        byte[] byteImage = new byte[0];
        if (cursor != null) {
            byteImage = cursor.getBlob(1);
        }

        // return byteImage
        return byteImage;
    }

    // Getting All Bitmap
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public List<byte[]> getAllImages() {
        List<byte[]> imageList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DB_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        try (Cursor cursor = db.rawQuery(selectQuery, null)) {
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                byte[] blob;
                do {
                    blob = cursor.getBlob(1);
                    // Adding contact to list
                    imageList.add(blob);
                } while (cursor.moveToNext());
            }
        }

        // return contact list
        return imageList;
    }
}
