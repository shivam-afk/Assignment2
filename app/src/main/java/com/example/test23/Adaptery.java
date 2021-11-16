package com.example.test23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    //zoom method instance
    private  RecyclerViewClickListerner listener;


    private Context mContext;
    private List<DataModel> chatList;

    public Adaptery(Context mContext, List<DataModel> chatList,RecyclerViewClickListerner listener) {
        this.mContext = mContext;
        this.chatList = chatList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.my_item,parent,false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.fn.setText(chatList.get(position).getcName().getFirst());
        holder.ln.setText(chatList.get(position).getcName().getLast());
        holder.ct.setText(chatList.get(position).getcLocation().getCity());
        holder.st.setText(chatList.get(position).getcLocation().getState());



        //adding glide library
        Glide.with(mContext)
                .load(chatList.get(position).getcPicture().getThumbnail())
                .into(holder.tmb);





    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        TextView fn;
        TextView ln;
        TextView ct;
        TextView st;
        ImageView tmb;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fn = itemView.findViewById(R.id.textView);
            ln = itemView.findViewById(R.id.textView2);
            tmb = itemView.findViewById(R.id.imageView);
            ct = itemView.findViewById(R.id.textView3);
            st = itemView.findViewById(R.id.textView4);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View itemView) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }

    public  interface  RecyclerViewClickListerner
    {
        void onClick(View v,int position);
    }
}
