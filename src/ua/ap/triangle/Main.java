package ua.ap.triangle;

public class Main {
    //method for testing some opportunity triangle
    public static void main(String[] args) {
        Triangle[] arrayOfTriangle = new Triangle[5];

        double paramHeight = 8.0;
        double paramMainSide = 7.0;
        for (int i = 0; i < arrayOfTriangle.length; i++) {
            arrayOfTriangle[i] = new Triangle(paramHeight, paramMainSide);
            paramHeight += 3.4;
            paramMainSide -= 0.3;
        }
        System.out.println("Initialization of instances....");
        for (int i = 0; i < arrayOfTriangle.length; i++) {
            arrayOfTriangle[i].print();
        }
        arrayOfTriangle[1].setheight(10.2);
        arrayOfTriangle[1].setheight(14.3);

        System.out.println("Result after changes....");
        for (int i = 0; i < arrayOfTriangle.length; i++) {
            arrayOfTriangle[i].print();
        }
    }

}
