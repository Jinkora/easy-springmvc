package com.kavlez.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
@XmlRootElement
public class Subject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
