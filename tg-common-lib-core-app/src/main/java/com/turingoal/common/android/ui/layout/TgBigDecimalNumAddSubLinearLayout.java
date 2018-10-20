package com.turingoal.common.android.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;

import libs.android.turingoal.com.tg_common_lib_core_app.R;


/**
 * 购物车数量加减的LinearLayout,支持大数操作
 */
public class TgBigDecimalNumAddSubLinearLayout extends LinearLayout implements View.OnClickListener {
    private ImageView ivSub;
    private TextView tvNum;
    private ImageView ivAdd;
    private BigDecimal minNumber = BigDecimal.valueOf(0); // 最小值，小于等于最小值，减号会变灰色
    private BigDecimal maxNumber = BigDecimal.valueOf(Double.MAX_VALUE); // 最大值，大鱼等于最大值，加号会变灰色
    private BigDecimal unitNumber = BigDecimal.valueOf(1); // 左右加减单位
    private BigDecimal number = BigDecimal.valueOf(1); // 当前的数字为1
    private int scale = 2; // 保留几位小数

    public TgBigDecimalNumAddSubLinearLayout(Context context) {
        this(context, null, 0);
    }

    public TgBigDecimalNumAddSubLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TgBigDecimalNumAddSubLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
            if (number.compareTo(minNumber) > 0) {
                setNumber(number.subtract(unitNumber));
            }
        } else if (i == R.id.tg_common_number_add_sub_view_ivAdd) {
            if (number.compareTo(maxNumber) < 0) {
                setNumber(number.add(unitNumber));
            }
        }
    }

    public void setMinNumber(BigDecimal minNumber) {
        this.minNumber = minNumber;
        setNumber(number);
    }

    public void setMinNumber(Long minNumber) {
        this.minNumber = BigDecimal.valueOf(minNumber);
        setNumber(number);
    }

    public void setMaxNumber(BigDecimal maxNumber) {
        this.maxNumber = maxNumber;
        setNumber(number);
    }

    public void setMaxNumber(Long maxNumber) {
        this.maxNumber = BigDecimal.valueOf(maxNumber);
        setNumber(number);
    }

    public void setUnitNumber(BigDecimal unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setUnitNumber(Long unitNumber) {
        this.unitNumber = BigDecimal.valueOf(unitNumber);
    }

    public TextView getTvNum() {
        return tvNum;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public String getNumberStr() {
        return number.toString();
    }

    public String getNumberScaleStr() {
        return number.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    public void setScale(int scale) {
        this.scale = scale;
        setNumber(number);
    }

    public void setNumber(BigDecimal number) {
        if (number.compareTo(minNumber) < 0) {
            this.number = minNumber;
        } else if (number.compareTo(maxNumber) > 0) {
            this.number = maxNumber;
        } else {
            this.number = number;
        }
        if (this.number.compareTo(minNumber) == 0) { // 等于最小值，不可以再减
            ivSub.setImageResource(R.drawable.tg_common_ic_sub_gray_24dp); // 灰色减号
            ivAdd.setImageResource(R.drawable.tg_common_ic_add_black_24dp); // 黑色加号
        } else if (this.number.compareTo(maxNumber) == 0) { // 等于最大值，不可以再加
            ivSub.setImageResource(R.drawable.tg_common_ic_sub_black_24dp); // 黑色减号
            ivAdd.setImageResource(R.drawable.tg_common_ic_add_gray_24dp); // 灰色加号
        } else {
            ivSub.setImageResource(R.drawable.tg_common_ic_sub_black_24dp); // 黑色减号
            ivAdd.setImageResource(R.drawable.tg_common_ic_add_black_24dp); // 黑色加号
        }
        BigDecimal numberScale = this.number.setScale(scale, BigDecimal.ROUND_HALF_UP); // 四舍五入
        tvNum.setText(numberScale.toString());
        if (bigDecimalNumCallback != null) {
            bigDecimalNumCallback.NumChange(this.number, this.number.toString(), numberScale, numberScale.toString());
        }
    }

    public void setNumCallback(BigDecimalNumCallback bigDecimalNumCallback) {
        this.bigDecimalNumCallback = bigDecimalNumCallback;
    }

    private BigDecimalNumCallback bigDecimalNumCallback;

    public interface BigDecimalNumCallback {
        void NumChange(BigDecimal num, String numStr, BigDecimal numScale, String numScaleStr);
    }
}
