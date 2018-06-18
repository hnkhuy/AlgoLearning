package WeightedRandom;

/**
 * Created by huy.huynh on 18/06/2018.
 */
public class WeightedRandomMain {
    public static int getWeightedRandomMessageIndex(int[] w) {
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
            weightRatio[i] = w[i] / totalWeight;
        }
        double randomNumber = Math.random() * totalWeight;
        for (int i = 0; i < w.length; i++) {

        }
        return 0;
    }
}
