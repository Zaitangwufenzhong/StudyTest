package com.example.firstone;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.ref.WeakReference;

public class VerifiedCodeActivity extends AppCompatActivity {

    private Button mBtnOK;
    private Button mBtnSendCode;
    private EditText mEdCode;
    private static Handler mHandler;
    private static final int MSG_START = 0;
    private static final int MSG_OK = 1;
    private int timeCount = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verified_code);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mBtnOK = findViewById(R.id.btn_ok);
        mBtnSendCode = findViewById(R.id.btn_send_code);
        mEdCode = findViewById(R.id.code_input);

        HandlerThread ht = new HandlerThread("mainHandler");
        ht.start();
        mHandler = new MyHandler(new WeakReference<>(getWindow().getDecorView()));

        mBtnSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(MSG_START);
            }
        });

        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = mEdCode.getText().toString().trim();
                if (!TextUtils.isEmpty(code)) {
                    //时间之内，输入验证码，点击确认，停掉倒计时
                    mHandler.removeMessages(MSG_START);
                }
            }
        });

        findViewById(R.id.code_toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class MyHandler extends Handler {
        //传递一个 WeakReference 包装的视图
        //用于在 Handler 中访问视图，同时避免内存泄漏
        public MyHandler(WeakReference<View> v) {
            View view = v.get();
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_START:
                    mBtnSendCode.setText("剩余时间：" + timeCount--);
                    mHandler.sendEmptyMessageDelayed(MSG_START,1000);
                    if (timeCount == 0) {
                        mBtnSendCode.setText("请重新发送验证码");
                    }
                    break;
                case MSG_OK:
                    break;
            }
        }
    }


}

