package WeightedRandom;

import java.util.Arrays;

/**
 * Created by huy.huynh on 18/06/2018.
 */
public class WeightedRandomMain {
    public static void main(String[] args) {
        Message[] messageCenter = new Message[]{
                new Message(GenericData.GOOD_MESSAGE, 90),
                new Message(GenericData.MEDIUM_MESSAGE, 9),
                new Message(GenericData.BAD_MESSAGE, 1)}; //   <----- N = 3

        int messageOfVersion=1000;//   <----- message number

        int[] counter = new int[messageCenter.length];

        int[] weights = Arrays.stream(messageCenter).mapToInt(message -> message.getWeighth()).toArray();

        for (int i = 0; i < messageOfVersion; i++) {
            counter[WeightedRandom.getWeightedRandomMessageIndex(weights)]++;
        }

        for (int i = 0; i < counter.length; i++) {
            System.out.println("Message: " + messageCenter[i].getMessageContent() + " - " + counter[i]+ " time(s).");
        }

    }
}
