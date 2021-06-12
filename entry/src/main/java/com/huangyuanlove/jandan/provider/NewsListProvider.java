package com.huangyuanlove.jandan.provider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.NewResult;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;
import ohos.app.Context;

import java.util.List;

public class NewsListProvider extends BaseItemProvider {


    private List<NewResult.Posts> data;


    public NewsListProvider(List<NewResult.Posts> data) {
        this.data = data;
    }

    public void setData(List<NewResult.Posts> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        if (data != null && position >= 0 && position < data.size()) {
            return data.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Component getComponent(int position, Component convertComponent, ComponentContainer componentContainer) {
        final Component cpt;

        NewsHolder newsHolder;
        NewResult.Posts post = data.get(position);
        if (convertComponent == null) {
            cpt = LayoutScatter.getInstance(componentContainer.getContext()).parse(ResourceTable.Layout_item_news, null, false);
            newsHolder = new NewsHolder(cpt);
            cpt.setTag(newsHolder);
        } else {
            cpt = convertComponent;
            newsHolder = (NewsHolder) cpt.getTag();
        }


        newsHolder.newsTitle.setText(post.title);
        newsHolder.newsAuthor.setText(post.author.name);
        newsHolder.newsTime.setText(post.date);
        if (post.commentCount == 0 || !"open".equalsIgnoreCase(post.commentStatus)) {
            newsHolder.newsCommon.setVisibility(Component.INVISIBLE);
        } else {
            newsHolder.newsCommon.setVisibility(Component.VISIBLE);
            newsHolder.newsCommon.setText(post.commentCount + "评论");
        }
        if (post.customFields.thumbC != null && post.customFields.thumbC.size() > 0) {
            Glide.with(componentContainer.getContext())
                    .load(post.customFields.thumbC.get(0))
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .skipMemoryCache(false)
                    .placeholder(ResourceTable.Media_news_image)
                    .into(newsHolder.newsImage);
        }
        return cpt;
    }

    private static class NewsHolder {
        Image newsImage;
        Text newsTitle;
        Text newsAuthor;
        Text newsTime;
        Text newsCommon;

        NewsHolder(Component component) {
            newsTitle = (Text) component.findComponentById(ResourceTable.Id_news_title);
            newsAuthor = (Text) component.findComponentById(ResourceTable.Id_news_author);
            newsTime = (Text) component.findComponentById(ResourceTable.Id_news_time);
            newsCommon = (Text) component.findComponentById(ResourceTable.Id_news_common);
            newsImage = (Image) component.findComponentById(ResourceTable.Id_news_image);
        }

    }

}
