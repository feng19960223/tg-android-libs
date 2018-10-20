package com.turingoal.mengbao.common.android.biz.domain;

import java.io.Serializable;
import java.util.Date;
import com.turingoal.mengbao.common.android.constants.TgMengbaoConstantYesNo;
import com.turingoal.mengbao.common.android.util.TgMengBaoDateUtil;
import lombok.Data;

/**
 * [孩子] 
 */
@Data
public class Child implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 孩子
    private String codeNum; // 编码
    private String nickname; // 昵称
    private String realname; // 孩子真实姓名
    private String avatar; // 孩子头像
    private Integer gender; // 孩子性别
    private Date birthday; // 孩子生日
    private Integer height; // 身高
    private Integer weight; // 体重
    private Integer valueGrowth; // 成长值
    private Integer valueFlower; // 花朵（活跃值）
    private String userId; // 家长id
    private String userRealname; // 家长真实姓名
    private String relationship; // 亲子关系
    private String schoolId; // 学校
    private String schoolCodeNum; // 学校编号
    private String schoolTitle; // 学校名称
    private Integer classGrade; // 班级年级
    private String classId; // 班级id
    private String classCodeNum; // 班级编号
    private String classTitle; // 班级名字
    private Date nicknameUpdateTime; // 昵称修改时间
    private Date avatarUpdateTime; // 头像修改时间
    private Date createTime; // 入园时间
    private Integer commentStatus = TgMengbaoConstantYesNo.NO; // 是否点评
    private String parentAvatar; // 家长头像
    private String cellPhoneNum; // 家长电话
   
    /**
     * 孩子生日
     */
    public String getBirthdayStr4Date() {
        return TgMengBaoDateUtil.date2String(birthday);
    }
    
    /**
     * 孩子生日
     */
    public String getBirthdayStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(birthday);
    }
            
    /**
     * 昵称修改时间
     */
    public String getNicknameUpdateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(nicknameUpdateTime);
    }
    
    /**
     * 昵称修改时间
     */
    public String getNicknameUpdateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(nicknameUpdateTime);
    }
            
    /**
     * 头像修改时间
     */
    public String getAvatarUpdateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(avatarUpdateTime);
    }
    
    /**
     * 头像修改时间
     */
    public String getAvatarUpdateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(avatarUpdateTime);
    }
            
    /**
     * 入园时间
     */
    public String getCreateTimeStr4Date() {
        return TgMengBaoDateUtil.date2String(createTime);
    }
    
    /**
     * 入园时间
     */
    public String getCreateTimeStr4DateTime() {
        return TgMengBaoDateUtil.dateTime2String(createTime);
    }
}