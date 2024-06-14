package com.example.firstone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLogin;
    private Button mBtnRegist;
    private EditText mEtUserId;
    private EditText mEtUserPwd;
    private Button mBtnTest;
    private SharedPreferences mSharedPreferences;

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

        //获取mSharedPreferences
        mSharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        mEtUserId = findViewById(R.id.username);
        mEtUserPwd = findViewById(R.id.password);

        // 监听
        mBtnLogin.setOnClickListener(this);
        mBtnRegist.setOnClickListener(this);
        mBtnTest.setOnClickListener(this);
    }

    /**
        此方法用于初始化模拟数据
     */


    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            //获取用户名及密码
            String username = mEtUserId.getText().toString();
            String password = mEtUserPwd.getText().toString();

            //输出文本
            String ok = "登录成功";
            String error = "帐号或密码错误，请重新输入！";
            String empty = "帐号或密码不能为空！";
            Intent intent = null;
            if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                //(Toast底部普通版)
                Toast.makeText(getApplicationContext(), empty, Toast.LENGTH_LONG).show();
            } else {
                String name = mSharedPreferences.getString("username",null);
                String pwd = mSharedPreferences.getString("password",null);
                if (username.equals(name) && password.equals(pwd)) {
                    //正确的跳转页面
                    Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_LONG).show();
                    intent = new Intent(MainActivity.this, LoginSlideActivity.class);
                    startActivity(intent);
                } else {
                    //错误的跳转页面( 弹出登陆失败  Toast居中版)
                    Toast toastCenter = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                }
            }
        } else if (v.getId() == R.id.btn_register) {
            Intent intent = new Intent(MainActivity.this, RegisActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_test) {
            Intent intent = new Intent(MainActivity.this, init_page.class);
            startActivity(intent);
        }

    }

}