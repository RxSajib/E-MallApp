package com.ecommerce.mymall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Horizantal_Adapter extends RecyclerView.Adapter<Horizantal_Adapter.ViewHolder> {

    List<Horizantal_Model> horizantal_modelList = new ArrayList<>();

    public Horizantal_Adapter(List<Horizantal_Model> horizantal_modelList) {
        this.horizantal_modelList = horizantal_modelList;
    }

    @NonNull
    @Override
    public Horizantal_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View Mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_horizantal_teams, parent, false);

        return new ViewHolder(Mview);
    }

    @Override
    public void onBindViewHolder(@NonNull Horizantal_Adapter.ViewHolder holder, int position) {

        int imageposition = horizantal_modelList.get(position).getHorizantalimeg();
        String productname = horizantal_modelList.get(position).getHoritalproductname();
        String productprocessor = horizantal_modelList.get(position).getHorizantalproductdetails();
        String productprice = horizantal_modelList.get(position).getHorizantalproductPrice();

        holder.setproductimageset(imageposition);
        holder.setProductnameset(productname);
        holder.setProductdetailsset(productprocessor);
        holder.setProductpriceset(productprice);
    }

    @Override
    public int getItemCount() {
        return horizantal_modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View Mview;
        private ImageView productimage;
        private TextView productname;
        private TextView productdetails;
        private TextView productprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Mview = itemView;
            productimage = Mview.findViewById(R.id.HorizanTalPhoneID);
            productname = Mview.findViewById(R.id.HorizantalPhoeNameID);
            productdetails = Mview.findViewById(R.id.HoritaphoneProcessor);
            productprice = Mview.findViewById(R.id.HorizantalPhonPriceID);
        }

        public void setproductimageset(int img){
            productimage.setImageResource(img);
        }
        public void setProductnameset(String nam){
            productname.setText(nam);
        }
        public void setProductdetailsset(String det){
            productdetails.setText(det);
        }
        public void setProductpriceset(String pric){
            productprice.setText(pric);
        }
    }
}
