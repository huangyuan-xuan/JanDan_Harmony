package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.MyApplication;
import com.huangyuanlove.jandan.ResourceTable;
import com.huangyuanlove.jandan.data.CommonRequestResult;
import com.huangyuanlove.jandan.data.Girls;
import com.huangyuanlove.jandan.data.Pictures;
import com.huangyuanlove.jandan.net.GirlPicsInterface;
import com.huangyuanlove.jandan.net.PicsInterface;
import com.huangyuanlove.jandan.provider.GirlsProvider;
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

public class GirlsFraction extends Fraction {
    private ListContainer girlsListContainer;
    private GirlsProvider provider;
    private ArrayList<Girls> data;

    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {
        Component component = scatter.parse(ResourceTable.Layout_fraction_shot_picture, container, false);
        initView(component);
        loadData(false);
        HiLog.error(MainAbilitySlice.LABEL," GirlsFraction onComponentAttached:" );

        return component;
    }

    private void initView(Component component) {
        girlsListContainer = (ListContainer) component.findComponentById(ResourceTable.Id_girls_list);
        data = new ArrayList<>();
        provider = new GirlsProvider(data);
        girlsListContainer.setItemProvider(provider);
    }

    private void loadData(boolean isLoadMore) {
        HashMap<String, Integer> requestParams = new HashMap<>();
        if (data.size() > 0 && isLoadMore) {
            requestParams.put("start_id", data.get(data.size() - 1).id);
        }
        GirlPicsInterface girlsService = MyApplication.retrofit.create(GirlPicsInterface.class);
        Call<CommonRequestResult<Girls>> call = girlsService.getGirlPics(requestParams);
        call.enqueue(new Callback<CommonRequestResult<Girls>>() {
            @Override
            public void onResponse(Call<CommonRequestResult<Girls>> call, Response<CommonRequestResult<Girls>> response) {
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
            public void onFailure(Call<CommonRequestResult<Girls>> call, Throwable throwable) {
                HiLog.debug(MainAbilitySlice.LABEL, "request for GirlsFraction failure" + throwable.toString());
                new ToastDialog(getComponent().getContext())
                        .setText("请求出错")
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
            }
        });

    }

    private void update() {
        provider.setData(data);
        provider.notifyDataChanged();
    }
}
