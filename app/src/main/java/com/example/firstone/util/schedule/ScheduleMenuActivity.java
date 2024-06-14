package com.example.firstone.util.schedule;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.firstone.R;
import com.example.firstone.util.schedule.fragment.EatFragment;
import com.example.firstone.util.schedule.fragment.SleepFragment;
import com.example.firstone.util.schedule.fragment.SportFragment;
import com.example.firstone.util.schedule.fragment.StudyFragment;
import com.example.firstone.util.schedule.fragment.WorkFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScheduleMenuActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private StudyFragment mStudyFragment;
    private WorkFragment mWorkFragment;
    private SportFragment mSportFragment;
    private SleepFragment mSleepFragment;
    private EatFragment  mEatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_schedule_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //初始化控件
        mBottomNavigationView = findViewById(R.id.btn_menu_schedule);

        //默认首页选中
        selectedFragment(0);

    }

    private void selectedFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);

        if (position == 0) {
            if (mStudyFragment == null) {
                mStudyFragment = new StudyFragment();
                fragmentTransaction.add(R.id.content, mStudyFragment);
            } else {
                fragmentTransaction.show(mStudyFragment);
            }
        } else if (position == 1) {
            if (mWorkFragment == null) {
                mWorkFragment = new WorkFragment();
                fragmentTransaction.add(R.id.content,mWorkFragment);
            } else {
                fragmentTransaction.show(mWorkFragment);
            }
        } else if (position == 2) {
            if (mSportFragment == null) {
                mSportFragment = new SportFragment();
                fragmentTransaction.add(R.id.content, mSportFragment);
            } else {
                fragmentTransaction.show(mSportFragment);
            }
        } else if (position == 3) {
            if (mSleepFragment == null) {
                mSleepFragment = new SleepFragment();
                fragmentTransaction.add(R.id.content, mSleepFragment);
            } else {
                fragmentTransaction.show(mSleepFragment);
            }
        } else if (position == 4) {
            if (mEatFragment == null) {
                mEatFragment = new EatFragment();
                fragmentTransaction.add(R.id.content, mEatFragment);
            } else {
                fragmentTransaction.show(mEatFragment);
            }
        }

        //一定要提交！！！
        fragmentTransaction.commit();

        //点击切换事件
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.study) {
                    selectedFragment(0);
                } else if (menuItem.getItemId() == R.id.work) {
                    selectedFragment(1);
                } else if (menuItem.getItemId() == R.id.sport) {
                    selectedFragment(2);
                } else if (menuItem.getItemId() == R.id.sleep) {
                    selectedFragment(3);
                } else if (menuItem.getItemId() == R.id.eat) {
                    selectedFragment(4);
                }
                return true;
            }
        });

    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if(mStudyFragment != null) {
            fragmentTransaction.hide(mStudyFragment);
        }
        if(mWorkFragment != null) {
            fragmentTransaction.hide(mWorkFragment);
        }
        if(mSportFragment != null) {
            fragmentTransaction.hide(mSportFragment);
        }
        if(mSleepFragment != null) {
            fragmentTransaction.hide(mSleepFragment);
        }
        if(mEatFragment != null) {
            fragmentTransaction.hide(mEatFragment);
        }

    }

}
