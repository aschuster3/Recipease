package com.betahax.recipease.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.betahax.recipease.database.contracts.RecipeContract;


/**
 * A database helper used to store information about questions answered by the user
 */
public class RecipeDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "recipes.db";
    private static final int DATABASE_VERSION = 1;


    public RecipeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(RecipeContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Definitely change this
        sqLiteDatabase.execSQL(RecipeContract.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
