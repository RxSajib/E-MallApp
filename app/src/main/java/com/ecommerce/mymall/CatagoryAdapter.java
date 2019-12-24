package com.ecommerce.mymall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.CviewHolder> {

    private List<CatagoryHolder> catagoryHolders;

    public CatagoryAdapter(List<CatagoryHolder> catagoryHolders) {
        this.catagoryHolders = catagoryHolders;
    }

    @NonNull
    @Override
    public CatagoryAdapter.CviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_layout, parent, false);


        return new CviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryAdapter.CviewHolder holder, int position) {

        String getimage = catagoryHolders.get(position).getCatagoryimage();
        String gettext = catagoryHolders.get(position).getCatagoryname();

        holder.setCatagorytextset(gettext);
    }

    @Override
    public int getItemCount() {
        return catagoryHolders.size();
    }

    public class CviewHolder extends RecyclerView.ViewHolder {

        private ImageView catagoryimag;
        private TextView catagorytext;

        public CviewHolder(@NonNull View itemView) {
            super(itemView);

            catagoryimag = itemView.findViewById(R.id.CatagoryImageID);
            catagorytext = itemView.findViewById(R.id.CatagoryTextID);
        }

        public void setCatagoryimagset(){
            /// set from database
        }
        public void setCatagorytextset(String txt){
            catagorytext.setText(txt);
        }
    }
}
