package com.turingoal.common.android.support.system;

/**
 * 常量-》系统常量
 */
public interface TgConstantSystemValues {
    // 基础配置
    String DEFAULT_ENCODING = "utf-8"; // 默认编码
    String INIT_PASS = "000000"; // 初始密码
    String PASS_PREFIX = "tg_pass"; // 密码前缀
    String DEFAULT_TREE_ROOT_ID = "0"; // 树默认根节点id
    String DEFAULT_TREE_ROOT_CODE_NUM = "root"; // 树默认根节点编码
    // token相关
    String ACCESS_TOKEN = "access_token"; // token名称
    String ACCESS_TOKEN_PREFIX = "TgBearer_"; // token前缀
    String ACCESS_TOKEN_ISSUER = "tgTokenIssuer"; // token issuer
    String ACCESS_TOKEN_AUDIENCE = "tgTokenAudience"; // token 观众.代表这个JWT的接收对象；
    String ACCESS_TOKEN_ID = "tgTokenId"; // token id
    String ACCESS_TOKEN_SUBJECT = "tgTokenSubject"; // token 代表这个JWT的主体，即它的所有人；
    String ACCESS_TOKEN_CLAIMS = "tgTokenClaims"; // token Claims
    String ACCESS_TOKEN_ISSUE_TIME = "tgTokenIssueTime"; // token issuer 时间
    String ACCESS_TOKEN_EXPIRATION_TIME = "tgTokenExpirationTime"; // token issuer 时间
    // 用户信息
    String CURRENT_USER = "tgCurrentUser"; // 当前用户
    String CURRENT_USER_ID = "tgCurrentUserId"; // 当前用户id
    String CURRENT_USERNAME = "tgCurrentUsername";  // 当前用户名
    String CURRENT_USER_CODE_NUM = "tgCurrentUserCodeNum";  // 当前用户编码
    String CURRENT_USER_REALRNAME = "tgCurrentUserRealname"; // 当前用户真实姓名
    String CURRENT_USER_PASSWORD = "tgCurrentUserPassword"; // 当前用户密码
    // 角色
    String CURRENT_USER_ROLE_ID = "tgCurrentUserRoleId";  // 当前用户角色id
    String CURRENT_USER_ROLE_CODE_NUM = "tgCurrentUserRoleCodeNum";  // 当前用户角色编码
    String CURRENT_USER_ROLE_NAME = "tgCurrentUserRoleName";  // 当前用户角色名称
    String CURRENT_USER_ROLES = "tgCurrentUserRoles";  // 当前用户角色,多个
    String CURRENT_USER_ROLES_ID_S = "tgCurrentUserRolesIds";  // 当前用户角色Id,多个
    String CURRENT_USER_ROLES_CODE_NUM_S = "tgCurrentUserRolesCodeNums";  // 当前用户角色CodeNum,多个
    String CURRENT_USER_ROLES_NAME_S = "tgCurrentUserRolesNames";  // 当前用户角色名称,多个
    // 账户机构
    String CURRENT_USER_BIZ_ORG_ID = "tgCurrentUserBizOrgId";  // 当前用户账户机构id
    String CURRENT_USER_BIZ_ORG_CODE_NUM = "tgCurrentUserBizOrgCodeNum";  // 当前用户账户机构编码
    String CURRENT_USER_BIZ_ORG_NAME = "tgCurrentUserBizOrgName";  // 当前用户账户机构名称
    // 机构
    String CURRENT_USER_ORG_ID = "tgCurrentUserOrgId";  // 当前用户机构id
    String CURRENT_USER_ORG_CODE_NUM = "tgCurrentUserOrgCodeNum";  // 当前用户机构编码
    String CURRENT_USER_ORG_NAME = "tgCurrentUserOrgName";  // 当前用户机构名称
    // 系统常用常量
    String SUCCESS = "成功"; // 成功
    String FAIL = "失败"; // 失败
    int SUCCESS_INT = 1; // 成功
    int FAIL_INT = 2; // 失败
    // 登录
    String LOGIN_STAUS = "tgLoginStatus"; // 登录状态
    String CAPTCHA_NAME = "tgCurrentCaptcha"; // 保存的验证码名称
    String LOGIN_ERROR_COUNT = "tgLoginErrorCount"; // 登录出错次数
    String LOGIN_LOCK = "tgLock";  // 锁定
    String LOGIN_ERROR_MESSAGE = "tgErrorMessage"; // 错误信息
    String USER_LANGUAGE = "tgUserLanguage"; // 客户端语言
    String USER_THEME = "tgUserTheme"; // 客户端主题
}
