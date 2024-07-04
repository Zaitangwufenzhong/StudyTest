package com.example.firstone.util.schedule.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.firstone.R;
import com.example.firstone.util.webview.WebViewActivity;
import com.example.firstone.util.webview.WebViewActivity2;

public class WorkFragment extends Fragment {

    private Button mTestBtn;
    private Button mTestBtn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        mTestBtn = view.findViewById(R.id.test_btn);
        mTestBtn2 = view.findViewById(R.id.test_btn2);
        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                startActivity(intent);
            }
        });

        mTestBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebViewActivity2.class);
                startActivity(intent);
            }
        });

        return view;
    }

}