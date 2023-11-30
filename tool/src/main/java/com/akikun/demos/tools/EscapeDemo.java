package com.akikun.demos.tools;

import cn.hutool.json.JSONUtil;
import org.apache.commons.text.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李俊秋(龙泽)
 */
public class EscapeDemo {

    public static void main(String[] args) {
//        String str = "{\"a\":\"1\",\"b\":2,\"c\":[{\"d\":false}]}";
//        String res = StringEscapeUtils.escapeJson(str);
//        System.out.println(res);


        Person father = new Person();
        father.name = "李秋";
        father.age = 30;
        
        Person child = new Person();
        child.name = "李豪";
        child.age = 10;


        List<Person> children = new ArrayList<>();
        children.add(child);
        father.children = children;

        String jsonStr = JSONUtil.toJsonStr(father);
        System.out.println(jsonStr);

        String escapeJson = StringEscapeUtils.escapeJson(jsonStr);
        System.out.println(escapeJson);

        String unescapeJson = StringEscapeUtils.unescapeJson(escapeJson);
        System.out.println(unescapeJson);


    }

    static class Person {
        String name;
        Integer age;

        List<Person> children;

        // 没有 Get 方法， hutool的JsonUtil不能序列化

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public List<Person> getChildren() {
            return children;
        }
    }

}
