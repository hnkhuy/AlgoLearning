package BaiToanLietKe.PhuongPhapSinh;

import BaiToanLietKe.PhuongPhapSinh.GenerateInterface;
import Utilities.FileUtils;

import java.util.*;

/**
 * Created by huy.huynh on 08/02/2018.
 */
public class TapConKPhanTu implements GenerateInterface {
    public void listedArray() {
        String input = FileUtils.readTextFile(getClass(), "Input.txt");
        String[] splitter = input.split(System.lineSeparator());
        int n = Integer.parseInt(splitter[0]);
        int k = Integer.parseInt(splitter[1]);

        printArray(getFirstArray(k));
        printArray(getLastArray(k, n));

        //        printArray(getMinInPosition(k));
        //        printArray(getMaxInPosition(k, n));

        int[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, k, n);
            if (previousArray != null && checkDuplicateByAlgorithm(previousArray)) {
                printArray(previousArray);
            }

        } while (previousArray != null);
    }

    public void listedArray2() {
        String input = FileUtils.readTextFile(getClass(), "Input.txt");
        System.out.println("input = " + input);
        String[] splitter = input.split(System.lineSeparator());
        int n = Integer.parseInt(splitter[0]);
        int k = Integer.parseInt(splitter[1]);
        System.out.println(n + "-" + k);
    }

    private int[] buildNextArray_o(int[] previousArray, int k, int n) {
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

    public int[] buildNextArray(int[] previousArray, int k, int n) {
        int[] maxInPosition = getLastArray(k, n);
        int[] minInPosition = getFirstArray(k);

        for(int i=k-1; i>=0;i--){
            if(previousArray[i]<maxInPosition[i]){
                previousArray[i]++;
                for(int j=i+1; j<k;j++){
                    previousArray[j] = minInPosition[j];
                }
                return previousArray;
            }
        }
        return previousArray;
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

    public int[] getFirstArray(int k) {
        int first[] = new int[k];
        for (int i = 0; i < k; i++) {
            first[i] = i + 1;
        }
        return first;
    }

    public int[] getLastArray(int k, int n) {
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

    public void printArray(int[] array) {
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