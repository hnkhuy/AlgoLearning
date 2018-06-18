package WeightedRandom;

/**
 * Created by huy.huynh on 18/06/2018.
 */
public class WeightedRandom {
    public static int getWeightedRandomMessageIndex(int[] w) {
        if ((w == null) || (w.length == 0)) {
            throw new RuntimeException("Weight Array should not be null or empty");
        }
        long totalWeight = 0;
        int maxWeightIndex = 0;
        int maxWeight = 0;
        for (int i = 0; i < w.length; i++) {
            totalWeight += w[i];
            if (w[i] > maxWeight) {
                maxWeightIndex = i;
            }
        }
        double weightRatio[] = new double[w.length];
        for (int i = 0; i < w.length; i++) {
            weightRatio[i] = w[i] / (double) totalWeight;
        }
        double randomNumber = Math.random();
        double ratioSum = 0;
        for (int i = 0; i < w.length; i++) {
            ratioSum += weightRatio[i];
            if (ratioSum >= randomNumber) {
                return i;
            }
        }
        return maxWeightIndex;
    }
}
