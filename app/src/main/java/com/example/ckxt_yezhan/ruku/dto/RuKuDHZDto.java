package com.example.ckxt_yezhan.ruku.dto;

import com.example.ckxt_yezhan.database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.structure.BaseModel;

@QueryModel(database = MyDatabase.class)
public class RuKuDHZDto extends BaseModel {
    @Column
    private String id_rukudhz;
    @Column
    private String id_rukudhzckxt;
    @Column
    private String rukudh;
    @Column
    private String zhuangtai;
    @Column
    private String rukulx;
    @Column
    private String wuziqf;
    @Column
    private String zhuguandw;
    @Column
    private String cangkuid;
    @Column
    private String yaoqiurksj;
    @Column
    private String diaoboyj;
    @Column
    private String beizhu;
    @Column
    private String kaidanrq;
    @Column
    private String fawudw;
    @Column
    private String fawudwlxr;
    @Column
    private String fawudwlxfs;
    @Column
    private String shouwudw;
    @Column
    private String shouwudwlxr;
    @Column
    private String shouwudwlxfs;
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
    private String wuzizy;
    @Column
    private String diaobosy;
    @Column
    private String rukutzdid;
    @Column
    private String kufangid;
    @Column
    private String kufangmc;
    @Column
    private String wuzizymc;
    @Column
    private String cangkumc;
    @Column
    private String wuziqfmc;
    @Column
    private String rukulxmc;
    @Column
    private String zhuangtaimc;

    public String getId_rukudhzckxt() {
        return id_rukudhzckxt;
    }

    public void setId_rukudhzckxt(String id_rukudhzckxt) {
        this.id_rukudhzckxt = id_rukudhzckxt;
    }

    public String getId_rukudhz() {
        return id_rukudhz;
    }

    public void setId_rukudhz(String id_rukudhz) {
        this.id_rukudhz = id_rukudhz;
    }

    public String getRukudh() {
        return rukudh;
    }

    public void setRukudh(String rukudh) {
        this.rukudh = rukudh;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getRukulx() {
        return rukulx;
    }

    public void setRukulx(String rukulx) {
        this.rukulx = rukulx;
    }

    public String getWuziqf() {
        return wuziqf;
    }

    public void setWuziqf(String wuziqf) {
        this.wuziqf = wuziqf;
    }

    public String getZhuguandw() {
        return zhuguandw;
    }

    public void setZhuguandw(String zhuguandw) {
        this.zhuguandw = zhuguandw;
    }

    public String getCangkuid() {
        return cangkuid;
    }

    public void setCangkuid(String cangkuid) {
        this.cangkuid = cangkuid;
    }

    public String getYaoqiurksj() {
        return yaoqiurksj;
    }

    public void setYaoqiurksj(String yaoqiurksj) {
        this.yaoqiurksj = yaoqiurksj;
    }

    public String getDiaoboyj() {
        return diaoboyj;
    }

    public void setDiaoboyj(String diaoboyj) {
        this.diaoboyj = diaoboyj;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getKaidanrq() {
        return kaidanrq;
    }

    public void setKaidanrq(String kaidanrq) {
        this.kaidanrq = kaidanrq;
    }

    public String getFawudw() {
        return fawudw;
    }

    public void setFawudw(String fawudw) {
        this.fawudw = fawudw;
    }

    public String getFawudwlxr() {
        return fawudwlxr;
    }

    public void setFawudwlxr(String fawudwlxr) {
        this.fawudwlxr = fawudwlxr;
    }

    public String getFawudwlxfs() {
        return fawudwlxfs;
    }

    public void setFawudwlxfs(String fawudwlxfs) {
        this.fawudwlxfs = fawudwlxfs;
    }

    public String getShouwudw() {
        return shouwudw;
    }

    public void setShouwudw(String shouwudw) {
        this.shouwudw = shouwudw;
    }

    public String getShouwudwlxr() {
        return shouwudwlxr;
    }

    public void setShouwudwlxr(String shouwudwlxr) {
        this.shouwudwlxr = shouwudwlxr;
    }

    public String getShouwudwlxfs() {
        return shouwudwlxfs;
    }

    public void setShouwudwlxfs(String shouwudwlxfs) {
        this.shouwudwlxfs = shouwudwlxfs;
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

    public String getWuzizy() {
        return wuzizy;
    }

    public void setWuzizy(String wuzizy) {
        this.wuzizy = wuzizy;
    }

    public String getDiaobosy() {
        return diaobosy;
    }

    public void setDiaobosy(String diaobosy) {
        this.diaobosy = diaobosy;
    }

    public String getRukutzdid() {
        return rukutzdid;
    }

    public void setRukutzdid(String rukutzdid) {
        this.rukutzdid = rukutzdid;
    }

    public String getKufangid() {
        return kufangid;
    }

    public void setKufangid(String kufangid) {
        this.kufangid = kufangid;
    }

    public String getKufangmc() {
        return kufangmc;
    }

    public void setKufangmc(String kufangmc) {
        this.kufangmc = kufangmc;
    }

    public String getWuzizymc() {
        return wuzizymc;
    }

    public void setWuzizymc(String wuzizymc) {
        this.wuzizymc = wuzizymc;
    }

    public String getCangkumc() {
        return cangkumc;
    }

    public void setCangkumc(String cangkumc) {
        this.cangkumc = cangkumc;
    }

    public String getWuziqfmc() {
        return wuziqfmc;
    }

    public void setWuziqfmc(String wuziqfmc) {
        this.wuziqfmc = wuziqfmc;
    }

    public String getRukulxmc() {
        return rukulxmc;
    }

    public void setRukulxmc(String rukulxmc) {
        this.rukulxmc = rukulxmc;
    }

    public String getZhuangtaimc() {
        return zhuangtaimc;
    }

    public void setZhuangtaimc(String zhuangtaimc) {
        this.zhuangtaimc = zhuangtaimc;
    }
}
