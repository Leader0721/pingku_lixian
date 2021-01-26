package com.example.ckxt_yezhan.base.biaozhun;

public enum Shangjiadzt {

    XIN_DAN("0", "新单未上架"),
    YI_FA_SONG_WCS("3", "已发送WCS"),
    SHANG_JIA_WAN_CHENG("5", "上架完成");

    private String value;
    private String label;

    Shangjiadzt(String value, String label) {
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
