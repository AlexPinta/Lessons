package ua.ap.Homework3;

/**
 * @author  Alex Pinta
 * @version  %I%, %G%
 */
public class MyThrow extends ArrayIndexOutOfBoundsException {
    public enum ExceptionOperation {ADD, REMOVE};
    private ExceptionOperation curentEO;

    public MyThrow(ExceptionOperation eo) {
        this.curentEO = eo;
    }
    @Override
    public String toString() {
        return "Incorrect " + curentEO.toString() + " operation with array";
    }
}
