package day13_CookiesWebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_CookiesAutomation extends TestBase {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void cookiesTest() {
        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);

        /* Lambda ile yazılması
        cookiesSet.stream().forEach(t -> System.out.println("name : " + t.getName() + " value :" + t.getValue()));
         */

        int sayac = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(sayac + ".ci cookie :" + each);
            System.out.println("name :" + each.getName());
            System.out.println("value" + each.getValue());
            sayac++;
        }

        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayısı = cookiesSet.size();
        Assert.assertTrue(cookieSayısı > 5);

        // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookiesSet
        ) {
            if (each.getName().equals(" i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(newCookie);
        cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        sayac = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(sayac + ".ci cookie : " + each);
            sayac++;
        }
        // 6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookiesSet.contains(newCookie));


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());


    }
}
