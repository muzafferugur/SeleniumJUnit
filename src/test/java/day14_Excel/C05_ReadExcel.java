package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {

        // - Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // - FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // - WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);// ==> Workbook objesiyle fis objesi ile akışa aldğımız bir excell dosyası create ettik.


        //sayfa 2'ye gidip: satır sayısının 24, kullanılan satır sayısının 12 olduğunu test edin.
        int sonSatirIndex = workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirSayisi = 24;
        Assert.assertEquals(expectedSatirSayisi, sonSatirIndex + 1);

        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        //getPhysicalNumberOfRows();-->kullanılan Satır Sayısını verir

        int expectedKullanilanSatirSaiyisi = 12;
        Assert.assertEquals(expectedKullanilanSatirSaiyisi, kullanilanSatirSayisi);
    }
}
