package com.example.ckxt_yezhan.base.biaozhun;

public enum Chukudzt {

    XIN_DAN_DAI_CHU_KU("5", "新单待出库"),
    BU_FEN_CHU_KU("7", "部分出库"),
    YI_XIA_FA_SHOU_CHI_JI("10", "已下发手持机"),
    YI_SHENG_CHENG_JIAN_HUO_DAN("12", "已生成拣货单"),
    JIAN_HUO_WAN_CHENG("13", "拣货完成"),
    CHU_KU_WAN_CHENG("15", "出库完成");

    private String value;
    private String label;

    Chukudzt(String value, String label) {
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
