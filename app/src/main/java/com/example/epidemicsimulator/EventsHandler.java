package com.example.epidemicsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EventsHandler {



    // Randomly pick an event
    public static void pickEvent(Player mPlayer, Activity activity){
        RoomDB database = RoomDB.getInstance(activity);
        int eventNum=database.eventDao().getCount();
        Random random=new Random();
        EventData event = database.eventDao().getEvent(random.nextInt(eventNum)+1);  //randomly pick an event
        //EventData event = database.eventDao().getEvent(1);
        TextView mEventTitle, mEventDescription;

        int eventID=event.getID();

        //create dialog
        Dialog dialog =  new Dialog(activity);
        //set content view
        int layoutResId=0;
        switch (eventID){
            case 1:
                layoutResId = R.layout.dialog_event1;
    //            mEventTitle=(TextView)activity.findViewById(R.id.event_title);
    //            mEventDescription=(TextView)activity.findViewById(R.id.event_descrip);

                dialog.setContentView(layoutResId);
                //initialize width
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                //initialize height
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                //set layout
                dialog.getWindow().setLayout(width,height);
                //show dialog
                dialog.show();

                TextView mEvent1Text;
                String event1String;
                mEvent1Text = (TextView)dialog.findViewById(R.id.event_descrip);
                event1String = mEvent1Text.getText().toString();

                TextView mEvent1outcomeText;
                String event1outcomeString;
                mEvent1outcomeText = (TextView)dialog.findViewById(R.id.event_outcome);
                event1outcomeString = mEvent1outcomeText.getText().toString();

                if(mPlayer.getFood()==0){
                    mEvent1Text.setText(ReplaceCharInString.replace(event1String,"help you!"));
                    mEvent1outcomeText.setText(ReplaceCharInString.replace(event1outcomeString,"a food!"));
                    mPlayer.setFood(1);
                }
                else if(mPlayer.getDrink()==0){
                    mEvent1Text.setText(ReplaceCharInString.replace(event1String,"help you!"));
                    mEvent1outcomeText.setText(ReplaceCharInString.replace(event1outcomeString,"a drink!"));
                    mPlayer.setDrink(1);
                }
                else if(mPlayer.getFood()+mPlayer.getDrink()<4){
                    mEvent1Text.setText(ReplaceCharInString.replace(event1String,"help you!"));
                    int flag=(mPlayer.getFood()<mPlayer.getDrink()?0:1);  //0: food<drink else 1
                    if(flag==0){
                        mEvent1outcomeText.setText(ReplaceCharInString.replace(event1outcomeString,"a food!"));
                        mPlayer.setFood(mPlayer.getFood()+1);
                    }else{
                        mEvent1outcomeText.setText(ReplaceCharInString.replace(event1outcomeString,"a drink!"));
                        mPlayer.setDrink(mPlayer.getDrink()+1);
                    }
                }
                else {
                    mEvent1Text.setText(ReplaceCharInString.replace(event1String, "rob you!"));
                    mEvent1outcomeText.setText(ReplaceCharInString.replace(event1outcomeString, "nothing and lost everything you have!"));
                    mPlayer.setFood(0);
                    mPlayer.setDrink(0);
                }

                Button mBack1Button = (Button) dialog.findViewById(R.id.bt_backcase1);
                mBack1Button.setEnabled(true);
                mBack1Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(activity,"Back from event",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                break;

            case 2:
                layoutResId = R.layout.dialog_event2;

                dialog.setContentView(layoutResId);
                //initialize width
                int width1 = WindowManager.LayoutParams.MATCH_PARENT;
                //initialize height
                int height1 = WindowManager.LayoutParams.WRAP_CONTENT;
                //set layout
                dialog.getWindow().setLayout(width1,height1);
                //show dialog
                dialog.show();

                TextView mEvent2Text;
                String event2String;
                int medicineChange;
                mEvent2Text = (TextView)dialog.findViewById(R.id.item_number_text);
                event2String = mEvent2Text.getText().toString();  // Retrieve the template string (Use to recover)
                medicineChange =mPlayer.getMedicine();
                mEvent2Text.setText(ReplaceCharInString.replace(event2String,Integer.toString(medicineChange)));

                Button mGiveButton = (Button) dialog.findViewById(R.id.bt_give);
                mGiveButton.setEnabled(false);
                if(mPlayer.getMedicine()!=0){
                    mGiveButton.setEnabled(true);
                }
                mGiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(activity,"You hand out the medicine",Toast.LENGTH_SHORT).show();
                        mPlayer.setMedicine(mPlayer.getMedicine()-1);
                        mPlayer.setHasMask(true);
                        dialog.dismiss();
                    }
                });
                Button mRefuseButton = (Button) dialog.findViewById(R.id.bt_refuse);
                mRefuseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // went back
                        dialog.dismiss();
                    }
                });

                break;

            case 3:
                if(!mPlayer.isHasMask()){
                    mPlayer.setInfected(true);
                }
                layoutResId = R.layout.dialog_event3;

                dialog.setContentView(layoutResId);
                //initialize width
                int width3 = WindowManager.LayoutParams.MATCH_PARENT;
                //initialize height
                int height3 = WindowManager.LayoutParams.WRAP_CONTENT;
                //set layout
                dialog.getWindow().setLayout(width3,height3);
                //show dialog
                dialog.show();

                TextView mEvent3Text;
                String event3String;
                int weaponChange;
                mEvent3Text = (TextView)dialog.findViewById(R.id.item_number_text3);
                event3String = mEvent3Text.getText().toString();  // Retrieve the template string (Use to recover)
                weaponChange =mPlayer.getWeapon();
                mEvent3Text.setText(ReplaceCharInString.replace(event3String,Integer.toString(weaponChange)));

                Button mUSEButton = (Button) dialog.findViewById(R.id.bt_use);
                mUSEButton.setEnabled(false);
                if(mPlayer.getWeapon()!=0){
                    mUSEButton.setEnabled(true);
                }
                mUSEButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(activity,"You used the weapon to against the robbers!",Toast.LENGTH_SHORT).show();
                        mPlayer.setWeapon(mPlayer.getWeapon()-1);

                        // winner prize level 0
                        mPlayer.setFood(mPlayer.getFood()+1);
                        mPlayer.setDrink(mPlayer.getDrink()+1);

                        // winner prize level 1
                        if(mPlayer.getPHealth()>=80||mPlayer.getMHealth()>=80){
                            mPlayer.setHasMask(true);
                        }
                        // winner prize level 2
                        if(mPlayer.getPHealth()>=90||mPlayer.getMHealth()>=90){
                            mPlayer.setMedicine(mPlayer.getMedicine()+1);
                        }
                        dialog.dismiss();
                    }
                });
                Button mCancelButton = (Button) dialog.findViewById(R.id.bt_cancel);
                mCancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(activity,"The robbers robbed you!!!",Toast.LENGTH_SHORT).show();
                        // Food--
                        if(mPlayer.getFood()>0){
                            mPlayer.setFood(mPlayer.getFood()-1);
                        }else{
                            mPlayer.setFood(0);
                        }
                        // Drink--
                        if(mPlayer.getDrink()>0){
                            mPlayer.setDrink(mPlayer.getDrink()-1);
                        }else{
                            mPlayer.setDrink(0);
                        }
                        // Toy--
                        if(mPlayer.getToy()>0){
                            mPlayer.setToy(mPlayer.getToy()-1);
                        }else{
                            mPlayer.setToy(0);
                        }
                        // Medicine--
                        if(mPlayer.getMedicine()>0){
                            mPlayer.setMedicine(mPlayer.getMedicine()-1);
                        }else{
                            mPlayer.setMedicine(0);
                        }

                        // went back
                        dialog.dismiss();
                    }
                });
                break;
            //case 4:
            //    break;
            //case 5:
            //    break;
            //case 6:
            //    break;


        }




    }
}
