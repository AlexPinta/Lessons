package ua.ap.Homework7.SubTaskSort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 27.05.15
 * Time: 7:07
 * @version: 1.0
 */
public class MultiThreadSort implements Runnable{
    protected long[] arrayOfLongs;
    private int first;
    private int last;
    private Thread t;

    public MultiThreadSort(long[] pArrayOfLongs, ThreadGroup locThreadGroup) {
        this.arrayOfLongs = pArrayOfLongs;
        this.t = new Thread(locThreadGroup, this);
    }

    public Thread getT() {
        return t;
    }

    @Override
    public void run() {
        //System.out.println("Start thread: " + this.first + " - " + this.last);
        startSort(this.first, this.last);
    }

    public void quickSort() {
        first = 0;
        last = arrayOfLongs.length-1;
        this.t.start();
    }
    private void quickSort(int first, int last) {
        this.first = first;
        this.last = last;
        this.t.start();
    }

    private void startSort(int first, int last){
        int i = first;
        int j = last;
        long x = arrayOfLongs[(first + last) / 2];
        long temp =0;
        MultiThreadSort locMultiThreadSort = null, locMultiThreadSort1  = null;
        do {
            while (arrayOfLongs[i] < x) i++;
            while (arrayOfLongs[j] > x) j--;

            if(i <= j) {
                if (i < j) {
                    temp = arrayOfLongs[i];
                    arrayOfLongs[i] = arrayOfLongs[j];
                    arrayOfLongs[j] = temp;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last){
            locMultiThreadSort = new MultiThreadSort(arrayOfLongs, this.t.getThreadGroup());
            locMultiThreadSort.quickSort(i, last);
            /*try {
                locMultiThreadSort.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } */
        }
        if (first < j)  {
            locMultiThreadSort1 = new MultiThreadSort(arrayOfLongs, this.t.getThreadGroup());
            locMultiThreadSort1.quickSort(first, j);
            /*try {
                locMultiThreadSort1.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } */
        }

        //System.out.println("End thread: " + this.first + " - " + this.last);

    }

}
