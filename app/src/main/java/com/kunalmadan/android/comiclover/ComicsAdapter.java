package com.kunalmadan.android.comiclover;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KUNAL on 03-09-2016.
 */
public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.MyViewHolder> {

    private ArrayList<Comic> mdata ;
    private Context mContext;

    public ComicsAdapter(Context context, ArrayList<Comic> data) {
        mdata = new ArrayList<>();
        mdata = data;
        mContext = context;
        Log.v("kithe","kithe"+data);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;

        public MyViewHolder(View view) {

            super(view);
            Log.v("inviewholder","inviewholder");
            title = (TextView) view.findViewById(R.id.text1);
            price = (TextView) view.findViewById(R.id.text2);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comic_strips, parent, false);
        Log.v("inviewholder","inviewholder");
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
              final Comic val =   mdata.get(position);
        Log.v("price","price"+val.getPrice());
        if(val.getPrice() == "0") {
            holder.price.setText("NA");

        }

        else {
            holder.price.setText("$"+val.getPrice());
        }

        Log.v("hellloo","hellloo"+val.getTitle()+"price"+val.getPrice());
        holder.title.setText(val.getTitle());


        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ComicDetail.class);

                intent.putExtra("key",val);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

                //intent.putParcelableArrayListExtra("",mdata);

            }
        });

    }

    @Override
    public int getItemCount() {
        Log.v("size","size"+mdata.size());

        return mdata.size();
    }
}
