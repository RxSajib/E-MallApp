package com.ecommerce.mymall;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CatagoryAdapter catagoryAdapter;

    ////Catagory sliding banner
    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;
    private List<slider_model> slideriteamslist;
    ////Catagory sliding banner

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.CatagoryRecylearViewID);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<CatagoryHolder> catagoryHolderList = new ArrayList<>();
        catagoryHolderList.add(new CatagoryHolder("link", "T-Shart"));
        catagoryHolderList.add(new CatagoryHolder("ink", "Bag"));
        catagoryHolderList.add(new CatagoryHolder("ink", "Phone"));
        catagoryHolderList.add(new CatagoryHolder("ink", "Camera"));
        catagoryHolderList.add(new CatagoryHolder("ink", "Toyes"));

        catagoryAdapter  = new CatagoryAdapter(catagoryHolderList);
        recyclerView.setAdapter(catagoryAdapter);
        catagoryAdapter.notifyDataSetChanged();


        /// catagory sliding banner
        viewPager = view.findViewById(R.id.HomeViwePagerID);
        slideriteamslist = new ArrayList<>();

        slideriteamslist.add(new slider_model(R.drawable.offerone));
        slideriteamslist.add(new slider_model(R.drawable.offertwo));
        slideriteamslist.add(new slider_model(R.drawable.offerthree));
        slideriteamslist.add(new slider_model(R.drawable.offerfour));

        sliderAdapter = new SliderAdapter(slideriteamslist);

        viewPager.setAdapter(sliderAdapter);
        /// catagory sliding banner

        return view;
    }

}
