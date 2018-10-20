package com.turingoal.common.android.constants;

/**
 * uri中使用的字符常量
 */
public interface TgConstant4Uri {
    /** # */
    String COMPONENTS_FRAGMENT = "#";
    /** ? */
    String COMPONENTS_QUESTIONMARK = "?";
    /** & */
    String COMPONENTS_AMPERSAND = "&"; // &
    /** http 协议 */
    String SCHEME_HTTP = "http"; //
    /** https 协议 */
    String SCHEME_HTTPS = "https";
    /** 针对ClassPath路径的伪协议前缀（兼容Spring）: "classpath:" */
    String PATH_PREFIX_CLASSPATH = "classpath:";
    /** URL 前缀表示文件: "file:" */
    String PATH_PREFIX_FILE = "file:";
    /** URL 前缀表示jar: "jar:" */
    String PATH_PREFIX_JAR = "jar:";
    /** URL 前缀表示war: "war:" */
    String PATH_PREFIX_WAR = "war:";
    /** URL 协议表示文件: "file" */
    String PROTOCOL_FILE = "file";
    /** URL 协议表示Jar文件: "jar" */
    String PROTOCOL_JAR = "jar";
    /** URL 协议表示zip文件: "zip" */
    String PROTOCOL_ZIP = "zip";
    /** URL 协议表示WebSphere文件: "wsjar" */
    String PROTOCOL_WSJAR = "wsjar";
    /** URL 协议表示JBoss zip文件: "vfszip" */
    String PROTOCOL_VFSZIP = "vfszip";
    /** URL 协议表示JBoss文件: "vfsfile" */
    String PROTOCOL_VFSFILE = "vfsfile";
    /** URL 协议表示JBoss VFS资源: "vfs" */
    String PROTOCOL_VFS = "vfs";
    /** Jar路径以及内部文件路径的分界符: "!/" */
    String SEPARATOR_JAR = "!/";
    /** WAR路径及内部文件路径分界符 */
    String SEPARATOR_WAR = "*/";
}
