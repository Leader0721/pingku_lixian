package com.example.ckxt_yezhan.base;

import android.app.Application;

import com.example.ckxt_yezhan.utils.Utils;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;


public class BaseApplication extends Application {
    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = (BaseApplication) getApplicationContext();
        Utils.init(application);

        //初始化DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        //设置日志显示
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
    }

    public static BaseApplication getInstance() {
        return application;
    }

}
