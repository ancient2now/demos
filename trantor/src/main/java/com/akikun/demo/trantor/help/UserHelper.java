package com.akikun.demo.trantor.help;

import com.akikun.demo.trantor.dict.UserStatusDict;
import com.akikun.demo.trantor.model.UserBO;

/**
 * @author 李俊秋(龙泽)
 */
public class UserHelper {

    public static UserBO showButtons(UserBO user) {
        if (user == null) {
            return null;
        }

        boolean isShowEdit = Boolean.FALSE;

        UserBO.Buttons buttons = UserBO.Buttons.builder()
                .isShowCreate(isEnableStatus(user))
                .isShowDelete(isEnableStatus(user))
                .isShowDetail(isEnableStatus(user))

                .isShowEdit(isShowEdit)

                .build();
        user.setButtons(buttons);
        return user;
    }

    public static boolean isEnableStatus(UserBO user) {
        return UserStatusDict.ENABLE.equals(getStatus(user));
    }

    static String getStatus(UserBO user) {
        return user == null ? null : user.getStatus();
    }
}
