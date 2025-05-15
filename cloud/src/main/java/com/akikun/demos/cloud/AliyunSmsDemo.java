package com.akikun.demos.cloud;

import cn.hutool.json.JSONUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李俊秋(龙泽)
 * @date 2025/4/17
 */
public class AliyunSmsDemo {
    public static Client createClient() throws Exception {
        Config config = new Config()
                // 配置 AccessKey ID，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
                .setAccessKeyId(System.getenv("ALIYUN_KEY_ID"))
                // 配置 AccessKey Secret，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
                .setAccessKeySecret(System.getenv("ALIYUN_KEY_SECRET"));

        // 配置 Endpoint
        config.endpoint = "dysmsapi.aliyuncs.com";

        return new Client(config);
    }

    public static void main(String[] args) throws Exception {

        //67字： 【夸幻助手】通知：您的预约已完成，请使用证件号[330103199001010000]和手机号[18000000000]登录查看二维码。


        String mobile = "18000000000";
        Map<String, Object> params = new HashMap<>();
        params.put("idCard", "330103199001010000");
        params.put("mobilePhone", mobile);

        Client client = AliyunSmsDemo.createClient();
        SendSmsRequest request = new SendSmsRequest();
        request.setSignName("夸幻助手");
        request.setTemplateCode("SMS_483785098");
        request.setPhoneNumbers(mobile);
        request.setTemplateParam(JSONUtil.toJsonStr(params));

        SendSmsResponse response = client.sendSms(request);
        System.out.println(response);
    }
}
