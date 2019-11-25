package com.shana.house.qv;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/23
 * @since 1.0.0
 */
@Data
public class Student implements Serializable {
    private int age;
    private String name;
    private String sex;

    public Student(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

