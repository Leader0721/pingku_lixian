package com.example.ckxt_yezhan.utils;

import com.example.ckxt_yezhan.bean.WuziBean;
import com.example.ckxt_yezhan.utils.coder.Base64Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QrDecodeUtils {
    public static final byte RS = 30;
    public static final byte _07 = 7;
    public static final byte GS = 29;
    public static final byte A001 = 0;//物资名称
    public static final byte A002 = 1; //编目码
    public static final byte A006 = 5;//规格型号
    public static final byte A051 = 50;//数量
    public static final byte EOT = 4;

    public static WuziBean decode(String base64Str) throws Exception {
        WuziBean wuziBean = new WuziBean();
        byte[] bytes = Base64Util.decode(base64Str);
        List<Integer> gsIndexList = new ArrayList<Integer>();
        if (bytes == null || bytes.length == 0) {
            return null;
        }
//        if (bytes[0]!=30 && bytes[1]!=7){
//            throw new Exception("扫描的是货位码");
//        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == GS) {
                gsIndexList.add(i);
                i++;
            }
        }
        try {
            for (int i = 0; i < gsIndexList.size() - 1; i++) {
                //编目码
                int gsIndex = gsIndexList.get(i);
                int nextGsIndex = gsIndexList.get(i + 1);
                if (bytes[gsIndex + 1] == A002) {
                    byte[] tmp = Arrays.copyOfRange(bytes, gsIndex + 2, nextGsIndex);
                    String zhengshibmm = new String(tmp, "GB18030");
                    wuziBean.setZhengshibmm(zhengshibmm);
                } else if (bytes[gsIndex + 1] == A001) {
                    byte[] tmp = Arrays.copyOfRange(bytes, gsIndex + 2, nextGsIndex);
                    String wuzimc = new String(tmp, "GB18030");
                    wuziBean.setWuzimc(wuzimc);
                } else if (bytes[gsIndex + 1] == A006) {
                    byte[] tmp = Arrays.copyOfRange(bytes, gsIndex + 2, nextGsIndex);
                    String guigexh = new String(tmp, "GB18030");
                    wuziBean.setGuigexh(guigexh);
                } else if (bytes[gsIndex + 1] == A051) {
                    byte[] tmp = Arrays.copyOfRange(bytes, gsIndex + 2, nextGsIndex);
                    String shuliang = new String(tmp, "GB18030");
                    wuziBean.setShuliang(shuliang);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return wuziBean;
    }

}
