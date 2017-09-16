package com.miyang.latte.util.callback;

import android.support.annotation.Nullable;

/**
 * Created by 刘合鹏
 */

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);
}
