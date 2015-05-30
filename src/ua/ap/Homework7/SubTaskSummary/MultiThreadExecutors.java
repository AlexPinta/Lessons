package ua.ap.Homework7.SubTaskSummary;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 26.05.15
 * Time: 14:19
 * @version: 1.0
 */
public class MultiThreadExecutors implements Callable <Long>{
    private long[] arrayLong;
    private int startPosition;
    private int endPosition;

    public MultiThreadExecutors(long[] pArrayLong, int pStartPosition, int pEndPosition) {
        arrayLong = pArrayLong;
        startPosition = pStartPosition;
        endPosition = pEndPosition;
    }

    @Override
    public Long call() throws Exception {
        long summ = 0;
        for (int i = this.startPosition; i <= this.endPosition; i++) {
            summ += arrayLong[i];
        }
        return summ;
    }
}
