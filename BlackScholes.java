import java.util.Scanner;

public class BlackScholes {
    //please note that:
    //the CDF and ERF methods are used to calculate the cumulative distribution function and error function, respectively, which are required for the Black-Scholes calculation
    //these methods are implemented using an approximation formula sourced from: https://papers.ssrn.com/sol3/papers.cfm?abstract_id=4487559
    //please never use this calculator to make financial or market decisions, as this is a hobbyist project. 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the current stock price: ");
        double S = input.nextDouble();

        System.out.print("Enter the strike price: ");
        double K = input.nextDouble();

        System.out.print("Enter the risk-free interest rate (as a decimal): ");
        double r = input.nextDouble();

        System.out.print("Enter the time to expiration (in years): ");
        double T = input.nextDouble();

        System.out.print("Enter the volatility (as a decimal): ");
        double sigma = input.nextDouble();

        double d1 = (Math.log(S/K) + (r + sigma*sigma/2)*T) / (sigma*Math.sqrt(T));
        double d2 = d1 - sigma*Math.sqrt(T);

        double callPrice = S*CDF(d1) - K*Math.exp(-r*T)*CDF(d2);
        double putPrice = K*Math.exp(-r*T)*CDF(-d2) - S*CDF(-d1);

        System.out.println("Call option price: %.2f%n", callPrice);
        System.out.println("Put option price: %.2f%n", putPrice);
    }

    public static double CDF(double x) {
        return 0.5*(1.0 + erf(x/Math.sqrt(2.0)));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5*Math.abs(z));

        double ans = 1 - t*Math.exp(-z*z - 1.26551223 + t*(1.00002368 + t*(0.37409196 + t*(0.09678418 + t*(-0.18628806 + t*(0.27886807 + t*(-1.13520398 + t*(1.48851587 + t*(-0.82215223 +  t*0.17087277)))))))));

        if (z >= 0.0) {
            return ans;
        } else {
            return -ans;
        }
    }
}
