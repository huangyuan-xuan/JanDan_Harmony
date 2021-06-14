package com.huangyuanlove.jandan;

import com.huangyuanlove.jandan.slice.NewsDetailAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class NewsDetailAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        addActionRoute("ability.intent.NEWS_DETAIL", NewsDetailAbilitySlice.class.getName());
        super.onStart(intent);
        addActionRoute("ability.intent.NEWS_DETAIL", NewsDetailAbilitySlice.class.getName());
        super.setMainRoute(NewsDetailAbilitySlice.class.getName());
        addActionRoute("ability.intent.NEWS_DETAIL", NewsDetailAbilitySlice.class.getName());
    }
}
