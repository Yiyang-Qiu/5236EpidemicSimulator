package com.example.epidemicsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddRanksActivity extends AppCompatActivity {
    //initialize variables
    EditText playerText, pointText;
    Button btAdd, btReset;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    RankAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ranks);

        //Assign variables
//        playerText = findViewById(R.id.edit_text_addRank);
//        pointText = findViewById(R.id.edit_text_addPoint);
//        btAdd = findViewById(R.id.bt_add);
//        btReset = findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);

        //initialize database
        database = RoomDB.getInstance(this);
        //store database value in data list
        dataList = database.mainDao().getAll();

        //initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        //set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        //initialize adapter
        adapter = new RankAdapter(AddRanksActivity.this,dataList);
        //set adapter
        recyclerView.setAdapter(adapter);

//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                // It will be modified after finishing the point counting modules.
                // The point will                //check condition
                ////                if(!sText.equals("")){
                ////                    //when text is not empty
                ////                    //initialize main data
                ////                    MainData data = new MainData();
                ////                    //set info on main data
                ////                    data.setText(sText);
                ////                    data.setPoint(Integer.valueOf(sText1));
                ////                    //insert text in database
                ////                    database.mainDao().insert(data);
                ////                    //clear edit text
                ////                    playerText.setText("");
                ////                    pointText.setText("");
                ////                    //notify when data is inserted
                ////                    dataList.clear();
                ////                    List<MainData>tempList=database.mainDao().getAll();
                ////                    RankSorting.sortRank(tempList);
                ////                    dataList.addAll(tempList);
                ////                    adapter.notifyDataSetChanged();
                ////                }
                ////            }
                ////        });
                ////
                ////        btReset.setOnClickListener(new View.OnClickListener() {
                ////            @Override
                ////            public void onClick(View view) {
                ////                //delete all data from database
                ////                database.mainDao().reset(dataList);
                ////                //notify when all data deleted
                ////                dataList.clear();
                ////                dataList.addAll(database.mainDao().getAll());
                ////                adapter.notifyDataSetChanged();
                ////            }
                ////        }); be automatically added into database in future sprints

                //Get string from edit text
//                String sText= playerText.getText().toString().trim();
//                String sText1= pointText.getText().toString().trim();
//
    }
}