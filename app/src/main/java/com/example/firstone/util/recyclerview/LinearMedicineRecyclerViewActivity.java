package com.example.firstone.util.recyclerview;

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
        //mRvmain.addItemDecoration(new MyDecoration());

        //创建适配器
        LinearAdapter adapter = new LinearAdapter(mData);
        //设置到RecyclerView中
        mList.setAdapter(adapter);
    }

    //添加分隔线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}