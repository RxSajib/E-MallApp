package com.ecommerce.mymall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Login_Page extends FragmentPagerAdapter {
    public Login_Page(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                LoginFragement loginFragement = new LoginFragement();
                return loginFragement;

            case 1:
                RegisterFragement registerFragement = new RegisterFragement();
                return registerFragement;

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Login";

            case 1:
                return "Register";
        }
        return super.getPageTitle(position);
    }
}
