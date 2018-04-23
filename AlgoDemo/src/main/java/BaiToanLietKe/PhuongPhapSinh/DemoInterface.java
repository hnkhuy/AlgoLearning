package BaiToanLietKe.PhuongPhapSinh;

import java.util.Arrays;

public interface DemoInterface<T> {
    void executeAlgorithm();

    default T[] getNextArray(T[] previousArray, int k, int n) {
        if (previousArray == null) {
            return getFirstArray(k);
        } else if (Arrays.equals(previousArray, getLastArray(k, n))) {
            return null;
        } else {
            return buildNextArray(previousArray, k, n);
        }
    }

    T[] buildNextArray(T[] previousArray, int k, int n);

    T[] getFirstArray(int k);

    T[] getLastArray(int k, int n);

    default void printArray(T[] array) {
        if ((array == null) || (array.length == 0))
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
