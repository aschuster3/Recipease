package com.betahax.recipease.database.contracts;

import android.provider.BaseColumns;
import android.view.InputDevice;

/**
 * Created by Owner on 9/20/2014.
 */
public class RecipeContract extends GeneralContract {

    public RecipeContract() {
        // Intentionally empty
    }

    public static abstract class DBEntry implements BaseColumns {
        public static final String TABLE_NAME = "recipes",
                                   RECIPE_NAME = "name",
                                   INGREDIENTS = "ingredients",
                                   IMAGE_SOURCE = "image_source",
                                   NOTES = "notes";
    }

    public static final String CREATE_TABLE =
        "CREATE TABLE " + DBEntry.TABLE_NAME + " (" +
        DBEntry._ID + TEXT_TYPE + COMMA_SEP +
        DBEntry.RECIPE_NAME + TEXT_TYPE + COMMA_SEP +
        DBEntry.INGREDIENTS + TEXT_TYPE + COMMA_SEP +
        DBEntry.IMAGE_SOURCE + TEXT_TYPE + COMMA_SEP +
        DBEntry.NOTES + TEXT_TYPE + COMMA_SEP +
        ")";

    public static final String DROP_TABLE =
        "DROP TABLE IF EXISTS " + DBEntry.TABLE_NAME;
}
