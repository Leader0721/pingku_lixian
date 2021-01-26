package com.example.ckxt_yezhan.ruku.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.base.BaseListAdapter;
import com.example.ckxt_yezhan.ruku.dto.RuKuDMXDto;
import com.example.ckxt_yezhan.utils.StringUtils;

import java.util.List;

public class RuKuDMXAdapter extends BaseListAdapter<RuKuDMXDto> {
    public RuKuDMXAdapter(Context context, List<RuKuDMXDto> list) {
        super(context, list);
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_rukudmx
                    , parent, false);
            holder.tv_wuzimc = (TextView) convertView.findViewById(R.id.tv_wuzimc);
            holder.tv_bianmum = (TextView) convertView.findViewById(R.id.tv_bianmum);
            holder.tv_guigexh = (TextView) convertView.findViewById(R.id.tv_guigexh);

            holder.tv_zhiliangdj = (TextView) convertView.findViewById(R.id.tv_zhiliangdj);
            holder.tv_jihuasl = (TextView) convertView.findViewById(R.id.tv_jihuasl);
            holder.tv_yanshousl = (TextView) convertView.findViewById(R.id.tv_yanshousl);
            holder.tv_shangjiasl = (TextView) convertView.findViewById(R.id.tv_shangjiasl);
            holder.tv_wuzibm = (TextView) convertView.findViewById(R.id.tv_wuzibm);
            holder.tv_jiliangdw = (TextView) convertView.findViewById(R.id.tv_jiliangdw);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RuKuDMXDto bean = list.get(position);

        StringUtils.setVal(holder.tv_wuzimc, bean.getWuzimc() + "");
        StringUtils.setVal(holder.tv_bianmum, bean.getZhengshibmm() + "");
        StringUtils.setVal(holder.tv_guigexh, bean.getGuigexh() + "");
        StringUtils.setVal(holder.tv_zhiliangdj, bean.getZhiliangdj() + "");
        StringUtils.setVal(holder.tv_jihuasl, bean.getJihuarksl() + "");
        StringUtils.setVal(holder.tv_yanshousl, bean.getYiyanshousl() + "");
        StringUtils.setVal(holder.tv_shangjiasl, bean.getYishangjiasl() + "");
        StringUtils.setVal(holder.tv_wuzibm, bean.getWuzibm() + "");
        StringUtils.setVal(holder.tv_jiliangdw, bean.getJiliangdw() + "");
        return convertView;

    }

    class ViewHolder {
        TextView tv_wuzimc;
        TextView tv_bianmum;
        TextView tv_guigexh;
        TextView tv_zhiliangdj;
        TextView tv_jihuasl;
        TextView tv_yanshousl;
        TextView tv_shangjiasl;
        TextView tv_wuzibm;
        TextView tv_jiliangdw;

    }

}
