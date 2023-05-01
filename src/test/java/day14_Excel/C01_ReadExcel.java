package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        // - Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // - FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // - WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);// ==> Workbook objesiyle fis objesi ile akışa aldğımız bir excell dosyası create ettik.

        // - Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // ==> Excel dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçelim.

        // - Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // ==> Sayfa birdeki ücüncü satırı bu şekilde seçeriz.

        // - Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // ==> Satır seçimi yapıldıktan sonra gücre seçimi bu şekilde yapılır.
        System.out.println(cell);
    }
}
