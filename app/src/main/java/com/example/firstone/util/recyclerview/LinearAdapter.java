package com.example.firstone.util.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    //存储传递给适配器的上下文
    private Context mContext;
    //传入一个列表数据
    private List<String> list;

    private OnItemClickListener mListener;

    //适配器的构造函数
    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    /**
      * 作用是创建新的 ViewHolder 对象，用于展示 RecyclerView 中的条目
     **/
    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //view 就是每一个 item 长什么样子的 xml文件
        //inflater（条目布局文件，新视图绑定适配器后添加到ViewGroup 通常是parent 也就是RecyclerView，ViewType类型，这里没使用）
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_medicine_item,parent,false));
    }
    /**
     *  作用是绑定viewHolder
     **/
    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //可以设置一些内容
        holder.textView.setText("medicine");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //也可以通过回调 在外部实现
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"click...."+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *  作用是返回条目个数（列表长度）List<>  ----> list.length
     **/
    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            //布局控件在哪个布局里就要用该布局调用findViewById
            textView = itemView.findViewById(R.id.tv_title_medicine);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
