package com.example.ckxt_yezhan.base.biaozhun;

public enum Jianhuodzt {

    XIN_DAN_DAI_JIAN_HUO("0", "新单待拣货"),
    JIAN_HUO_ZHONG("5", "拣货中"),
    JIAN_HUO_WAN_CHENG("10", "拣货完成");

    private String value;
    private String label;

    Jianhuodzt(String value, String label) {
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
