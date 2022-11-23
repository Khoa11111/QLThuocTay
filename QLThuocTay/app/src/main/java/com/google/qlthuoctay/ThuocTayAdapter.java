package com.google.qlthuoctay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThuocTayAdapter extends RecyclerView.Adapter<ThuocTayAdapter.ThuocTayViewHolder>{

    private List<ThuocTay> list;

    public ThuocTayAdapter(List<ThuocTay> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ThuocTayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row,parent,false);
        return new ThuocTayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThuocTayViewHolder holder, int position) {
        ThuocTay thuocTay = list.get(position);
        if(thuocTay == null){
            return;
        }
        holder.tvTen.setText(thuocTay.getTen());
        holder.tvCongDung.setText(thuocTay.getCongdung());
        holder.tvSL.setText(thuocTay.getSl());
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ThuocTayViewHolder extends RecyclerView.ViewHolder{

        TextView tvTen, tvCongDung, tvSL;

        public ThuocTayViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTen = itemView.findViewById(R.id.tv_ten);
            tvCongDung = itemView.findViewById(R.id.tv_congdung);
            tvSL = itemView.findViewById(R.id.tv_soluong);
        }
    }
}
