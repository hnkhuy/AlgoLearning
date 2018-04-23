package BaiToanLietKe.PhuongPhapSinh;

import Utilities.FileUtils;

import java.util.Arrays;

public class Exercise04 implements DemoInterface<String> {
    private String[] listName;

    @Override
    public void executeAlgorithm() {
        String input = FileUtils.readTextFile(getClass(), "Input.txt");
        String[] splitter = input.split(System.lineSeparator());
        int k = Integer.parseInt(splitter[0]);
        listName = splitter[1].split(",");
        Arrays.sort(listName);
        int n = listName.length;
        if (k > n) {
            System.out.println("k must not be larger than n");
            return;
        }
//        System.out.println("n = " + n);
//        printArray(listName);
//        System.out.println("listName = " + listName[4].compareTo(listName[5]));

        printArray(getFirstArray(k));
        printArray(getLastArray(k, n));

        String[] previousArray = null;
        do {
            previousArray = getNextArray(previousArray, k, n);
            if (previousArray != null && checkDuplicateByAlgorithm(previousArray)) {
                printArray(previousArray);
            }

        } while (previousArray != null);
    }

    @Override
    public String[] buildNextArray(String[] previousArray, int k, int n) {
        String[] maxInPosition = getLastArray(k, n);
        String[] minInPosition = getFirstArray(k);

        for (int i = k - 1; i >= 0; i--) {
            if (previousArray[i].compareTo(maxInPosition[i]) < 0) {
                previousArray[i] = listName[getNamePosition(previousArray[i]) + 1];
                for (int j = i + 1; j < k; j++) {
                    previousArray[j] = minInPosition[j];
                }
                return previousArray;
            }
        }
        return previousArray;
    }

    int getNamePosition(String name) {
        for (int i = 0; i < listName.length; i++) {
            if (listName[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkDuplicateByAlgorithm(String[] array) {
        for (int j = 0; j < array.length; j++)
            for (int k = j + 1; k < array.length; k++)
                if (k != j && array[k].compareTo(array[j]) <= 0)
                    return false;
        return true;
    }

    @Override
    public String[] getFirstArray(int k) {
        return Arrays.copyOfRange(listName, 0, k);
    }

    @Override
    public String[] getLastArray(int k, int n) {
        return Arrays.copyOfRange(listName, n - k, n);
    }
}
