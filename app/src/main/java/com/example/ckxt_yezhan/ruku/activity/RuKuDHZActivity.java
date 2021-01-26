package com.example.ckxt_yezhan.ruku.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.base.BaseActivity;
import com.example.ckxt_yezhan.base.biaozhun.Rukudzt;
import com.example.ckxt_yezhan.ruku.adapter.RuKuDHZAdapter;
import com.example.ckxt_yezhan.ruku.dao.RuKuDHZDao;
import com.example.ckxt_yezhan.ruku.dao.RuKuDMXDao;
import com.example.ckxt_yezhan.ruku.dto.RuKuDHZDto;
import com.example.ckxt_yezhan.ruku.dto.RuKuDMXDto;
import com.example.ckxt_yezhan.ruku.query.RuKuDHZQueryInfo;
import com.example.ckxt_yezhan.ruku.query.RuKuDMXQueryInfo;

import java.util.List;

public class RuKuDHZActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ImageView mIvBack;
    private ListView mLvContent;

    private RelativeLayout rl_top;
    private RuKuDHZAdapter mRuKuDHZAdapter;
    private PopupWindow mPopupBottom;
    List<RuKuDHZDto> RuKuDHZDtoList;
    private LinearLayout mLlContent;
    private RuKuDHZDto mRuKuDHZDto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_ku_dhz);
        initView();

        initListView();
    }
    private void initView() {
        // mCangkuid = (String) SpUtils.get(BaseKeys.CANGKUID, "");
        mIvBack = findViewById(R.id.iv_back);
        mLvContent = findViewById(R.id.lv_content);

        mIvBack.setOnClickListener(this);
        rl_top=findViewById(R.id.rl_top);
        mLlContent = findViewById(R.id.ll_content);
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
        mRuKuDHZDto= RuKuDHZDtoList.get(i);
        popupBottom();

    }
    private void initListView() {
        RuKuDHZDao ruKuDHZDao=new RuKuDHZDao(RuKuDHZActivity.this);
        RuKuDHZDtoList=ruKuDHZDao.queryRuKuDHZ();

        mRuKuDHZAdapter = new RuKuDHZAdapter(this, RuKuDHZDtoList);
        mLvContent.setAdapter(mRuKuDHZAdapter);
        mLvContent.setOnItemClickListener(this);
    }
    private void popupBottom() {
        View view = LayoutInflater.from(this).inflate(R.layout.popup_rukuysd, null, false);
        mPopupBottom = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tvDanpinys = view.findViewById(R.id.tv_danpinys);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);

        tvDanpinys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupBottom.dismiss();


                Bundle bundle = new Bundle();
                bundle.putString("id_rukudhzckxt", mRuKuDHZDto.getId_rukudhzckxt());
                bundle.putString("rukudh", mRuKuDHZDto.getRukudh());
                openActivity(RuKuDMXActivity.class, bundle);
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupBottom.dismiss();
            }
        });


        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.7f;
        this.getWindow().setAttributes(lp);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mPopupBottom.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            }
        });
        mPopupBottom.setAnimationStyle(R.style.PopupBottomStyle);
        mPopupBottom.setFocusable(true);
        mPopupBottom.setOutsideTouchable(false);
        mPopupBottom.setBackgroundDrawable(new BitmapDrawable());
        mPopupBottom.getContentView().setFocusable(true); // 这个很重要
        mPopupBottom.getContentView().setFocusableInTouchMode(true);
        mPopupBottom.showAtLocation(rl_top, Gravity.BOTTOM, 0, 0);
    }

   @Override
    protected void onRestart() {
        super.onRestart();
      //判断所有入库明细验收，如果全部验收完成修改入库单状态
       RuKuDMXDao ruKuDMXDao=new RuKuDMXDao(RuKuDHZActivity.this);
       RuKuDMXQueryInfo ruKuDMXQueryInfo=new RuKuDMXQueryInfo();
       ruKuDMXQueryInfo.setId_rukudhzckxt(mRuKuDHZDto.getId_rukudhzckxt());
       List<RuKuDMXDto> ruKuDMXDtoList=ruKuDMXDao.queryRuKuDMX(ruKuDMXQueryInfo);
       int yanshouflag=0;
       int shangjiaflag=0;
       for(int i=0;i<ruKuDMXDtoList.size();i++){
           RuKuDMXDto ruKuDMXDto=ruKuDMXDtoList.get(i);
           float jihuarksl=ruKuDMXDto.getJihuarksl();
           float yiyanshousj=ruKuDMXDto.getYiyanshousl();
           float yishangjiasl=ruKuDMXDto.getYishangjiasl();
           if(yiyanshousj<jihuarksl){
               yanshouflag=1;

           }
           if(yiyanshousj==jihuarksl&&yishangjiasl<jihuarksl){
               shangjiaflag=1;
           }

       }
       if(ruKuDMXDtoList.size()>0){
           if(yanshouflag==0){
               //验收完成
               RuKuDHZDao ruKuDHZDao=new RuKuDHZDao(RuKuDHZActivity.this);
               RuKuDHZQueryInfo ruKuDHZQueryInfo=new RuKuDHZQueryInfo();
               ruKuDHZQueryInfo.setZhuangtai(Rukudzt.YAN_SHOU_WAN_CHENG.getValue());
               ruKuDHZQueryInfo.setId_rukudhzckxt(mRuKuDHZDto.getId_rukudhzckxt());
               ruKuDHZDao.updateZhuangTai(ruKuDHZQueryInfo);
               initListView();
               if(shangjiaflag==0){
                   //入库完成
                   initListView();
               }
           }else{
               //验收中
                RuKuDHZDao ruKuDHZDao=new RuKuDHZDao(RuKuDHZActivity.this);
                RuKuDHZQueryInfo ruKuDHZQueryInfo=new RuKuDHZQueryInfo();
                ruKuDHZQueryInfo.setZhuangtai(Rukudzt.YAN_SHOU_ZHONG.getValue());
                ruKuDHZQueryInfo.setId_rukudhzckxt(mRuKuDHZDto.getId_rukudhzckxt());
                ruKuDHZDao.updateZhuangTai(ruKuDHZQueryInfo);
               initListView();
           }
       }


    }

}
