package ua.ap.Homework7.SubTaskSummary;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 26.05.15
 * Time: 21:22
 * @version: 1.0
 */
public class MultiThread implements Calculable{

    private long[] arrayLong;
    private final int quantityRecord = 50000;
    private int quantityThread;
    //private long Summary = 0;
    public MultiThread(long[] pArrayLong) {
        arrayLong = pArrayLong;
        quantityThread = Math.round(arrayLong.length / quantityRecord);
        if (arrayLong.length % quantityRecord >= 5 && quantityThread > 0) {
            quantityThread--;
        } else if (quantityThread == 0 && arrayLong.length != 0){
            quantityThread++;
        }
    }

    private class ThreadInstance implements Runnable {
        private int start;
        private int end;
        protected long summ;

        private ThreadInstance(int pStart, int pEnd) {
            start = pStart;
            end = pEnd;
        }

        public long getSumm() {
            return summ;
        }

        @Override
        public void run() {
            for (int i = this.start; i <= this.end; i++) {
                summ += arrayLong[i];
            }
        }
    }

    @Override
    public long calc() {
        ThreadInstance[] arrayThread = new ThreadInstance[quantityThread];
        for (int counter = 0; counter < quantityThread; counter++){
            arrayThread[counter] = new ThreadInstance(counter*quantityRecord, (counter == quantityThread-1) ? arrayLong.length-1 : ((counter+1)*quantityRecord-1));
            Thread t = new Thread(arrayThread[counter]);
            try {
                t.start();
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long summary = 0;
        for (int i = 0; i < arrayThread.length; i++) {
            summary += arrayThread[i].getSumm();
        }
        return summary;
    }


}
