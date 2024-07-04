package com.example.firstone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class RegisActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private EditText et_re_password;
    //private Toolbar mToolbar;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_func_regis);

        //mToolbar = findViewById(R.id.regis_toolbar);

        //获取mSharedPreferences
        //保存一些简单的数据
        mSharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        et_username = findViewById(R.id.regis_username);
        et_password = findViewById(R.id.regis_password);
        et_re_password = findViewById(R.id.regis_re_password);
        //返回
        findViewById(R.id.regis_toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //点击注册
        findViewById(R.id.btn_regis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String re_password = et_re_password.getText().toString();

                if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(re_password)) {
                    Toast.makeText(RegisActivity.this,"内容不能为空",Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor edit = mSharedPreferences.edit();
                    edit.putString("username",username);
                    edit.putString("password",password);
                    edit.putString("re_password",re_password);

                    //!
                    edit.commit();
                    if (password.equals(re_password)) {
                        Toast.makeText(RegisActivity.this,"注册成功，请登录",Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}