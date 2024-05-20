package com.example.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ScenesExploreTest extends AppCompatActivity implements View.OnClickListener{

    private ImageView mExitScenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.test_activity_scenes_explore);

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