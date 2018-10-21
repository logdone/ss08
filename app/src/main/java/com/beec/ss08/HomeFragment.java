package com.beec.ss08;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("");
        ShowAlertDialog("Be careful a new disaster is coming ! \n follow the instructions and the check list to get more information . ");

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_home, container, false);
        HomeContentAdapter adapter = new HomeContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return recyclerView;

    }











    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture,done;
        public TextView name,detailText;
        public Boolean isChecked;
        //  public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card_home, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);

            // description = (TextView) itemView.findViewById(R.id.card_text);



        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class HomeContentAdapter extends RecyclerView.Adapter<HomeFragment.ViewHolder> {

        private static final int LENGTH = 4;
        // Set numbers of Card in RecyclerView.

        private final Drawable[] mPlacePictures;
        public Context context;

        public HomeContentAdapter(Context context) {
            this.context = context;
            Resources resources = context.getResources();
            TypedArray a = resources.obtainTypedArray(R.array.home_alert_picture);
            mPlacePictures = new Drawable[a.length()];

            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public HomeFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HomeFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(HomeFragment.ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);

        }
        //    ShowAlertDialog("Your item is checked now !");
        @Override
        public int getItemCount() {
            return LENGTH;
        }


    }

    public void ShowAlertDialog(String message){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("ALERT !");
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.drawable.warning);
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> {

                    dialog.dismiss();
                });
        alertDialog.show();
    }


}
