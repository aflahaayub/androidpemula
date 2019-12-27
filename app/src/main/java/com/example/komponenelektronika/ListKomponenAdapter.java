package com.example.komponenelektronika;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListKomponenAdapter extends RecyclerView.Adapter<ListKomponenAdapter.ListViewHolder> {
    private ArrayList<Komponen> list = new ArrayList<>();
    private Context mContext;
    private OnItemClickCallback onItemClickCallback;

    public ListKomponenAdapter(ArrayList<Komponen> list){
        this.list = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        Komponen komponen = list.get(position);
        Glide.with(holder.itemView.getContext())
                .load(komponen.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.textName.setText(komponen.getName());
        holder.textDetail.setText(komponen.getDetail());

        holder.mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(list.get(holder.getAdapterPosition()));

            }
        });


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView textName, textDetail;
        RelativeLayout mainActivity;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.image_alat);
            textName = itemView.findViewById(R.id.text_name);
            textDetail = itemView.findViewById(R.id.detail_item);
            mainActivity = itemView.findViewById(R.id.relative);
        }
    }
    public void setOnItemClickCallback (OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback{
        void onItemClicked(Komponen data);
    }

}
