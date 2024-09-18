import java.util.List;
import java.util.*;

public class RsiCalculator {
//will only return actual rsi values for the last 3 of nine timepoints because of the way RSI is calculated.
    public static double[] getRSI(double[] prices, int n) {
        double[] deltas = new double[prices.length - 1];

        for (int i = 0; i < deltas.length; i++) {
            deltas[i] = prices[i+1] - prices[i];
        }

        double[] seed = Arrays.copyOfRange(deltas, 0, n+1);
        double up = 0, down = 0;

        for (int i = 0; i < seed.length; i++) {
            if (seed[i] >= 0) {
                up += seed[i];
            } else {
                down += Math.abs(seed[i]);
            }
        }

        up /= n;
        down /= n;

        double[] rs = new double[prices.length];
        double[] rsi = new double[prices.length];
        rs[n] = up / down;
        rsi[n] = 100.0 - 100.0 / (1.0 + rs[n]);

        for (int i = n+1; i < prices.length; i++) {
            double delta = deltas[i-1];

            if (delta >= 0) {
                up = (up * (n-1) + delta) / n;
                down = (down * (n-1)) / n;
            } else {
                down = (down * (n-1) + Math.abs(delta)) / n;
                up = (up * (n-1)) / n;
            }

            rs[i] = up / down;
            rsi[i] = 100.0 - 100.0 / (1.0 + rs[i]);
        }

        return rsi;
    }

    public static void main(String[] args) {
        double[] prices = {10.0, 11.0, 12.0, 11.5, 11.0, 10.5, 11.0, 11.5, 12.0, 13.0};
        double[] rsi = getRSI(prices, 7);

        for (int i = 0; i < rsi.length; i++) {
            System.out.println("RSI[" + i + "] = " + rsi[i]);
        }
    }
}
