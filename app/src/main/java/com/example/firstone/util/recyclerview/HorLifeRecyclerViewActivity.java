package com.example.firstone.util.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;
import com.example.firstone.util.recyclerview.Bean.LifeData;
import com.example.firstone.util.recyclerview.Bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class HorLifeRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvHor;

    private RecyclerView mList;
    List<ItemBean> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hor_life_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mList = findViewById(R.id.rv_hor);
        //准备数据
        initData();
        mRvHor = findViewById(R.id.rv_hor);

    }

    private void initData(){
        mData = new ArrayList<>();

        for(int i = 0; i < LifeData.icons.length; i++) {
            ItemBean data = new ItemBean();
            data.icon = LifeData.icons[i];
            data.title= LifeData.title[i];
            //添加到集合
            mData.add(data);
        }

        //设置成水平
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorLifeRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList.setLayoutManager(linearLayoutManager);
        //mRvHor.addItemDecoration(new MyDecoration());

        //创建适配器
        HorAdapter adapter = new HorAdapter(mData);
        //添加到RecyclerView中
        mList.setAdapter(adapter);
    }

    //添加分隔线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}