package com.miyang.miyangec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.miyang.latte.delegates.LatteDelegate;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
