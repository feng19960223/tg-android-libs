package com.turingoal.common.android.support.workflow;

/**
 * 常量-》工作流流程状态
 */
public interface TgConstantWorkflowProcessState {
    String START = "start"; // 开始
    String LIVE = "live"; // 进行中
    String END = "end"; // 结束
    String ACTIVE = "active"; // 激活
    String SUSPEND = "suspend"; // 挂起
}
