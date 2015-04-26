package ua.ap.Homework2;

public class Rectangle extends Shape {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    @Override
    public double getArea() {
        return a.getDistance(b) * b.getDistance(c);
    }

    @Override
    public double getPerimeter() {
        return 2*(a.getDistance(b) + b.getDistance(c));
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!a.equals(rectangle.a)) return false;
        if (!b.equals(rectangle.b)) return false;
        if (!c.equals(rectangle.c)) return false;
        if (!d.equals(rectangle.d)) return false;

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
        return "Rectangle: area - " + getArea() + " getPerimeter - " + getPerimeter() + " class name: " + getClass();
    }
}