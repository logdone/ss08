package com.beec.ss08;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beec.ss08.entity.ChkItem;

import java.util.ArrayList;
import java.util.List;


public class ItemFragment extends Fragment {

    List<ChkItem> chkItemsList;

    ChkAdabter mAdapter;
    public ItemFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chkList);

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);

            // use a linear layout manager
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            chkItemsList  = new ArrayList<>();
            ChkItem chk1 = new ChkItem("Water","@mipmap/ic_launcher_round","Water must be stored in plastic containers to " +
                    "avoid those that break or decompose",2);
            ChkItem chk2 = new ChkItem("Food","@mipmap/ic_launcher_round","Food supplies should be non-perishable" +
                    "and shouldn't require refrigeration cooking or water " +
                    "food items should be compact and light weight ",2);
            ChkItem chk3 = new ChkItem("First aid Kit","@mipmap/ic_launcher_round","adhesive  bandages , sterile dressings ," +
                    "bandages , hand wipes / antispetic  wipes " +
                    "sanitizer , cold pack , adhesive taps , aspirin / otc pain killers ," +
                    "laxative / anti diarrhea ",2);
            ChkItem chk4 = new ChkItem("Tools","@mipmap/ic_launcher_round","knife , scissors , tape , sterno ,  ",2);
            ChkItem chk5 = new ChkItem("Sanitation","@mipmap/ic_launcher_round","Test ",2);
            ChkItem chk6 = new ChkItem("Special items","@mipmap/ic_launcher_round","Test ",2);
            ChkItem chk7 = new ChkItem("Entertainment","@mipmap/ic_launcher_round","Test ",2);
            ChkItem chk8 = new ChkItem("Pet needs","@mipmap/ic_launcher_round","Test ",2);
            ChkItem chk9 = new ChkItem("Documents and records","@mipmap/ic_launcher_round","Test ",2);

            chkItemsList.add(chk1);
            chkItemsList.add(chk2);
            chkItemsList.add(chk3);
            chkItemsList.add(chk4);
            chkItemsList.add(chk5);
            chkItemsList.add(chk6);
            chkItemsList.add(chk7);
            chkItemsList.add(chk8);



            mAdapter = new ChkAdabter(chkItemsList,getContext());
            recyclerView.setAdapter(mAdapter);

        }
        return view;

    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

}
class ChkAdabter extends RecyclerView.Adapter<ChkAdabter.ViewHolder> {
    private List<ChkItem> typesList;
    private Context context;

    public ChkAdabter(List<ChkItem> list, Context context) {

        this.typesList=list;
        this.context=context;
    }

    @Override
    public ChkAdabter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list_row,parent,false);
        return new ChkAdabter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChkAdabter.ViewHolder holder, int position) {
        ChkItem item = typesList.get(position);
        holder.title.setText(item.getTitle());
        holder.image.setImageResource(R.drawable.ic_launcher_background);
        holder.quantity.setText("quantity ="+item.getQty()+"");


    }

    @Override
    public int getItemCount() {
        return typesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title,quantity;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            image=(ImageView)itemView.findViewById(R.id.imageView);
            quantity = (TextView)itemView.findViewById(R.id.txtPriority);

        }
    }
}
