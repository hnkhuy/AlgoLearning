package BaiToanLietKe.PhuongPhapSinh;

import Utilities.FileUtils;

import java.util.Arrays;

public class LietKeHoanVi implements GenerateInterface {

    public void permutationArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        int n = Integer.parseInt(output2);

        printArray(getFirstArray(n));
        printArray(getLastArray(0, n));
        System.out.println("-----");

        int[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, n, n);
            printArray(previousArray);
        } while (previousArray != null);
    }

    @Override
    public int[] buildNextArray(int[] previousArray, int k, int n) {
        for (int i = 0; i < n; i++) {
            if ((previousArray[n - i - 2] < previousArray[n - i - 1])) {
                int splitPosition = n - i - 1;

                int[] inFrontArray = Arrays.copyOfRange(previousArray, 0, splitPosition);
                int[] behindArray = Arrays.copyOfRange(previousArray, splitPosition, previousArray.length);

                int pos = findAppropriatePosition(behindArray, previousArray[splitPosition - 1]);
                int swapValue = behindArray[pos];
                behindArray[pos] = inFrontArray[splitPosition - 1];
                inFrontArray[splitPosition - 1] = swapValue;
                Arrays.sort(behindArray);

                int[] nextArray = new int[previousArray.length];
                System.arraycopy(inFrontArray, 0, nextArray, 0, inFrontArray.length);
                System.arraycopy(behindArray, 0, nextArray, inFrontArray.length, behindArray.length);

                return nextArray;
            }
        }
        return null;
    }

    private int findAppropriatePosition(int[] array, int k) {
        int p = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] > k) && (array[i] < array[p])) {
                p = i;
            }
        }
        return p;
    }

    @Override
    public int[] getFirstArray(int n) {
        int first[] = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = i + 1;
        }
        return first;
    }

    @Override
    public int[] getLastArray(int k, int n) {
        int last[] = new int[n];
        for (int i = 0; i < n; i++) {
            last[i] = n - i;
        }
        return last;
    }
}
