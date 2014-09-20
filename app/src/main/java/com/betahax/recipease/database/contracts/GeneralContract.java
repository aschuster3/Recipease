package com.betahax.recipease.database.contracts;

/**
 * This GeneralContract will be used to simplify database contracts by pre-defining
 * commonly needed types and functions
 */
public abstract class GeneralContract {

    // These constants represent the SQLite3 data types
    public static final String  NULL_TYPE = " NULL",
                                REAL_TYPE = " REAL",
                                INT_TYPE = " INTEGER",
                                TEXT_TYPE = " TEXT",
                                BLOB_TYPE = " BLOB";

    // This constant is for identifying the primary key
    public static final String PRIMARY_KEY = " PRIMARY KEY";

    /**
     * A method to generate foreign key references more easily
     *
     * @param entryName The name of the column entry
     * @param referenceTable The table that the foreign key will reference
     * @param referenceEntryName The column entry that the foreign key references
     * @return The fully generated foreign key reference to be placed in a CREATE TABLE call
     */
    public static String foreignKey(String entryName, String referenceTable, String referenceEntryName) {
        return String.format(" FOREIGN KEY(%s) REFERENCES %s(%s)", entryName, referenceTable, referenceEntryName);
    }

    // A convenience for adding comma separation
    public static final String COMMA_SEP = ", ";
}
