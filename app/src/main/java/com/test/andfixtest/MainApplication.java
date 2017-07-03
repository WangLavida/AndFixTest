package com.test.andfixtest;

import android.app.Application;
import android.content.pm.PackageManager;

import com.alipay.euler.andfix.patch.PatchManager;
import com.lzy.okgo.OkGo;

/**
 * Created by W.J on 2017/7/3.
 */

public class MainApplication extends Application {
    public static PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
        // 初始化patch管理类
        patchManager = new PatchManager(this);
//       初始化patch版本
        try {
            patchManager.init((getPackageManager().getPackageInfo(getPackageName(), 0)).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        // 加载已经添加到PatchManager中的patch
        patchManager.loadPatch();
    }
}
