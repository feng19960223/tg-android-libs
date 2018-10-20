package com.turingoal.common.android.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import libs.android.turingoal.com.tg_common_lib_core_app.R;


/**
 * 设置title和context的LinearLayout
 */
public class TgNumAddSubLinearLayout extends LinearLayout implements View.OnClickListener {
    private ImageView ivSub;
    private TextView tvNum;
    private ImageView ivAdd;
    private int minNumber = 1; // 最小值
    private int maxNumber = Integer.MAX_VALUE; // 最大值
    private int number = minNumber; // 当前的数字为1

    public TgNumAddSubLinearLayout(Context context) {
        this(context, null, 0);
    }

    public TgNumAddSubLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TgNumAddSubLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.tg_common_number_add_sub_view, this);
        ivSub = findViewById(R.id.tg_common_number_add_sub_view_ivSub);
        tvNum = findViewById(R.id.tg_common_number_add_sub_view_tvNum);
        ivAdd = findViewById(R.id.tg_common_number_add_sub_view_ivAdd);
        ivSub.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        setNumber(minNumber);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.tg_common_number_add_sub_view_ivSub) {
            if (number > minNumber) {
                setNumber(number - 1);
            }
        } else if (i == R.id.tg_common_number_add_sub_view_ivAdd) {
            if (number < maxNumber) {
                setNumber(number + 1);
            }

        }
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
        setNumber(number);
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        setNumber(number);
    }

    public TextView getTvNum() {
        return tvNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < minNumber) {
            this.number = minNumber;
        } else if (number > maxNumber) {
            this.number = maxNumber;
        } else {
            this.number = number;
        }
        if (this.number == minNumber) { // 小于最小值
            ivSub.setImageResource(R.drawable.tg_common_ic_sub_gray_24dp); // 灰色减号
            ivAdd.setImageResource(R.drawable.tg_common_ic_add_black_24dp); // 黑色加号
        } else if (this.number == maxNumber) { // 大鱼最大值
            ivSub.setImageResource(R.drawable.tg_common_ic_sub_black_24dp); // 黑色减号
            ivAdd.setImageResource(R.drawable.tg_common_ic_add_gray_24dp); // 灰色加号
        } else {
            ivSub.setImageResource(R.drawable.tg_common_ic_sub_black_24dp); // 黑色减号
            ivAdd.setImageResource(R.drawable.tg_common_ic_add_black_24dp); // 黑色加号
        }
        tvNum.setText("" + this.number);
        if (numCallback != null) {
            numCallback.NumChange(this.number);
        }
    }

    public void setNumCallback(NumCallback numCallback) {
        this.numCallback = numCallback;
    }

    private NumCallback numCallback;

    public interface NumCallback {
        void NumChange(int num);
    }
}
