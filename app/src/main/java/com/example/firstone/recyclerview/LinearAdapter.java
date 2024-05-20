package com.example.firstone.recyclerview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    //绑定viewHolder
    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, int position) {

    }

    //列表长度(数据集合的大小)
    @Override
    public int getItemCount() {
        return 0;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
