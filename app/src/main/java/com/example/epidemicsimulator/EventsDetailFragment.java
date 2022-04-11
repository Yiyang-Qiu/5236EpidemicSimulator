package com.example.epidemicsimulator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventsDetailFragment extends Fragment {

    private Button mBackButton, addButton;
    EditText mNameText,mDesText;
    RoomDB database;
    EventData event;

    public EventsDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_events_detail, container, false);

        database=RoomDB.getInstance(getActivity());
        mNameText=(EditText)v.findViewById(R.id.text1);
        mDesText = (EditText)v.findViewById(R.id.text2);


        mBackButton=(Button)v.findViewById(R.id.back2_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventsActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container4, new SettingsOptionsFragment(),null).addToBackStack(null).commit();
            }
        });

        addButton = (Button) v.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event= new EventData();
                event.setName(mNameText.getText().toString());
                event.setDescription(mDesText.getText().toString());
                database.eventDao().insert(event);
                mNameText.setText("");
                mDesText.setText("");
            }
        });



        return v;
    }
}