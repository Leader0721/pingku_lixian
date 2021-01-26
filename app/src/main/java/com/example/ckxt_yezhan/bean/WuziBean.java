package com.example.ckxt_yezhan.bean;

public class WuziBean {
    private String wuzimc;
    private String zhengshibmm;
    private String guigexh;
    private String shuliang;

    public String getWuzimc() {
        return wuzimc;
    }

    public void setWuzimc(String wuzimc) {
        this.wuzimc = wuzimc;
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

    public String getShuliang() {
        return shuliang;
    }

    public void setShuliang(String shuliang) {
        this.shuliang = shuliang;
    }

    @Override
    public String toString() {
        return "WuziBean{" +
                "wuzimc='" + wuzimc + '\'' +
                ", zhengshibmm='" + zhengshibmm + '\'' +
                ", guigexh='" + guigexh + '\'' +
                ", shuliang='" + shuliang + '\'' +
                '}';
    }
}
