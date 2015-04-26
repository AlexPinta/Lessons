package ua.ap.Homework2;

public class Triangle extends Shape{

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double halfOfPerimeter = (double) 1/2*getPerimeter();
        return Math.sqrt(halfOfPerimeter*(halfOfPerimeter - a.getDistance(b))*(halfOfPerimeter - b.getDistance(c))*(halfOfPerimeter - c.getDistance(a)));
    }

    @Override
    public double getPerimeter() {
        return a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!a.equals(triangle.a)) return false;
        if (!b.equals(triangle.b)) return false;
        if (!c.equals(triangle.c)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle: area - " + getArea() + " getPerimeter - " + getPerimeter() + " class name: " + getClass();
    }
}
