package com.turingoal.common.android.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.turingoal.common.android.util.system.TgLogUtil;
import com.turingoal.common.android.util.ui.TgDialogUtil;
import com.turingoal.common.android.util.ui.TgKeyboardUtil;

import butterknife.ButterKnife;
import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 基类Activity
 */
public abstract class TgBaseActivity extends AppCompatActivity {
    public static final String TAG = "TgActivity";
    private Context appContext; // 全局context
    private TextView tvToobarTitle; // 标题
    private ImageView ivToobarLeftBut; // 左侧按钮
    private ImageView ivToobarRightBut; // 右侧按钮
    private TextView tvToobarLeftText; // 左侧文本
    private TextView tvToobarRightText; // 右侧文本
    private View noDataView; // 没有数据view
    private View errorView; // 加载数据出错view

    /**
     * 设置布局界面的Id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化组件/数据
     */
    protected abstract void initialized();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId(); //layoutId
        if (layoutId != 0) {
            setContentView(layoutId);
            //getWindow().setBackgroundDrawable(null);
        }
        appContext = getApplicationContext();
        TgBaseApplication.addActivity(this);
        ARouter.getInstance().inject(this); // ARouter自动解析参数，每个Activity里不用再写
        ButterKnife.bind(this); // 必须在setContentView();之后,且父类bind绑定后,子类不需要再bind
        initialized(); // 初始化
    }

    /**
     * 设置Toolbar
     */
    protected void initToolbar(final Integer tvTitleId, final String titleStr) {
        if (tvTitleId != null) {
            tvToobarTitle = (TextView) findViewById(tvTitleId); // 标题
            setTitle(titleStr); // 设置标题
        }
    }

    /**
     * 设置Toolbar
     */
    protected void initToolbar(final Integer tvTitleId, final Integer ivBackId, final String titleStr) {
        this.initToolbar(tvTitleId, titleStr); // 标题
        if (ivBackId != null) {
            ivToobarLeftBut = (ImageView) findViewById(ivBackId); // 左侧按钮，设置为返回按钮
            setBackBtn(true); // 设置返回按钮
        }
    }


    /**
     * 设置Toolbar
     */
    protected void initToolbar(final Integer tvTitleId, final Integer ivBackId, final Integer ivToobarRightButId, final String titleStr, final boolean backBut, final View.OnClickListener toobarRightButClickListener) {
        this.initToolbar(tvTitleId, titleStr); // 标题
        if (ivBackId != null) {
            ivToobarLeftBut = (ImageView) findViewById(ivBackId); // 左侧按钮，设置为返回按钮
            setBackBtn(backBut); // 设置返回按钮
        }
        if (ivToobarRightButId != null) {
            ivToobarRightBut = (ImageView) findViewById(ivToobarRightButId); // 右侧按钮
            setToobarRightButClickListener(toobarRightButClickListener);
        }
    }

    /**
     * 设置Toolbar
     */
    protected void initToolbar(final Integer tvTitleId, final Integer ivToobarLeftButId, final String titleStr, final View.OnClickListener toobarLeftButClickListener) {
        this.initToolbar(tvTitleId, titleStr); // 标题
        if (ivToobarLeftButId != null) {
            ivToobarLeftBut = (ImageView) findViewById(ivToobarLeftButId); // 左侧按钮
            setToobarLeftButClickListener(toobarLeftButClickListener);
        }
    }

    /**
     * 设置Toolbar
     */
    protected void initToolbar(final Integer tvTitleId, final Integer ivToobarLeftButId, final Integer ivToobarRightButId, final String titleStr, final View.OnClickListener toobarLeftButClickListener, final View.OnClickListener toobarRightButClickListener) {
        this.initToolbar(tvTitleId, ivToobarLeftButId, titleStr, toobarLeftButClickListener); // 标题,左侧按钮
        if (ivToobarRightButId != null) {
            ivToobarRightBut = (ImageView) findViewById(ivToobarRightButId); // 右侧按钮
            setToobarRightButClickListener(toobarRightButClickListener);
        }
    }

    /**
     * 设置标题
     */
    protected void setTitle(final String titleStr) {
        if (tvToobarTitle != null) {
            tvToobarTitle.setText(titleStr);
        }
    }

    /**
     * 设置左侧按钮事件
     */
    protected void setToobarLeftButClickListener(final View.OnClickListener clickListener) {
        if (ivToobarLeftBut != null) {
            ivToobarLeftBut.setVisibility(View.VISIBLE);
            ivToobarLeftBut.setOnClickListener(clickListener);
        } else {
            TgLogUtil.d("没有左侧按钮");
        }
    }

    /**
     * 设置右侧按钮事件
     */
    protected void setToobarRightButClickListener(final View.OnClickListener clickListener) {
        if (ivToobarRightBut != null) {
            ivToobarRightBut.setVisibility(View.VISIBLE);
            ivToobarRightBut.setOnClickListener(clickListener);
        } else {
            TgLogUtil.d("没有右侧按钮");
        }
    }

    /**
     * 设置返回按钮
     */
    protected void setBackBtn(final boolean show) {
        if (show) {
            ivToobarLeftBut.setVisibility(View.VISIBLE);
            setToobarLeftButClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    defaultFinish(); // 关闭当前页面
                }
            });
        } else {
            ivToobarLeftBut.setVisibility(View.GONE);
        }
    }

    /**
     * 设置左侧文字
     */
    protected void setToobarLeftText(final Integer tvToobarLeftTextId, final String str, final View.OnClickListener clickListener) {
        if (tvToobarLeftTextId != null) {
            tvToobarLeftText = (TextView) findViewById(tvToobarLeftTextId);
            if (tvToobarLeftText != null) {
                tvToobarLeftText.setVisibility(View.VISIBLE);
                tvToobarLeftText.setText(str);
                tvToobarLeftText.setOnClickListener(clickListener);
            } else {
                TgLogUtil.d("没有左侧文字");
            }
        }
    }

    /**
     * 设置右侧文字
     */
    protected void setToobarRightText(final Integer tvToobarRightTextId, final String str, final View.OnClickListener clickListener) {
        if (tvToobarRightTextId != null) {
            tvToobarRightText = (TextView) findViewById(tvToobarRightTextId);
            if (tvToobarRightText != null) {
                tvToobarRightText.setVisibility(View.VISIBLE);
                tvToobarRightText.setText(str);
                tvToobarRightText.setOnClickListener(clickListener);
            } else {
                TgLogUtil.d("没有左侧文字");
            }
        }
    }

    /**
     * 没有数据view
     */
    protected View getNotDataView(final ViewGroup viewGroup) {
        if (noDataView == null) {
            noDataView = getLayoutInflater().inflate(R.layout.tg_common_view_empty, viewGroup, false);
        }
        return noDataView;
    }

    /**
     * 加载数据出错view
     */
    protected View getErrorView(final ViewGroup viewGroup) {
        if (errorView == null) {
            errorView = getLayoutInflater().inflate(R.layout.tg_common_view_error, viewGroup, false);
        }
        return errorView;
    }

    /**
     * 显示加载进度条
     */
    public void showLoadingProgress() {
        TgDialogUtil.showLoadingProgress(this);
    }

    /**
     * 隐藏加载进度条
     */
    public void dismissLoadingProgress() {
        TgDialogUtil.dismissLoadingProgress();
    }

    /**
     * 默认finish
     */
    public void defaultFinish() {
        TgDialogUtil.closeLoadingProgress(); //关闭进度条
        finish();
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        TgBaseApplication.deleteActivity(this); // 从堆栈删除当前Activity
    }

    /**
     * 触摸事件
     */
    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        try {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (TgKeyboardUtil.isShouldHideInput(v, ev)) {
                    TgKeyboardUtil.hideSoftInput(this);
                }
                return super.dispatchTouchEvent(ev);
            }
            if (getWindow().superDispatchTouchEvent(ev)) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return onTouchEvent(ev);
    }

    public Context getAppContext() {
        return appContext;
    }

    public TextView getTvToobarTitle() {
        return tvToobarTitle;
    }

    public ImageView getIvToobarLeftBut() {
        return ivToobarLeftBut;
    }

    public ImageView getIvToobarRightBut() {
        return ivToobarRightBut;
    }

    public TextView getTvToobarLeftText() {
        return tvToobarLeftText;
    }

    public TextView getTvToobarRight() {
        return tvToobarRightText;
    }
}
