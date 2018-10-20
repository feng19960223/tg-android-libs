package com.turingoal.common.android.bean;

import lombok.Data;

/**
 * 缩略图参数
 */
@Data
public class TgThumbnailParamBean {
    private Boolean thumbnail;
    private Integer width;
    private Integer height;
    private Float scale;
    
    public TgThumbnailParamBean() {
        super();
    }

    public TgThumbnailParamBean(final Boolean thumbnailParm, final Integer widthParm, final Integer heightParm) {
        this.thumbnail = thumbnailParm;
        this.width = widthParm;
        this.height = heightParm;
    }

    public Boolean getThumbnail() {
        return (thumbnail != null && thumbnail && (width != null || height != null)) || (thumbnail != null && thumbnail && scale != null);
    }
}
