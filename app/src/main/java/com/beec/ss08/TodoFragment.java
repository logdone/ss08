package com.beec.ss08;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beec.ss08.DetailFragment.DetailActivity;
import com.beec.ss08.DetailFragment.TodoDetailActivity;
import com.beec.ss08.entity.ChkItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        TodoContentAdapter adapter = new TodoContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getActivity().setTitle("Check List");
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture,done;
        public TextView name,detailText;
        public Boolean isChecked;
      //  public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card_chk, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            done = (ImageView) itemView.findViewById(R.id.checkbox);
            name = (TextView) itemView.findViewById(R.id.card_title);
            detailText = (TextView) itemView.findViewById(R.id.detailText);
            isChecked = false;
           // description = (TextView) itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, TodoDetailActivity.class);
                    intent.putExtra(TodoDetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);

                }
            });


        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class TodoContentAdapter extends RecyclerView.Adapter<TodoFragment.ViewHolder> {

        private static final int LENGTH = 6;
        // Set numbers of Card in RecyclerView.
        private final String[] mPlaces;
        private final String[] mPlaceDesc;
        private final Drawable[] mPlacePictures;
        public Context context;

        public TodoContentAdapter(Context context) {
            this.context = context;
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.check);
            mPlaceDesc = resources.getStringArray(R.array.check_desc);
            TypedArray a = resources.obtainTypedArray(R.array.check_picture);
            mPlacePictures = new Drawable[a.length()];

            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public TodoFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TodoFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(TodoFragment.ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]);
            holder.done.setOnClickListener((v)->{
                if (holder.isChecked){
                    holder.done.setImageResource(R.drawable.blank_square);
                }else {
                ShowAlertDialog("Your item is checked now !");
                 holder.done.setImageResource(R.drawable.checked_box);
                }
                holder.isChecked = !holder.isChecked;
            });
        }
//    ShowAlertDialog("Your item is checked now !");
        @Override
        public int getItemCount() {
            return LENGTH;
        }

        public void ShowAlertDialog(String message){

            android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(context).create();
            alertDialog.setTitle("Success");
            alertDialog.setMessage(message);
            alertDialog.setIcon(R.drawable.done);
            alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
}
