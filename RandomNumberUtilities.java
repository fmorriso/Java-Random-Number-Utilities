import java.util.Random;

public class RandomNumberUtilities {
    private static Random rand = new Random();

    public static double getRandomDoubleInRange(double min, double max) {
        return rand.nextDouble() * (max - min) + min;
    }

    public static double getRandomDoubleInRangeWithTolerance(double min, double max, double tolerance) {
        double minWithTolerance = min - tolerance;
        double maxWithTolerance = max + tolerance;
        double range = maxWithTolerance - minWithTolerance;

        double randomNumber = rand.nextDouble() * range + minWithTolerance;
        if (randomNumber >= min && randomNumber <= max) {
            return randomNumber;
        }
        else if (randomNumber < min) {
            return min;
        }
        else
            return max;
    }
    public static int getRandomIntInRange(int min, int max) {
        return rand.nextInt() * (max - min) + min;
    }
}
