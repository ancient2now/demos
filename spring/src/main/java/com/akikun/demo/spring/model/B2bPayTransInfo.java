package com.akikun.demo.spring.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;

@Data
@Builder
@JacksonXmlRootElement(localName = "packet")
public class B2bPayTransInfo implements Serializable {

    private static final long serialVersionUID = 6131979995224785873L;

    @Tolerate
    public B2bPayTransInfo() {}

    /**
     * 交易名称
     */
    @JacksonXmlProperty(localName = "transName")
    private String transName;

    /**
     * 交易请求明文
     */
    @JacksonXmlProperty(localName = "Plain")
    private String plain;

    /**
     * 交易请求明文的签名
     */
    @JacksonXmlProperty(localName = "Signature")
    private String signature;

}
