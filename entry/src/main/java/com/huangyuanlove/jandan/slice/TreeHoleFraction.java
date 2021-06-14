package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.CommonRequestResult;
import com.huangyuanlove.jandan.data.Pictures;
import com.huangyuanlove.jandan.data.TreeHole;
import com.huangyuanlove.jandan.net.PicsInterface;
import com.huangyuanlove.jandan.net.TreeHoleInterface;
import com.huangyuanlove.jandan.provider.GirlsProvider;
import com.huangyuanlove.jandan.provider.TreeHoleProvider;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.ListContainer;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeHoleFraction extends Fraction {

    private Component component;
    private ArrayList<TreeHole> data;
    private TreeHoleProvider provider;
    private ListContainer treeHoleList;

    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {
        component = scatter.parse(ResourceTable.Layout_fraction_complaints, container, false);
        initView(component);
        loadData(false);
        return component;
    }

    private void loadData(boolean loadMore) {
        HashMap<String, Integer> callParams = new HashMap<>();

        if (loadMore && data.size() > 0) {
            callParams.put("start_id", data.get(data.size() - 1).id);
        }else{
            data.clear();
        }


        TreeHoleInterface treeHoleService = MyApplication.retrofit.create(TreeHoleInterface.class);
        Call<CommonRequestResult<TreeHole>> call = treeHoleService.getTreeHolePost(callParams);

        call.enqueue(new Callback<CommonRequestResult<TreeHole>>() {
            @Override
            public void onResponse(Call<CommonRequestResult<TreeHole>> call, Response<CommonRequestResult<TreeHole>> response) {
                assert response.body() != null;
                if (response.body().code == 0) {
                    data.addAll(response.body().data);
                    update();
                } else {
                    new ToastDialog(getContext())
                            .setText(response.message())
                            .setAlignment(LayoutAlignment.CENTER)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<CommonRequestResult<TreeHole>> call, Throwable throwable) {
                HiLog.debug(MainAbilitySlice.LABEL, "request for funnyPictures failure" + throwable.toString());
                new ToastDialog(getComponent().getContext())
                        .setText("请求出错")
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
            }
        });

    }

    private void initView(Component component) {
        treeHoleList = (ListContainer) component.findComponentById(ResourceTable.Id_tree_holo_list);
        data = new ArrayList<>();
        provider = new TreeHoleProvider(data);
        treeHoleList.setItemProvider(provider);
    }
    private void update(){
        provider.setData(data);
        provider.notifyDataChanged();
    }
}
