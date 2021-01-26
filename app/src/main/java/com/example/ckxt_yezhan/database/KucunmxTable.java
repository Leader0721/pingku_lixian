package com.example.ckxt_yezhan.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class KucunmxTable extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    private int id;
    @Column
    private int kufangid;
    @Column
    private int cangkuid;
    @Column
    private int zhiliangdj;
    @Column

    private int wuziid;
    @Column
    private String shengchanrq;
    @Column
    private String picih;
    @Column
    private String shengchancj;
    @Column
    private int huoweiid;
    @Column
    private String biaozhundwsl;
    @Column
    private String danjia;
    @Column
    private String jine;
    @Column
    private String baozhiq;
    @Column
    private String beizhu;
    @Column
    private int wuziqf;
    @Column
    private String weihubyrq;
    @Column
    private String baoyangzq;
    @Column
    private int tuopanid;
    @Column
    private String guoqisj;
    @Column
    private String xulieh;
    @Column
    private String baozhuangdysl;
    @Column
    private String baozhuangdyzdgwzsl;
    @Column
    private int zhuguandwid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKufangid() {
        return kufangid;
    }

    public void setKufangid(int kufangid) {
        this.kufangid = kufangid;
    }

    public int getCangkuid() {
        return cangkuid;
    }

    public void setCangkuid(int cangkuid) {
        this.cangkuid = cangkuid;
    }

    public int getZhiliangdj() {
        return zhiliangdj;
    }

    public void setZhiliangdj(int zhiliangdj) {
        this.zhiliangdj = zhiliangdj;
    }

    public int getWuziid() {
        return wuziid;
    }

    public void setWuziid(int wuziid) {
        this.wuziid = wuziid;
    }

    public String getShengchanrq() {
        return shengchanrq;
    }

    public void setShengchanrq(String shengchanrq) {
        this.shengchanrq = shengchanrq;
    }

    public String getPicih() {
        return picih;
    }

    public void setPicih(String picih) {
        this.picih = picih;
    }

    public String getShengchancj() {
        return shengchancj;
    }

    public void setShengchancj(String shengchancj) {
        this.shengchancj = shengchancj;
    }

    public int getHuoweiid() {
        return huoweiid;
    }

    public void setHuoweiid(int huoweiid) {
        this.huoweiid = huoweiid;
    }

    public String getBiaozhundwsl() {
        return biaozhundwsl;
    }

    public void setBiaozhundwsl(String biaozhundwsl) {
        this.biaozhundwsl = biaozhundwsl;
    }

    public String getDanjia() {
        return danjia;
    }

    public void setDanjia(String danjia) {
        this.danjia = danjia;
    }

    public String getJine() {
        return jine;
    }

    public void setJine(String jine) {
        this.jine = jine;
    }

    public String getBaozhiq() {
        return baozhiq;
    }

    public void setBaozhiq(String baozhiq) {
        this.baozhiq = baozhiq;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public int getWuziqf() {
        return wuziqf;
    }

    public void setWuziqf(int wuziqf) {
        this.wuziqf = wuziqf;
    }

    public String getWeihubyrq() {
        return weihubyrq;
    }

    public void setWeihubyrq(String weihubyrq) {
        this.weihubyrq = weihubyrq;
    }

    public String getBaoyangzq() {
        return baoyangzq;
    }

    public void setBaoyangzq(String baoyangzq) {
        this.baoyangzq = baoyangzq;
    }

    public int getTuopanid() {
        return tuopanid;
    }

    public void setTuopanid(int tuopanid) {
        this.tuopanid = tuopanid;
    }

    public String getGuoqisj() {
        return guoqisj;
    }

    public void setGuoqisj(String guoqisj) {
        this.guoqisj = guoqisj;
    }

    public String getXulieh() {
        return xulieh;
    }

    public void setXulieh(String xulieh) {
        this.xulieh = xulieh;
    }

    public String getBaozhuangdysl() {
        return baozhuangdysl;
    }

    public void setBaozhuangdysl(String baozhuangdysl) {
        this.baozhuangdysl = baozhuangdysl;
    }

    public String getBaozhuangdyzdgwzsl() {
        return baozhuangdyzdgwzsl;
    }

    public void setBaozhuangdyzdgwzsl(String baozhuangdyzdgwzsl) {
        this.baozhuangdyzdgwzsl = baozhuangdyzdgwzsl;
    }

    public int getZhuguandwid() {
        return zhuguandwid;
    }

    public void setZhuguandwid(int zhuguandwid) {
        this.zhuguandwid = zhuguandwid;
    }
}
