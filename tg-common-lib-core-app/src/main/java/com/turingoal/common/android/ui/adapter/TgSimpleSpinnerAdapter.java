package com.turingoal.common.android.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * spinner适配器
 */
public class TgSimpleSpinnerAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private String[] mStringArray;

    public TgSimpleSpinnerAdapter(final Context context, final String[] stringArray) {
        super(context, android.R.layout.simple_spinner_item, stringArray);
        mContext = context;
        mStringArray = stringArray;
    }

    @Override
    public View getDropDownView(final int position, View convertView, final ViewGroup parent) {
        // 修改Spinner展开后的字体颜色大小
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
        TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setTextColor(Color.parseColor("#615F5F"));
        tv.setText(mStringArray[position]);
        tv.setTextSize(14);
        return convertView;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // 修改Spinner选择后结果的字体颜色大小
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setTextColor(Color.parseColor("#615F5F"));
        tv.setText(mStringArray[position]);
        tv.setTextSize(14);
        return convertView;
    }
}
