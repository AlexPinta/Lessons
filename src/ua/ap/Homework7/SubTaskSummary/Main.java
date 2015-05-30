package ua.ap.Homework7.SubTaskSummary;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 26.05.15
 * Time: 9:59
 * @version: 1.0
 */
public class Main {
    public static void main(String args[]){
        long[] arrayLong = new long[2000000];
        Random locRandom = new Random(50000);
        for (int i = 0; i < arrayLong.length; i++) {
            arrayLong[i] = locRandom.nextLong();
        }

        System.out.println("Start single thread.....");
        long startTime = System.currentTimeMillis();
        SingleThread locSingleThread = new SingleThread(arrayLong);
        System.out.println("Value: " + locSingleThread.calc());
        System.out.println("Time execute: " + (System.currentTimeMillis() - startTime));

        System.out.println("Start plural threads with executors.....");
        startTime = System.currentTimeMillis();
        Proxy locProxy = new Proxy(arrayLong);
        System.out.println("Value: " + locProxy.calc());
        System.out.println("Time execute: " + (System.currentTimeMillis() - startTime));

        System.out.println("Start plural threads common realization.....");
        startTime = System.currentTimeMillis();
        MultiThread locMultiThread = new MultiThread(arrayLong);
        System.out.println("Value: " + locMultiThread.calc());
        System.out.println("Time execute: " + (System.currentTimeMillis() - startTime));

    }
}
