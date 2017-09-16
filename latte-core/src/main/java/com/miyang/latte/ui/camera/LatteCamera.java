package com.miyang.latte.ui.camera;

import android.net.Uri;

import com.miyang.latte.delegates.PermissionCheckerDelegate;
import com.miyang.latte.util.file.FileUtil;

/**
 * Created by 刘合鹏
 * 照相机调用类
 */

public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}
