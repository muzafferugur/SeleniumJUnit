package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    /*
    Excel dosyasındaki tüm verileri clasımıza alıp bir Java objesine store edelim
    böylece her seferinde excel'e ulaşıp satır,sutun vs... uğraşmayalım
    Bunun için map yapıcaz : key ve valuelere ihtiyacımız var

    Database yapısında olan exceli koyabileceğimiz en uygun Java objesi Map
     */


    @Test
    public void readExcelTest() throws IOException {


        Map<String, String> ulkelerMap=new HashMap<>();

        // - Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // - FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // - WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);// ==> Workbook objesiyle fis objesi ile akışa aldğımız bir excell dosyası create ettik.

        int sonSatirIndex = workbook
                .getSheet("Sayfa1")
                .getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            //key i..,

        }

    }
}
