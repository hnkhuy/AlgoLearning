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
            return splitAndSwap(previousArray, n - i - 1);
        }
        //        }
        return null;
    }

    public int changeAndReturnValue(int[] array, int p, int value) {
        int returnValue = array[p];
        array[p] = value;

        return returnValue;
    }

    public int[] splitAndSwap(int[] array, int k) {
        int[] inFrontArray = Arrays.copyOfRange(array, 0, k);
        int[] behindArray = Arrays.copyOfRange(array, k, array.length);
//        printArray(inFrontArray);
//        printArray(behindArray);
        int pos = findAppropriateNumber(behindArray, array[k - 1]);
//        System.out.println("pos = " + pos + "- " + behindArray[pos]);
        int swapValue = behindArray[pos];
        behindArray[pos] = inFrontArray[k - 1];
        inFrontArray[k - 1] = swapValue;
//        printArray(inFrontArray);
//        printArray(behindArray);
        Arrays.sort(behindArray);

        int[] result = new int[array.length];
        System.arraycopy(inFrontArray, 0, result, 0, inFrontArray.length);
        System.arraycopy(behindArray, 0, result, inFrontArray.length, behindArray.length);

        printArray(array);
        printArray(result);

        return result;
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
