package com.example.epidemicsimulator;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Add database entities
@Database(entities = {MainData.class,UsernameData.class},version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    //create database instances
    private static RoomDB database;
    RankAdapter adapter;

    //define database name
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){
        //Check condition
        if (database == null){
            //when database is null then initialize it
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        //return database
        return database;
    }

    //create Dao
    public abstract MainDao mainDao();
    public abstract UsernameDao usernameDao();
}
