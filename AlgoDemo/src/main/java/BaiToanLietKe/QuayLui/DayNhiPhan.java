package BaiToanLietKe.QuayLui;

import Utilities.FileUtils;

/**
 * Created by huy.huynh on 12/06/2018.
 */
public class DayNhiPhan {
    int number;
    char data[] = {'0', '1'};
    boolean isFirst = true;

    public void binaryArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        number = Integer.parseInt(output2);
        String fileBuffer = "";

//        String demo="asdfg";
//        System.out.println("fileBuffer = " + demo.charAt(demo.length()-1));
        getArray("");

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
                    System.out.println("r: " + currentValue);
                } else {
                    getArray(currentValue);
                }
            } else if (currentValue.length() == number) {
                currentValue = currentValue.substring(0, currentValue.length() - 1) + data[i];
                System.out.println("r: " + currentValue);
            }
        }
    }

    private boolean compareLastChar(String s, char c) {
        if (s.equals("")) return true;
        int indexOfLast=0;
        int indexOfChar=0;
        for (int i = 0; i < data.length; i++) {
            if(data[i]==s.charAt(s.length() - 1)){
                indexOfLast=i;
            }
            if (data[i]==c){
                indexOfChar=i;
            }
        }

        if (indexOfLast >= indexOfChar) {
            return true;
        } else return false;
    }
}
