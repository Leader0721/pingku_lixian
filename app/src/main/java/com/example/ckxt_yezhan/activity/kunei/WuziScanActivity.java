package com.example.ckxt_yezhan.activity.kunei;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.base.BaseActivity;
import com.example.ckxt_yezhan.base.BaseKeys;
import com.example.ckxt_yezhan.bean.WuziBean;
import com.example.ckxt_yezhan.utils.BgChangeUtils;
import com.example.ckxt_yezhan.utils.QrDecodeUtils;
import com.example.ckxt_yezhan.utils.ToastUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.zebra.adc.decoder.Barcode2DWithSoft;

import java.util.List;

public class WuziScanActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTvScan;
    private TextView mTvWuzimc;
    private TextView mTvZhengshibmm;
    private TextView mTvGuigexh;
    private ImageView mIvBack;
    public Barcode2DWithSoft mReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuziscan);
        initView();
    }

    private void initView() {
        mTvScan = findViewById(R.id.tv_scan);
        mIvBack = findViewById(R.id.iv_back);
        mTvWuzimc = findViewById(R.id.tv_wuzimc);
        mTvZhengshibmm = findViewById(R.id.tv_bianmum);
        mTvGuigexh = findViewById(R.id.tv_guigexh);

        BgChangeUtils.addTouchDark(mTvScan, false);
        mIvBack.setOnClickListener(this);
        mTvScan.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            mReader = Barcode2DWithSoft.getInstance();
        } catch (Exception ex) {
            ToastUtils.show(ex.getMessage());
            return;
        }
        if (!mReader.isPowerOn())
            new InitTask().execute();
    }

    public Barcode2DWithSoft.ScanCallback mScanCallback = new Barcode2DWithSoft.ScanCallback() {
        @Override
        public void onScanComplete(int i, int length, byte[] data) {
            if (length < 1) {
                return;
            }
            String barCode = "";
            try {
                barCode = new String(data, 0, length, BaseKeys.CODE_UTF_8);
                WuziBean wuziBean = QrDecodeUtils.decode(barCode);
                mTvWuzimc.setText(wuziBean.getWuzimc());
                mTvZhengshibmm.setText(wuziBean.getZhengshibmm());
                mTvGuigexh.setText(wuziBean.getGuigexh());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 设备上电异步类
     *
     * @author
     */
    public class InitTask extends AsyncTask<String, Integer, Boolean> {
        ProgressDialog mypDialog;

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = false;
            if (mReader != null) {
                result = mReader.open(WuziScanActivity.this);
                if (result) {
                    /*
                     * mReader.setParameter(324, 1); mReader.setParameter(300,
                     * 0); // Snapshot Aiming mReader.setParameter(361, 0); //
                     * Image Capture Illumination
                     */
                    mReader.setParameter(1718, 1);
                    mReader.setScanCallback(mScanCallback);
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            mypDialog.cancel();
            if (!result) {
                ToastUtils.show("init fail");
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mypDialog = new ProgressDialog(WuziScanActivity.this);
            mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mypDialog.setMessage("请稍后");
            mypDialog.setCanceledOnTouchOutside(false);
            mypDialog.show();
        }
    }

    @Override
    protected void onDestroy() {
        if (mReader != null) {
            mReader.close();
        }
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 139 || keyCode == 280) {
            if (event.getRepeatCount() == 0) {
                initScan();
            }
        }
        if (keyCode == 4) {
            if (mReader != null) {
                mReader.close();
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_scan:
                initScan();
                break;
        }
    }

    private void initScan() {
        AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        mReader.scan();
                        mReader.setScanCallback(mScanCallback);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(intent);

                        ToastUtils.show("没有权限无法扫描");
                    }
                }).start();
    }

}
