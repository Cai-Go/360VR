package com.example.wzh.a360vr.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wzh.a360vr.R;

/**
 * Created by WZH on 2017/9/3.
 */

public class VRHolder extends RecyclerView.ViewHolder {
    ImageView mImageView;
    TextView mTextView;

    public VRHolder(View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.item_imageView);
        mTextView = itemView.findViewById(R.id.item_tetxView);
    }
}
