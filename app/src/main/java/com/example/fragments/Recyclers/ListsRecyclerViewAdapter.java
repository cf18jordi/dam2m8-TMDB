package com.example.fragments.Recyclers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.fragments.Model.List.ListModel;
import com.example.fragments.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class ListsRecyclerViewAdapter extends RecyclerView.Adapter<ListsRecyclerViewAdapter.ViewHolder> {
    private ArrayList<ListModel> arrayList;
    private Context c;

    public ListsRecyclerViewAdapter(ArrayList<ListModel> arrL, Context context){
        this.arrayList = arrL;
        this.c = context;
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.listTitle.setText(arrayList.get(i).getName());
        holder.iCount.setText(String.valueOf(arrayList.get(i).getItem_count()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView listTitle, iCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listTitle = itemView.findViewById(R.id.listTitle);
            iCount = itemView.findViewById(R.id.itemCount);
        }

    }
}
