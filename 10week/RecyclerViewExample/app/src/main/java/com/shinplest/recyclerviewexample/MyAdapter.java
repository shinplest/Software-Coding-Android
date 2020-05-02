package com.shinplest.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mData = null ;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1 ;
        ViewHolder(View itemView) {
            super(itemView) ;
            textView1 = itemView.findViewById(R.id.text1) ;
        }
    }

    MyAdapter(ArrayList<String> list){
        mData = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false) ;
        MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(view) ;

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        String text = mData.get(position) ;
        holder.textView1.setText(text) ;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
