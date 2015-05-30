package ua.ap.Homework7.SubTaskSort;

import ua.ap.Homework7.SubTaskSummary.MultiThread;
import ua.ap.Homework7.SubTaskSummary.Proxy;
import ua.ap.Homework7.SubTaskSummary.SingleThread;

import java.util.Arrays;
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
        long[] arrayLong = new long[20000];
        Random locRandom = new Random(5000);
        ThreadGroup locThreadGroup = new ThreadGroup("MyGroup");

        for (int i = 0; i < arrayLong.length; i++) {
            arrayLong[i] = locRandom.nextLong();
        }
        long[] tempArray = arrayLong.clone();
        System.out.println("Start native method:");
        long startTime = System.currentTimeMillis();
        Arrays.sort(tempArray);
        System.out.println("Time execute: " + (System.currentTimeMillis() - startTime));

        /*for (int i = 0; i < tempArray.length; i++) {
            System.out.print(tempArray[i] + " ");
        }
        System.out.println();   */

        tempArray = arrayLong.clone();
        System.out.println("Start single thread sort:");
        startTime = System.currentTimeMillis();
        SingleThreadSort locSingleThreadSort = new SingleThreadSort(tempArray);
        locSingleThreadSort.quickSort();
        System.out.println("Time execute: " + (System.currentTimeMillis() - startTime));

        /*for (int i = 0; i < tempArray.length; i++) {
            System.out.print(tempArray[i] + " ");
        }
        System.out.println();   */

        tempArray = arrayLong.clone();
        System.out.println("Start multi thread sort:");
        startTime = System.currentTimeMillis();
        MultiThreadSort locMultiThreadSort = new MultiThreadSort(tempArray, locThreadGroup);
        locMultiThreadSort.quickSort();
        try {
            locMultiThreadSort.getT().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean allThreadIsDone = false;
        while (!allThreadIsDone) {
            int countOfThread = locThreadGroup.activeCount();
            Thread[] arrayOfThread = new Thread[countOfThread];
            locThreadGroup.enumerate(arrayOfThread);
            for (Thread elem : arrayOfThread) {
                if (elem == null || elem.isAlive()) {
                    allThreadIsDone = false;
                    break;
                } else {
                    allThreadIsDone = true;
                }
            }
            if (arrayOfThread.length == 0) break;
            if (allThreadIsDone && countOfThread == locThreadGroup.activeCount()) break;
        }
        System.out.println("Time execute: " + (System.currentTimeMillis() - startTime));

        /*for (int i = 0; i < tempArray.length; i++) {
            System.out.print(tempArray[i] + " ");
        }
        System.out.println();  */

    }

}
