package ua.ap.Homework6;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 20.05.15
 * Time: 16:48
 * @version: 1.0
 */
public class GeoProgression implements Runnable{
    private final int znamenatel = 2;
    private int i;
    private double result;
    public GeoProgression(int i) {
        this.i = i;
        Thread locThread = new Thread(this);
        locThread.setDaemon(true);
        locThread.start();

    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        result = 1*(Math.pow(znamenatel, this.i) - 1)/(znamenatel - 1);
    }
}
