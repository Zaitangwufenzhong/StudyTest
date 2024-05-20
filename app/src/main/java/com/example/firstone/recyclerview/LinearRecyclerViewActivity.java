package com.example.firstone.recyclerview;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear_recycler_view);

        mRvmain = findViewById(R.id.rv_main);
        mRvmain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
    }
}