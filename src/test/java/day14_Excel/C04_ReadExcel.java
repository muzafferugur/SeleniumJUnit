package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

        // - Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // - FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // - WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);// ==> Workbook objesiyle fis objesi ile akışa aldğımız bir excell dosyası create ettik.

        //İngilizce başkentler sütununu yazdıralım.
        //son satır numarasını nasıl buluruz onunla başlayalım
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);//190->indexi veriyor.
        String satirdakiData = "";

        for (int i = 0; i <= sonSatir; i++) {

            satirdakiData = C03_ReadExcel.banaDataGetir(i, 1);
            System.out.println(satirdakiData);
        }

    }
}
