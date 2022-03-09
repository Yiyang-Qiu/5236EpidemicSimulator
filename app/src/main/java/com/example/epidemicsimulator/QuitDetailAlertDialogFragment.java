package com.example.epidemicsimulator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QuitDetailAlertDialogFragment extends DialogFragment {


    public QuitDetailAlertDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dg = new AlertDialog.Builder(getActivity());
        dg.setTitle("Do you really want to quit the Epidemic Simulator?").setPositiveButton(android.R.string.ok,null);
        dg.setNegativeButton(android.R.string.no,null);
        return dg.create();

    }

}