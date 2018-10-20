package com.turingoal.common.android.app;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.turingoal.common.android.util.io.TgJsonUtil;

import java.lang.reflect.Type;

@Route(path = "/service/json")
public class TgArouterJsonServiceImpl implements SerializationService {
    @Override
    public void init(Context context) {

    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return TgJsonUtil.json2Object(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return TgJsonUtil.object2Json(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return TgJsonUtil.json2Object(input, clazz);
    }
}
