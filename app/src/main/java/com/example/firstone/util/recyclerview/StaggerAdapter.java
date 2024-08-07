package com.example.firstone.util.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;

import java.util.List;

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.LinearViewHolder> {

    private Context mContext;
    private List<String> list;
    private OnItemClickListener mListener;

    //适配器的构造函数
    public StaggerAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }
    @NonNull
    @Override
    public StaggerAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //view 就是每一个 item 长什么样子的 xml文件
        //inflater（条目布局文件，新视图绑定适配器后添加到ViewGroup 通常是parent 也就是RecyclerView，ViewType类型，这里没使用）
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_stagger_foods_item,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull StaggerAdapter.LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //可以设置一些内容
        if(position % 2 != 0 ) {
            holder.imageView.setImageResource(R.mipmap.image1);
        } else {
            holder.imageView.setImageResource(R.mipmap.image2);
        }
        holder.itemView.setOnClickListener((v) -> {mListener.onClick(position);});
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            //布局控件在哪个布局里就要用该布局调用findViewById
            imageView = itemView.findViewById(R.id.tv_title_foods);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
