package com.kavlez.pojo;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
public class Teacher {
    private Subject subject;
    private String name;

    @Override
    public String toString() {
        return "{\"name\":\"" + this.name + "\"}";
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
