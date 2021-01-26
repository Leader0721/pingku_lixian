package com.example.ckxt_yezhan.bean;

import com.example.ckxt_yezhan.database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.structure.BaseModel;

@QueryModel(database = MyDatabase.class)

public class KucunMXBean extends BaseModel {


    @Column
    private int cangkuid;
    @Column
    private int wuziid;
    @Column
    private String beizhu;
    @Column
    private String wuzimc;



    public int getCangkuid() {
        return cangkuid;
    }

    public void setCangkuid(int cangkuid) {
        this.cangkuid = cangkuid;
    }

    public int getWuziid() {
        return wuziid;
    }

    public void setWuziid(int wuziid) {
        this.wuziid = wuziid;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getWuzimc() {
        return wuzimc;
    }

    public void setWuzimc(String wuzimc) {
        this.wuzimc = wuzimc;
    }
}
