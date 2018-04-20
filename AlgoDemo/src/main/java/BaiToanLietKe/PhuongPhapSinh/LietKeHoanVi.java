package BaiToanLietKe.PhuongPhapSinh;

import Utilities.FileUtils;

import java.util.Arrays;

public class LietKeHoanVi implements GenerateInterface {

    public void permutationArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        int n = Integer.parseInt(output2);

        //        printArray(getFirstArray(n));
        //        printArray(getLastArray(0, n));

        int[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, n, n);
            printArray(previousArray);
            //            if (previousArray != null /*&& checkDuplicateByAlgorithm(previousArray)*/) {
            //                printArray(previousArray);
            //            }
            //
        } while (previousArray != null);
    }

    @Override
    public int[] buildNextArray(int[] previousArray, int k, int n) {
        int i = 0;
        //        for (int i = 0; i < n; i++) {
        if ((previousArray[n - i - 2] < previousArray[n - i - 1])) {
            splitAndSwap(previousArray, n - i - 1);
        }
        //        }
        return null;
    }

    public int[] swap(int[] array, int k) {
        int sw = array[k];
        array[k] = array[k - 1];
        array[k - 1] = sw;

        return array;
    }

    public int splitAndSwap(int[] array, int k) {
        int[] inFrontArray = Arrays.copyOfRange(array, 0, k);
        int[] behindArray = Arrays.copyOfRange(array, k, array.length);
        printArray(inFrontArray);
        printArray(behindArray);
        int pos = findAppropriateNumber(behindArray, array[k - 1]);
//        System.out.println("pos = " + pos);

        return 0;
    }

    private int findAppropriateNumber(int[] array, int k) {
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
