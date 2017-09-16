package com.miyang.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.miyang.latte.delegates.LatteDelegate;
import com.miyang.latte.delegates.bottom.BottomItemDelegate;
import com.miyang.latte.ec.R;
import com.miyang.latte.ec.R2;
import com.miyang.latte.ec.main.personal.list.ListAdapter;
import com.miyang.latte.ec.main.personal.list.ListBean;
import com.miyang.latte.ec.main.personal.list.ListItemType;
import com.miyang.latte.ec.main.personal.uploadimg.UploadImageView;
import com.miyang.latte.net.RestClient;
import com.miyang.latte.net.callback.IError;
import com.miyang.latte.net.callback.IFailure;
import com.miyang.latte.net.callback.ISuccess;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by 刘合鹏
 */

public class PersonalDelegate extends BottomItemDelegate {

    private int IsShopActivate = 1;
    private LatteDelegate delegate;

    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRvSettings = null;


    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        //  从缓存取出审核状态进行判断
        if (IsShopActivate == 1) {
            delegate = new UploadImageView();
        } else if (IsShopActivate == 2) {
            delegate = new UploadImageView();
        }
        final ListBean address = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setDelegate(delegate)
                .setText("身份认证")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(address);


        //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvSettings.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRvSettings.setAdapter(adapter);
        mRvSettings.addOnItemTouchListener(new PersonalClickListener(this));
        //testRestClient();
    }

    private void testRestClient() {
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
    }


}
