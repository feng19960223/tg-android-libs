package com.turingoal.common.android.bean;

import com.turingoal.common.android.support.system.TgConstantSystemValues;
import com.turingoal.common.android.util.math.TgIdentitieUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 树节点
 *
 * @param <T> 树节点类型
 */
@Data
public abstract class TgBaseTreeNodeBean<T extends TgBaseTreeNodeBean<T>> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id = TgIdentitieUtil.uuidWithoutUnderline(); // 封装JDK自带的UUID, 通过Random数字生成, 中间无"-"分割.
    private String codeNum; // 编码
    private String title; // 文本
    private String parentId = TgConstantSystemValues.DEFAULT_TREE_ROOT_ID; // 父级id
    private String parentCodeNum = TgConstantSystemValues.DEFAULT_TREE_ROOT_CODE_NUM; // 父级编码
    private boolean leaf = true; // 是否叶子节点
    private int nodeLevel = 1; // 默认是1级
    // 由于前端不同树插件需要的节点名称不一致，所以使用参数来判断
    private List<T> children = new ArrayList<>(); // 子节点
    private List<T> list = new ArrayList<>(); // 子节点
    private List<T> data = new ArrayList<>(); // 子节点
    private List<T> nodes = new ArrayList<>(); // 子节点
    public static final String CHILDREN_PARM_NAME_CHILDREN = "children"; // 子节点名称
    public static final String CHILDREN_PARM_NAME_LIST = "list"; // 子节点名称
    public static final String CHILDREN_PARM_NAME_DATA = "data"; // 子节点名称
    public static final String CHILDREN_PARM_NAME_NODES = "nodes"; // 子节点名称
    // 扩展属性
    private Boolean expanded; // 是否展开。用对象类型转json是为null不输出
    private Boolean checked; // 是否选中。用对象类型转json是为null不输出

    public TgBaseTreeNodeBean() {
        super();
    }

    public TgBaseTreeNodeBean(final String idParm, final String titleParm) {
        super();
        this.id = idParm;
        this.title = titleParm;
    }

    public TgBaseTreeNodeBean(final String idParm, final String titleParm, final String parentIdParm) {
        super();
        this.id = idParm;
        this.title = titleParm;
        this.parentId = parentIdParm;
    }

    public TgBaseTreeNodeBean(final String idParm, final String titleParm, final String codeNumParm, final String parentIdParm, final String parentCodeNumParm) {
        super();
        this.id = idParm;
        this.codeNum = codeNumParm;
        this.title = titleParm;
        this.parentId = parentIdParm;
        this.parentCodeNum = parentCodeNumParm;
    }

    /**
     * 根据children参数名称返回对应的children
     */
    public List<T> getChildrenByChildrenParmName(final String childrenParmName) {
        List<T> result;
        if (CHILDREN_PARM_NAME_CHILDREN.equals(childrenParmName)) {
            result = getChildren();
        } else if (CHILDREN_PARM_NAME_DATA.equals(childrenParmName)) {
            result = getData();
        } else if (CHILDREN_PARM_NAME_NODES.equals(childrenParmName)) {
            result = getNodes();
        } else {
            result = getList();
        }
        return result;
    }

    /**
     * 是否叶子节点
     */
    public String isLeafStr() {
        if (leaf) {
            return "是";
        } else {
            return "否";
        }
    }
}
