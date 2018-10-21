package com.beec.ss08;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.beec.ss08.DetailFragment.CardContentFragment;
import com.beec.ss08.DetailFragment.DetailActivity;
import com.beec.ss08.DetailFragment.InstructionDetailActivity;

import java.util.ArrayList;
import java.util.List;


public class InstructionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        getActivity().setTitle("Instructions List");
        InstructionContentAdapter adapter = new InstructionContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card_instruction, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, InstructionDetailActivity.class);
                    intent.putExtra(InstructionDetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });


        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class InstructionContentAdapter extends RecyclerView.Adapter<InstructionFragment.ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 7;

        private final String[] mPlaces;
        private final String[] mPlaceDesc;


        public InstructionContentAdapter(Context context) {
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.instructions);
            mPlaceDesc = resources.getStringArray(R.array.instruction_desc);
            TypedArray a = resources.obtainTypedArray(R.array.instructions_picture);

            a.recycle();
        }

        @Override
        public InstructionFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new InstructionFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(InstructionFragment.ViewHolder holder, int position) {
            holder.name.setText(mPlaces[position % mPlaces.length]);
            holder.description.setText(mPlaceDesc[position % mPlaceDesc.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
