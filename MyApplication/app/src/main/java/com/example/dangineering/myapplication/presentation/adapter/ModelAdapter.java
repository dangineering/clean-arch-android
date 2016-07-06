package com.example.dangineering.myapplication.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dangineering.myapplication.R;
import com.example.dangineering.myapplication.presentation.recyclerview.GettyViewHolder;
import com.example.dangineering.myapplication.presentation.viewmodel.ImageViewModel;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<GettyViewHolder> {

    private List<ImageViewModel> imageViewModels;

    public ModelAdapter() {
        imageViewModels = new ArrayList<>();
    }

    public void setData(List<ImageViewModel> imageViewModels) {
        this.imageViewModels.clear();
        this.imageViewModels.addAll(imageViewModels);
        notifyDataSetChanged();
    }


    @Override
    public GettyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate and return view holder

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_itme_view, parent, false);  // it will crash without this!
        return new GettyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GettyViewHolder holder, int position) {

        ImageViewModel curImageViewModel = imageViewModels.get(position);

        holder.setImageUri(curImageViewModel.getImageUrl());
        holder.setTextView(curImageViewModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return imageViewModels.size();
    }
}
