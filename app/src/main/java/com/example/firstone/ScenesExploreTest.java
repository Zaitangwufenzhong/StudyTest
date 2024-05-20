package com.example.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstone.R;

public class ScenesExploreTest extends AppCompatActivity implements View.OnClickListener{

    private ImageView mExitScenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scenes_explore_test);

        mExitScenes = findViewById(R.id.exit_scenes);

        mExitScenes.setOnClickListener(this);

    }
    public void onClick(View v){
        Intent intent = null;
        if(v.getId() == R.id.exit_scenes){
            intent = new Intent(ScenesExploreTest.this,init_page.class);
            startActivity(intent);
        }
    }
}