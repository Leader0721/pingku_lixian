package com.example.ckxt_yezhan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ckxt_yezhan.R;
import com.example.ckxt_yezhan.base.BaseListAdapter;
import com.example.ckxt_yezhan.bean.MainBean;

import java.util.List;

public class MainAdapter extends BaseListAdapter<MainBean> {

    public MainAdapter(Context context, List<MainBean> list) {
        super(context, list);
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_gridview_main
                    , parent, false);
            holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MainBean bean = list.get(position);
        holder.tv_name.setText(bean.getName());
        switch (bean.getType()) {
            case "0":
                holder.iv_icon.setImageResource(R.mipmap.download);
                break;
            case "1":
                holder.iv_icon.setImageResource(R.mipmap.download);

                break;
            case "2":
                holder.iv_icon.setImageResource(R.mipmap.download);

                break;
            case "3":
                holder.iv_icon.setImageResource(R.mipmap.download);

                break;
            default:
                holder.iv_icon.setImageResource(R.mipmap.download);
                break;
        }
        return convertView;
    }


    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
    }
}
