package com.example.wzh.a360vr.model;

import com.example.wzh.a360vr.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WZH on 2017/9/2.
 */

public class Data {

    public static final String[] title_Arr = {
            "地平线",
            "上海迪斯尼",
            "火山",
            "火星",
            "极光",
            "老街",
            "上海夜景",
            "圣托里尼",
            "星空",
            "樱花",
            "银河系",
            "月球"
    };


    public static final String[] asset_Arr = {
            "dpx.jpg",
            "dsn.jpg",
            "hs.jpg",
            "hx.jpg",
            "kg.jpg",
            "lj.jpg",
            "sh.jpg",
            "stln.jpg",
            "xk.jpg",
            "yh.jpg",
            "yhx.jpg",
            "yq.jpg"
    };

    public static final int[] resource_Arr = {
            R.mipmap.dpx,
            R.mipmap.dsn,
            R.mipmap.hs,
            R.mipmap.hx,
            R.mipmap.kg,
            R.mipmap.lj,
            R.mipmap.sh,
            R.mipmap.stln,
            R.mipmap.xk,
            R.mipmap.yh,
            R.mipmap.yhx,
            R.mipmap.yq
    };

    public static List<VRMode> getVRImageList() {
        List<VRMode> list = new ArrayList<>();
        for (int i = 0; i < title_Arr.length; i++) {
            list.add(new VRMode(title_Arr[i], asset_Arr[i],resource_Arr[i]));
        }
        return list;
    }
}
