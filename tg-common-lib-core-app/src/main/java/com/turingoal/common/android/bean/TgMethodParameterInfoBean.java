package com.turingoal.common.android.bean;

import java.lang.reflect.Type;
import lombok.Data;

/**
 * 方法参数信息
 */
@Data
public class TgMethodParameterInfoBean {
    private final String name;
    private final Type type;
    private final int index;

    public TgMethodParameterInfoBean(final String nameParm, final Type typeParm, final int indexParm) {
        this.name = nameParm;
        this.type = typeParm;
        this.index = indexParm;
    }
}
