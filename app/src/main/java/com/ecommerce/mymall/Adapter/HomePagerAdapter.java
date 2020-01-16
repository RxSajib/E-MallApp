package com.ecommerce.mymall.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.mymall.ModalClass.HomePageModal;
import com.ecommerce.mymall.ModalClass.slider_model;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends RecyclerView.Adapter {

    private List<HomePageModal> homePageModalList = new ArrayList<>();

    public HomePagerAdapter(List<HomePageModal> homePageModalList) {
        this.homePageModalList = homePageModalList;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }


}
