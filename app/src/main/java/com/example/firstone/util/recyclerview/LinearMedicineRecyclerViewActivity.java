package com.example.firstone.util.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;
import com.example.firstone.util.recyclerview.Bean.MedicineData;
import com.example.firstone.util.recyclerview.Bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class LinearMedicineRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvmain;
    private RecyclerView mList;

    List<ItemBean> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear_medicine_recycler_view);

        mList = findViewById(R.id.rv_main);
        //准备数据
        initData();
        mRvmain = findViewById(R.id.rv_main);
    }

    private void initData(){
        //创建数据集合
        mData = new ArrayList<>();

        for(int i = 0; i < MedicineData.icons.length; i++){
            ItemBean data = new ItemBean();
            data.icon = MedicineData.icons[i];
            data.title= MedicineData.title[i];
            //添加到集合
            mData.add(data);
        }

        //需要设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mList.setLayoutManager(layoutManager);

        // 创建 MyDecoration 的实例并传递当前活动的上下文
        MyDecoration itemDecoration = new MyDecoration(LinearMedicineRecyclerViewActivity.this);

        // 将 MyDecoration 添加到 RecyclerView
        mList.addItemDecoration(itemDecoration);

        //创建适配器
        LinearAdapter adapter = new LinearAdapter(mData);
        //设置到RecyclerView中
        mList.setAdapter(adapter);
    }

    //添加分隔线
    public class MyDecoration extends RecyclerView.ItemDecoration {
        private Context mContext;

        public MyDecoration(Context context) {
            this.mContext = context;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, mContext.getResources().getDimensionPixelOffset(R.dimen.dividerHeight), mContext.getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}