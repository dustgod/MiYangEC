package com.miyang.latte.ec.launcher;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.miyang.latte.delegates.LatteDelegate;
import com.miyang.latte.ec.R;
import com.miyang.latte.ec.R2;
import com.miyang.latte.ec.main.EcBottomDelegate;
import com.miyang.latte.util.timer.BaseTimerTask;
import com.miyang.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 刘合鹏 on 2017/9/6 0006.
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    private Timer mTimer = null;
    private int mCount = 5;


    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
//        getSupportDelegate().startWithPop(new EcBottomDelegate());
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            getSupportDelegate().start(new EcBottomDelegate(), SINGLETASK);
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);

    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            getSupportDelegate().start(new EcBottomDelegate(), SINGLETASK);
                        }
                    }
                }
            }
        });
    }
}
