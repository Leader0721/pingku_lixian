package com.example.ckxt_yezhan.base.biaozhun;

public enum ZhiliangdjEnum {
    DAI_FEI_PIN("4", "待废品"),
    KAN_YONG_PIN("2", "堪用品"),
    DAI_XIU_PIN("3", "待修品"),
    DAI_XIU_YI_JI_PIN("31", "待修一级品"),
    KAN_YONG_PIN_ER_JI("22", "堪用品二级"),
    KAN_YONG_PIN_SAN_JI("23", "堪用品三级"),
    KAN_YONG_PIN_YI_JI("21", "堪用品一级"),
    XIN_PIN("1", "新品"),
    DAI_XIU_ER_JI_PIN("32", "待修二级品");

    private String value;
    private String label;

    ZhiliangdjEnum(String value, String label) {
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
