package com.example.dangineering.myapplication.presentation.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangineering.myapplication.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class GettyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    TextView textView;

    Context context;

    public GettyViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image_view);
        textView = (TextView)  itemView.findViewById(R.id.text_view);
        context = itemView.getContext();
    }

    public void setImageUri(String uri){
        if (!uri.equals("")) {
            Picasso.with(context)
                    .load(uri)
                    .into(imageView);
        }

    }

    public void setTextView(String text) {
        textView.setText(text);
    }

}
