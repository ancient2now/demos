package com.akikun.demo.spring.signature;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李俊秋(龙泽)
 */
@RequestMapping("/com/akikun/demo/spring/")
@RestController
@Slf4j
public class WhenRequestIsSpecialController {

    /**
     B2bPayTransInfo 对应的报文

     */
    @RequestMapping(method = RequestMethod.POST, path = "/requestStr")
    public String requestStr(@RequestBody String info) {
        return info;
    }

    /**
     * 请求信息放到body体里
     * 用@RequestParam接收
     *
     * return 失败
     */
    @RequestMapping(method = RequestMethod.POST, path = "/body2param")
    public B2bPayTransInfo body2param(@RequestParam("Plain") String plain, @RequestParam("Signature") String signature) {
        B2bPayTransInfo info = B2bPayTransInfo.builder().plain(plain).signature(signature).build();
        return info;
    }

    /**
     * 请求信息放到body体里
     * 用@RequestBody接收
     *
     * return 失败
     */
    @RequestMapping(method = RequestMethod.POST, path = "/body2body")
    public String body2body(@RequestBody String info) {
        return info;
    }

    /**
     * 请求信息放到Param里
     * 用@RequestParam接收
     *
     * return 成功
     */
    @RequestMapping(method = RequestMethod.POST, path = "/param2param")
    public B2bPayTransInfo param2param(@RequestParam("Plain") String plain, @RequestParam("Signature") String signature) {
        B2bPayTransInfo info = B2bPayTransInfo.builder().plain(plain).signature(signature).build();
        return info;
    }

    /**
     * 请求信息放到Param里
     * 用@RequestBody接收
     *
     * 如果 content-type: application/x-www-form-urlencoded; charset=GBK
     *    成功
     */
    @RequestMapping(method = RequestMethod.POST, path = "/param2body")
    public String param2body(@RequestBody String body) {
        return body;
    }


    /**
     * 请求体是XML格式
     *
     *
     B2bPayTransInfo 对应的报文

     <packet>
     <transName>交易名称</transName>
     <Plain>交易请求明文</Plain>
     <Signature>交易请求明文的签名</Signature>
     </packet>

     使用了Jackson 成功
     */
    @RequestMapping(method = RequestMethod.POST, path = "/requestXml",
            consumes = MediaType.TEXT_XML_VALUE)
    public B2bPayTransInfo requestXml(@RequestBody B2bPayTransInfo info) {
        return info;
    }
}
