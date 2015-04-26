package ua.ap.Homework2;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Surface newSurface = new Surface();
        //initalization....
        newSurface.printInfo();

        newSurface.paste(new Triangle(new Point(4,3), new Point(6,8), new Point(12,3)),0);
        newSurface.paste(new Square(new Point(0,0), new Point(0,8), new Point(8,8), new Point(8,0)),1);
        newSurface.paste(new Rectangle(new Point(0,0), new Point(0,4), new Point(12,4), new Point(12,0)),2);
        newSurface.paste(new Triangle(new Point(0,0), new Point(3,12), new Point(12,1)),3);
        //added all elements to collection
        newSurface.printInfo();

        //trying add element to full cell
        newSurface.paste(new Triangle(new Point(10,7), new Point(15,12), new Point(17,5)),1);

        //last try with added element didn't agree surface class

        newSurface.printInfo();
        System.out.println("Summary area of surface: " + newSurface.getArea());

        //remove elements with exception..... it's for example

        for (int i = 0; i <= 3; i++){
            newSurface.remove(i);
        }

        newSurface.printInfo();

        System.out.println("Summary area of surface: " + newSurface.getArea());
    }
}
