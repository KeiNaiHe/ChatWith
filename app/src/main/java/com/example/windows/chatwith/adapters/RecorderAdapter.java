package com.example.windows.chatwith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.windows.chatwith.R;
import com.example.windows.chatwith.fragments.WXChartFragment;
import com.example.windows.chatwith.utils.PersonInfoUtil;

import java.util.List;

/**
 * Created by Windows on 2018/6/28.
 */

public class RecorderAdapter extends ArrayAdapter<WXChartFragment.Recorder> {
    //item 最小最大值
    private int mMinItemWidth;
    private int mMaxIItemWidth;

    private LayoutInflater mInflater;

    public RecorderAdapter(@NonNull Context context, List<WXChartFragment.Recorder> datas) {
        super(context, -1, datas);
        mInflater = LayoutInflater.from(context);

        //获取屏幕宽度
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        //item 设定最小最大值
        mMaxIItemWidth = (int) (outMetrics.widthPixels * 0.7f);
        mMinItemWidth = (int) (outMetrics.widthPixels * 0.15f);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_recorder, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.id_icon);
            holder.seconds = convertView.findViewById(R.id.id_recorder_time);
            holder.length = convertView.findViewById(R.id.id_recorder_length);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(getContext())
                .load(PersonInfoUtil.getHeadPortrait())
                .apply(new RequestOptions().centerCrop())
                .into(holder.icon);
        //设置时间  matt.round 四舍五入
        holder.seconds.setText(Math.round(getItem(position).getTime()) + "\"");
        //设置背景的宽度
        ViewGroup.LayoutParams lp = holder.length.getLayoutParams();
        //getItem(position).time
        lp.width = (int) (mMinItemWidth + (mMaxIItemWidth / 60f * getItem(position).getTime()));

        return convertView;
    }

    private class ViewHolder {
        TextView seconds;
        View length;
        ImageView icon;
    }
}
