package com.example.firstone.util.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.firstone.R;

//瀑布流效果
public class StaggerFoodRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvStagger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stagger_food_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mRvStagger = findViewById(R.id.rv_stagger);
        mRvStagger.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvStagger.addItemDecoration(new MyDecoration());
        mRvStagger.setAdapter(new StaggerAdapter(StaggerFoodRecyclerViewActivity.this, new StaggerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StaggerFoodRecyclerViewActivity.this, "click " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
        class MyDecoration extends RecyclerView.ItemDecoration {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight2), getResources().getDimensionPixelOffset(R.dimen.dividerHeight2));
            }
        }
}
