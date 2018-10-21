package com.beec.ss08;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EditProfFragment extends Fragment {

    public EditProfFragment() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Edit Profile");
        //return inflater.inflate(R.layout.fragment_edit_prof, container, false);
        View view = inflater.inflate(R.layout.fragment_edit_prof, container, false);
        Button addOpenHomeBtn = view.findViewById(R.id.add_open_home_btn);
        addOpenHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAlertDialog("Your Profile updated !");
            }
        });
        EditText input_name = view.findViewById(R.id.input_name);
        EditText input_phone = view.findViewById(R.id.input_phone);
        EditText input_email = view.findViewById(R.id.input_email);
        EditText input_password = view.findViewById(R.id.input_password);
        EditText input_em3 = view.findViewById(R.id.input_em3);
        EditText input_em1 = view.findViewById(R.id.input_em1);


        input_name.setText("Dhia Ghali");
        input_phone.setText("+21622474355");
        input_email.setText("ghalidhia@gmail.com");
        input_password.setText("azerty");
        input_em3.setText("+21622485495");
        input_em1.setText("+21629958495");

        return view;


    }

    public void ShowAlertDialog(String message){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Success");
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.drawable.done);
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> {

                    dialog.dismiss();
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction ft =   ((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.replace(R.id.flContent, homeFragment).addToBackStack(HomeFragment.TAG).commit();
                });
        alertDialog.show();
    }



}
