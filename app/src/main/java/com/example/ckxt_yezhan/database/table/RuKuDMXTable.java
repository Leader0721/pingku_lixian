package com.example.ckxt_yezhan.database.table;

import com.example.ckxt_yezhan.database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class RuKuDMXTable extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    private int id_rukudmx;
    @Column
    private String id_rukudmxckxt;
    @Column
    private String wuziid;
    @Column
    private String zhiliangdj;
    @Column
    private String shengchanrq;
    @Column
    private String picih;
    @Column
    private float danjia;
    @Column
    private String rukudid;
    @Column
    private String create_user;
    @Column
    private String create_time;
    @Column
    private String modify_user;
    @Column
    private String modify_time;
    @Column
    private String is_delete;
    @Column
    private float jihuarksl;
    @Column
    private float yiyanshousl;
    @Column
    private float yishangjiasl;
    @Column
    private String wuzibm;
    @Column
    private String wuzimc;
    @Column
    private String linshibmm;
    @Column
    private String zhengshibmm;
    @Column
    private String guigexh;
    @Column
    private String jiliangdw;
    @Column
    private String beizhu;
    @Column
    private String cangkuid;
    @Column
    private String wuzizyid;
    @Column
    private String zhiliangdjmc;
    @Column
    private String ckmc;

    public int getId_rukudmx() {
        return id_rukudmx;
    }

    public void setId_rukudmx(int id_rukudmx) {
        this.id_rukudmx = id_rukudmx;
    }

    public String getId_rukudmxckxt() {
        return id_rukudmxckxt;
    }

    public void setId_rukudmxckxt(String id_rukudmxckxt) {
        this.id_rukudmxckxt = id_rukudmxckxt;
    }

    public String getWuziid() {
        return wuziid;
    }

    public void setWuziid(String wuziid) {
        this.wuziid = wuziid;
    }

    public String getZhiliangdj() {
        return zhiliangdj;
    }

    public void setZhiliangdj(String zhiliangdj) {
        this.zhiliangdj = zhiliangdj;
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

    public float getDanjia() {
        return danjia;
    }

    public void setDanjia(float danjia) {
        this.danjia = danjia;
    }

    public String getRukudid() {
        return rukudid;
    }

    public void setRukudid(String rukudid) {
        this.rukudid = rukudid;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public float getJihuarksl() {
        return jihuarksl;
    }

    public void setJihuarksl(float jihuarksl) {
        this.jihuarksl = jihuarksl;
    }

    public float getYiyanshousl() {
        return yiyanshousl;
    }

    public void setYiyanshousl(float yiyanshousl) {
        this.yiyanshousl = yiyanshousl;
    }

    public float getYishangjiasl() {
        return yishangjiasl;
    }

    public void setYishangjiasl(float yishangjiasl) {
        this.yishangjiasl = yishangjiasl;
    }

    public String getWuzibm() {
        return wuzibm;
    }

    public void setWuzibm(String wuzibm) {
        this.wuzibm = wuzibm;
    }

    public String getWuzimc() {
        return wuzimc;
    }

    public void setWuzimc(String wuzimc) {
        this.wuzimc = wuzimc;
    }

    public String getLinshibmm() {
        return linshibmm;
    }

    public void setLinshibmm(String linshibmm) {
        this.linshibmm = linshibmm;
    }

    public String getZhengshibmm() {
        return zhengshibmm;
    }

    public void setZhengshibmm(String zhengshibmm) {
        this.zhengshibmm = zhengshibmm;
    }

    public String getGuigexh() {
        return guigexh;
    }

    public void setGuigexh(String guigexh) {
        this.guigexh = guigexh;
    }

    public String getJiliangdw() {
        return jiliangdw;
    }

    public void setJiliangdw(String jiliangdw) {
        this.jiliangdw = jiliangdw;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getCangkuid() {
        return cangkuid;
    }

    public void setCangkuid(String cangkuid) {
        this.cangkuid = cangkuid;
    }

    public String getWuzizyid() {
        return wuzizyid;
    }

    public void setWuzizyid(String wuzizyid) {
        this.wuzizyid = wuzizyid;
    }

    public String getZhiliangdjmc() {
        return zhiliangdjmc;
    }

    public void setZhiliangdjmc(String zhiliangdjmc) {
        this.zhiliangdjmc = zhiliangdjmc;
    }

    public String getCkmc() {
        return ckmc;
    }

    public void setCkmc(String ckmc) {
        this.ckmc = ckmc;
    }
}
