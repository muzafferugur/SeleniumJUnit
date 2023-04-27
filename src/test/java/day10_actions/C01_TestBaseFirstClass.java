package day10_actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void test() {
        driver.get("https://amazon.com");


        /*
         *Test base, testlerden önce ve sonra tekrar tekrar kullandığımız kodları içerir
         * İçerisindeki methodları kullanabilmemiz için extends yapıyoruz. Bu sayede
         * test class'ımızda sadece test case'ler bulunmaktadır.
         * Utilities package da Test Base oluşturuyoruz.
         * -setUp method
         * -reports(Raporlar)
         * -tearDown method
         * TestBase classi abstract yapabiliriz.(Olmasada olabilir), extends yaparak kullanabiliriz.
         *Ve bu classda object create edemeyiz.
         */

    }
}
