package com.example.ckxt_yezhan.base.biaozhun;

public enum WuziqfEnum {
    ZHAN_CHU("1", "战储"),
    ZHOU_ZHUAN("2", "周转"),
    DAI_CHU("3", "代储"),
    GUO_JIA_CHU_BEI_CHENG_PIN_YOU("4", "国家储备成品油"),
    QI_TA("5", "其他");

    private String value;
    private String label;

    WuziqfEnum(String value, String label) {
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
