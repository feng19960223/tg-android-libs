package com.turingoal.common.android.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 基本查询属性
 */
@Data
public abstract class TgBaseQueryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final long DEFAULT_LENGTH = 20L;
    private Integer draw = 1; // dataTable用,保证异步请求的返回值是同一次请求的
    private String queryType; // 查询类型
    private Integer exportType; // 导出类型
    private String simpleQueryParam; // 简单查询参数
    private Boolean queryByPage = false; // 分页
    private Long start = 0L; // 开始记录
    private Long limit = DEFAULT_LENGTH; // 数量
    private Long end; // 结束记录
    private Long page = 1L;  // 当前页数
    private String requestUrl; // 当前请求路径
    // private List<TgSqlSortBean> sorters;
    private String sortCondition; // 拼接好的排序sql
    // 范围
    private String queryStartStr; // 查询开始
    private Integer queryStartInteger; // 查询开始
    private String queryEndStr; // 查询结束
    private Integer queryEndInteger; // 查询结束
    private String queryRange; // 查询范围字符串
    // 时间相关
    private String queryStartYearStr; // 查询开始年
    private Integer queryStartYear; // 查询开始年
    private String queryEndYearStr; // 查询结束年
    private Integer queryEndYear; // 查询结束年
    private String queryYearRange; // 查询年范围字符串
    private String queryStartMonthStr; // 查询开始月
    private Integer queryStartMonth; // 查询开始月
    private String queryEndMonthStr; // 查询结束月
    private Integer queryEndMonth; // 查询结束月
    private String queryMonthRange; // 查询月范围字符串
    private Date queryStartDate; // 查询开始日期
    private Date queryEndDate; // 查询结束日期
    private String queryDateRange; // 查询日期范围字符串
    private Date queryStartTime; // 查询开始时间
    private Date queryEndTime; // 查询结束时间
    private String queryTimeRange; // 查询时间范围
    private Date queryStartDateTime; // 查询开始日期时间
    private Date queryEndDateTime; // 查询结束日期时间
    private String queryDateTimeRange; // 查询日期时间范围
    private Integer queryYear; // 查询年
    private Date queryDate; // 查询日期
    private String treeChildrenParmName = TgBaseTreeNodeBean.CHILDREN_PARM_NAME_LIST; // 默认是list

    /**
     * 得到page
     */
    public Long getPage() {
        if (page == null || page < 1) {
            page = 1L;
        }
        return page;
    }

    /**
     * 设置分页大小
     */
    public void setLength(final Long lengthParm) {
        if (lengthParm != null && lengthParm > 0) {
            this.limit = lengthParm;
        }
    }

    /**
     * 分页大小
     */
    public Long getLength() {
        return this.limit;
    }

    /**
     * 设置start
     */
    public void setStart(final Long startParm) {
        if (startParm != null && startParm > 0) {
            this.start = startParm;
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
