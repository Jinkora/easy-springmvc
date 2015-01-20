package com.kavlez.pojo;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 */
public class Teacher {
    private Subject subject;
    private String name;
    private Gender gender;

    @Override
    public String toString() {
        return "{\"name\":\""+this.name+"\"}";
    }

    public enum Gender{
        Male,Female;

        Gender() {
        }
    }

    public Gender getGender() {
        return this.gender!=null?gender:Gender.Male;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
