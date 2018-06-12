package BaiToanLietKe.QuayLui;

import Utilities.FileUtils;

/**
 * Created by huy.huynh on 12/06/2018.
 */
public class DayNhiPhan {
    int number;

    public void binaryArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        number = Integer.parseInt(output2);
        String fileBuffer = "";

        getArray(new StringBuilder());

        //        String previousArray = null;
        //        int quantity = 0;
        //        do {
        //            previousArray = getNextArray(previousArray, number);
        //            if (previousArray != null) {
        //                quantity++;
        //                //                System.out.println(previousArray);
        //                fileBuffer += (previousArray + System.lineSeparator());
        //            }
        //
        //            if ((quantity > 1) && (previousArray == null)) {
        //                System.out.println(fileBuffer);
        //                FileUtils.writeToTextFile(getClass(), "GenerationOutput.txt", fileBuffer);
        //                System.out.println("Quantity of binary array: " + quantity);
        //            }
        //        } while (previousArray != null);
    }

    public StringBuilder getArray(StringBuilder a) {
        System.out.println(a);
        if (a.length() == 0) {
            a.append("0");
            getArray(a);
        }
        if (a.charAt(a.length() - 1) == '0') {
            if (a.length() < number) {
                a.setCharAt(a.length() - 1, '1');
                getArray(a);
            } else {
//                System.out.println(a);
            }
        } else {
            if (a.length() < number) {
                a.append("0");
                getArray(a);
            } else {
//                System.out.println(a);
            }
        }
        return a;
    }

    ;

}
