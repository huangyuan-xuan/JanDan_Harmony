package com.huangyuanlove.jandan.slice;

import ohos.aafwk.ability.fraction.Fraction;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.PageSliderProvider;

import java.util.List;

public class MainPageSlideProvider extends PageSliderProvider {
    private List<Fraction> list;
    public MainPageSlideProvider(List<Fraction> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        return list ==null ?0 :list.size();
    }

    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        Component component = list.get(i).getComponent();
        componentContainer.addComponent(component);
        return component;
    }

    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((Component) o);
    }

    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        return true;
    }
}
