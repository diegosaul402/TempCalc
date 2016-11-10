package com.diegosaul402.tempcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diegosaul402.tempcalc.temps.TempEntity;
import com.diegosaul402.tempcalc.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 09/11/2016.
 */

public class TempAdapter extends RecyclerView.Adapter<TempAdapter.ViewHolder> {

    private Context context;
    private List<TempEntity> tempList;
    private OnItemClickListener onItemClickListener;


    public TempAdapter(Context context, List<TempEntity> tempList, OnItemClickListener onItemClickListener){
        this.context = context;
        this.tempList = tempList;
        this.onItemClickListener = onItemClickListener;
    }

    public TempAdapter(Context context, OnItemClickListener onItemClickListener){
        this.context = context;
        this.tempList = new ArrayList<TempEntity>();
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return tempList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        TempEntity element = tempList.get(position);

        //String strTip = String.format(context.getString(R.string.Required), TipUtils.getTip(element));
        //holder.txtContent.setText(strTip);
        holder.setOnItemClickListener(element, onItemClickListener);
    }

    //Metodos que hacen cambios en el arreglo de elementos
    public void add(TempEntity elemento){
        tempList.add(0,elemento);
        notifyDataSetChanged();
    }

    public void clear(){
        tempList.clear();
        notifyDataSetChanged();
    }

    public void init(){
        tempList = new ArrayList<TempEntity>();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setOnItemClickListener(final TempEntity element, final OnItemClickListener onItemClickListener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(element);
                }
            });
        }
    }
}
