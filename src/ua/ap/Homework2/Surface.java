package ua.ap.Homework2;

import java.util.ArrayList;

public class Surface {
    private final int CAPACITY_OF_ARRAY = 4;
    private Shape shapeDefault = null;
    private ArrayList<Shape> arrayList = new ArrayList<Shape>();

    Surface() {
        for (int i = 0; i < CAPACITY_OF_ARRAY; i++) {
            arrayList.add(shapeDefault);
        }
    }
    public boolean paste(Shape element, int index){
        if (arrayList.get(index) == null) {
            arrayList.set(index, element);
            return true;
        } else {
            System.out.println("The cell with index " + index + " is full");
            return false;
        }
    }

    public boolean remove(int  index) {
        try {
            arrayList.set(index, null);
            return true;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Index " + index + " out of boundary");
            return false;
        }  catch (Exception e) {
            System.out.println("Any error!");
            return false;
        }
    }

    public void printInfo(){
        for (int i = 0; i < CAPACITY_OF_ARRAY; i++) {
            System.out.println("Cell ["+(i+1)+"] consist of: " + (arrayList.get(i) != null ? arrayList.get(i).toString() : "nothing"));
        }
        System.out.println("");
    }

    public double getArea() {
        Shape objShape;
        double summeryArea = 0.00;
        for (int i = 0; i < CAPACITY_OF_ARRAY; i++) {
            objShape = arrayList.get(i);
            //interpretation elements to parent class - for using method
            summeryArea += (double) (objShape == null ? 0.00 : objShape.getArea());
        }

        return summeryArea;
    }
}
