package com.example.ckxt_yezhan.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.ckxt_yezhan.view.ProgressDialog;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;

public class BaseActivity extends Activity {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public static final String ARG_PARAM3 = "param3";
    public static final String ARG_PARAM4 = "param4";
    public static final String ARG_PARAM5 = "param5";
    public static final String ARG_PARAM6 = "param6";
    public static final String ARG_PARAM7 = "param7";
    public static final String ARG_PARAM8 = "param8";
    protected String TAG = this.getClass().getSimpleName();
    public static ArrayList<Activity> activityList = new ArrayList<Activity>();
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        EventBus.getDefault().register(this);
        activityList.add(this);
    }

    /**
     * 启动一个Activity
     *
     * @param pClass
     * @param pBundle
     */
    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
//        overridePendingTransition(R.anim.slide_top_show, R.anim.slide_top_hide);
        overridePendingTransition(0, 0);
    }

    protected void openActivityForResult(Class<?> pClass, Bundle pBundle, int pRequestCode) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivityForResult(intent, pRequestCode);
    }

    /**
     * 显示等待框
     */
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        if (!progressDialog.isShow()) {
            progressDialog.show();
        }
    }

    /**
     * 显示等待框是否可以消失
     */
    public void setProgressCancelable(boolean cancelable) {
        if (null != progressDialog) {
            progressDialog.setCancelable(cancelable);
        }
    }

    /**
     * 隐藏等待框
     */
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.cancelImmediately();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgress();
        activityList.remove(this);
    }

}
