package com.huangyuanlove.jandan.provider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.Girls;
import com.huangyuanlove.jandan.slice.MainAbilitySlice;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import ohos.agp.components.*;
import ohos.agp.components.element.Element;
import ohos.hiviewdfx.HiLog;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GirlsProvider extends BaseItemProvider {

    private List<Girls> data;
    public GirlsProvider(List<Girls> data) {
        this.data = data;
    }

    public void setData(List<Girls> data) {
        this.data = data;
        HiLog.error(MainAbilitySlice.LABEL," GirlsProvider setData:" + data.size());
    }

    @Override
    public int getCount() {
        int count = data == null ? 0 :data.size();
        HiLog.error(MainAbilitySlice.LABEL," GirlsProvider getCount:" + count);
        return count;
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
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        Component cpt;
        GirlsPictureHolder holder;
        if(component ==null){
            cpt = LayoutScatter.getInstance(componentContainer.getContext()).parse(ResourceTable.Layout_item_girls ,null,false);
            holder = new GirlsPictureHolder(cpt);
            cpt.setTag(holder);
        }else{
            cpt = component;
            holder = (GirlsPictureHolder) cpt.getTag();
        }
        Girls picture = data.get(i);
        holder.girlsPictureAuthor.setText(picture.author);
        holder.girlsPictureTime.setText(picture.date +"\t" + i);
        if(picture.content!=null){
            picture.content = picture.content.replace("#img#","");
        }
        if(picture.content ==null || picture.content.length() ==0){
            holder.girlsPictureContent.setVisibility(Component.HIDE);
        }else{
            holder.girlsPictureContent.setText(picture.content);
            holder.girlsPictureContent.setVisibility(Component.VISIBLE);

        }

        Picasso.get()
                .load(picture.images.get(0).url)

                .tag(componentContainer.getContext())
                .into(holder.girlsPictureImage);




        holder.girlsPictureVoteNegative.setText("XX " + picture.voteNegative);
        holder.girlsPictureVotePositive.setText("OO " + picture.votePositive);
        holder.girlsPictureSubCommentCount.setText("吐槽 " + picture.subCommentCount);


        return cpt;
    }

    private static class GirlsPictureHolder {

        Text girlsPictureAuthor;
        Text girlsPictureTime;
        Text girlsPictureContent;
        Image girlsPictureImage;
        Text girlsPictureVotePositive;
        Text girlsPictureVoteNegative;
        Text girlsPictureSubCommentCount;
        Text girlsPictureMore;

        GirlsPictureHolder(Component component) {
            girlsPictureAuthor = (Text) component.findComponentById(ResourceTable.Id_girls_picture_author);
            girlsPictureTime = (Text) component.findComponentById(ResourceTable.Id_girls_picture_time);
            girlsPictureContent = (Text) component.findComponentById(ResourceTable.Id_girls_picture_content);
            girlsPictureImage = (Image) component.findComponentById(ResourceTable.Id_girls_picture_image);
            girlsPictureVotePositive = (Text) component.findComponentById(ResourceTable.Id_girls_picture_vote_positive);
            girlsPictureVoteNegative = (Text) component.findComponentById(ResourceTable.Id_girls_picture_vote_negative);
            girlsPictureSubCommentCount = (Text) component.findComponentById(ResourceTable.Id_girls_picture_sub_comment_count);
            girlsPictureMore = (Text) component.findComponentById(ResourceTable.Id_girls_picture_more);

        }

    }
}
