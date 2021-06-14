package com.huangyuanlove.jandan.provider;

import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.Pictures;
import com.huangyuanlove.jandan.slice.MainAbilitySlice;
import com.squareup.picasso.Picasso;
import ohos.agp.components.*;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.List;

public class FunnyPictureProvider extends BaseItemProvider {
    private static final HiLogLabel LABEL = new HiLogLabel(HiLog.DEBUG, 0x00201, "FunnyPictureProvider");

    private List<Pictures> data;

    public FunnyPictureProvider(List<Pictures> data) {
        this.data = data;
    }

    public void setData(List<Pictures> data) {
        this.data = data;
        HiLog.error(MainAbilitySlice.LABEL,"setData:" + data.size());
    }

    @Override
    public int getCount() {
        int count = data == null ? 0 :data.size();
        HiLog.error(MainAbilitySlice.LABEL,"getCount:" + count);
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
        FunnyPictureHolder holder;
        if(component ==null){
            cpt = LayoutScatter.getInstance(componentContainer.getContext()).parse(ResourceTable.Layout_item_funny_pictures ,null,false);
            holder = new FunnyPictureHolder(cpt);
            cpt.setTag(holder);
        }else{
            cpt = component;
            holder = (FunnyPictureHolder) cpt.getTag();
        }
        Pictures picture = data.get(i);
        holder.funnyPictureAuthor.setText(picture.author);
        holder.funnyPictureTime.setText(picture.date +"\t" + i);
        if(picture.content!=null){
            picture.content = picture.content.replace("#img#","");
        }
        if(picture.content ==null || picture.content.length() ==0){
            holder.funnyPictureContent.setVisibility(Component.HIDE);
        }else{
            holder.funnyPictureContent.setText(picture.content);
            holder.funnyPictureContent.setVisibility(Component.VISIBLE);

        }

        Picasso.get()
                .load(picture.images.get(0).fullUrl)

                .tag(componentContainer.getContext())
                .into(holder.funnyPictureImage);


        holder.funnyPictureVoteNegative.setText("XX " + picture.voteNegative);
        holder.funnyPictureVotePositive.setText("OO " + picture.votePositive);
        holder.funnyPictureSubCommentCount.setText("吐槽 " + picture.subCommentCount);


        return cpt;
    }

    private static class FunnyPictureHolder {

        Text funnyPictureAuthor;
        Text funnyPictureTime;
        Text funnyPictureContent;
        Image funnyPictureImage;
        Text funnyPictureVotePositive;
        Text funnyPictureVoteNegative;
        Text funnyPictureSubCommentCount;
        Text funnyPictureMore;

        FunnyPictureHolder(Component component) {
            funnyPictureAuthor = (Text) component.findComponentById(ResourceTable.Id_funny_picture_author);
            funnyPictureTime = (Text) component.findComponentById(ResourceTable.Id_funny_picture_time);
            funnyPictureContent = (Text) component.findComponentById(ResourceTable.Id_funny_picture_content);
            funnyPictureImage = (Image) component.findComponentById(ResourceTable.Id_funny_picture_image);
            funnyPictureVotePositive = (Text) component.findComponentById(ResourceTable.Id_funny_picture_vote_positive);
            funnyPictureVoteNegative = (Text) component.findComponentById(ResourceTable.Id_funny_picture_vote_negative);
            funnyPictureSubCommentCount = (Text) component.findComponentById(ResourceTable.Id_funny_picture_sub_comment_count);
            funnyPictureMore = (Text) component.findComponentById(ResourceTable.Id_funny_picture_more);

        }

    }
}
