package com.jinping.interview.test;

/**
 * @Classname Person
 * @Description
 * @Date 2020/12/23 11:16 上午
 * @Created by jinping
 */
public class Person {
    private int id;
    private String name;
    private int pid;

    public Person(int id, String name, int pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
