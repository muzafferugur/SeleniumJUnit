package day15_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    /*
    ***Js Executors***

    * Selenium ile web elementlerinin kontrollerini sağlarken selenium komutları yetersiz  kalabilir veya sorunlarla karşılaşabiliriz.
    * Bu durumlarda laternatif olarak üstesinden gelmek için JavascriptExecutor classını dahil edebiliriz.
    * Javascript HTML kodlara direkt erişip yönetebilen bir script dili olduğundan bize çok fazla kolaylık sağlayabilir.

    Peki nasıl yapılır?

    *ı.adım:            JavascriptExecutor kullanmak için öncelikle driverımızı JavascriptExecutor'a cast edelim.
    *                           JavascriptExecutor jse=(JavascriptExecutor) driver;
    * ıı.adım:          Kullanacağımız web elementi Locate edelim.
    *                           WebElement sellElementi= driver.findElement(By.xpath("//a[text()='Sell']"));
    * ııı.adım:         Js driver ilw executeScript methodunu çalıştıralım,içine parameter olarak ilgili script ve webelementi yazalım.
    *                            jse.executeScript("ilgili script", "web element");=>örneğin Sell elementine click yapmak için==> jse.executeScript("arguments[0].click();", sellElementi);
    *
    * Bir de ScrollIntoView özelliği var bunu da aşağıdaki soruda görebiliriz.
     */
    @Test
    public void JSExecutorTest() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //aşağıdaki sign in butonunu görene kadar js ile scroll yapalım
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", signInButonu);

        //sign in butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();", signInButonu);

        Thread.sleep(5000);

    }
}
