public class GoldenSectionSearch {
    // Function to minimize (replace this with the actual function)
    private static double f(double x) {
        // Placeholder function definition
        return (x * x) - 4 * x + 4; // Example: f(x) = x^2 - 4x + 4
    }

    public static double goldenSectionSearch(double a, double b, double tolerance) {
        double tau = (Math.sqrt(5) - 1) / 2;
        double x1 = b - tau * (b - a);
        double x2 = a + tau * (b - a);
        double f1 = f(x1);
        double f2 = f(x2);

        while ((b - a) > tolerance) {
            if (f1 > f2) {
                a = x1;
                x1 = x2;
                x2 = b - (x1 - a);
                f1 = f2;
                f2 = f(x2);
            } else {
                b = x2;
                x2 = x1;
                x1 = a + (b - x2);
                f2 = f1;
                f1 = f(x1);
            }
        }

        // The minimum lies within the interval [a, b]
        // We return the midpoint as the best estimate of the minimum location
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        double a = 0; // lower bound of the interval
        double b = 2; // upper bound of the interval
        double tolerance = 1e-5; // tolerance

        double minimum = goldenSectionSearch(a, b, tolerance);
        System.out.println("The minimum is at: " + minimum);
    }
}
