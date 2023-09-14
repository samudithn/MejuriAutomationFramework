
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

/*
* Test Task for QA Automation Engineer
*
* Samudith Nanayakkara
* Page Object Model followed- page class:-MejuriPage
*
* */

class MejuriTest {

    //Setup method used for browser initialization
    @BeforeAll
    public static void setUp() {
        open("https://mejuri.com/world/en");
        getWebDriver().manage().window().maximize();
    }

    @Test
    @ExtendWith({TextReportExtension.class})
    public void MejuriTest(){

        MejuriPage mp=new MejuriPage();
        mp.cookiePopupManage();
        mp.login("https://mejuri.com/world/en","yomev23411@ipnuc.com","Pass@12345");
        mp.findTheProductCatalogRings("Honey Mini Signet");
        mp.addVerifyFavouriteFunc("MY WISHLIST");
    }

}