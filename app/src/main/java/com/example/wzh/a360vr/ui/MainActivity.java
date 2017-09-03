package com.example.wzh.a360vr.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wzh.a360vr.R;
import com.example.wzh.a360vr.adapter.VRAdapter;
import com.example.wzh.a360vr.model.Data;
import com.example.wzh.a360vr.model.VRMode;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private VrPanoramaView mVrPanoramaView;
    private TextView mTextView;

    private LinearLayoutManager mLinearLayoutManager;
    private VRAdapter mVRAdapter;
    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.main_recyclerView);
        mImageView = findViewById(R.id.main_imageView);
        mVrPanoramaView = findViewById(R.id.main_vrPanoramaView);
        mTextView = findViewById(R.id.main_tv);


        mVrPanoramaView.setTouchTrackingEnabled(true);
        mVrPanoramaView.setFullscreenButtonEnabled(true);
        mVrPanoramaView.setInfoButtonEnabled(false);
        mVrPanoramaView.setStereoModeButtonEnabled(false);

        //随机生成列表中的一个位置
        currentPosition = new Random().nextInt(Data.getVRImageList().size());
        VRMode vrMode = Data.getVRImageList().get(currentPosition);
        loadVR(vrMode);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mVRAdapter = new VRAdapter(this, Data.getVRImageList());
        mRecyclerView.setAdapter(mVRAdapter);
    }

    private void loadVR(VRMode vrMode) {
        loadVR(getBitmapFromAsset(vrMode.assetName));
        mTextView.setText(vrMode.title);
    }

    private void loadVR(Bitmap bitmap) {
        if (bitmap == null) return;
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        options.inputType = VrPanoramaView.Options.TYPE_MONO;
        mVrPanoramaView.loadImageFromBitmap(bitmap, options);

    }

    private Bitmap getBitmapFromAsset(String resourceName) {
        if (TextUtils.isEmpty(resourceName)) return null;
        try {
            InputStream inputStream = getAssets().open(resourceName);
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initEvent() {

        mVRAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (currentPosition == position) return;
                currentPosition = position;
                VRMode model = mVRAdapter.getData().get(position);
                loadVR(model);
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVrPanoramaView.pauseRendering();
    }

    @Override
    protected void onDestroy() {
        mVrPanoramaView.shutdown();
        super.onDestroy();
    }

}
