package com.example.ckxt_yezhan.ruku.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.base.BaseActivity;
import com.example.ckxt_yezhan.base.BaseKeys;
import com.example.ckxt_yezhan.bean.WuziBean;
import com.example.ckxt_yezhan.ruku.adapter.RuKuDMXAdapter;
import com.example.ckxt_yezhan.ruku.dao.RuKuDMXDao;
import com.example.ckxt_yezhan.ruku.dto.RuKuDMXDto;
import com.example.ckxt_yezhan.ruku.query.RuKuDMXQueryInfo;
import com.example.ckxt_yezhan.utils.BgChangeUtils;
import com.example.ckxt_yezhan.utils.QrDecodeUtils;
import com.example.ckxt_yezhan.utils.StringUtils;
import com.example.ckxt_yezhan.utils.ToastUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.zebra.adc.decoder.Barcode2DWithSoft;

import java.util.List;

public class RuKuDMXActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ImageView mIvBack;
    private ListView mLvContent;
    private PopupWindow mPopupYanshou;
    private RelativeLayout rl_top;
    private RuKuDMXAdapter mKuDMXAdapter;
    private PopupWindow mPopupBottom;
    List<RuKuDMXDto> mRuKuDMXDtoList;
    private String id_rukudhzckxt;
    public Barcode2DWithSoft mReader;
    private EditText etHuowei;
    private SearchView mSvContent;
    //private List<CommonBean> mWvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_ku_dmx);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id_rukudhzckxt = bundle.getString("id_rukudhzckxt");
        initSearchView();
        initView();
        initListView(null);
    }
    private void initView() {
        // mCangkuid = (String) SpUtils.get(BaseKeys.CANGKUID, "");
        mIvBack = findViewById(R.id.iv_back);
        mLvContent = findViewById(R.id.lv_content);

        mIvBack.setOnClickListener(this);
        rl_top=findViewById(R.id.rl_top);
        rl_top = findViewById(R.id.rl_top);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }
    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
        popupYanshou(i);
    }
    private void initListView(String chaXunTJ) {

        RuKuDMXDao ruKuDMXDao=new RuKuDMXDao(RuKuDMXActivity.this);
        RuKuDMXQueryInfo ruKuDMXQueryInfo =new RuKuDMXQueryInfo();
        ruKuDMXQueryInfo.setChaXunTJ(chaXunTJ);
        ruKuDMXQueryInfo.setId_rukudhzckxt(id_rukudhzckxt);

        mRuKuDMXDtoList=ruKuDMXDao.queryRuKuDMX(ruKuDMXQueryInfo);

       mKuDMXAdapter = new RuKuDMXAdapter(this, mRuKuDMXDtoList);

        mLvContent.setAdapter(mKuDMXAdapter);
        mLvContent.setOnItemClickListener(this);
    }
    private void initSearchView() {
        mSvContent = findViewById(R.id.sv_top);
        //设置搜索框直接展开显示。左侧有放大镜(在搜索框中) 右侧有叉叉 可以关闭搜索框
        mSvContent.setIconified(false);
        //设置搜索框直接展开显示。左侧有放大镜(在搜索框外) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        mSvContent.setIconifiedByDefault(false);
        //设置搜索框直接展开显示。左侧有无放大镜(在搜索框中) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        mSvContent.onActionViewExpanded();
        //设置最大宽度
//        mSvContent.setMaxWidth();
        //设置是否显示搜索框展开时的提交按钮
//        mSvContent.setSubmitButtonEnabled(true);
        //设置输入框提示语
        mSvContent.setQueryHint("请输入物资名称或扫描物资码");
        mSvContent.clearFocus();
        mSvContent.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                initListView(s);

                return false;
            }
        });
    }
    private void popupYanshou(final int position) {
        final RuKuDMXDto ruKuDMXDto = mRuKuDMXDtoList.get(position);
        View view = LayoutInflater.from(this).inflate(R.layout.popup_rukuysdmx, null, false);
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent event) {
                int keyCode=event.getKeyCode();

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
                return onKeyDown(keyCode, event);
            }
        });
        mPopupYanshou = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tvName = view.findViewById(R.id.tv_name);
        final EditText etShuliang = view.findViewById(R.id.et_shuliang);

        TextView tv_wuzibm = view.findViewById(R.id.tv_wuzibm);
        TextView tv_zhengshibmm = view.findViewById(R.id.tv_zhengshibmm);
        TextView tv_guigexh = view.findViewById(R.id.tv_guigexh);
        TextView tv_jiliangdw = view.findViewById(R.id.tv_jiliangdw);

          etHuowei = view.findViewById(R.id.et_huowei);
      //  final WheelView wvContent = view.findViewById(R.id.wv_content);


       // wvContent.setItems(mWvContent);
        //wvContent.setSeletion(0);
        TextView tvShangjia = view.findViewById(R.id.tv_shangjia);
        TextView tvYanshou = view.findViewById(R.id.tv_yanshou);
        BgChangeUtils.addTouchDark(tvShangjia, false);
        BgChangeUtils.addTouchDark(tvYanshou, false);

        tvName.setText(ruKuDMXDto.getWuzimc());
        tv_wuzibm.setText(ruKuDMXDto.getWuzibm());
        tv_zhengshibmm.setText(ruKuDMXDto.getZhengshibmm());
        tv_guigexh.setText(ruKuDMXDto.getGuigexh());
        tv_jiliangdw.setText(ruKuDMXDto.getJiliangdw());

        tvShangjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (StringUtils.isEmpty(etShuliang)) {
                    ToastUtils.show("验收数量不能为空");
                    return;
                }
                if (StringUtils.isEmpty(etHuowei)) {
                    ToastUtils.show("货位不能为空");
                    return;
                }

            }
        });

        tvYanshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (StringUtils.isEmpty(etShuliang)) {
                    ToastUtils.show("验收数量不能为空");
                    return;
                }
                float jihuarksl=ruKuDMXDto.getJihuarksl();
                float yiyanshousj=ruKuDMXDto.getYiyanshousl();
                float yishangjiasl=ruKuDMXDto.getYishangjiasl();
                float dangqianyssl= Float.parseFloat(etShuliang.getText().toString());
                if(dangqianyssl>(jihuarksl-yiyanshousj)){
                    ToastUtils.show("验收数量不能超过待验收数量");
                    return;
                }
                yiyanshousj=yiyanshousj+dangqianyssl;
                //更新数据库，刷新数据

                RuKuDMXDao ruKuDMXDao=new RuKuDMXDao(RuKuDMXActivity.this);
                RuKuDMXQueryInfo ruKuDMXQueryInfo=new RuKuDMXQueryInfo();
                ruKuDMXQueryInfo.setYiyanshousj(yiyanshousj);
                ruKuDMXQueryInfo.setId_rukudmxckxt(ruKuDMXDto.getId_rukudmxckxt());
                //Rukudzt.YAN_SHOU_ZHONG.getValue();
                ruKuDMXDao.updateYiyanshousj(ruKuDMXQueryInfo);


                ToastUtils.show("验收成功");
                initListView(null);
                mPopupYanshou.dismiss();

            }
        });


        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.7f;
        this.getWindow().setAttributes(lp);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mPopupYanshou.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            }
        });
        mPopupYanshou.setAnimationStyle(R.style.PopupBottomStyle);
        mPopupYanshou.setFocusable(true);
        mPopupYanshou.setOutsideTouchable(false);
        mPopupYanshou.setBackgroundDrawable(new BitmapDrawable());
        mPopupYanshou.getContentView().setFocusable(true); // 这个很重要
        mPopupYanshou.getContentView().setFocusableInTouchMode(true);
//        popupWindow.setOutsideTouchable(false);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupYanshou.showAtLocation(rl_top, Gravity.CENTER, 0, -200);
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
                result = mReader.open(RuKuDMXActivity.this);
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
            mypDialog = new ProgressDialog(RuKuDMXActivity.this);
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
                initListView(wuziBean.getWuzimc());
               // ToastUtils.show(barCode);
            } catch (Exception e) {
                //扫描的是货位
                etHuowei.setText(barCode);
                //ToastUtils.show("不是托盘码，请检查");
                e.printStackTrace();
            }
        }
    };

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
