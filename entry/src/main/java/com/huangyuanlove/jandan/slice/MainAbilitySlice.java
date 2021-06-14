package com.huangyuanlove.jandan.slice;

import com.huangyuanlove.jandan.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;
import ohos.agp.components.TabList;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.ArrayList;

public class MainAbilitySlice extends AbilitySlice {
    public static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");
    private TabList tabList;
    private ArrayList<Fraction> fractions;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initView();
    }

    @Override
    public void onActive() {
        super.onActive();



    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    private void initView(){

        initFraction();
        initTabList();


    }

    private void initFraction() {


        fractions = new ArrayList<>();
        fractions.add(new NewsFraction());
        fractions.add(new FunnyPicturesFraction());
        fractions.add(new GirlsFraction());
        fractions.add(new TreeHoleFraction());
    }

    private void initTabList(){
        tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        TabList.Tab tab = tabList.new Tab(getContext());
        tab.setText("新鲜事");
        tabList.addTab(tab);

        tab = tabList.new Tab(getContext());
        tab.setText("无聊图");
        tabList.addTab(tab);

        tab = tabList.new Tab(getContext());
        tab.setText("妹子图");
        tabList.addTab(tab);

        tab = tabList.new Tab(getContext());
        tab.setText("树洞");
        tabList.addTab(tab);
        tabList.setFixedMode(true);
        tabList.selectTabAt(0);
        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {
                int position = tab.getPosition();
                HiLog.info(LABEL, "onSelected tabPosition:" + position);
                showFraction(position);
            }

            @Override
            public void onUnselected(TabList.Tab tab) {
                HiLog.info(LABEL, "onUnselected tabPosition:" + tab.getPosition());
            }

            @Override
            public void onReselected(TabList.Tab tab) {
                HiLog.info(LABEL, "onReselected tabPosition:" + tab.getPosition());
            }
        });
        showFraction(0);


    }
    private void showFraction(int position){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .replace(ResourceTable.Id_main_fraction, fractions.get(position))
                .submit();
    }

}
