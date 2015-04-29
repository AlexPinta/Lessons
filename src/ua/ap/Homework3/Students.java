package ua.ap.Homework3;

/**
 * @author  Alex Pinta
 * @version  %I%, %G%
 */
public class Students extends Person{
    private int course;

    public Students(String name, String surName, char sex, int age, int course) {
        super(name, surName, sex, age);
        this.course = course;
    }

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
