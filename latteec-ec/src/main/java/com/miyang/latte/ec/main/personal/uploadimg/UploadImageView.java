package com.miyang.latte.ec.main.personal.uploadimg;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.miyang.latte.delegates.BaseDelegate;
import com.miyang.latte.delegates.LatteDelegate;
import com.miyang.latte.ec.R;
import com.miyang.latte.ec.R2;
import com.miyang.latte.net.RestClient;
import com.miyang.latte.net.callback.IError;
import com.miyang.latte.net.callback.IFailure;
import com.miyang.latte.net.callback.ISuccess;
import com.miyang.latte.ui.camera.LatteCamera;
import com.miyang.latte.ui.camera.RequestCodes;
import com.miyang.latte.util.callback.CallbackManager;
import com.miyang.latte.util.callback.CallbackType;
import com.miyang.latte.util.callback.IGlobalCallback;
import com.miyang.latte.util.file.FileUtil;
import com.miyang.latte.util.log.LatteLogger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 刘合鹏 on 2017/9/14.
 */

public class UploadImageView extends LatteDelegate {

    private static  final int IMG_FRONT=1;
    private static  final int IMG_OPPOSITE=2;


    @BindView(R2.id.img_upload_front)
    ImageView frontImg=null;

    @BindView(R2.id.img_upload_opposite)
    ImageView oppositeImg=null;

    @BindView(R2.id.btn_upload_front)
    ImageView btn_upload_front=null;

    @BindView(R2.id.btn_upload_opposite)
    ImageView btn_upload_opposite=null;

    @BindView(R2.id.tv_upload_front)
    TextView tv_upload_front=null;

    @BindView(R2.id.tv_upload_opposite)
    TextView tv_upload_opposite=null;


    @OnClick(R2.id.btn_upload_front)
    void onClickFrontBtn() {//正面图片
        CallbackManager.getInstance().addCallback(CallbackType.ON_CROP, new IGlobalCallback<Uri>() {
            @Override
            public void executeCallback(Uri args) {
               if(frontImg!=null){
                   Glide.with(UploadImageView.this).load(args).into(frontImg);
               }
                btn_upload_front.setVisibility(View.GONE);
                tv_upload_front.setVisibility(View.GONE);
                try {
                    Bitmap bitmap = BitmapFactory.decodeFile(args.getPath());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                String imgBase64=    Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);
                    RestClient.builder().url("UploadFile").params("fs",imgBase64).params("fileName","123.jpg").params("memloginid","c0000118").params("token","75odSuBLe6eEsvce3I2ex905FzW+OLTisWFcsEqzY77TIo0H0KtNJQ==").success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                        }
                    }).build().post();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        this.startCameraWithCheck();
    }
    @OnClick(R2.id.btn_upload_opposite)
    void onClickOppositeBtn() {//反面图片
        CallbackManager.getInstance().addCallback(CallbackType.ON_CROP, new IGlobalCallback<Uri>() {
            @Override
            public void executeCallback(Uri args) {
                if(frontImg!=null){
                    Glide.with(UploadImageView.this).load(args).into(oppositeImg);
                }

                btn_upload_opposite.setVisibility(View.GONE);
                tv_upload_opposite.setVisibility(View.GONE);
                try {
                    Bitmap bitmap = BitmapFactory.decodeFile(args.getPath());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                    String imgBase64=    Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);
                    RestClient.builder().url("UploadFile").params("fs",imgBase64).params("fileName","123.jpg").params("memloginid","c0000118").params("token","75odSuBLe6eEsvce3I2ex905FzW+OLTisWFcsEqzY77TIo0H0KtNJQ==").success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                        }
                    }).build().post();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
       this.startCameraWithCheck();
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_uploadimage;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            switch (requestCode){
                case RequestCodes.TAKE_PHOTO:

                    break;
                case RequestCodes.PICK_PHOTO:
                    break;
                default:
                    break;
            }
        }


    }
}
