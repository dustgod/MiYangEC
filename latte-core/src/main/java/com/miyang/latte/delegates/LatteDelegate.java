package com.miyang.latte.delegates;

import com.tsy.sdk.myokhttp.MyOkHttp;

/**
 * Created by 刘合鹏 on 2017/4/2
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

    MyOkHttp mMyOkhttp = new MyOkHttp();
}
