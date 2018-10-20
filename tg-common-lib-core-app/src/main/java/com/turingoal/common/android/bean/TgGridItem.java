package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 九宫格实体类
 */
@Data
public class TgGridItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private int imageId = 1; // 图片
    private String imagePath; // 图片
    private String title = "标题"; // 标题
    private String urlPath = ""; // 路径

    public TgGridItem(final int imageIdParm, final String titleParm) {
        this.imageId = imageIdParm;
        this.title = titleParm;
    }

    public TgGridItem(final String imagePathParm, final String titleParm) {
        this.imagePath = imagePathParm;
        this.title = titleParm;
    }

    public TgGridItem(final int imageIdParm, final String titleParm, final String urlPathParm) {
        this.imageId = imageIdParm;
        this.title = titleParm;
        this.urlPath = urlPathParm;
    }

    public TgGridItem(final String imagePathParm, final String titleParm, final String urlPathParm) {
        this.imagePath = imagePathParm;
        this.title = titleParm;
        this.urlPath = urlPathParm;
    }
}