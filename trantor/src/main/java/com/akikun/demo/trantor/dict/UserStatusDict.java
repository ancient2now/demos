package com.akikun.demo.trantor.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;
import io.terminus.trantorframework.api.annotation.typemeta.Icon;

/**
 * @author 李俊秋(龙泽)
 */
@Dictionary(name = "用户状态")
public interface UserStatusDict {

    @DictionaryItem(value = "启用", icon = Icon.dot, iconColor = Icon.Color.Green)
    String ENABLE = "ENABLE";

    @DictionaryItem(value = "停用", icon = Icon.dot, iconColor = Icon.Color.Red)
    String DISABLE = "DISABLE";
}
