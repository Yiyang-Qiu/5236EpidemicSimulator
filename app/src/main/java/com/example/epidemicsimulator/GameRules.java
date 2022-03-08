package com.example.epidemicsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class GameRules extends AppCompatActivity {
    private static final String TAG = "ActivityGameRules";
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rules);

        TextView theTextView1 = (TextView) findViewById(R.id.textView2);
        theTextView1.setText("      As the game starts, you will have five options from which you can choose three. This represents the three categories of supplies you harvested on your way back to your apartment at the start of the pandemic. You only get limited resources. Every day you pass in the game, your physical and mental health drops by 20%. If either of the two reaches 0%, you will die. You can restore physical health (food and water) using the supplies you gain. You can also interact with the items you get (sleep, radio, books...), maybe it will help your mental health. Don't try to escape reality by sleeping. The psychological benefits of sleep are limited. The truly brave one will find another way.\n");
        String stringFromText1 = theTextView1.getText().toString();

        Log.d(TAG, "onCreate: " + stringFromText1);

        TextView theTextView2 = (TextView) findViewById(R.id.textView4);
        theTextView2.setText("      The Ohio State University police will come to your rescue. But it might take them 14 days to find you. You need to stay alive when the campus police arrive. Besides, all communications equipment was cut off and permanently unavailable at the start of the outbreak. The only thing you can use is a radio you might get at Caldwell lab. The radio will occasionally hear messages from campus police.\n");
        String stringFromText2 = theTextView2.getText().toString();
        Log.d(TAG, "onCreate: " + stringFromText2);

        TextView theTextView3 = (TextView) findViewById(R.id.textView5);
        theTextView3.setText("      You may encounter different events. The impact of each event is different. It all depends on whether you want to turn on the event or not. (events here means you probably can get some resources or some helpers (some buffs))\n");
        String stringFromText3 = theTextView3.getText().toString();
        Log.d(TAG, "onCreate: " + stringFromText3);

        TextView theTextView4 = (TextView) findViewById(R.id.textView6);
        theTextView4.setText("      You can use the map to go out and explore. Each exploration will cost 10% of your physical and mental health. You may find something to gain from your exploration. (here we probably use google map or some other hardware like Gyro as our sensor)\n");
        String stringFromText4 = theTextView4.getText().toString();
        Log.d(TAG, "onCreate: " + stringFromText4);

        TextView theTextView5 = (TextView) findViewById(R.id.textView7);
        theTextView5.setText("      If you are still alive after 14 days, you will be rescued by the campus police and end 1. If you die within 14 days, you'll have Ending 2 right away. The game has multiple endings (methods of death) waiting for your exploration.\n");
        String stringFromText5 = theTextView5.getText().toString();
        Log.d(TAG, "onCreate: " + stringFromText5);

        mBackButton=(Button)findViewById(R.id.back_button_rules);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            //back to menu
            }
        });
    }
}