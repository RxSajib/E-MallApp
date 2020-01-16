package com.ecommerce.mymall.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecommerce.mymall.ModalClass.Horizantal_Model;
import com.ecommerce.mymall.R;

import java.util.ArrayList;
import java.util.List;

public class Gride_Adapter extends BaseAdapter {

    List<Horizantal_Model> horizantal_modelList = new ArrayList<>();

    public Gride_Adapter(List<Horizantal_Model> horizantal_modelList) {
        this.horizantal_modelList = horizantal_modelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_grideview, null);
            ImageView phoneimage = view.findViewById(R.id.GrideImageID);
            TextView phonename = view.findViewById(R.id.GrideviewPhonenameID);
            TextView phoneprocessor = view.findViewById(R.id.GrideProcessorID);
            TextView phoneprice = view.findViewById(R.id.GridePhonePriceID);

            phoneimage.setImageResource(horizantal_modelList.get(position).getHorizantalimeg());
            phonename.setText(horizantal_modelList.get(position).getHoritalproductname());
            phoneprocessor.setText(horizantal_modelList.get(position).getHorizantalproductdetails());
            phoneprice.setText(horizantal_modelList.get(position).getHorizantalproductPrice());
        }
        else {
            view = convertView;
        }
        return view;
    }
}
