package com.example.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class init_page extends AppCompatActivity implements View.OnClickListener{
    private ImageView mScenesEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_init_page);

        mScenesEnter = findViewById(R.id.pct_4);

        mScenesEnter.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = null;
        if(v.getId() == R.id.pct_4){
            intent = new Intent(init_page.this,ScenesExploreTest.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "请点击正确位置", Toast.LENGTH_SHORT).show();
        }
    }
}