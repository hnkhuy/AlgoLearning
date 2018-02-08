import java.util.Arrays;

/**
 * Created by huy.huynh on 08/02/2018.
 */
public class Listed {
    public void listedArray() {
        int k = 3;
        int n = 5;

        printArray(getFirstArray(k));
        printArray(getLastArray(k, n));
        int[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, k, n);
            printArray(previousArray);
        } while (previousArray != null);
    }

    private int[] getNextArray(int[] previousArray, int k, int n) {
        if (previousArray == null) {
            return getFirstArray(k);
        } else if (Arrays.equals(previousArray, getLastArray(k, n))) {
            return null;
        } else {
            return buildNextArray(previousArray, k, n);
        }
    }

    private int[] buildNextArray(int[] previousArray, int k, int n) {
        int max0 = 3;
        int max1 = 4;
        int max2 = 5;
        int min0 = 1;
        int min1 = 2;
        int min2 = 3;

        //        for (int i = k - 1; i > 0; i--) {
        if (previousArray[k - 1] < max2) {
            previousArray[k - 1]++;
            return previousArray;
        } else if (previousArray[k - 2] < max1) {
            previousArray[k - 2]++;
            previousArray[k - 1] = min2;
            return previousArray;
        } else {
            previousArray[k - 3]++;
            previousArray[k - 2] = min1;
            previousArray[k - 1] = min2;
            return previousArray;
        }
    }
    //    }

    private int[] getFirstArray(int k) {
        int first[] = new int[k];
        for (int i = 0; i < k; i++) {
            first[i] = i + 1;
        }
        return first;
    }

    private int[] getLastArray(int k, int n) {
        int last[] = new int[k];
        for (int i = 0; i < k; i++) {
            last[k - i - 1] = n - i;
        }
        return last;
    }

    private void printArray(int[] array) {
        //        System.out.println(String.format("{%s, %s, %s}", array[0], array[1], array[2]));
        String printBuffer = "{";
        for (int i = 0; i <= array.length; i++) {
            if (i != array.length) {
                printBuffer += array[i] + ", ";
            } else {
                printBuffer += "}";
            }
        }
        System.out.println(printBuffer.replace(", }", "}"));
    }
}
