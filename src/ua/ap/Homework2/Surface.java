package ua.ap.Homework2;

import java.util.ArrayList;

/**
 * @author Alex Pinta
 * @version  1.0
 *
 * Class Surface is arrayList prototype
 * there is final capacity of arrayList = 4
 *
 * for add/remove element use:
 * @see #paste(Shape, int)
 * @see #remove(int)
 */
public class Surface {
    private final int CAPACITY_OF_ARRAY = 4;
    private Shape shapeDefault = null;
    private ArrayList<Shape> arrayList = new ArrayList<Shape>(CAPACITY_OF_ARRAY);

    Surface() {
        for (int i = 0; i < CAPACITY_OF_ARRAY; i++) {
            arrayList.add(shapeDefault);
        }
    }

    /**
     * @param element  The element, which will be added in arrayList
     * @param index    The index for operation paste
     * @return boolen  true - when operation agree, false - disagree operation
     *
     * @exception IndexOutOfBoundsException  If you try to add element out of capacity
     */
    public boolean paste(Shape element, int index){
        try {
            if (arrayList.get(index) == null) {
                arrayList.set(index, element);
                return true;
            } else {
                System.out.println("The cell with index " + index + " is full");
                return false;
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Index " + index + " out of boundary");
            return false;
        }  catch (Exception e) {
            System.out.println("Any error!");
            return false;
        }
    }

    /**
     * @param index   index of removed element
     * @return boolen true - when operation agree, false - disagree operation
     *
     * @exception IndexOutOfBoundsException  If you try to remove element out of capacity
     */
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
            summeryArea += (double) (objShape == null ? 0.00 : objShape.getArea());
        }

        return summeryArea;
    }
}
