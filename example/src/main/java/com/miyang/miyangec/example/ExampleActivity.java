package com.miyang.miyangec.example;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.miyang.latte.activities.ProxyActivity;
import com.miyang.latte.delegates.LatteDelegate;
import com.miyang.latte.ec.launcher.LauncherDelegate;
import com.miyang.latte.ec.main.EcBottomDelegate;
import com.tsy.sdk.myokhttp.MyOkHttp;

public class ExampleActivity extends ProxyActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
//        return new EcBottomDelegate();
    }


}
