package com.example.epidemicsimulator;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//define table name
@Entity(tableName = "name_table")
public class UsernameData implements Serializable {
    //Create id Column
    @PrimaryKey(autoGenerate = true)
    private int ID;

    //create username column
    @ColumnInfo(name = "username")
    private String text;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
