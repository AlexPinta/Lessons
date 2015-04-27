package ua.ap.Homework2;

/**
 * @author Alex Pinta
 * @version 1.0
 *
 * Class Point use to create some geometric shape
 *
 * access to private property use:
 * @see #getX()
 * @see #getY()
 *
 * for set x,y coordinate use:
 * @see #setX(double)
 * @see #setY(double)
 *
 * use constructor
 * @see #Point(double, double)
 *
 * function, which return distance with other point
 * @see  #getDistance(Point)
 */
public class Point {
    private double x;
    private double y;

    /**
     * Class constructor
     * @param x  the X coordinate
     * @param y  the Y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getDistance(Point point){
        return Math.sqrt(Math.pow(x - point.x,2) + Math.pow(y - point.y,2));
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
