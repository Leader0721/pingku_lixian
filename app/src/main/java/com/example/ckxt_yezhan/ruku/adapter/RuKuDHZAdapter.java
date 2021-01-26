package com.example.ckxt_yezhan.ruku.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.base.BaseListAdapter;
import com.example.ckxt_yezhan.ruku.dto.RuKuDHZDto;
import com.example.ckxt_yezhan.utils.StringUtils;
import com.example.ckxt_yezhan.utils.Utils;

import java.util.List;

public class RuKuDHZAdapter extends BaseListAdapter<RuKuDHZDto> {
    public RuKuDHZAdapter(Context context, List<RuKuDHZDto> list) {
        super(context, list);
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_rukud
                    , parent, false);
            holder.tv_rukudh = (TextView) convertView.findViewById(R.id.tv_rukudh);
            holder.tv_kaidanrq = (TextView) convertView.findViewById(R.id.tv_kaidanrq);
            holder.tv_fawudw = (TextView) convertView.findViewById(R.id.tv_fawudw);
            holder.tv_zhuangtai = (TextView) convertView.findViewById(R.id.tv_zhuangtai);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RuKuDHZDto bean = list.get(position);

        StringUtils.setVal(holder.tv_rukudh, bean.getRukudh() + "");
        StringUtils.setVal(holder.tv_kaidanrq, bean.getKaidanrq() + "");
        StringUtils.setVal(holder.tv_fawudw, bean.getFawudw() + "");
        if(bean.getZhuangtai()!=null){
            /*
             YAN_SHOU_ZHONG("6", "验收中"),
    YAN_SHOU_WAN_CHENG("7", "验收完成"),
             */
            switch (bean.getZhuangtai()) {
                case "5":
                    StringUtils.setVal(holder.tv_zhuangtai, "新单待入库");
                    holder.tv_zhuangtai.setTextColor(Utils.getApp().getResources().getColor(R.color.c1c94a3));
                    break;
                case "6":
                    StringUtils.setVal(holder.tv_zhuangtai, "验收中");
                    holder.tv_zhuangtai.setTextColor(Utils.getApp().getResources().getColor(R.color.cf8b551));
                    break;
                case "7":
                    StringUtils.setVal(holder.tv_zhuangtai, "验收完成");
                    holder.tv_zhuangtai.setTextColor(Utils.getApp().getResources().getColor(R.color.cf57f17));
                    break;
                case "10":
                    StringUtils.setVal(holder.tv_zhuangtai, "已下发手持机");
                    holder.tv_zhuangtai.setTextColor(Utils.getApp().getResources().getColor(R.color.cf57f17));
                    break;
                case "15":
                    StringUtils.setVal(holder.tv_zhuangtai, "入库完成");
                    holder.tv_zhuangtai.setTextColor(Utils.getApp().getResources().getColor(R.color.red));
                    break;
                default:
                    StringUtils.setVal(holder.tv_zhuangtai, "单据状态");
                    holder.tv_zhuangtai.setTextColor(Utils.getApp().getResources().getColor(R.color.c353535));
                    break;
            }
        }


        return convertView;

    }

    class ViewHolder {
        TextView tv_rukudh;
        TextView tv_kaidanrq;
        TextView tv_fawudw;
        TextView tv_zhuangtai;
    }

}
