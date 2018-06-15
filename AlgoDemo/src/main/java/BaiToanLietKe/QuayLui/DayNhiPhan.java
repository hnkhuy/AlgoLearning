package BaiToanLietKe.QuayLui;

import Utilities.FileUtils;

/**
 * Created by huy.huynh on 12/06/2018.
 */
public class DayNhiPhan {
    int number;
    char data[] = {'0','1'};

    public void binaryArray() {
        String output2 = FileUtils.readTextFile(getClass(), "Input.txt");
        number = Integer.parseInt(output2);
        String fileBuffer = "";

        getArray("");

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

    public void getArray(String a) {
        for (int i = 0; i < data.length; i++) {
            if (a.length() < number) {
                a=a+data[i];
                getArray(a);
            }else if(a.length() == number){
                a=a.substring(0,2)+data[i];
            }
            if(a.length() == number){
                System.out.println(a);
            }
        }
    }

    ;

}
