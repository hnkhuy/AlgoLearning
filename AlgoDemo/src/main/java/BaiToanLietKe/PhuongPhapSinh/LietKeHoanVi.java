package BaiToanLietKe.PhuongPhapSinh;

import Utilities.FileUtils;

import java.util.Arrays;

public class LietKeHoanVi implements GenerateInterface {

    public void permutationArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        int n = Integer.parseInt(output2);

        printArray(getFirstArray(n));
        printArray(getLastArray(0, n));

        int[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, 0, n);
//            if (previousArray != null /*&& checkDuplicateByAlgorithm(previousArray)*/) {
//                printArray(previousArray);
//            }
//
        } while (previousArray != null);
    }

    @Override
    public int[] buildNextArray(int[] previousArray, int k, int n) {
        for (int i = 0; i < n; i++) {
            if ((previousArray[n - i - 1] > previousArray[n - i - 2])) {

            }
        }
        return null;
    }

    public int[] swap(int[] previousArray, int k) {
        int sw = previousArray[k];
        previousArray[k] = previousArray[k - 1];
        previousArray[k - 1] = sw;

        return previousArray;
    }

    public int findAppropriateNumber(int[] previousArray, int k) {
        return 0;
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
