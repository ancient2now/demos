package com.akikun.demos.cloud;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.dm20151123.Client;
import com.aliyun.dm20151123.models.SingleSendMailRequest;
import com.aliyun.teaopenapi.models.Config;

import java.util.Map;

/**
 * @author 李俊秋(龙泽)
 * @date 2025/4/17
 */

public class AliyunEmailDemo {
    public static void main(String[] args)  {
        try {
            Config config = getConfig();
            config.endpoint = "dm.aliyuncs.com";
            com.aliyun.dm20151123.Client client = new Client(config);
            SingleSendMailRequest request = new SingleSendMailRequest();
            request.setAccountName("noreply@kuahuan.com");
            request.setAddressType(1);
            request.setReplyToAddress(true);
            request.setToAddress("ancient2now@163.com");
            request.setSubject("预约成功通知");

            String template = "消息通知助手：\n\n您已成功预约，请使用身份证号[{idCard}]和手机号[{mobilePhone}]登录查看二维码。\n\n二维码不会动态刷新可以直接截图保存。\n\n祝您生活愉快！";
            Map<String, Object> params = MapUtil.newHashMap();
            params.put("idCard", "330103199001010000");
            params.put( "mobilePhone", "13800000000");

            String content = StrUtil.format(template, params);

            request.setTextBody(content);
            client.singleSendMail(request);
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    protected static Config getConfig() {
        // 建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html。
        try {
            return new Config()
                    .setAccessKeyId(System.getenv("ALIYUN_KEY_ID"))
                    .setAccessKeySecret(System.getenv("ALIYUN_KEY_SECRET"));
        } catch (Exception e) {
            return null;
        }
    }




}
