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
        if (data != null && position >= 0 && position < data.size()){
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

        if (convertComponent == null) {
            cpt = LayoutScatter.getInstance(componentContainer.getContext()).parse(ResourceTable.Layout_item_news, null, false);
        } else {
            cpt = convertComponent;
        }
        NewResult.Posts post = data.get(position);
        Text titleText = (Text) cpt.findComponentById(ResourceTable.Id_news_title);
        titleText.setText(post.title);

        Text news_author = (Text) cpt.findComponentById(ResourceTable.Id_news_author);
        news_author.setText(post.author.name);

            Text news_time = (Text) cpt.findComponentById(ResourceTable.Id_news_time);
        news_time.setText(post.date);

          Text news_common = (Text) cpt.findComponentById(ResourceTable.Id_news_common);
          if(post.commentCount ==0 || !"open".equalsIgnoreCase(post.commentStatus)){
              news_common.setVisibility(Component.INVISIBLE);
          }else{
              news_common.setVisibility(Component.VISIBLE);
              news_common.setText(post.commentCount +"评论");
          }
          Image newsImage = (Image) cpt.findComponentById(ResourceTable.Id_news_image);
          if(post.customFields.thumbC!=null && post.customFields.thumbC.size()>0){
              Glide.with(componentContainer.getContext())
                      .load(post.customFields.thumbC.get(0))
                      .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                      .skipMemoryCache(false)
                      .placeholder(ResourceTable.Media_news_image)
                      .into(newsImage);
          }




        return cpt;
    }
}
