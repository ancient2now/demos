package com.akikun.demo.grammer;


import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李俊秋(龙泽)
 */
public class PatternDemo {


    // å¯¹ç§è¡¨
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*filename=\"(.*)\"");
        String content = "attachment; filename*=utf-8''%E5%AF%B9%E7%85%A7%E8%A1%A8.xlsx; filename=\"å¯¹ç\u0085§è¡¨.xlsx\"";


        // 转换为UTF-8编码的字节数组
        byte[] utf8Bytes = content.getBytes(StandardCharsets.ISO_8859_1);

        // 如果需要再次将这个UTF-8编码的字节数组转换回字符串
        content = new String(utf8Bytes, StandardCharsets.UTF_8);

        System.out.println(content);


//        URLDecoder.decode(content, )

//        String deco = URLUtil.decode(content);
//        System.out.println(deco);

//        String decode = URLDecoder.decode(content);
//        System.out.println(decode);


        Matcher matcher = pattern.matcher(content);
        System.out.println(matcher.matches());

        System.out.println(matcher.group());
        System.out.println(matcher.group(1));
    }
}
