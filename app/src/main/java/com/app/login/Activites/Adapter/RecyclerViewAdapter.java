package com.app.login.Activites.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.login.Models.BusesViewModel;
import com.app.login.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewAdapterVH> {

    private List<BusesViewModel> busesViewModel;
    private Context context;
    private ClickedItem clickedItem;

    public RecyclerViewAdapter(ClickedItem clickedItem) {
        this.clickedItem=clickedItem;
    }

    public void setData(List<BusesViewModel> busesViewModel){
        this.busesViewModel=busesViewModel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new RecyclerViewAdapter.RecyclerViewAdapterVH(LayoutInflater.from(context).inflate(R.layout.views_rows,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterVH holder, int position) {

        BusesViewModel busesView=busesViewModel.get(position);

        String username=busesView.getName();
        String prefix=busesView.getDescription();
//        holder.prefix.setText(prefix);
        holder.username.setText(username);
        holder.imageMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedView(busesView);
            }
        });
    }
    public interface ClickedItem{
        public void ClickedView(BusesViewModel busesViewModel);
    }

    @Override
    public int getItemCount() {
        return busesViewModel.size();
    }

    public class RecyclerViewAdapterVH extends RecyclerView.ViewHolder {

        TextView username;
//        TextView prefix;
        ImageView imageMore;

        public RecyclerViewAdapterVH(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);

            imageMore=itemView.findViewById(R.id.imageMore);

        }
    }
}
