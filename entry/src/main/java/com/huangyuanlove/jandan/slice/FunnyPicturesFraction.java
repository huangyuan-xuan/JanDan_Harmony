package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.CommonRequestResult;
import com.huangyuanlove.jandan.data.Pictures;
import com.huangyuanlove.jandan.net.PicsInterface;
import com.huangyuanlove.jandan.provider.FunnyPictureProvider;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class FunnyPicturesFraction extends Fraction {
    private FunnyPictureProvider provider;
    private ArrayList<Pictures> pictures;

    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {
        Component component = scatter.parse(ResourceTable.Layout_fraction_funny_picture, container, false);
        pictures = new ArrayList<>();
        initView(component);
        loadData(false);

        return component;
    }

    private void loadData(boolean isLoadMore) {
        HashMap<String, Integer> callParams = new HashMap<>();

        if (isLoadMore && pictures.size() > 0) {
            callParams.put("start_id", pictures.get(pictures.size() - 1).id);
        }else{
            pictures.clear();
        }


        PicsInterface picsService = MyApplication.retrofit.create(PicsInterface.class);
        Call<CommonRequestResult<Pictures>> call = picsService.getPics(callParams);

        call.enqueue(new Callback<CommonRequestResult<Pictures>>() {
            @Override
            public void onResponse(Call<CommonRequestResult<Pictures>> call, Response<CommonRequestResult<Pictures>> response) {
                assert response.body() != null;
                if (response.body().code == 0) {
                    pictures.addAll(response.body().data);
                    update();
                } else {
                    new ToastDialog(getContext())
                            .setText(response.message())
                            .setAlignment(LayoutAlignment.CENTER)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<CommonRequestResult<Pictures>> call, Throwable throwable) {
                HiLog.debug(MainAbilitySlice.LABEL, "request for funnyPictures failure" + throwable.toString());
                new ToastDialog(getComponent().getContext())
                        .setText("请求出错")
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
            }
        });

    }

    private void initView(Component component) {
        ListContainer pictureListContainer = (ListContainer) component.findComponentById(ResourceTable.Id_funny_picture_list);
        provider = new FunnyPictureProvider(pictures);
        pictureListContainer.setItemProvider(provider);
        pictureListContainer.addItemVisibilityChangedListener(new ListContainer.ItemVisibilityChangedListener() {
            @Override
            public void onItemAdded(Component component, int i) {
                HiLog.error(MainAbilitySlice.LABEL,"onItemAdded" + i);
            }

            @Override
            public void onItemRemoved(Component component, int i) {
                HiLog.error(MainAbilitySlice.LABEL,"onItemRemoved" + i);
            }
        });
        pictureListContainer.setScrollListener(new ListContainer.ScrollListener() {
            @Override
            public void onScrollFinished() {
                HiLog.error(MainAbilitySlice.LABEL,"onScrollFinished");
            }
        });

    }

    private void update() {
        provider.setData(pictures);
        provider.notifyDataChanged();
    }

}
