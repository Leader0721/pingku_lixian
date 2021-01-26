package com.example.ckxt_yezhan.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.activity.kunei.WuziScanActivity;
import com.example.ckxt_yezhan.adapter.MainAdapter;
import com.example.ckxt_yezhan.base.BaseActivity;
import com.example.ckxt_yezhan.bean.MainBean;
import com.example.ckxt_yezhan.database.KucunmxTable;
import com.example.ckxt_yezhan.database.MyDatabase;
import com.example.ckxt_yezhan.database.WuziTable;
import com.example.ckxt_yezhan.kucun.activity.KuCunMX;
import com.example.ckxt_yezhan.ruku.activity.RuKuDHZActivity;
import com.example.ckxt_yezhan.utils.ToastUtils;
import com.example.ckxt_yezhan.view.XGridView;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
/*
01\15	1	入库 1
01\16	0.5	出库 0.5
01\17	1	出库 0.5  web导出入库单出库单数据，0.5
01\18	1	"web系统将json导入到数据库0.5 导入json数据解析到app数据库，0.25 ，将app数据库中的数据导出json，0.25"
01\19	1	整体联调

 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private XGridView mGvRuku;
    private XGridView mGvChuku;
    private XGridView mGvKunei;
    private XGridView mGvSetting;

    private MainAdapter mRukuAdapter;
    private MainAdapter mChukuAdapter;
    private MainAdapter mKuneiAdapter;
    private MainAdapter mSettingAdapter;

    private List<MainBean> mRukuBeanList;
    private List<MainBean> mChukuBeanList;
    private List<MainBean> mKuneiBeanList;
    private List<MainBean> mSettingBeanList;
    private long mExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试程序
//        KucunmxTable kucunmxTable=new KucunmxTable();
//        kucunmxTable.setCangkuid(1);
//        kucunmxTable.setBeizhu("dddd");
//        kucunmxTable.setWuziid(1);
//        kucunmxTable.insert();
//
//        WuziTable wuziTable=new WuziTable();
//        wuziTable.setId2(1);
//        wuziTable.setWuzimc("物资名称");
//        wuziTable.insert();

        class OnSuccess implements Transaction.Success {
            @Override
            public void onSuccess(Transaction transaction) {
                // Log.d(DB, "成功");
                initView();
            }
        }

        class OnError implements Transaction.Error {
            @Override
            public void onError(Transaction transaction, Throwable error) {
                // Log.d(DB, "失败");
                initView();
            }
        }
        DatabaseDefinition database = FlowManager.getDatabase(MyDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                        KucunmxTable kucunmxTable=new KucunmxTable();
        kucunmxTable.setCangkuid(1);
        kucunmxTable.setBeizhu("dddd");
        kucunmxTable.setWuziid(1);
        kucunmxTable.insert();

        WuziTable wuziTable=new WuziTable();
        wuziTable.setId_wuzi(1);
        wuziTable.setWuzimc("物资名称");
        wuziTable.insert();
            }
        }).success(new OnSuccess()).error(new OnError()).build();
        transaction.execute();

        initView();

    }

    private void initView() {
        mGvRuku = findViewById(R.id.gv_ruku);
        mGvChuku = findViewById(R.id.gv_chuku);
        mGvKunei = findViewById(R.id.gv_kunei);
        mGvSetting = findViewById(R.id.gv_setting);

        mRukuBeanList = new ArrayList<>();
        MainBean rukuOne = new MainBean("验收", "0");
        MainBean rukuTwo = new MainBean("上架", "1");
        mRukuBeanList.add(rukuOne);
        mRukuBeanList.add(rukuTwo);
        mRukuAdapter = new MainAdapter(this, mRukuBeanList);
        mGvRuku.setAdapter(mRukuAdapter);
        mGvRuku.setOnItemClickListener(this);

        mChukuBeanList = new ArrayList<>();
        MainBean chukuOne = new MainBean("拣货", "10");
        mChukuBeanList.add(chukuOne);
        mChukuAdapter = new MainAdapter(this, mChukuBeanList);
        mGvChuku.setAdapter(mChukuAdapter);
        mGvChuku.setOnItemClickListener(this);

        mKuneiBeanList = new ArrayList<>();
        MainBean kuneiOne = new MainBean("库存明细", "20");
        MainBean kuneiTwo = new MainBean("库存汇总", "21");
        MainBean kuneiThree = new MainBean("翻堆倒垛", "22");
        MainBean kuneiFour = new MainBean("库存盘点", "23");
        MainBean kuneiFive = new MainBean("物资扫描", "24");
        mKuneiBeanList.add(kuneiOne);
        mKuneiBeanList.add(kuneiTwo);
        mKuneiBeanList.add(kuneiThree);
        mKuneiBeanList.add(kuneiFour);
        mKuneiBeanList.add(kuneiFive);
        mKuneiAdapter = new MainAdapter(this, mKuneiBeanList);
        mGvKunei.setAdapter(mKuneiAdapter);
        mGvKunei.setOnItemClickListener(this);

        mSettingBeanList = new ArrayList<>();
        MainBean settingOne = new MainBean("设置服务器", "30");
        MainBean settingTwo = new MainBean("选择库房", "31");
        mSettingBeanList.add(settingOne);
        mSettingBeanList.add(settingTwo);
        mSettingAdapter = new MainAdapter(this, mSettingBeanList);
        mGvSetting.setAdapter(mSettingAdapter);
        mGvSetting.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
        switch (view.getId()) {
            case R.id.gv_ruku:
                switch (i) {
                    case 0:
                        openActivity(RuKuDHZActivity.class, null);
                        break;
                    case 1:

                        break;
                    case 2:
                        break;
                    default:

                        break;
                }
                break;
            case R.id.gv_chuku:
                switch (i) {
                    case 0:

                        break;
                    case 1:

                        break;
                    default:

                        break;
                }
                break;
            case R.id.gv_kunei:
                switch (i) {
                    case 0:
                        openActivity(KuCunMX.class, null);
                        break;
                    case 1:
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        openActivity(WuziScanActivity.class, null);
                        break;
                    default:

                        break;
                }
                break;
            case R.id.gv_setting:
                switch (i) {
                    case 0:
                        break;
                    case 1:

                        break;
                    default:
                        break;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    //按两次返回键退出
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                ToastUtils.show("再按一次退出");
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;//返回true，不会继续调用onBackPressed
        }
        return false;
    }

}
