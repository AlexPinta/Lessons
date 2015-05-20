package ua.ap.Homework6;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 17.05.15
 * Time: 23:27
 * @version: 1.0
 */
public class Main{
    public static void main(String args[]) {
        final int  count = 100;
        Factorial[] arrayThread = new Factorial[count];
        GeoProgression[] locGeoProgressions = new GeoProgression[count];

        for (int i = 0; i < count; i++) {
            arrayThread[i] = new Factorial(i);
            locGeoProgressions[i] = new  GeoProgression(i);
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Factorial " + i + " = " +arrayThread[i].getResult());
        }
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println("Geometric progression " + i + " = " +locGeoProgressions[i].getResult());
        }
    }


}