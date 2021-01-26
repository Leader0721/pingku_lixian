package com.example.ckxt_yezhan.base;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.example.ckxt_yezhan.utils.LogUtils;
import com.just.library.AgentWeb;

import org.simple.eventbus.EventBus;


public class BaseInterface {

    public static final String className = "bc";

    private AgentWeb agent;
    private Context context;

    public BaseInterface(AgentWeb agent, Context context) {
        this.agent = agent;
        this.context = context;
    }


    @JavascriptInterface
    public void showImage() {
        LogUtils.e("rentong", "showImage()");
        BaseEventCustom baseEventCustom = new BaseEventCustom();
        baseEventCustom.setTag(BaseKeys.SHOWIMAGE);
        baseEventCustom.setObj("1");
        EventBus.getDefault().post(baseEventCustom);
    }

    @JavascriptInterface
    public void showBigImage() {
        LogUtils.e("rentong", "showBigImage()" + "===============");
    }
}
