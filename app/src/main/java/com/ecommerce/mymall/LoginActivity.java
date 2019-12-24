package com.ecommerce.mymall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tableLayout;
    private Login_Page login_page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewPager = findViewById(R.id.ViewPagerID);
        tableLayout = findViewById(R.id.LoginTabLayoutID);
        login_page = new Login_Page(getSupportFragmentManager());
        viewPager.setAdapter(login_page);
        tableLayout.setupWithViewPager(viewPager);



        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
