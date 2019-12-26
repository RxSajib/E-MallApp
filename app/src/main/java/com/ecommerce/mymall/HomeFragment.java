package com.ecommerce.mymall;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


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
    private int CurrentPage = 2;
    private Timer timer;
    private final long DElAY_TIME = 3000;
    private final long POST_TIME = 3000;
    ////Catagory sliding banner

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


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

        catagoryAdapter = new CatagoryAdapter(catagoryHolderList);
        recyclerView.setAdapter(catagoryAdapter);
        catagoryAdapter.notifyDataSetChanged();


        /// catagory sliding banner
        viewPager = view.findViewById(R.id.HomeViwePagerID);
        viewPager.setCurrentItem(CurrentPage);
        slideriteamslist = new ArrayList<>();

        slideriteamslist.add(new slider_model(R.drawable.offerthree));
        slideriteamslist.add(new slider_model(R.drawable.offerfour));


        slideriteamslist.add(new slider_model(R.drawable.offerone)); ///this
        slideriteamslist.add(new slider_model(R.drawable.offertwo));
        slideriteamslist.add(new slider_model(R.drawable.offerthree));
        slideriteamslist.add(new slider_model(R.drawable.offerfour));


        slideriteamslist.add(new slider_model(R.drawable.offerone));  /// current page size 2
        slideriteamslist.add(new slider_model(R.drawable.offertwo));

        sliderAdapter = new SliderAdapter(slideriteamslist);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(20);
        viewPager.setAdapter(sliderAdapter);
        /// catagory sliding banner

        ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CurrentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE){
                    pagelooper();
                }
            }
        };
        viewPager.addOnPageChangeListener(pageChangeListener);

        startbannerslideshow();

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

              ///  startbannerslideshow();
               // stopbannerslideshow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startbannerslideshow();
                }

                return true;
            }
        });

        return view;
    }


    //// slider page looping
    private void pagelooper() {
        if (CurrentPage == slideriteamslist.size() - 2) {
            CurrentPage = 2;
            viewPager.setCurrentItem(CurrentPage, false);
        }
        if (CurrentPage == 1) {
            CurrentPage = slideriteamslist.size() - 3;
            viewPager.setCurrentItem(CurrentPage, false);
        }
    }

    private void startbannerslideshow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(CurrentPage >= slideriteamslist.size()){
                    CurrentPage = 1;
                }
                else {
                    viewPager.setCurrentItem(CurrentPage++, true);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, DElAY_TIME, POST_TIME);
    }

    private void stopbannerslideshow(){
        timer.cancel();
    }
    //// slider page looping
}
