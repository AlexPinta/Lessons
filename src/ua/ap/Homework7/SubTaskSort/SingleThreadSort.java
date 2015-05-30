package ua.ap.Homework7.SubTaskSort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 27.05.15
 * Time: 7:07
 * @version: 1.0
 */
public class SingleThreadSort {
    private long[] arrayOfLongs;

    public SingleThreadSort(long[] pArrayOfLongs) {
        arrayOfLongs = pArrayOfLongs;
    }
    public void quickSort(){
        startSort(0, arrayOfLongs.length-1);
    }

    private void startSort(int first, int last) {
        int i = first;
        int j = last;
        long x = arrayOfLongs[(first + last) / 2];
        long temp =0;
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
        if (i < last)
            startSort(i, last);
        if (first < j)
            startSort(first, j);
    }

}
