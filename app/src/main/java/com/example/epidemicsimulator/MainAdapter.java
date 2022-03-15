package com.example.epidemicsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowAnimationFrameStats;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //initialize variables
    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;

    //create constructor
    public MainAdapter(Activity context, List<MainData> dataList){
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //initialize main data
        MainData data = dataList.get(position);
        //initialize database
        database = RoomDB.getInstance(context);
        //set text on text view
        holder.textView.setText(data.getText());

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize main data
                MainData d = dataList.get(holder.getAbsoluteAdapterPosition());
                //get id
                int sID = d.getID();
                //get text
                String sText = d.getText();

                //create dialog
                Dialog dialog =  new Dialog(context);
                //set content view
                dialog.setContentView(R.layout.dialog_update);
                //initialize width
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                //initialize height
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                //set layout
                dialog.getWindow().setLayout(width,height);
                //show dialog
                dialog.show();
                //Initialize and assign variables
                EditText editText = dialog.findViewById(R.id.edit_text_in_dialog);
                Button btUpdate = dialog.findViewById(R.id.bt_update);

                //set text on edit text
                editText.setText(sText);

                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //dismiss dialog
                        dialog.dismiss();
                        //get updates text from edit text
                        String uText = editText.getText().toString().trim();
                        //update text in database
                        database.mainDao().update(sID,uText);
                        //notify when data is updated
                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
                        notifyDataSetChanged();
                    }
                });

            }
        });

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize main data
                MainData d = dataList.get(holder.getAbsoluteAdapterPosition());
                //delete data from database
                database.mainDao().delete(d);
                //notify when data is deleted
                int position = holder.getAbsoluteAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialize variables
        TextView textView;
        ImageView btEdit, btDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variables
            textView = itemView.findViewById(R.id.text_view_in_list);
            btEdit = itemView.findViewById(R.id.bt_edit);
            btDelete = itemView.findViewById(R.id.bt_delete);

        }
    }
}
