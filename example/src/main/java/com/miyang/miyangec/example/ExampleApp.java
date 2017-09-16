package com.miyang.miyangec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.miyang.latte.app.Latte;
import com.miyang.latte.net.interceptors.DebugInterceptor;
import com.miyang.latte.net.rx.AddCookieInterceptor;

/**
 * Created by Administrator on 2017/9/4.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       // Latte.init(this).withIcon(new FontAwesomeModule()).withIcon(new FontAwesomeModule()).withApiHost("http://www.myhz168.cn/Service/MobileService.asmx/").withInterceptor(new AddCookieInterceptor()).configure();

        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://www.myhz168.cn/Service/MobileService.asmx/")
                .withInterceptor(new AddCookieInterceptor())
                .configure();
    }
}
