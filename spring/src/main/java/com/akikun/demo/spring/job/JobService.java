package com.akikun.demo.spring.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 李俊秋(龙泽)
 */
@Service
public class JobService {

    private static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT_DEFAULT);

    /**
     * （0） Seconds (秒) ：可以用数字0－59 表示
     * （1） Minutes(分) ：可以用数字0－59 表示
     * （2） Hours(时) ：可以用数字0-23表示
     * （3） Day-of-Month(天) ：可以用数字1-31 中的任一一个值，但要注意一些特别的月份
     * （4） Month(月) ：可以用0-11 或用字符串 “JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV and DEC”
     * （5）Day-of-Week(每周)：可以用数字1-7表示（1 ＝ 星期日）或用字符口串“SUN, MON, TUE, WED, THU, FRI and SAT”
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void execute() {
        String name = Order.order.getName();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("time: " + now.format(DEFAULT_DATE_FORMATTER) + ", name: " + name);
    }

}
