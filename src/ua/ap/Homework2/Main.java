package ua.ap.Homework2;

import java.util.ArrayList;

/**
 * @author Alex Pinta
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        Surface newSurface = new Surface();
        newSurface.printInfo();

        newSurface.paste(new Triangle(new Point(4,3), new Point(6,8), new Point(12,3)),0);
        newSurface.paste(new Square(new Point(0,0), new Point(0,8), new Point(8,8), new Point(8,0)),1);
        newSurface.paste(new Rectangle(new Point(0,0), new Point(0,4), new Point(12,4), new Point(12,0)),2);
        newSurface.paste(new Triangle(new Point(0,0), new Point(3,12), new Point(12,1)),3);

        newSurface.printInfo();

        newSurface.paste(new Triangle(new Point(10,7), new Point(15,12), new Point(17,5)),1);

        newSurface.printInfo();
        System.out.println("Summary area of surface: " + newSurface.getArea());

        for (int i = 0; i <= 3; i++){
            newSurface.remove(i);
        }

        newSurface.printInfo();

        System.out.println("Summary area of surface: " + newSurface.getArea());
    }
}
