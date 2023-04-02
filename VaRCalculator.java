import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VaRCalculator {
    public static void main(String[] args) {
        File file = new File(args[0]);
        ArrayList<Double> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.add(Double.parseDouble(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        double alpha = Double.parseDouble(args[1]);
        Collections.sort(data);
        int index = (int) Math.ceil(alpha * data.size());
        double var = data.get(index - 1);
        
        System.out.printf("VaR at %.2f%% confidence level is %.2f\n", alpha * 100, var);
    }
}
