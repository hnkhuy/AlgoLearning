package BaiToanLietKe.PhuongPhapSinh;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by huy.huynh on 16/01/2018.
 */
public class PhuongPhapSinhMain {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //        System.out.println("result = ");
//        DayNhiPhan dayNhiPhan = new DayNhiPhan();
//        dayNhiPhan.binaryArray();

//        TapConKPhanTu listed = new TapConKPhanTu();
//        listed.listedArray();

        LietKeHoanVi lietKeHoanVi= new LietKeHoanVi();
//        lietKeHoanVi.permutationArray();
        int[] data = {1,3,6,5,4,2};
        lietKeHoanVi.splitAndSwap(data,2);
    }
}
