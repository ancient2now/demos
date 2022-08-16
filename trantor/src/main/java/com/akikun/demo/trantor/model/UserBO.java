package com.akikun.demo.trantor.model;

import com.akikun.demo.trantor.dict.UserStatusDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Transient;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 李俊秋(龙泽)
 */
@Data
public class UserBO extends BaseModel<Long> {


    @Field(name = "用户名")
    private String username;

    @Field(name = "密码")
    private String password;

    @Field(name = "状态")
    @DictionaryMeta(UserStatusDict.class)
    private String status;

    @Field(name = "操作按钮", type = FieldType.Json)
    @Transient
    private Buttons buttons;

    @Data
    @Builder
    public static class Buttons implements Serializable {

        private Boolean isShowDetail;

        private Boolean isShowCreate;

        private Boolean isShowEdit;

        private Boolean isShowDelete;

    }
}
