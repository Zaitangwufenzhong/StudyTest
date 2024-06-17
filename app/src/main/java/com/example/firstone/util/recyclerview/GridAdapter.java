package com.example.firstone.util.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;
import com.example.firstone.util.recyclerview.Bean.ItemBean;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;
    private List<ItemBean> mData;

    //适配器的构造函数
    public GridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    public GridAdapter(List<ItemBean> data) {
        this.mData = data;
    }
    @NonNull
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //view 就是每一个 item 长什么样子的 xml文件
        //inflater（条目布局文件，新视图绑定适配器后添加到ViewGroup 通常是parent 也就是RecyclerView，ViewType类型，这里没使用）
        View view = View.inflate(parent.getContext(),R.layout.layout_grid_drinks_item,null);
        return new LinearViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if(mData != null){
            return mData.size();
        }
        return 0;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            //布局控件在哪个布局里就要用该布局调用findViewById
            mTitle = itemView.findViewById(R.id.tv_title_drinks);
        }

        public void setData(ItemBean itemBean){
            mTitle.setText(itemBean.title);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
