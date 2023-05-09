package day15_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;

public class C03_IstenenWebElementSS extends TestBase {

    @Test
    public void webElementSS() {

       // amazona gidip nutella aratalım ve sonuç sayısının olduğu web elementin fotoğrafını çekelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.className("a-size-base s-desktop-toolbar a-text-normal"));

        File sonucYaziElementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
    }
}
