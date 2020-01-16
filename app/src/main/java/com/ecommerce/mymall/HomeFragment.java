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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecommerce.mymall.Adapter.CatagoryAdapter;
import com.ecommerce.mymall.Adapter.Gride_Adapter;
import com.ecommerce.mymall.Adapter.Horizantal_Adapter;
import com.ecommerce.mymall.Adapter.SliderAdapter;
import com.ecommerce.mymall.ModalClass.CatagoryHolder;
import com.ecommerce.mymall.ModalClass.Horizantal_Model;
import com.ecommerce.mymall.ModalClass.slider_model;

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

    ///stride_ad
    private ImageView bannerad;
    ///stride_ad

    ////horizantal product
    private TextView horizantal_productdeails;
    private TextView horizantal_viewAll;
    private RecyclerView horizantal_product;
    private Horizantal_Adapter horizantal_adapter;
    private List<Horizantal_Model> horizantal_modelList;
    ///horizantal product

    ///grideLayout
    private TextView gridettitle;
    private TextView grideshowall;
    private GridView productlist;
    private Gride_Adapter gride_adapter;
    ///grideLayout

    /// teast recylearview
    private RecyclerView testview;
    /// teast recylearview


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

        ///strideAD
        bannerad = view.findViewById(R.id.StrifAdID);
        ///strideAd


        //// horizantal product

        LinearLayoutManager horizantallayoutmanager = new LinearLayoutManager(getContext());
        horizantallayoutmanager.setOrientation(RecyclerView.HORIZONTAL);

        horizantal_productdeails = view.findViewById(R.id.HorzantalDealsTextID);
        horizantal_viewAll = view.findViewById(R.id.HorizantalShowAllID);
        horizantal_product = view.findViewById(R.id.HorixantalViewID);
        horizantal_product.setHasFixedSize(true);

        horizantal_product.setLayoutManager(horizantallayoutmanager);
        horizantal_modelList = new ArrayList<>();
        horizantal_modelList.add(new Horizantal_Model(R.drawable.glaxys10, "Redmi 5s", "SD 542", "price 17000/-"));
        horizantal_modelList.add(new Horizantal_Model(R.drawable.reilmex, "Realme X", "SD 710", "price 22000/-"));
        horizantal_modelList.add(new Horizantal_Model(R.drawable.samsung9s, "Samsung S9", "SD 800", "price 50000/-"));
        horizantal_modelList.add(new Horizantal_Model(R.drawable.reailmecc, "Reailme C8", "SD 500", "price 13000/-"));
        horizantal_modelList.add(new Horizantal_Model(R.drawable.motogp, "Moto Gp", "Adrino 530", "price 25000/-"));

        horizantal_adapter = new Horizantal_Adapter(horizantal_modelList);
        horizantal_product.setAdapter(horizantal_adapter);
        horizantal_adapter.notifyDataSetChanged();

        ///horizantal_product

        ///gride_layout
        gridettitle = view.findViewById(R.id.GrideProductTitileID);
        grideshowall = view.findViewById(R.id.GrideViewAllID);
        productlist = view.findViewById(R.id.ProductGrideViewID);
        gride_adapter = new Gride_Adapter(horizantal_modelList);
        productlist.setAdapter(gride_adapter);
        ///gride_layout


        /// teast recylearview
        testview = view.findViewById(R.id.TeastReylerviewID);
        LinearLayoutManager teastlayoutmanager = new LinearLayoutManager(getContext());
        teastlayoutmanager.setOrientation(RecyclerView.VERTICAL);
        testview.setLayoutManager(teastlayoutmanager);
        /// teast recylearview



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
