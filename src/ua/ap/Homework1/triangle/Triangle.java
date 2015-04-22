package ua.ap.triangle;

public class Triangle {

    private double height;
    private double mainSide;
    private double square;

    public Triangle(double height, double mainSide) {
        this.height 	= height;
        this.mainSide 	= mainSide;
        CalculateSquare();
    }
    public Triangle() {}

    public double getheight() {
        return height;
    }
    public void setheight(double height) {
        this.height = height;
        CalculateSquare();
    }
    public double getmainSide() {
        return mainSide;
    }
    public void setmainSide(double mainSide) {
        this.mainSide = mainSide;
        CalculateSquare();
    }

    public double getSquare() {
        return square;
    }

    public void CalculateSquare(){
        this.square = (double) 1/2*height*mainSide;
    }

    public void print() {
        System.out.println("Description of triangle:");
        System.out.println("Height: " + height);
        System.out.println("MainSide: " + mainSide);
        System.out.println("Square: " + square + "\n");
    }
}
