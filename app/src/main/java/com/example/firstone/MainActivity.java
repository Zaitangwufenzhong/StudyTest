package com.example.firstone;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstone.util.ItemBean;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLogin;
    private Button mBtnRegist;
    private EditText mEtUserId;
    private EditText mEtUserPwd;
    private Button mBtnTest;

    List<ItemBean> mData;

    //RecyclerView相关
    private RecyclerView list;
    //private ShapeableImageView mShapeableImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置状态栏颜色，实现沉浸式状态栏效果
        // getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_main);

        // 获取Button控件 并设置其点击事件(不能是“.”，应该是 =)
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegist = findViewById(R.id.btn_register);
        mEtUserId = findViewById(R.id.username);
        mEtUserPwd = findViewById(R.id.password);
        mBtnTest = findViewById(R.id.btn_test);

        // 获取recycler_view 控件
        list = this.findViewById(R.id.recycler_view);
        /**
            准备数据(一般开发中，从网络获取，或后台没准备好也需要模拟，现在：模拟数据)
         */
        initData();

        // 监听
        mBtnLogin.setOnClickListener(this);
        mBtnRegist.setOnClickListener(this);
        mBtnTest.setOnClickListener(this);
    }

    /**
        此方法用于初始化模拟数据
     */
    private void initData() {
        //<ListDataBea>(数据集合 Bea类) ----> Adapter(对应适配器) ---> setAdapter ---> 显示数据、
        //创建模拟数据集合
        mData = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            //创建对象
            ItemBean data = new ItemBean();
            data.icon = ;
            data.title = ;

            //添加到集合中
            mData.add(data);
        }

    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            //获取用户名及密码
            String username = mEtUserId.getText().toString();
            String password = mEtUserPwd.getText().toString();

            //输出文本
            String ok = "登录成功";
            String error = "帐号或密码错误，请重新输入！";
            Intent intent = null;
            if (username.equals("szy") && password.equals("20180917")) {
                //(Toast底部普通版)
                Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_LONG).show();
                //正确的跳转页面
                intent = new Intent(MainActivity.this, SlideActivity.class);
                startActivity(intent);
            } else {
                //错误的跳转页面( 弹出登陆失败  Toast居中版)
                Toast toastCenter = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
                toastCenter.setGravity(Gravity.CENTER, 0, 0);
                toastCenter.show();
            }
        } else if (v.getId() == R.id.btn_register) {
            Intent intent = new Intent(MainActivity.this, FuncRegisActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_test) {
            Intent intent = new Intent(MainActivity.this, init_page.class);
            startActivity(intent);
        }

    }

    //
    //
    //这里是菜单代码
    //
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.list_view_vertical_stander) {
            Log.d(TAG, "点击");
        } else if (itemId == R.id.list_view_vertical_reverse) {

        } else if (itemId == R.id.list_view_horizontal_stander) {

        } else if (itemId == R.id.list_view_horizontal_reverse) {

        } else if (itemId == R.id.grid_view_horizontal_stander) {

        } else if (itemId == R.id.grid_view_horizontal_reverse) {

        } else if (itemId == R.id.grid_view_vertical_stander) {

        } else if (itemId == R.id.grid_view_vertical_reverse) {

        } else if (itemId == R.id.stagger_view_horizontal_stander) {

        } else if (itemId == R.id.stagger_view_horizontal_reverse) {

        } else if (itemId == R.id.stagger_view_vertical_stander) {

        } else if (itemId == R.id.stagger_view_vertical_reverse) {

        }
        return super.onOptionsItemSelected(item);
    }
}