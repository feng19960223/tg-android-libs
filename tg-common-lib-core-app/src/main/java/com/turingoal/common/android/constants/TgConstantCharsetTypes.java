package com.turingoal.common.android.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 常用字符编码
 */
public interface TgConstantCharsetTypes {
    String UTF8 = StandardCharsets.UTF_8.name(); // UTF-8
    String GBK = "GBK"; // GBK
    String GB2312 = "GB2312"; // GB2312
    String GB18030 = "GB18030"; // GB18030
    String ISO_8859_1 = StandardCharsets.ISO_8859_1.name(); // ISO-8859-1
    Charset CHARSET_UTF_8 = StandardCharsets.UTF_8; // UTF-8
    Charset CHARSET_GBK = Charset.forName(GBK); // GBK
    Charset CHARSET_GB2312 = Charset.forName(GB2312); // GB2312
    Charset CHARSET_GB18030 = Charset.forName(GB18030); // GB18030
    Charset CHARSET_ISO_8859_1 = StandardCharsets.ISO_8859_1; // ISO-8859-1
}
