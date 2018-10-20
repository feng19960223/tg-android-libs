package com.turingoal.common.android.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.turingoal.common.android.util.ui.TgDialogUtil;

import butterknife.ButterKnife;
import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 基类Fragment
 */
public abstract class TgBaseFragment extends Fragment {
    public static final String TAG = "TgFragment";
    private Context appContext; // 全局context
    private Context activityContext; // 上下文context
    private View rootView; // 视图
    private TextView tvTitle; // 标题
    private String httpTaskKey = "HttpTaskKey_" + hashCode(); // HttpTaskKey
    private View notDataView; // 没有数据view

    /**
     * 设置布局界面的ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化组件/数据
     */
    protected abstract void initialized();

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            appContext = getActivity().getApplicationContext(); // 全局context
            activityContext = getActivity();  // 上下文context
            ARouter.getInstance().inject(this);
            ButterKnife.bind(this, rootView);
            initialized();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    /**
     * 设置Toolbar
     */
    protected void initToolbar(final int tvTitleId, final String titleStr) {
        tvTitle = (TextView) rootView.findViewById(tvTitleId); // 标题
        setTitle(titleStr); // 设置标题
    }

    /**
     * 设置标题
     */
    protected void setTitle(final String titleStr) {
        if (tvTitle != null) {
            tvTitle.setText(titleStr);
        }
    }

    /**
     * 显示加载进度条
     */
    public void showLoadingProgress() {
        TgDialogUtil.showLoadingProgress(activityContext);
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
        getActivity().finish();
    }

    /**
     * 没有数据view
     */
    protected View getNotDataView(final ViewGroup viewGroup) {
        if (notDataView == null) {
            notDataView = getLayoutInflater().inflate(R.layout.tg_common_view_empty, viewGroup, false);
        }
        return notDataView;
    }

    /**
     * 销毁
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public Context getAppContext() {
        return appContext;
    }

    public Context getAtivityContext() {
        return activityContext;
    }

    public View getRootView() {
        return rootView;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }
}
