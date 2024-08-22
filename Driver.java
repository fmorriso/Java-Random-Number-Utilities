import java.text.NumberFormat;

public class Driver {

    private static final NumberFormat formatter = NumberFormat.getNumberInstance();

    public static void main(String[] args) {
        System.out.format("Java Random Number Utilities using Java version %s%n", getJavaVersion());

        int iterations = 1_000_000;

        testRandomDouble(10, 20, iterations);
        testRandomDouble(1, 2, iterations);

        testRandomDoubleWithTolerance(10, 20, 0.001, iterations);
        testRandomDoubleWithTolerance(1, 2, 0.001, iterations);

        testRandomDouble(-100, 100, iterations);
        testRandomDoubleWithTolerance(-100, 100, 0.001, iterations);
        testRandomDoubleWithTolerance(-100, 100, 0.01, iterations);
        testRandomDoubleWithTolerance(-100, 100, 0.1, iterations);
        testRandomDoubleWithTolerance(-100, 100, 1.0, iterations);

        testRandomWholeNumber(100, 200, iterations);
        testRandomWholeNumber(1, 6, iterations);

        // These will throw exceptions, so leave commented unless curious
        // testRandomWholeNumber(6, 1, iterations);
        // testRandomDouble(2, 1, iterations);
    }

    private static void testRandomWholeNumber(int min, int max, int iterations) {

        System.out.format("Min: %d, Max: %d, Iterations: %s%n", min, max, formatter.format(iterations));

        int highestValue = Integer.MIN_VALUE;
        int highestCount = 0;

        int lowestValue = Integer.MAX_VALUE;
        int lowestCount = 0;

        int n;

        for (int i = 0; i < iterations; i++) {
            n = RandomNumberUtilities.getRandomIntInRange(min, max);
//            System.out.format("x = %d%n", n);

            lowestValue = Math.min(lowestValue, n);
            highestValue = Math.max(highestValue, n);

            if (n == max) highestCount++;
            else if (n == min) lowestCount++;
        }

        System.out.format("highestValue = %d, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %d, count=%d%n", lowestValue, lowestCount);
    }


    private static void testRandomDoubleWithTolerance(double min, double max, double tolerance, int iterations) {

        System.out.format("Min: %.1f, Max: %.1f, Iterations: %s, tolerance=%.5f%n", min, max, formatter.format(iterations), tolerance);

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;
        int lowestCount = 0;

        double x;

        for (int i = 0; i < iterations; i++) {
            x = RandomNumberUtilities.getRandomDoubleInRangeWithTolerance(min, max, tolerance);
//            System.out.format("x = %.4f%n", x);

            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);

            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);
    }

    private static void testRandomDouble(double min, double max, int iterations) {

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;
        int lowestCount = 0;

        System.out.format("Min: %.1f, Max: %.1f, Iterations: %s%n", min, max, formatter.format(iterations));

        double x;
        for (int i = 0; i < iterations; i++) {
            x = RandomNumberUtilities.getRandomDoubleInRange(min, max);
            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);
            // System.out.format("x = %.2f%n", x);
            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);
    }

    /**
     * get the java version that is running the current program
     *
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion() {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }

}
