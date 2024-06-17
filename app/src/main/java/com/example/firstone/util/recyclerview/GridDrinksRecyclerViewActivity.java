package com.example.firstone.util.recyclerview;

import android.content.ClipData;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;
import com.example.firstone.util.recyclerview.Bean.DrinksData;
import com.example.firstone.util.recyclerview.Bean.LifeData;
import com.example.firstone.util.recyclerview.Bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class GridDrinksRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;
    private RecyclerView mList;
    List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_drinks_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mList = findViewById(R.id.rv_grid);
        initData();
        mRvGrid = findViewById(R.id.rv_grid);
    }

    private void initData(){
        mData = new ArrayList<>();

        for(int i = 0; i < DrinksData.title.length; i++) {
            ItemBean data = new ItemBean();
            data.title= DrinksData.title[i];
            //添加到集合
            mData.add(data);
        }
        //(,有几列)
        mList.setLayoutManager(new GridLayoutManager(GridDrinksRecyclerViewActivity.this,4));
        //mList.addItemDecoration(new MyDecoration());

        GridAdapter adapter = new GridAdapter(mData);
        mList.setAdapter(adapter);

    }

    //添加分隔线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }

}