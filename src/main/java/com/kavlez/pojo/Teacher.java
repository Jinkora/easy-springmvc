package com.kavlez.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
public class Teacher {
    private Subject subject;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NumberFormat(pattern = "#,###,##")
    private long salary;

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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
