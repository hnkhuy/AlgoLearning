package BaiToanLietKe.QuayLui;

import Utilities.FileUtils;

/**
 * Created by huy.huynh on 12/06/2018.
 */
public class DayNhiPhan {
    int number;
    char data[] = {'0', '1'};
    String fileBuffer = "";

    public void binaryArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        number = Integer.parseInt(output2);

//        getArray("");
        getArray2("");

        System.out.println(fileBuffer);
        FileUtils.writeToTextFile(getClass(), "Output.txt", fileBuffer);
        System.out.println("Quantity of binary array: " + fileBuffer.split(System.lineSeparator()).length);
    }

    public void getArray2(String s) {
        for (int i = 0; i < data.length; i++) {
            if ((s + data[i]).length() == number) {
//                System.out.println("r: " + (s + data[i]));
                fileBuffer += (s + data[i] + System.lineSeparator());
            } else {
                getArray2((s + data[i]));
            }
        }
    }

    public void getArray(String currentValue) {
        for (int i = 0; i < data.length; i++) {
            if (currentValue.length() < number) {
                if (compareLastChar(currentValue, data[i])) {
                    currentValue = currentValue + data[i];
                } else {
                    currentValue = currentValue.substring(0, currentValue.length() - 1) + data[i];
                }
                if (currentValue.length() == number) {
//                    System.out.println("r: " + currentValue);
                    fileBuffer += (currentValue + System.lineSeparator());
                } else {
                    getArray(currentValue);
                }
            } else if (currentValue.length() == number) {
                currentValue = currentValue.substring(0, currentValue.length() - 1) + data[i];
//                System.out.println("r: " + currentValue);
                fileBuffer += (currentValue + System.lineSeparator());
            }
        }
    }

    private boolean compareLastChar(String s, char c) {
        if (s.equals("")) return true;
        int indexOfLast = 0;
        int indexOfChar = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == s.charAt(s.length() - 1)) {
                indexOfLast = i;
            }
            if (data[i] == c) {
                indexOfChar = i;
            }
        }

        if (indexOfLast >= indexOfChar) {
            return true;
        } else return false;
    }
}
