package ua.ap.Homework4;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 04.05.15
 * Time: 13:28
 * @version: 1.0
 */
public class Bug implements Comparable {
    private String name;
    private String color;
    private int age;
    private int size;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bug(String name, String color, int age, int size) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Object o) {
//        if (o instanceof Bug) {
//            return 0;
//        }
        Bug b = (Bug) o;
        if (getSize() > b.getSize()) {
            return 1;
        } else if (getSize() < b.getSize()){
            return -1;
        }
        return 0;
    }

    public String printInfo(){
        return "I'm a bug: " + getName() + " color: " + getColor() + " age: " + getAge() + " size: " + getSize();
    }
}

