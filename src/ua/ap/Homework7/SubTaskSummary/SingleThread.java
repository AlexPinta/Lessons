package ua.ap.Homework7.SubTaskSummary;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 26.05.15
 * Time: 10:06
 * @version: 1.0
 */
public class SingleThread implements Calculable{
    private long[] arrayLong;
    public SingleThread(long[] pArrayLong){
        this.arrayLong = pArrayLong;
    }

    @Override
    public long calc() {
        long summary = 0;
        for (long elem : arrayLong){
            summary += elem;
        }
        return summary;
    }
}
