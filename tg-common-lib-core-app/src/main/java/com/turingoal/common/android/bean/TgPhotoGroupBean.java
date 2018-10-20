package com.turingoal.common.android.bean;

import java.util.List;

import lombok.Data;

/**
 * 照片组
 */
@Data
public class TgPhotoGroupBean {
    private List<String> photos; // 所有图片
    private int indexNum; // 当前图片的位置
}
