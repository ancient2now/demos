package com.akikun.demo;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 李俊秋(龙泽)
 */
public class PlaceholderReplaceDemo {

    private static final Pattern PATTERN = Pattern.compile("\\$\\{(.*?)\\}");

    public static void main(String[] args) {

//        messageFormatImpl();
        long start;
        int times = 500_0000;

        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i) {
            replace01(i);
        }
        System.out.println("replace01 cost:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i) {
            replace02(i);
        }
        System.out.println("replace02 cost:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i) {
            replace03(i);
        }
        System.out.println("replace03 cost:" + (System.currentTimeMillis() - start));
    }

//    public static void messageFormatImpl() {
//        // 创建一个映射，其中键是占位符名称，值是要替换的内容
//        Map<String, String> placeholders = new HashMap<>();
//        placeholders.put("name", "John Doe");
//        placeholders.put("age", "30");
//
//        // 定义一个包含占位符的模板字符串
//        String template = "Hello, my name is ${name} and I am ${age} years old.";
//
//        // 将模板字符串转换为 MessageFormat 可以处理的格式
//        String formatTemplate = template.replace("${", "{").replace("}", "}");
//
//        // 使用 MessageFormat 进行格式化
//        MessageFormat formatter = new MessageFormat(formatTemplate);
//        String result = formatter.format(placeholders.values().toArray());
//
//        // 输出结果
//        System.out.println(result);
//    }

    public static String replace01(int age) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("age", age);

        String template = "Hello, my name is ${name} and I am ${age} years old.";
        String result = template;

        // 使用正则表达式替换
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            result = result.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue().toString());
//            result = result.replace("${" + entry.getKey() + "}", entry.getValue().toString());

        }

        if (age == 1) {
            System.out.println(result);
        }
        return result;

//        System.out.println(result);
    }

    public static String replace02(int age) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("age", age);

        String content = "Hello, my name is ${name} and I am ${age} years old.";

        Matcher matcher = PATTERN.matcher(content);
        while (matcher.find()) {
            String matchKey = matcher.group(1);
            Object value = data.get(matchKey);
            content = content.replace(matcher.group(), value == null ? "" : value.toString());
        }
        if (age == 1) {
            System.out.println(content);
        }
        return content;
    }

    public static String replace03(int age) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("age", age);

        String content = "Hello, my name is ${name} and I am ${age} years old.";

        Matcher matcher = PATTERN.matcher(content);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);
            Object replacement = data.getOrDefault(key, "");
            // 如果没有找到对应的值，保留原始占位符
            replacement = (replacement == null) ? "${" + key + "}" : replacement;
            matcher.appendReplacement(result, replacement.toString());
        }
        matcher.appendTail(result);


        if (age == 1) {
            System.out.println(result);
        }

        return result.toString();
    }
}
