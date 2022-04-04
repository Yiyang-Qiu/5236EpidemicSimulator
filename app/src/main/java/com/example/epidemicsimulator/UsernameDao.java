package com.example.epidemicsimulator;

import android.icu.text.Replaceable;

import  androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import  static androidx.room.OnConflictStrategy.REPLACE;

import java.util.List;

@Dao
public interface UsernameDao {
    //insert query
    @Insert(onConflict = REPLACE)
    void insert(UsernameData usernameData);

    //delete query
    @Delete
    void delete(UsernameData usernameData);

    //Delete all query
    @Delete
    void reset(List<UsernameData> usernameData);

    //update query
    @Query("UPDATE name_table SET username = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    //get all data query
    @Query("SELECT * FROM name_table")
    List<UsernameData> getAll();

    //check whether username exist
    @Query("SELECT count(*) FROM name_table where username = :username ")
    int checkUsername(String username);


}
