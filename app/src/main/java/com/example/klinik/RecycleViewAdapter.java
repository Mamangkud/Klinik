package com.example.klinik;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private ArrayList<String> number = new ArrayList<>();
    private ArrayList<String> nama_pasien = new ArrayList<>();
    private ArrayList<String> jenis_kelamin = new ArrayList<>();

    public RecycleViewAdapter(ArrayList<String> number, ArrayList<String> nama_pasien, ArrayList<String> jenis_kelamin) {
        this.number = number;
        this.nama_pasien = nama_pasien;
        this.jenis_kelamin = jenis_kelamin;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        holder.number.setText(number.get(position));
        holder.nama_pasien.setText(nama_pasien.get(position));
        holder.jenis_kelamin.setText(jenis_kelamin.get(position));
    }

    @Override
    public int getItemCount() {
        number.size();
        return number.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView number;
        TextView nama_pasien;
        TextView jenis_kelamin;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            nama_pasien = itemView.findViewById(R.id.nama_pasien);
            jenis_kelamin = itemView.findViewById(R.id.jenis_kelamin);
            relativeLayout = itemView.findViewById(R.id.rl_row);
        }
    }
}
