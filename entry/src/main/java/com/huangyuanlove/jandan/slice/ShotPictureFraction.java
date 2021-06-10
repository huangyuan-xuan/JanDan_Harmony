package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.ResourceTable;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;

public class ShotPictureFraction extends Fraction {


    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container, Intent intent) {
        Component component=  scatter.parse(ResourceTable.Layout_fraction_shot_picture,container,false);
        return component;
    }

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
    }
}
