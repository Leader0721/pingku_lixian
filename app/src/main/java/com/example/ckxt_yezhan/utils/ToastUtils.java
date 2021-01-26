package com.example.ckxt_yezhan.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ckxt_yezhan.R;


/**
 * @Description:吐司
 * @Prject:
 * @Package: com.example.pub.utils
 * @author: Edwin
 * @date: 2018/8/15   10:24
 * @Copyright: 个人版权所有
 * @Company:lxt
 * @version: 1.0.0
 */
public class ToastUtils {

    //自定义toast对象
    private static Toast toast;

    /**
     * 自定义短Toast调用
     *
     * @param message 显示文本
     * @return void
     */
    public static void shortToast(final String message) {
        if (!StringUtils.isEmpty(message)) {
            if (null == toast) {
                toast = new Toast(Utils.getApp());
            }
            toast.setDuration(Toast.LENGTH_SHORT);
            View view = ((LayoutInflater) Utils.getApp().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_toast, null);
            TextView textView = (TextView) view.findViewById(R.id.new_data_toast_message);
            textView.setText(message);
            toast.setView(view);
            toast.show();

//        cancel();
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 取消吐司显示
     */
    public static void cancel() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    /**
     * 自定义长Toast调用
     *
     * @param message 显示文本
     * @return void
     */
    public static void longToast(final String message) {
        if (null == toast) {
            toast = new Toast(Utils.getApp());
        }
        toast.setDuration(Toast.LENGTH_LONG);
        View view = ((LayoutInflater) Utils.getApp().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_toast, null);
        TextView textView = (TextView) view.findViewById(R.id.new_data_toast_message);
        textView.setText(message);
        toast.setView(view);
        toast.show();

//        cancel();
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 取消显示Toast
     */
    public static void cancelToast() {
        if (null != toast) {
            toast.cancel();
        }
    }

    /**
     * 默认Toast调用
     *
     * @param message 显示文本
     */
    public static void Toast(final String message) {
        Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 将最长使用的显示方法单独提出来，方便使用。
     * 屏幕中心位置短时间显示Toast。
     *
     * @param message
     */
    public static void show(String message) {
        if (!StringUtils.isEmpty(message)) {
            ToastShortBottomCenter(message);
        }
    }

    /**
     * 屏幕底部中间位置显示短时间Toast
     *
     * @param message
     */
    public static void ToastShortBottomCenter(String message) {
        if (Utils.getApp() != null) {
            Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 屏幕底部左边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortBottomLeft(String message) {
        if (Utils.getApp() != null) {

            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕底部右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortBottomRight(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortCenter(String message) {
        if (Utils.getApp() != null) {

            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心左边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortCenterLeft(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortCenterRight(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部中心位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortTopCenter(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部左边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortTopLeft(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortTopRight(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕底部中间位置显示长时间Toast
     *
     * @param message
     */
    public static void ToastLongBottomCenter(String message) {
        if (Utils.getApp() != null) {
            Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 屏幕底部左边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongBottomLeft(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕底部右边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongBottomRight(String message) {
        if (Utils.getApp() != null) {

            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongCenter(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心左边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongCenterLeft(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastLongCenterRight(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部中心位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongTopCenter(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部左边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongTopLeft(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部右边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongTopRight(String message) {
        if (Utils.getApp() != null) {
            Toast toast = Toast.makeText(Utils.getApp(), message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }
}
