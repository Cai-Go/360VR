package com.example.wzh.a360vr.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wzh.a360vr.R;

import me.drakeet.multitype.BuildConfig;
import me.drakeet.multitype.Items;
import me.drakeet.support.about.AbsAboutActivity;
import me.drakeet.support.about.Card;
import me.drakeet.support.about.Category;
import me.drakeet.support.about.Contributor;
import me.drakeet.support.about.License;
import me.drakeet.support.about.Line;

/**
 * Created by WZH on 2017/9/3.
 */

public class AboutActivity extends AbsAboutActivity {
    @Override
    protected void onCreateHeader(ImageView icon, TextView slogan, TextView version) {
        setHeaderContentColor(getResources().getColor(R.color.transparent100_white));
        icon.setImageResource(R.mipmap.ic_launcher);
        version.setText("v" + BuildConfig.VERSION_NAME);
    }

    @Override
    protected void onItemsCreated(@NonNull Items items) {
        items.add(new Category("介绍"));
        items.add(new Card(getString(R.string.card_content), "分享"));

        items.add(new Line());

        items.add(new Category("开发者"));
        items.add(new Contributor(R.drawable.me, "W.Z.H", "Developer & designer", "http://wuzhaohui026.github.io/"));

        items.add(new Line());

        items.add(new Category("开源库"));
        items.add(new License("MultiType", "drakeet", License.APACHE_2, "https://github.com/drakeet/MultiType"));
        items.add(new License("about-page", "drakeet", License.APACHE_2, "https://github.com/drakeet/about-page"));
        items.add(new License("BaseRecyclerViewAdapterHelper", "CymChad", License.APACHE_2, "https://github.com/CymChad/BaseRecyclerViewAdapterHelper"));
    }

    @Override
    protected void onActionClick(View action) {
        onClickShare();
    }

    private void onClickShare() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_content));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, getTitle()));
    }
}
