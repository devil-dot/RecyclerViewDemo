package com.kmtstudio.myrecyclerviewdemo6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static ClickListener clickListener;
    private Context context;
    private int[] images;
    private String[] titles, desc;

    public MyAdapter(Context context, int[] images, String[] titles, String[] desc) {
        this.context = context;
        this.images = images;
        this.titles = titles;
        this.desc = desc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sample_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(images[position]);

        holder.t1.setText(titles[position]);
        holder.t2.setText(desc[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        ImageView imageView;
        TextView t1, t2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgViewID);

            t1 = itemView.findViewById(R.id.titleTxtID);
            t2 = itemView.findViewById(R.id.descTxtID);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            clickListener.setOnItemClick(getAdapterPosition(), v);

        }

        @Override
        public boolean onLongClick(View v) {

            clickListener.setOnItemLongClick(getAdapterPosition(), v);

            return false;
        }
    }

    public void setOnItemClickListener(ClickListener listener) {

        MyAdapter.clickListener = listener;
    }
}
