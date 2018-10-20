package com.turingoal.common.android.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 分页bean
 */
@Data
public class TgPageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final Long DEFAULT_PAGESIZE = 20L;
    private Long pages = 1L; // 总页数
    private Long total = 1L;; // 总记录数
    private Long page = 1L; // 当前页数
    private Long limit = DEFAULT_PAGESIZE;; // 截止记录
    private Long start = 0L; // 开始记录
    private Long end = 0L; // 结束记录
    private String dir; // 大写的ASC or DESC
    private String sort; // 排序的字段
    private String actionURI; // 当前action的URI

    public TgPageBean() {
        super();
    }

    public TgPageBean(final Long startParm, final Long limitParm) {
        if (limitParm != null && limitParm > 0) {
            this.limit = limitParm;
        }
        setStart(startParm);
    }

    public TgPageBean(final Long totalParm, final Long limitlimitParm, final Long pageParm) {
        if (limitlimitParm != null && limitlimitParm > 0) {
            this.limit = limitlimitParm;
        }
        computePage(totalParm, limit); // 计算总页数
        this.page = pageParm;
        if (page < 1) {
            page = 1L;
        } else if (page > pages) {
            page = pages;
        }
        this.end = start + limit;
    }

    public TgPageBean(final Long totalParm, final Long limitNum, final Long pageNum, final String url) {
        this(totalParm, limitNum, pageNum);
        actionURI = url;
    }

    /**
     * 计算页数
     */
    public final void computePage(final Long totalParm, final Long limitParm) {
        total = totalParm; // 总数
        limit = limitParm; // 每页数量
        if ((total % limit) == 0) {
            pages = total / limit;
        } else {
            pages = total / limit + 1;
        }
    }

    /**
     * 设置start
     */
    public void setStart(final Long startParm) {
        if (startParm != null && startParm > 0) {
            this.start = startParm;
            this.end = start + limit;
            this.page = start / limit + 1;
        }
    }

    /**
     * 得到start
     */
    public Long getStart() {
        if (start != null && start > 0) {
            return start;
        } else if (page != null) {
            return (page - 1) * limit;
        } else {
            return start;
        }
    }
}
