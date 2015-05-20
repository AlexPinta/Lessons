package ua.ap.Homework6;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 20.05.15
 * Time: 13:13
 * @version: 1.0
 */
public class Factorial implements Runnable{
    private int i;
    private BigInteger result;

    public Factorial(int i) {
        this.i = i;
        Thread locThread = new Thread(this);
        locThread.setDaemon(true);
        //this.result = calculate();
        locThread.start();

    }

    public BigInteger getResult() {
        return result;
    }

    @Override
    public void run() {
        this.result = calculate();
    }

    private BigInteger calculate(){
        if(this.i < 0)  {
            return BigInteger.ZERO;
        }

        if (this.i == 0)
            return BigInteger.ONE;
        else
            this.i -= 1;
            return BigInteger.valueOf(this.i+1).multiply(calculate());
    }
}
