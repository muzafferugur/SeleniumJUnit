package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        /*
        input olarak verilen : satırNo,sutunNo değerlerini parametre olarak alıp o cell'deki datayı String olarak
        bana döndüren bir method oluşturalım
         */

        int satirNo = 4;
        int sutunNo = 4;

        //dönen String'in Cezayir olduğunu test edin
        String expectedData = "Cezayir";

        String actualData = banaDataGetir(satirNo - 1, sutunNo - 1);// satır no ve sutun no index değil , indexi almak için -1 dedik.
        //çünkü excel index ile çalışır
        Assert.assertEquals(expectedData, actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {//=>Bizden String döndürmesini istediğimiz için String yaptık
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex).toString();

        return istenenData;
    }
}
