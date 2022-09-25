package com.student.domain;

/*
学生类：    Student
成员变量：
学号： sid
姓名： name
年龄： age
生日： birthday
构造方法：
无参构造
带四个参数的构造
成员方法：
每个成员变量对应给出get/set方法
 */

public class Student {
    //1. 私有化成员变量
    private String sid;

    private String name;
    private int age;

    private String birthday;


    //2. 构造空参方法
    public Student() {
    }

    //3. 构造带全部参数方法


    public Student(String sid, String name, int age, String birthday) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    //4. 创建 set/get 方法

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
