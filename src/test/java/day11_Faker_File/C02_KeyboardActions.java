package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {
    @Test
    public void keyboardActionTest() {
        /*
        1.https://html.com/tags/iframe/ sayfasına gidelim
        2.videoyu görecek kadar aşağıya in
        3.videoyu izlemek için play tuşuna basın
        4.videoyu çalıştırdığınızı test edin
         */

        //1.https://html.com/tags/iframe/ sayfasına gidelim
        driver.get("https://html.com/tags/iframe/");

        //2.videoyu görecek kadar aşağıya in
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        //3.videoyu izlemek için play tuşuna basın
        WebElement Iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(Iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        //4.videoyu çalıştırdığınızı test edin
        WebElement youTubeLinki = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(youTubeLinki.isDisplayed());

    }
}
