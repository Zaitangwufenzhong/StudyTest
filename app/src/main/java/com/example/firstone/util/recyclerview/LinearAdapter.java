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

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            //view 就是每一个 item 长什么样子的 xml文件
            //inflater（条目布局文件，新视图绑定适配器后添加到ViewGroup 通常是parent 也就是RecyclerView，ViewType类型，这里没使用）
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_medicine_item,parent,false));
        }else{
            return new LinearViewHolderImage(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_medicine_item_image,parent,false));
        }
    }
    /**
     *  作用是绑定viewHolder
     **/
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(getItemViewType(position) == 0){
            //可以设置一些内容
            ((LinearViewHolder)holder).textView.setText("medicine");

        }else{
            ((LinearViewHolderImage)holder).textView.setText("药品名称");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //也可以通过回调 在外部实现
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"click...."+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 作用是获取viewType
     **/
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0){
            return 0;
        } else {
            return 1;
        }
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

    class LinearViewHolderImage extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolderImage(@NonNull View itemView) {
            super(itemView);
            //布局控件在哪个布局里就要用该布局调用findViewById
            textView = itemView.findViewById(R.id.tv_title_medicine);
            imageView = itemView.findViewById(R.id.tv_title_medicine_image);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
