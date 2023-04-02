import java.io.*;
import java.util.*;

public class BARCHCalculator {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java BARCHCalculator <filename> <alpha>");
            return;
        }

        String filename = args[0];
        double alpha = Double.parseDouble(args[1]);

        List<Double> returns = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                double value = Double.parseDouble(line);
                returns.add(value);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int n = returns.size();
        double[] z = new double[n];
        double[] sigma = new double[n];
        double[] h = new double[n];

        //compute z scores
        double mean = 0;
        for (int i = 0; i < n; i++) {
            mean += returns.get(i);
        }
        mean /= n;
        for (int i = 0; i < n; i++) {
            z[i] = (returns.get(i) - mean) / Math.sqrt(n);
        }

        //compute volatility estimates
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += z[j] * z[i - j];
            }
            sigma[i] = Math.sqrt(sum / n);
        }

        //compute h values
        h[0] = sigma[0] * sigma[0];
        for (int i = 1; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += h[j] * z[i - j - 1] * z[j];
            }
            h[i] = alpha + (1 - alpha) * sum / (i + 1);
        }

        double barch = Math.sqrt(h[n - 1]) * Math.sqrt(n);
        System.out.printf("BARCH(%d) estimate: %.4f\n", n, barch);
    }
}
