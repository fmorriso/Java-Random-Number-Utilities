import java.util.Random;

public class RandomNumberUtilities {

    private static Random rand = new Random();

    public static double getRandomDoubleInRange(double min, double max) {
        return rand.nextDouble() * (max - min) + min;
    }

    /**
     * Return a random number of type double in the range between the specified minimum and maximum,
     * inclusive of both the minimum and maximum, using the specified positive, non-zero
     * tolerance.
     *
     * @param min       - the minimum value in the range
     * @param max       - the maximum value in the range
     * @param tolerance - the tolerance to use when generating the random number.
     * @apiNote - The tolerance is subtracted from the minimum and added to the maximum
     * in order to insure that both the minimum and maximum are included in the range
     * of eligible random values.
     */
    public static double getRandomDoubleInRangeWithTolerance(double min, double max, double tolerance) {
        double minWithTolerance = min - tolerance;
        double maxWithTolerance = max + tolerance;
        double range = maxWithTolerance - minWithTolerance;

        double randomNumber = rand.nextDouble() * range + minWithTolerance;
        if (randomNumber >= min && randomNumber <= max) {
            return randomNumber;
        } else if (randomNumber < min) {
            return min;
        } else
            return max;
    }

    public static int getRandomIntInRange(int min, int max) {
        return rand.nextInt() * (max - min) + min;
    }

}
