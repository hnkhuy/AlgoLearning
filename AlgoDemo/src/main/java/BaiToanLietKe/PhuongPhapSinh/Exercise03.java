package BaiToanLietKe.PhuongPhapSinh;

import Utilities.FileUtils;

/**
 * Created by huy.huynh on 16/01/2018.
 */
public class Exercise03 {

    public void exercise03Array() {
        String input = FileUtils.readTextFile(getClass(), "Input.txt");
        int n = Integer.parseInt(input);
        String fileBuffer = "";

        String previousArray = null;
        int quantity = 0;
        do {
            previousArray = getNextArray(previousArray, n);
            if ((previousArray != null) && (checkConditionByAlgorithm(previousArray))) {
                quantity++;
                //                System.out.println(previousArray);
                fileBuffer += (previousArray + System.lineSeparator());
            }

            if ((quantity > 1) && (previousArray == null)) {
                System.out.println(fileBuffer);
                FileUtils.writeToTextFile(getClass(), "Output.txt", fileBuffer);
                System.out.println("Quantity of binary array: " + quantity);
            }
        } while (previousArray != null);
    }

    private boolean checkConditionByAlgorithm(String previousArray) {
        previousArray = previousArray + "a";
        String[] splitArray = previousArray.split("10");
        if (splitArray.length == 3) {
            return true;
        }
        return false;
    }

    private String getNextArray(String previousArray, int num) {
        if (previousArray == null) {
            return getFirstArray(num);
        } else if (previousArray.equals(getLastArray(num))) {
            return null;
        } else {
            return String.valueOf(buildNextArray(previousArray));
        }
    }

    private char[] buildNextArray(String previousArray) {
        char[] str = previousArray.toCharArray();
        //        System.out.println(str);
        //        System.out.println("previousArray.length() = " + previousArray.length());
        for (int i = str.length - 1; i >= 0; i--) {
            //            System.out.println("i = " + i);
            if (str[i] == '0') {
                str[i] = '1';
                for (int j = i + 1; j < str.length; j++) {
                    str[j] = '0';
                }
                break;
            }
        }
        return str;
    }

    private String getFirstArray(int num) {
        String first = "";
        for (int i = 0; i < num; i++) {
            first += "0";
        }
        return first;
    }

    private String getLastArray(int num) {
        String last = "";
        for (int i = 0; i < num; i++) {
            last += "1";
        }
        return last;
    }
}
