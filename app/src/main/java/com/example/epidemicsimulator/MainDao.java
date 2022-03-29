package com.example.epidemicsimulator;

import android.icu.text.Replaceable;

import  androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import  static androidx.room.OnConflictStrategy.REPLACE;

import java.util.List;

@Dao
public interface MainDao {
    //insert query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //delete query
    @Delete
    void delete(MainData mainData);

    //Delete all query
    @Delete
    void reset(List<MainData> mainData);

    //update query
    @Query("UPDATE rank_table SET player_info = :sText, point = :sPoint WHERE ID = :sID")
    void update(int sID, String sText, int sPoint);

    //get all data query
    @Query("SELECT * FROM rank_table")
    List<MainData> getAll();


}
