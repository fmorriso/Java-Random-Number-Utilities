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

        testRandomDoubleInclusive(-100, 200, iterations);
        testRandomDoubleExclusive(-100, 200, iterations);

        testRandomWholeNumber(100, 200, iterations);
        testRandomWholeNumber(1, 6, iterations);

        // These will throw exceptions, so leave commented unless curious
        // testRandomWholeNumber(6, 1, iterations);
        // testRandomDouble(2, 1, iterations);
    }


    /** Test random generation of whole numbers within a range
     * @param min - the minimum whole number to generate ** INCLUSIVE **
     * @param max - the maximum whole number to generate ** INCLUSIVE **
     * @param iterations - The number of iterations to run to verify the randomness
     */
    private static void testRandomWholeNumber(int min, int max, int iterations) {

        System.out.format("testRandomWholeNumber with min: %d, max: %d, iterations: %s%n", min, max, formatter.format(iterations));

//        System.out.format("Min: %d, Max: %d, Iterations: %s%n", min, max, formatter.format(iterations));

        int highestValue = Integer.MIN_VALUE;
        int highestCount = 0;

        int lowestValue = Integer.MAX_VALUE;
        int lowestCount = 0;

        int n;

        for (int i = 0; i < iterations; i++) {
            n = RandomNumberUtilities.getRandomIntInRange(min, max);
            // System.out.format("x = %d%n", n);

            lowestValue = Math.min(lowestValue, n);
            highestValue = Math.max(highestValue, n);

            if (n == max) highestCount++;
            else if (n == min) lowestCount++;
        }

        System.out.format("highestValue = %d, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %d, count=%d%n", lowestValue, lowestCount);

        System.out.println("=".repeat(80));
    }


    /**
     * Test the randomness of double precision number generation with an explicit tolerance
     * @param min - the minimum double precision number to generate ** INCLUSIVE **
     * @param max - the maximum double precision number to generate ** INCLUSIVE **
     * @param tolerance - the tolerance to use when dealing with double precision random number generation
     * @param iterations - The number of iterations to run to verify the randomness
     */
    private static void testRandomDoubleWithTolerance(double min, double max, double tolerance, int iterations) {
        System.out.format("testRandomDoubleWithTolerance with min: %.1f, max: %.1f, tolerance: %.1f, iterations: %s%n", min, max, tolerance, formatter.format(iterations));

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;
        int lowestCount = 0;

        double x;

        for (int i = 0; i < iterations; i++) {
            x = RandomNumberUtilities.getRandomDoubleInRangeWithTolerance(min, max, tolerance);
            // System.out.format("x = %.4f%n", x);

            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);

            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);

        System.out.println("=".repeat(80));
    }

    /**
     * Test the randomness of double precision number generation with an implicit tolerance
     *
     * @param min - the minimum double precision number to generate ** INCLUSIVE **
     * @param max - the maximum double precision number to generate ** INCLUSIVE **
     * @param iterations - The number of iterations to run to verify the randomness
     */
    private static void testRandomDouble(double min, double max, int iterations) {
        System.out.format("testRandomDouble with min: %.1f, max: %.1f, iterations: %s%n", min, max, formatter.format(iterations));

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;
        int lowestCount = 0;

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

        System.out.println("=".repeat(80));
    }

    private static void testRandomDoubleInclusive(double min, double max, int iterations) {
        System.out.format("testRandomDoubleInclusive with min: %.1f, max: %.1f, iterations: %s%n", min, max, formatter.format(iterations));

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;
        int lowestCount = 0;

        double x;
        for (int i = 0; i < iterations; i++) {
            x = RandomNumberUtilities.getRandomDoubleInRange(min, max, true);
            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);
            // System.out.format("x = %.2f%n", x);
            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);

        System.out.println("=".repeat(80));
    }


    private static void testRandomDoubleExclusive(double min, double max, int iterations) {
        System.out.format("testRandomDoubleExclusive with min: %.1f, max: %.1f, iterations: %s%n", min, max, formatter.format(iterations));

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;
        int lowestCount = 0;

        double x;
        for (int i = 0; i < iterations; i++) {
            x = RandomNumberUtilities.getRandomDoubleInRange(min, max, false);
            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);
            // System.out.format("x = %.2f%n", x);
            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);

        System.out.println("=".repeat(80));
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
