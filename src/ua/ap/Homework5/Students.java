package ua.ap.Homework5;

import java.io.Serializable;

/**
 * @author  Alex Pinta
 * @version  %I%, %G%
 */
public class Students extends Person implements Serializable {
    private static final long serialVersionUID = -2901393642175302255L;
    private int course;

    public Students(String name, String surName, char sex, int age, int course) {
        super(name, surName, sex, age);
        this.course = course;
    }

    public Students(){ }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String printInfo() {
        return super.printInfo() + " course: " + getCourse();
    }


}
