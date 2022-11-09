package com.akikun.demo.spring.controller;

import com.akikun.demo.spring.model.B2bPayTransInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李俊秋(龙泽)
 */
@RequestMapping("/com/akikun/demo/spring/")
@RestController
@Slf4j
public class WhenRequestBodyIsXmlController {

    /**
     B2bPayTransInfo 对应的报文

     <packet>
         <transName>交易名称</transName>
         <Plain>交易请求明文</Plain>
         <Signature>交易请求明文的签名</Signature>
     </packet>
     */
    @RequestMapping(method = RequestMethod.POST, path = "/requestXml",
            consumes = MediaType.TEXT_XML_VALUE)
    public B2bPayTransInfo requestXml(@RequestBody B2bPayTransInfo info) {
        return info;
    }
}
