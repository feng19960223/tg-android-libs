package com.turingoal.common.android.bean;

import java.util.Properties;
import lombok.Data;

/**
 * 发送邮件需要使用的基本信息
 */
@Data
public class TgMailSenderBean {
    private String mailServerHost; // 发送邮件的服务器的IP
    private String mailServerPort = "25"; // 发送邮件的服务器端口
    private String fromAddress; // 邮件发送者的地址
    private String toAddress; // 邮件接收者的地址
    private String userName; // 登陆邮件发送服务器的用户名
    private String password;  // 登陆邮件发送服务器的密码
    private boolean validate = false; // 是否需要身份验证
    private String subject; // 邮件主题
    private String content; // 邮件的文本内容
    private String[] attachFileNames; // 邮件附件的文件名

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        if (validate) {
            p.put("mail.smtp.auth", "true");
        } else {
            p.put("mail.smtp.auth", "false");
        }
        return p;
    }
}
