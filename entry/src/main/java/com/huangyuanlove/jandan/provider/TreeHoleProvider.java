package com.huangyuanlove.jandan.provider;

import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.Pictures;
import com.huangyuanlove.jandan.data.TreeHole;
import com.squareup.picasso.Picasso;
import ohos.agp.components.*;

import java.util.ArrayList;

public class TreeHoleProvider extends BaseItemProvider {

    private ArrayList<TreeHole> data;

    public TreeHoleProvider(ArrayList<TreeHole> data) {
        this.data = data;
    }

    public void setData(ArrayList<TreeHole> data) {
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
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        Component cpt;
        TreeHoleHolder holder;
        if (component == null) {
            cpt = LayoutScatter.getInstance(componentContainer.getContext()).parse(ResourceTable.Layout_item_tree_hole, null, false);
            holder = new TreeHoleHolder(cpt);
            cpt.setTag(holder);
        } else {
            cpt = component;
            holder = (TreeHoleHolder) cpt.getTag();
        }
        TreeHole picture = data.get(i);
        holder.funnyPictureAuthor.setText(picture.author);
        holder.funnyPictureTime.setText(picture.date + "\t" + i);
        holder.funnyPictureContent.setText(picture.content);


        holder.funnyPictureVoteNegative.setText("XX " + picture.voteNegative);
        holder.funnyPictureVotePositive.setText("OO " + picture.votePositive);
        holder.funnyPictureSubCommentCount.setText("吐槽 " + picture.subCommentCount);


        return cpt;
    }

    private static class TreeHoleHolder {

        Text funnyPictureAuthor;
        Text funnyPictureTime;
        Text funnyPictureContent;
        Text funnyPictureVotePositive;
        Text funnyPictureVoteNegative;
        Text funnyPictureSubCommentCount;
        Text funnyPictureMore;

        TreeHoleHolder(Component component) {
            funnyPictureAuthor = (Text) component.findComponentById(ResourceTable.Id_tree_hole_author);
            funnyPictureTime = (Text) component.findComponentById(ResourceTable.Id_tree_hole_time);
            funnyPictureContent = (Text) component.findComponentById(ResourceTable.Id_tree_hole_content);
            funnyPictureVotePositive = (Text) component.findComponentById(ResourceTable.Id_tree_hole_vote_positive);
            funnyPictureVoteNegative = (Text) component.findComponentById(ResourceTable.Id_tree_hole_vote_negative);
            funnyPictureSubCommentCount = (Text) component.findComponentById(ResourceTable.Id_tree_hole_sub_comment_count);
            funnyPictureMore = (Text) component.findComponentById(ResourceTable.Id_tree_hole_more);

        }

    }
}
