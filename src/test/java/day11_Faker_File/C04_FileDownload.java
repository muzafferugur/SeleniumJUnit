package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    /*

    1.downloadTest() methodunun içindei testi yapalım:
    --https://the-internet.herokuapp.com/download adresine gidelim
    --some-file.txt dosyasını indirelim
    2.Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim.
     */

    @Test
    public void downloadTest() throws InterruptedException {

        // --https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //--some-file.txt dosyasını indirelim
        WebElement someFileLinki= driver.findElement(By.xpath("//a[text()='some-file.txt']"));
        someFileLinki.click();

        Thread.sleep(2000);

        String farklıKısıım=System.getProperty("user.home");
        String  ortakKısım="\\Downloads\\some-file.txt";

        String arananDosyaYolu=farklıKısıım+ortakKısım;

        //geriye o dosya yolundaki dosyanın var olduğunu assert edelim.
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }
}
