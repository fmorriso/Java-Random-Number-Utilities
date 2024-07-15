import java.text.NumberFormat;

public class Driver {

    public static void main(String[] args) {
        System.out.format("Java Random Number Utilities using Java version %s%n", getJavaVersion());
        testRandomDouble(10, 20);
        testRandomDouble(1, 2);
        testRandomDoubleWithTolerance(10, 20, 0.001);
        testRandomDoubleWithTolerance(1, 2, 0.001);
    }

    private static void testRandomDoubleWithTolerance(double min, double max, double tolerance) {
        NumberFormat formatter = NumberFormat.getNumberInstance();

        int maxIterations = 1_000_000;
        System.out.format("Max Iterations: %s%n", formatter.format(maxIterations));

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;;
        int lowestCount = 0;

        for (int i = 0; i < maxIterations; i++) {
            double x = RandomNumberUtilities.getRandomDoubleInRangeWithTolerance(min, max, tolerance);
//            System.out.format("x = %.4f%n", x);

            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);

            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);
    }

    private static void testRandomDouble(double min, double max) {
        NumberFormat formatter = NumberFormat.getNumberInstance();

        double highestValue = 0;
        int highestCount = 0;

        double lowestValue = Double.MAX_VALUE;;
        int lowestCount = 0;

        int maxIterations = 1_000_000;
        System.out.format("Max Iterations: %s%n", formatter.format(maxIterations));

        for (int i = 0; i < maxIterations; i++) {
            double x = RandomNumberUtilities.getRandomDoubleInRange(min, max);
            lowestValue = Math.min(lowestValue, x);
            highestValue = Math.max(highestValue, x);
            // System.out.format("x = %.2f%n", x);
            if (x == max) highestCount++;
            else if (x == min) lowestCount++;
        }

        System.out.format("highestValue = %.6f, count = %d%n", highestValue, highestCount);
        System.out.format("lowestValue = %.6f, count=%d%n", lowestValue, lowestCount);
    }

    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }
}
