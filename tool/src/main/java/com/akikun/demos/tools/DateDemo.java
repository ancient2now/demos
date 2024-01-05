package com.akikun.demos.tools;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author 李俊秋(龙泽)
 */
public class DateDemo {

    public static void main(String[] args) {
        testTimestamp();
    }

    private static void testTimestamp() {
        long timestamp = 1703606400000L;

        // 将时间戳转换为日期对象
        Date date = new Date(timestamp);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("日期对象：" + date);
        System.out.println("本地日期：" + localDate);
    }

    private static void testIsIn() {
        Date now = new Date();
        Date beginDate = DateUtil.beginOfDay(now);
        Date endDate = DateUtil.beginOfDay(now);

        DateTime today = DateUtil.beginOfDay(now);

        boolean res = DateUtil.isIn(today, beginDate, endDate);
        System.out.println(res);
    }
}
