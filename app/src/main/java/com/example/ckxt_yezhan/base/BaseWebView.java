package com.example.ckxt_yezhan.base;

import android.app.Activity;
import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.ckxt_yezhan.utils.LogUtils;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import androidx.annotation.RequiresApi;


public class BaseWebView {


    private void setSuportH5(AgentWeb agentWeb) {

        WebSettings webSettings = agentWeb.getAgentWebSettings().getWebSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheMaxSize(1024 * 1024 * 8);
        String appCachePath = BaseApplication.getInstance().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);

    }

    /**
     * 获取WebView
     *
     * @param activity
     * @param layout
     * @param mCallback
     * @param mWebChromeClient
     * @param mWebViewClient
     * @param url
     * @return
     */
    public AgentWeb createWebView(Activity activity, LinearLayout layout, ChromeClientCallbackManager.ReceivedTitleCallback mCallback
            , WebChromeClient mWebChromeClient, WebViewClient mWebViewClient, String url) {

        AgentWeb agentWeb = AgentWeb.with(activity)
                .setAgentWebParent(layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .createAgentWeb()
                .ready()
                .go(url);


        agentWeb.getJsInterfaceHolder().addJavaObject(BaseInterface.className, new BaseInterface(agentWeb, activity));
        // setSuportH5(agentWeb);
        return agentWeb;

    }

    /**
     * 获取WebView
     *
     * @param activity
     * @param layout
     * @param mCallback
     * @param url
     * @return
     */
    public AgentWeb createWebView(Activity activity, LinearLayout layout, ChromeClientCallbackManager.ReceivedTitleCallback mCallback, String url) {

        AgentWeb agentWeb = AgentWeb.with(activity)
                .setAgentWebParent(layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setWebViewClient(new BCWebViewClient(url))
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go(url);


        agentWeb.getJsInterfaceHolder().addJavaObject(BaseInterface.className, new BaseInterface(agentWeb, activity));
        //setSuportH5(agentWeb);
        return agentWeb;
    }

    /**
     * 获取WebView
     *
     * @param activity
     * @param layout
     * @param url
     * @return
     */
    public AgentWeb createWebView(Activity activity, LinearLayout layout, UrlClickInterface urlClickInterface, String url) {

        AgentWeb agentWeb = AgentWeb.with(activity)
                .setAgentWebParent(layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setWebViewClient(new BCWebViewClient(url))
                .createAgentWeb()
                .ready()
                .go(url);


        agentWeb.getJsInterfaceHolder().addJavaObject(BaseInterface.className, new BaseInterface(agentWeb, activity));
        this.urlClickInterface = urlClickInterface;
        //setSuportH5(agentWeb);

        return agentWeb;

    }

    /**
     * 获取WebView
     *
     * @param activity
     * @param layout
     * @param url
     * @return
     */
    public AgentWeb createWebView(Activity activity, LinearLayout layout, String url) {

        AgentWeb agentWeb = AgentWeb.with(activity)
                .setAgentWebParent(layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setWebViewClient(new BCWebViewClient(url))
                .createAgentWeb()
                .ready()
                .go(url);


        agentWeb.getJsInterfaceHolder().addJavaObject(BaseInterface.className, new BaseInterface(agentWeb, activity));
        //setSuportH5(agentWeb);

        return agentWeb;

    }


    /**
     * 显示WebView加载情况
     */
    UrlClickInterface urlClickInterface;

    class BCWebViewClient extends WebViewClient {

        private String url = "";

        public BCWebViewClient(String url) {
            this.url = url;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);

            LogUtils.e("loadUrl", errorResponse.toString());

            /** 判断发生错误的url是不是我们请求的url,因为有时候请求一个页面，虽然能正常加载，但是依然有很多资源性的错误，都会到这里来 */
            if (request.getUrl().toString().equals(url)) {
                /** 我们请求的地址发生错误，指向404页面，并传递参数 */
                String loadUrl = "file:///android_asset/404.html?" + url;
                LogUtils.e("loadUrl", loadUrl);
                view.loadUrl(loadUrl);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (urlClickInterface != null) {
                urlClickInterface.clickUrl(url);
            } else {
                view.loadUrl(url);
            }
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (urlClickInterface != null) {
                urlClickInterface.pageFinished(url);
            }

        }
    }

    public interface UrlClickInterface {
        public void clickUrl(String url);

        public void pageFinished(String url);
    }

}
