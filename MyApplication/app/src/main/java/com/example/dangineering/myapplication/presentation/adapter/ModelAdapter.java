package com.example.dangineering.myapplication.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangineering.myapplication.R;
import com.example.dangineering.myapplication.presentation.viewmodel.SampleViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    private List<SampleViewModel> models;

    public ModelAdapter() {
        models = new ArrayList<SampleViewModel>();
    }

    public ModelAdapter(List<SampleViewModel> models) {
        this.models = models;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View modelView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model, viewGroup, false);
//        return new ViewHolder(modelView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        SampleViewModel model = models.get(position);

//        viewHolder.modelTitle.setText(model.getTitle());
//        viewHolder.modelSubtitle.setText(model.getSubtitle());
//
//        Picasso.with(viewHolder.view.getContext())
//                .load(model.getImageUrl())
//                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void add(SampleViewModel model) {
        models.add(model);
        notifyDataSetChanged();
    }

    public void add(List<SampleViewModel> models) {
        this.models.addAll(models);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;

//        @BindView(R.id.model_title)
//        TextView modelTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
