package com.example.ckxt_yezhan.base.biaozhun;

public enum Rukudzt {

    XIN_DAN_DAI_RU_KU("5", "新单待入库"),
    YAN_SHOU_ZHONG("6", "验收中"),
    YAN_SHOU_WAN_CHENG("7", "验收完成"),
    YI_XIA_FA_SHOU_CHI_JI("10", "已下发手持机"),
    RU_KU_WAN_CHENG("15", "入库完成");

    private String value;
    private String label;

    Rukudzt(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return value;
    }

}
