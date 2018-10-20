package com.turingoal.common.android.bean;

import com.turingoal.common.android.biz.domain.TgFile;
import com.turingoal.common.android.util.io.TgJsonUtil;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.List;

import lombok.Data;

/**
 * 返回结果
 * <p>
 * 用于rest方式返回结果。
 * </p>
 */
@Data
public class TgResponseBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final boolean SUCCESS = true;
    public static final boolean FAULT = false;
    public static final Integer SUCCESS_CODE = 0;
    public static final Integer TOKEN_VALIDATE_FAULT_CODE = 1001;
    private boolean success = true;
    private int code = SUCCESS_CODE; // 0为成功, 一般success和code使用其中一个
    private int httpStatus = 200;
    private boolean tokenValidateResult = true; // token校验结果
    private String avoidRepeatSubmitToken; // 避免重复提交token
    private String msg;
    private T data;
    private String exceptionDetailMsg; // 异常详细信息
    // -------- 分页 ----------------
    private long pages; // 总页数
    private long total; // 总记录数
    private int draw; // dataTable用 ，接收和返回必须一样
    private long pageSize; // 每页数据
    private long page; // 当前页数
    private long start; // 开始记录数
    private long end; // 结束记录数
    // --------- 文件上传 --------
    private TgFile item;

    public TgResponseBean() {
        super();
    }

    /**
     * result
     */
    public static TgResponseBean result(final boolean result) {
        TgResponseBean responseBean = new TgResponseBean();
        responseBean.setSuccess(result);
        return responseBean;
    }

    /**
     * success
     */
    public static TgResponseBean success() {
        return new TgResponseBean();
    }

    /**
     * fault
     */
    public static TgResponseBean fault() {
        return result(FAULT);
    }

    /**
     * success
     */
    public static TgResponseBean success(final String message) {
        TgResponseBean responseBean = success();
        responseBean.setMsg(message);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final String message) {
        TgResponseBean responseBean = fault();
        responseBean.setMsg(message);
        return responseBean;
    }

    /**
     * success
     */
    public static TgResponseBean success(final Object dataParm) {
        TgResponseBean responseBean = success();
        responseBean.setData(dataParm);
        return responseBean;
    }

    /**
     * success
     */
    public static TgResponseBean success(final int codeParm) {
        TgResponseBean responseBean = success();
        responseBean.setCode(codeParm);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final int codeParm) {
        TgResponseBean responseBean = fault();
        responseBean.setCode(codeParm);
        return responseBean;
    }

    /**
     * success
     */
    public static TgResponseBean success(final int codeParm, final String message) {
        TgResponseBean responseBean = success();
        responseBean.setCode(codeParm);
        responseBean.setMsg(message);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final int codeParm, final String message) {
        TgResponseBean responseBean = fault();
        responseBean.setCode(codeParm);
        responseBean.setMsg(message);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final Throwable exceptionMessage, final boolean detailMsg) {
        TgResponseBean responseBean = fault();
        // 异常情况
        if (exceptionMessage != null) {
            exceptionMessage.printStackTrace(new PrintWriter(new StringWriter()));
            // this.exceptionMessage = sw.toString(); 太详细了
            responseBean.setMsg(exceptionMessage.getMessage());
            if (detailMsg) {
                responseBean.setExceptionDetailMsg(exceptionMessage.toString()); // 太详细了
            }
        }
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final Throwable exceptionMessage) {
        TgResponseBean responseBean = fault(exceptionMessage, false);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final Integer codeParm, final Throwable exceptionMessage, final boolean detailMsg) {
        TgResponseBean responseBean = fault(exceptionMessage, detailMsg);
        responseBean.setCode(codeParm);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final Integer codeParm, final Throwable exceptionMessage) {
        TgResponseBean responseBean = fault(codeParm, exceptionMessage, false);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final int httpStatusParm, final Integer codeParm, final Throwable exceptionMessage, final boolean detailMsg) {
        TgResponseBean responseBean = fault(codeParm, exceptionMessage, detailMsg);
        responseBean.setHttpStatus(httpStatusParm);
        return responseBean;
    }

    /**
     * fault
     */
    public static TgResponseBean fault(final int httpStatusParm, final Integer codeParm, final Throwable exceptionMessage) {
        TgResponseBean responseBean = fault(httpStatusParm, codeParm, exceptionMessage, false);
        return responseBean;
    }

    /**
     * tokenFault
     */
    public static TgResponseBean tokenFault(final String message) {
        TgResponseBean responseBean = new TgResponseBean();
        responseBean.setTokenValidateResult(FAULT); // 校验结果设置为false
        responseBean.setCode(TgResponseBean.TOKEN_VALIDATE_FAULT_CODE); // token校验失败code
        responseBean.setMsg(message);
        return responseBean;
    }

    // ******************************* 分页 *****************************************//

    /**
     * list
     */
    public static TgResponseBean list(final List<?> recordsList) {
        TgResponseBean responseBean = success();
        responseBean.setData(recordsList);
        return responseBean;
    }

    /**
     * 分页
     */
    public static TgResponseBean page(final long totalRecordsNum, final List<?> recordsList) {
        TgResponseBean responseBean = list(recordsList);
        responseBean.setTotal(totalRecordsNum);
        return responseBean;
    }

    /**
     * 分页
     */
    public static TgResponseBean page(final long totalRecordsNum, final long pageParm, final List<?> recordsList) {
        TgResponseBean responseBean = page(totalRecordsNum, recordsList);
        responseBean.setPage(pageParm);
        return responseBean;
    }

    /**
     * 分页
     */
    public static TgResponseBean page(final long totalRecordsNum, final long pageParm, final long pageSizeParm, final List<?> recordsList) {
        TgResponseBean responseBean = page(totalRecordsNum, pageParm, recordsList);
        responseBean.setPageSize(pageSizeParm);
        if ((totalRecordsNum % pageSizeParm) == 0) {
            responseBean.setPages(totalRecordsNum / pageSizeParm);
        } else {
            responseBean.setPages(totalRecordsNum / pageSizeParm + 1);
        }
        return responseBean;
    }

    // ****************************************** 文件上传 *************************************************

    /**
     * file
     */
    public static TgResponseBean file(final TgFile file) {
        TgResponseBean responseBean = success();
        responseBean.setItem(file);
        return responseBean;
    }

    @Override
    public String toString() {
        return TgJsonUtil.object2Json(this);
    }
}
