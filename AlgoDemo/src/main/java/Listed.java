import java.util.*;

/**
 * Created by huy.huynh on 08/02/2018.
 */
public class Listed {
    public void listedArray() {
        int k = 3;
        int n = 5;

        printArray(getFirstArray(k));
        printArray(getLastArray(k, n));
        System.out.println("");

        //        printArray(getMinInPosition(k));
        //        printArray(getMaxInPosition(k, n));

        int[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, k, n);
            if (previousArray != null && checkDuplicateByAlgorithm(previousArray))
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
        int[] maxInPosition = getLastArray(k, n);
        int[] minInPosition = getFirstArray(k);

        //        for (int i = k - 1; i > 0; i--) {
        if (previousArray[k - 1] < maxInPosition[k - 1]) {
            previousArray[k - 1]++;
            return previousArray;
        } else if (previousArray[k - 2] < maxInPosition[k - 2]) {
            previousArray[k - 2]++;
            previousArray[k - 1] = minInPosition[k - 1];
            return previousArray;
        } else {
            previousArray[k - 3]++;
            previousArray[k - 2] = minInPosition[k - 2];
            previousArray[k - 1] = minInPosition[k - 1];
            return previousArray;
        }

    }

    private boolean checkDuplicateByAlgorithm(int[] array) {
        for (int j = 0; j < array.length; j++)
            for (int k = j + 1; k < array.length; k++)
                if (k != j && array[k] <= array[j])
                    return false;
        return true;
    }

    private boolean checkDuplicateBySet(int[] array) {
        //        Integer[] newArray= array;

        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.valueOf(array[i]);
        }
        Set<Integer> set = new HashSet(Arrays.asList(result));
        if (set.size() == array.length) {
            return true;
        }
        return false;
    }

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

    //    private int[] getMinInPosition(int k) {
    //        int min[] = new int[k];
    //        for (int i = 0; i < k; i++) {
    //            min[i] = i + 1;
    //        }
    //        return min;
    //    }
    //
    //    private int[] getMaxInPosition(int k, int n) {
    //        int max[] = new int[k];
    //        for (int i = 0; i < k; i++) {
    //            max[i] = n + (i - k) + 1;
    //        }
    //        return max;
    //    }

    private void printArray(int[] array) {
        //        System.out.println(String.format("{%s, %s, %s}", array[0], array[1], array[2]));
        if (array == null)
            return;
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
