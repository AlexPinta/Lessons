package ua.ap.Homework5;

import java.io.Serializable;

/**
 * @author  Alex Pinta
 * @version  %I%, %G%
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 5399411950434847372L;
    private String name;
    private String surName;
    private char sex;
    private  int age;


    public Person(String name, String surName, char sex, int age) {
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        this.age = age;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printInfo(){
        return "I am a " + surName + " " + name + ". " + age + " years old. Sex: " + sex;
    }

}
