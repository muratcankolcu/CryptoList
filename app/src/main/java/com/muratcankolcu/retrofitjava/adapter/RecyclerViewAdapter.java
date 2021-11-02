package com.muratcankolcu.retrofitjava.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muratcankolcu.retrofitjava.R;
import com.muratcankolcu.retrofitjava.model.CryptoModel;

import java.security.CryptoPrimitive;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>{

    private ArrayList<CryptoModel> cryptoList;

    private String [] colors={"#0ff1ce","#ff0000","#ff80ed","#2adada","#ffd700","#407294","#cbcba9","#065535","#dcedc1","#dcedc1","#8a2be2","#ffe4e1","#00ff00"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList){

        this.cryptoList=cryptoList;
    }


    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

        holder.bind(cryptoList.get(position),colors,position);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textPrice;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(CryptoModel cryptoModel,String[] colors,Integer position){

            itemView.setBackgroundColor(Color.parseColor(colors[position%13]));
            textName=itemView.findViewById(R.id.text_name);
            textPrice=itemView.findViewById(R.id.text_price);
            textName.setText(cryptoList.get(position).currency);
            textPrice.setText(cryptoList.get(position).price);
        }
    }
}
