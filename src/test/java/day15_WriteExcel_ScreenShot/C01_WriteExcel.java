package day15_WriteExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        /*
        3) Adimlari takip ederek 1.satira kadar gidelim
        4) 5.hucreye yeni bir cell olusturalim
        5) Olusturdugumuz hucreye "Nufus" yazdiralim
        6) 2.satir nufus kolonuna 1500000 yazdiralim
        7) 10.satir nufus kolonuna 250000 yazdiralim
        8) 15.satir nufus kolonuna 54000 yazdiralim
        9) Dosyayi kaydedelim
        10) Dosyayi kapatalim
         */
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //4) 5.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye "Nufus" yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(54000);

        // 9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        /*
        => Excel dosyanıza veri girişi yaptıktan sonra dosyayı akışa aldığını gibi sonlandırmanız
            gerekir. Sonrasında da workbook objemizi kayıt etmemizz gerekir.
         */
        workbook.write(fos); // => Write methodu ile sonlandırdığımız işlemi workbook'a yazdırdık.

        // 10) Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();


    }
}
