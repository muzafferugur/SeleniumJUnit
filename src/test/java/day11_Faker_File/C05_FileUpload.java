package day11_Faker_File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    /*
    -https://the-internet.herokuapp.com/upload sayfasına git
    -chooseFile butonuna basalım.
    -Yükelemk istediğimiz dosyayı seçelim*(Bu işlemi selenium ile yapma şansımız yok)
   **Çünkü web tabanlı bir uygulama değil. sendKeys methodu imdadımıza yetişir.
   eğer chooseFile butonun var olan bi dosyanın dosya yolunu yollarsanız
   seçme işlemi otomatik olarak yapılmış olacaktır.**
    -Upload butonuna basalım
    -"File Uploaded!" textinin görüntülendiğini test edelim.
    
     */

    @Test
    public void uploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonunu locate ettik.
        WebElement dosyaSeçButonu= driver.findElement(By.id("file-upload"));

        //2.adım yükelencek dosyanın dosya yolunu oluşturalım

    }
}
