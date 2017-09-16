package com.miyang.latte.ec.main;

import android.graphics.Color;

import com.miyang.latte.delegates.bottom.BaseBottomDelegate;
import com.miyang.latte.delegates.bottom.BottomItemDelegate;
import com.miyang.latte.delegates.bottom.BottomTabBean;
import com.miyang.latte.delegates.bottom.ItemBuilder;
import com.miyang.latte.ec.main.cart.ShopCartDelegate;
import com.miyang.latte.ec.main.discover.DiscoverDelegate;
import com.miyang.latte.ec.main.index.IndexDelegate;
import com.miyang.latte.ec.main.personal.PersonalDelegate;

import java.util.LinkedHashMap;

/**
 * Created by 刘合鹏
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-compass}", "分类"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
