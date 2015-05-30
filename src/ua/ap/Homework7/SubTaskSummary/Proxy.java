package ua.ap.Homework7.SubTaskSummary;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 26.05.15
 * Time: 14:31
 * @version: 1.0
 */
public class Proxy implements Calculable{
    private long[] arrayLong;
    private final int quantityRecord = 50000;
    public Proxy(long[] pArrayLong) {
        arrayLong = pArrayLong;
    }

    @Override
    public long calc() {
        int quantityThread = Math.round(arrayLong.length / quantityRecord);
        boolean allThreadIsDone = false;
        ExecutorService locExecutorService = Executors.newFixedThreadPool(30);
        long Summary = 0;
        if (arrayLong.length % quantityRecord >= 5 && quantityThread > 0) {
            quantityThread--;
        } else if (quantityThread == 0 && arrayLong.length != 0){
            quantityThread++;
        }

        Future<Long>[] arrayFutureResult = new Future[quantityThread];

        for (int counter = 0; counter < quantityThread; counter++){
            MultiThreadExecutors locMultiThreadExecutors = new MultiThreadExecutors(arrayLong, counter*quantityRecord,
                                         (counter == quantityThread-1) ? arrayLong.length-1 : ((counter+1)*quantityRecord-1));

            arrayFutureResult[counter] = locExecutorService.submit(locMultiThreadExecutors);
        }
        long startTime = System.currentTimeMillis();
        int beginPosition = 0;
        while (!allThreadIsDone) {
            for (int futureCounter = beginPosition; futureCounter < arrayFutureResult.length; futureCounter++) {
                try {
                    if (!arrayFutureResult[futureCounter].isDone()) {
                        allThreadIsDone = false;
                        break;
                    } else {
                        beginPosition = futureCounter;
                        allThreadIsDone = true;
                    }
                } catch (NullPointerException ne) {
                    allThreadIsDone = false;
                    break;
                }
            }
            if (System.currentTimeMillis() - startTime > 3600 * 1000) {
                locExecutorService.shutdownNow();
            }
        }

        if (allThreadIsDone) {
            for (int i = 0; i < arrayFutureResult.length; i++) {
                try {
                    Summary += arrayFutureResult[i].get().longValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return 0;
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            return Summary;
        } else {
            return 0;
        }
    }


}
