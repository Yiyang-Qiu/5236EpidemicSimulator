package com.example.epidemicsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class ScoreFragment extends Fragment {
    // Game over (win or lose). Calculate the score. Win: Congras || Lose: Play ending.
    Button mPlayButton, mBackButton, mRankButton;
    TextView mDayText, mScoreText;
    String tempDay, tempScore;
    int mScore;
    RoomDB database;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_score, container, false);
        // retrieve day
        database=RoomDB.getInstance(getActivity());
        mDayText = (TextView) v.findViewById(R.id.day_text);
        mScoreText = (TextView) v.findViewById(R.id.score_text);
        tempDay=mDayText.getText().toString();
        tempScore=mScoreText.getText().toString();
        mPlayButton=(Button) v.findViewById(R.id.play_button);
        mBackButton=(Button) v.findViewById(R.id.back_button);
        mRankButton=(Button) v.findViewById(R.id.rank_button);

        int mDay = getActivity().getIntent().getIntExtra("DAY",0);
        Player mPlayer=Player.get(getActivity());
        mScore = mPlayer.getPHealth()+mPlayer.getMHealth()+mDay;  // formula to calculate score

        mDayText.setText(ReplaceCharInString
                .replace(tempDay,Integer.toString(mDay)));  //set day text
        mScoreText.setText(ReplaceCharInString
                .replace(tempScore,Integer.toString(mScore)));  //set score text


        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent1);
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(),MenuActivity.class);
                startActivity(intent1);
            }
        });

        mRankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(),AddRanksActivity.class);
                startActivity(intent1);
            }
        });

        // Add Rank record to database
        MainData record = new MainData();
        record.setText(mPlayer.getUsername());
        record.setPoint(mScore);
        database.mainDao().insert(record);
        mPlayer.reset();

        //Toast.makeText(getActivity(),Integer.toString(mPlayer.getMHealth()),Toast.LENGTH_SHORT).show();
        return v;
    }
}
