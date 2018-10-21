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
import android.widget.Toast;


public class OpenHomeFragment extends Fragment {


    public OpenHomeFragment() {
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
        getActivity().setTitle("Open Home");
        View view = inflater.inflate(R.layout.fragment_open_home, container, false);
        Button addOpenHomeBtn = view.findViewById(R.id.add_open_home_btn);
        addOpenHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowAlertDialog("Your Open home request posted with success we appreciate your willing to help");
            }
        });
        return view;
    }


    public void ShowAlertDialog(String message){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Success");
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.drawable.done);
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                        HomeFragment homeFragment = new HomeFragment();
                        FragmentTransaction ft =   ((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.replace(R.id.flContent, homeFragment).addToBackStack(HomeFragment.TAG).commit();
                    }
                });
        alertDialog.show();
    }

}
