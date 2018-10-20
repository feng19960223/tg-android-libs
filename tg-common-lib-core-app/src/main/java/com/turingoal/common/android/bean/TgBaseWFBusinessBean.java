package com.turingoal.common.android.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 工作流业务BaseEntity
 */
@Data
public abstract class TgBaseWFBusinessBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String attrIds; // 附件ids
    private String bizType; // 不同的业务
    private String userId; //
    private String subjoinParameter;
    // 在业务表设计的时候添加一列：PROCESS_INSTANCE_ID
    // 在流程启动之后把流程ID更新到业务表中，这样不管从业务还是流程都可以查询到对方！
    private String processInstanceId; // 流程实例id
    private String taskId; // taskId
    private String activeId; // activeId
    private Date startTime; // 开始时间
    private Date endTime; // 结束时间
    private Date realityStartTime; // 实际开始时间
    private Date realityEndTime; // 实际结束时间
    private Date applyTime; // 申请时间
    private int dealType; // 处理类型 1提交 2驳回
    private String nextAssignee; // 下一个责任人
    private String nextPerson;
    private String nextPersonGroupId;
    private String nextAssigneeDeptId; // 部门id
    private String nextAssigneeGroupId; // 职务id
    private String handleType; // 操作方式
    private String currentNode; // 节点ID
    private String jumpNodeId; // 跳转的ID
    private String rejectActiveId; // 需要驳回的节点
    private String dealRemarks; // 处理意见

    // 流程任务
    // private Task task;
    // 流程参数
    // private Map<String, Object> variables;
    // 运行中的流程实例
    // private ProcessInstance processInstance;
    // 历史的流程实例
    // private HistoricProcessInstance historicProcessInstance;
    // 流程定义
    // private ProcessDefinition processDefinition;
}