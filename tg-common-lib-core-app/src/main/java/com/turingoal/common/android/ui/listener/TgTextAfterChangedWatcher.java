package com.turingoal.common.android.ui.listener;

import android.text.TextWatcher;

/**
 * 文本监听器
 */
public abstract class TgTextAfterChangedWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
