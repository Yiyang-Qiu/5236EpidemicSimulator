package com.example.epidemicsimulator;

import android.icu.text.Replaceable;

import  androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import  static androidx.room.OnConflictStrategy.REPLACE;

import java.util.List;

@Dao
public interface EventDao {
    //insert query
    @Insert(onConflict = REPLACE)
    void insert(EventData eventData);

    //delete query
    @Delete
    void delete(EventData eventData);

    //Delete all query
    @Delete
    void reset(List<EventData> eventData);

    //update query
    @Query("UPDATE event_table SET event_name = :sName, event_description = :sDescription WHERE ID = :sID")
    void update(int sID, String sName, int sDescription);

    //get event by id
    @Query("SELECT * FROM event_table WHERE ID = :sID" )
    EventData getEvent(int sID);

    //get number of events
    @Query("SELECT count(*) FROM event_table")
    int getCount();


}
