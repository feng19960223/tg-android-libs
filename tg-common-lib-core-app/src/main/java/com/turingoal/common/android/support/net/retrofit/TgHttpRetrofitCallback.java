package com.turingoal.common.android.support.net.retrofit;

import android.content.Context;
import android.util.Log;

import com.turingoal.common.android.base.TgBaseActivity;
import com.turingoal.common.android.bean.TgResponseBean;
import com.turingoal.common.android.util.io.TgJsonUtil;
import com.turingoal.common.android.util.lang.TgStringUtil;
import com.turingoal.common.android.util.ui.TgDialogUtil;
import com.turingoal.common.android.util.ui.TgToastUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Retrofit请求Callback
 */
public abstract class TgHttpRetrofitCallback<T> implements Callback<TgResponseBean<T>> {
    protected Context context;
    protected boolean showErrorMessage = true; // 是否显示消息
    protected boolean checkToken = true;// 是否检查token

    public TgHttpRetrofitCallback() {
        super();
    }

    public TgHttpRetrofitCallback(final Context contextParm, final boolean showErrorMessageParm, final boolean checkTokenParm) {
        this.context = contextParm;
        this.showErrorMessage = showErrorMessageParm;
        this.checkToken = checkTokenParm;
    }

    /**
     * successHandler 需要覆盖该方法
     */
    public abstract void successHandler(final T data);

    /**
     * failHandler 需要时覆盖该方法
     */
    public void failHandler(final String msg) {

    }

    /**
     * 检查token错误 需要时覆盖该方法
     */
    public void tokenErrorHandler(final String msg) {

    }

    @Override
    public void onResponse(Call<TgResponseBean<T>> call, Response<TgResponseBean<T>> response) {
        if (response.isSuccessful()) { // success时body有值
            TgResponseBean<T> result = response.body(); // body转成TgResponseBean
            if (checkToken && !result.isTokenValidateResult()) { // 检查token,token不正确
                showErrorMsgAndTokenErrorHandler(result.getMsg()); // 进度和提醒,tokenErrorHandler
            } else if (result.isSuccess()) {
                successHandler(result.getData());
            } else {
                showErrorMsgAndFailHandler(result.getMsg());  // 进度和提醒,failHandler
            }
        } else { // success false 时errorBody有值
            try {
                TgResponseBean result = TgJsonUtil.json2Object(response.errorBody().string(), TgResponseBean.class); // errorBody转成TgResponseBean
                showErrorMsgAndFailHandler(result.getMsg());  // 进度和提醒
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onFailure(Call<TgResponseBean<T>> call, Throwable t) {
        showErrorMsgAndFailHandler(t.getMessage());  // 进度和提醒
    }

    /**
     * 进度和提醒
     */
    public String showErrorMsg(final String messageParm) {
        String message = messageParm;
        if (TgStringUtil.isBlank(message)) {
            message = "对不起，出错了！";
        }
        Log.i("TgHttpCallback", "onError: " + message);
        if (context != null) {// 进度和提醒
            TgDialogUtil.dismissLoadingProgress(); // 隐藏加载提示框
            if (showErrorMessage) {
                TgToastUtil.showLong(message);
            }
        }
        return message;
    }

    /**
     * 进度和提醒, tokenErrorHandler
     */
    public void showErrorMsgAndTokenErrorHandler(final String messageParm) {
        String message = showErrorMsg(messageParm);
        tokenErrorHandler(message);
    }

    /**
     * 进度和提醒, failHandler
     */
    public void showErrorMsgAndFailHandler(final String messageParm) {
        String message = showErrorMsg(messageParm);
        failHandler(message);
    }
}
