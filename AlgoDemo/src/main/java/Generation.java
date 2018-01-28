/**
 * Created by huy.huynh on 16/01/2018.
 */
public class Generation {

    public void testReadAndWriteFile() {
        FileUtils fileUtils = new FileUtils();
        //        String output = fileUtils.getFile("GenerationInput.txt");
        //        System.out.print(output);

        System.out.println("getClass().getClassLoader() = " + getClass().getResource("GenerationInput.txt"));
        System.out.println(
                "getClass().getClassLoader() = " + getClass().getClassLoader().getResource("GenerationInput.txt"));

        String output2 = FileUtils.readTextFile(getClass(), "GenerationInput.txt");
        output2 += System.getProperty("line.separator") + "5";
        System.out.print(output2);
        FileUtils.writeToTextFile(getClass().getClassLoader(), "GenerationOutput.txt", output2);
    }

    public void binaryArray() {
        String output2 = FileUtils.readTextFile(getClass(), "GenerationInput.txt");
        int number = Integer.parseInt(output2);

        String previousArray = null;
        int quantity = 0;
        do {
            output2.length();
            previousArray = getNextArray(previousArray, number);
            if (previousArray != null) {
                quantity++;
                System.out.println(previousArray);

            }

            if ((quantity > 1) && (previousArray == null)) {
                System.out.println("Quantity of binary array: " + quantity);
            }
        } while (previousArray != null);
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
