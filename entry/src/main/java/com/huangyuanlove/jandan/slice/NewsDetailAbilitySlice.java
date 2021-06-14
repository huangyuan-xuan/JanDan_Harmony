package com.huangyuanlove.jandan.slice;

import com.bumptech.glide.Glide;
import com.huangyuanlove.jandan.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Image;
import ohos.agp.components.webengine.WebView;

public class NewsDetailAbilitySlice extends AbilitySlice {
    private WebView webView;
    private Image image;
    private String imageUrl;
    private String newsUrl;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_slice_news_detail);
        imageUrl = intent.getStringParam("image");
        newsUrl = intent.getStringParam("url");
        initView();
    }

    private void initView() {
        webView = (WebView) findComponentById(ResourceTable.Id_news_detail_web);
        image = (Image) findComponentById(ResourceTable.Id_news_detail_image);
        Glide.with(this).load(imageUrl).into(image);
        webView.load(newsUrl);
    }


}
