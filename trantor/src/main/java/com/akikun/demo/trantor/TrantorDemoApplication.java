package com.akikun.demo.trantor;

import cn.hutool.json.JSONUtil;
import com.akikun.demo.trantor.dict.UserStatusDict;
import com.akikun.demo.trantor.help.UserHelper;
import com.akikun.demo.trantor.model.UserBO;

/**
 * @author 李俊秋(龙泽)
 */
public class TrantorDemoApplication {

    private static TrantorDemoApplication demo = new TrantorDemoApplication();

    public static void main(String[] args) {

        UserBO user = demo.fetchUser();

        UserHelper.showButtons(user);

        String json = JSONUtil.toJsonPrettyStr(user);
        System.out.println(json);
    }

    private UserBO fetchUser() {
        UserBO user = new UserBO();
        user.setUsername("Aki");
        user.setPassword("*******");
        user.setStatus(UserStatusDict.ENABLE);
        return user;
    }

}
