package com.miyang.latte.ec.main.index;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.miyang.latte.delegates.bottom.BottomItemDelegate;
import com.miyang.latte.ec.R;
import com.miyang.latte.net.RestClient;
import com.miyang.latte.net.callback.IError;
import com.miyang.latte.net.callback.IFailure;
import com.miyang.latte.net.callback.ISuccess;

/**
 * Created by 刘合鹏
 */

public class IndexDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }


}
