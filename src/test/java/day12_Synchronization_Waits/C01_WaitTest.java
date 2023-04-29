package day12_Synchronization_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_WaitTest extends TestBase {
    /*
    iki method oluşturun implicitWait(),explicitWait()
    iki method için aşağıdaki adımları test edin

    1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    2.Remove butonuna basin.
    3.“It’s gone!” mesajinin goruntulendigini dogrulayin.
    4.Add buttonuna basin
    5.It’s back mesajinin gorundugunu test edin
     */

    @Test
    public void implicitWaitTest() {

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());

        // Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

    }

    @Test
    public void explicitWaitTest() {

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());

        /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmayabilir.
        (HTML kodları yazan developer farklı uygulamalar yapabilir).Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız.
         */

        // Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());
    }
}
