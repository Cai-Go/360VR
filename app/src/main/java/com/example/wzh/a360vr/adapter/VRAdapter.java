package com.example.wzh.a360vr.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wzh.a360vr.R;
import com.example.wzh.a360vr.model.VRMode;

import java.util.List;

/**
 * Created by WZH on 2017/9/2.
 */

public class VRAdapter extends BaseQuickAdapter<VRMode,BaseViewHolder> {

    private Context mContext;

    public VRAdapter(Context context, List<VRMode> vrImageList) {
        super(R.layout.item_layout,vrImageList);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, VRMode item) {
        helper.setText(R.id.item_tetxView, item.title);
        helper.setImageResource(R.id.item_imageView, item.resourceName);
    }

//
//    @Override
//    public VRHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
//        VRHolder vrHolder = new VRHolder(rootView);
//        return vrHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(VRHolder holder, int position) {
//        holder.mTextView.setText(mList.get(position).title);
//        holder.mImageView.setImageResource(mList.get(position).resourceName);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mList.size();
//    }
}
