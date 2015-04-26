package ua.ap.Homework2;

public class Square extends Shape {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getArea() {
        return Math.pow(a.getDistance(b),2);
    }

    @Override
    public double getPerimeter() {
        return 4*a.getDistance(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        if (!a.equals(square.a)) return false;
        if (!b.equals(square.b)) return false;
        if (!c.equals(square.c)) return false;
        if (!d.equals(square.d)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + d.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Square: area - " + getArea() + " getPerimeter - " + getPerimeter() + " class name: " + getClass();
    }
}
