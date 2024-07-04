package com.example.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstone.util.recyclerview.GridDrinksRecyclerViewActivity;
import com.example.firstone.util.recyclerview.HorLifeRecyclerViewActivity;
import com.example.firstone.util.recyclerview.LinearMedicineRecyclerViewActivity;
import com.example.firstone.util.SlideMenu;
import com.example.firstone.util.recyclerview.StaggerFoodRecyclerViewActivity;
import com.example.firstone.util.schedule.ScheduleMenuActivity;

public class LoginSlideActivity extends AppCompatActivity implements View.OnClickListener{

    //声明控件
    private ImageView user_head;
    private TextView mTvUsername;
    private SlideMenu slideMenu;
    private Button mBtnMdc;
    private Button mBtnLife;
    private Button mBtnDrinks;
    private Button mBtnFoods;
    private Button mBtnSchedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_slide);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        user_head = findViewById(R.id.layout2_head);

        // 获取 Intent 中的数据
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_KEY");
        // 使用用户名，例如设置到文本视图中
        TextView textView = findViewById(R.id.username);
        textView.setText(username);

        slideMenu = findViewById(R.id.slideMenu);
        mBtnMdc = findViewById(R.id.btn_layout_medicine);
        mBtnLife = findViewById(R.id.btn_layout_main_life);
        mBtnDrinks = findViewById(R.id.btn_layout_main_drinks);
        mBtnFoods = findViewById(R.id.btn_layout_main_foods);
        mBtnSchedule = findViewById(R.id.btn_layout_main_schedule);

        //实现侧滑(点击加侧滑)
        user_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });

        mBtnMdc.setOnClickListener(this);
        mBtnLife.setOnClickListener(this);
        mBtnDrinks.setOnClickListener(this);
        mBtnFoods.setOnClickListener(this);
        mBtnSchedule.setOnClickListener(this);
    }

    public void onClick(View v){
        //用switch报错：why --> 在 Android 开发中，资源 ID（如 R.id.btn_layout_medicine）在编译时是未知的。它们是在编译过程中由 aapt（Android Asset Packaging Tool）生成的。因此，它们不是编译时常量，而是在运行时分配的值。
        if (v.getId() == R.id.btn_layout_medicine) {
            Intent intent = new Intent(LoginSlideActivity.this, LinearMedicineRecyclerViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_layout_main_life) {
            Intent intent = new Intent(LoginSlideActivity.this, HorLifeRecyclerViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_layout_main_drinks) {
            Intent intent = new Intent(LoginSlideActivity.this, GridDrinksRecyclerViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_layout_main_foods) {
            Intent intent = new Intent(LoginSlideActivity.this, StaggerFoodRecyclerViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_layout_main_schedule) {
            Intent intent = new Intent(LoginSlideActivity.this, ScheduleMenuActivity.class);
            startActivity(intent);
        }
    }
}