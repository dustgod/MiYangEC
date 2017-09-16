package com.miyang.latte.ec.main.personal.uploadimg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.miyang.latte.delegates.BaseDelegate;
import com.miyang.latte.delegates.LatteDelegate;
import com.miyang.latte.ec.R;
import com.miyang.latte.ec.R2;
import com.miyang.latte.net.RestClient;
import com.miyang.latte.net.callback.IError;
import com.miyang.latte.net.callback.IFailure;
import com.miyang.latte.net.callback.ISuccess;

import butterknife.OnClick;

/**
 * Created by 刘合鹏 on 2017/9/14.
 */

public class UploadImageView extends LatteDelegate {
    @OnClick(R2.id.img_upload_front)
    void onClickFrontBtn() {//正面图片
        try {
            RestClient.builder().url("Login")
                    .params("MemberloginID", "c0000118").
                    params("PWD", "111111")
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                        }
                    }).failure(new IFailure() {
                @Override
                public void onFailure() {

                }
            }).error(new IError() {
                @Override
                public void onError(int code, String msg) {
                }
            }).build().get();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @OnClick(R2.id.img_upload_opposite)
    void onClickOppositeBtn() {//反面图片
new Thread(){
    @Override
    public void run() {
        RestClient.builder().url("http://www.myhz168.cn/Service/MobileService.asmx/Login")
                .params("MemberloginID", "c0000118").
                params("PWD", "111111")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {
            }
        }).build().get();
    }
}.start();
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_uploadimage;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

}
