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
                                   DIRECTIONS = "directions",
                                   IMAGE_SOURCE = "image_source",
                                   LAST_DATE_USED = "last_date_used",
                                   NOTES = "notes",
                                   COOK_TIME = "cook_time",
                                   BASE = "base",
                                   SERVES = "serves",
                                   TIMES_USED = "times_used";
    }

    public static final String CREATE_TABLE =
        "CREATE TABLE " + DBEntry.TABLE_NAME + " (" +
        DBEntry._ID + INT_TYPE + COMMA_SEP +
        DBEntry.RECIPE_NAME + TEXT_TYPE + COMMA_SEP +
        DBEntry.INGREDIENTS + TEXT_TYPE + COMMA_SEP +
        DBEntry.DIRECTIONS + TEXT_TYPE + COMMA_SEP +
        DBEntry.IMAGE_SOURCE + TEXT_TYPE + COMMA_SEP +
        DBEntry.LAST_DATE_USED + TEXT_TYPE + COMMA_SEP +
        DBEntry.NOTES + TEXT_TYPE + COMMA_SEP +
        DBEntry.COOK_TIME + INT_TYPE + COMMA_SEP +
        DBEntry.BASE + INT_TYPE + COMMA_SEP +
        DBEntry.SERVES + INT_TYPE + COMMA_SEP +
        DBEntry.TIMES_USED + INT_TYPE +COMMA_SEP +
        ")";

    public static final String DROP_TABLE =
        "DROP TABLE IF EXISTS " + DBEntry.TABLE_NAME;
}
