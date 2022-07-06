package com.akikun.demo.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 李俊秋(龙泽)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoTestApplication {

    @Autowired
    private LdapService ldapService;


    @Test
    public void test() {

        ldapService.authenticate("13092", "test");

    }
}
