package com.huangyuanlove.jandan.slice;

import ohos.agp.colors.RgbColor;
import ohos.agp.components.*;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

import java.util.List;

public class MainPageSlideProvider extends PageSliderProvider {
    private List<String> list;
    public MainPageSlideProvider(List<String> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        return list ==null ?0 :list.size();
    }

    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        Text label = new Text(null);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setLayoutConfig(
                new StackLayout.LayoutConfig(
                        ComponentContainer.LayoutConfig.MATCH_PARENT,
                        ComponentContainer.LayoutConfig.MATCH_PARENT
                ));
        label.setText(list.get(i));
        label.setTextColor(Color.BLACK);
        label.setTextSize(50);
        ShapeElement element = new ShapeElement();
        element.setRgbColor(RgbColor.fromArgbInt(Color.getIntColor("#AFEEEE")));
        label.setBackground(element);
        componentContainer.addComponent(label);
        return label;
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
