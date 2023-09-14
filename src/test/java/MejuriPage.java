import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MejuriPage {

    private static final SelenideElement acceptCookiePopup= $(byXpath("//button[@id='onetrust-accept-btn-handler']"));
    private static final SelenideElement loginButton= $(byXpath("//header/div[1]/div[2]/ul[1]/li[2]/button[1]"));
    private static final SelenideElement emailField= $(byName("email"));
    private static final SelenideElement passwordField= $(byName("password"));
    private static final SelenideElement submitButton= $(byXpath("//button[contains(@type,'submit')]"));
    private static final SelenideElement closePopup= $(byXpath("//body/div[@id='portal-modal-container']/div[1]/div[2]/div[1]/button[1]/i[1]/*[1]"));
    private static final SelenideElement NavbarRingOption= $(byXpath("//body[1]/div[1]/div[2]/header[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]/span[1]"));
    private static final SelenideElement findProduct= $(byXpath("//body[1]/div[1]/div[2]/header[1]/div[1]/div[2]/ul[1]/li[1]/button[1]"));
    private static final SelenideElement productSearch= $(byXpath("//body/div[@id='__next']/div[3]/section[1]/div[1]/div[1]/div[1]/input[1]"));
    private static final SelenideElement searchedRingTile= $(byXpath("//h6[contains(text(),'Honey Signet')]"));
    private static final SelenideElement addToWishListBtn= $(byXpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/button[2]"));
    private static final SelenideElement navBarWishList= $(byXpath("//body[1]/div[2]/div[2]/header[1]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
    private static final SelenideElement wishListHeading= $(byXpath("//h2[contains(text(),'My wishlist')]"));
    private static final SelenideElement wishHMSVerify= $(byXpath("//span[contains(text(),'Honey Mini Signet')]"));
    private static final SelenideElement birthdayPopup= $(byXpath("//span[contains(text(),'Now What?')]"));

    //To manage Cookie popup
    public void cookiePopupManage(){
        $(acceptCookiePopup).shouldBe(visible).click();
    }

    //Login Functionality
    public void login(String ExpectedURL,String username,String password) {

        String url = WebDriverRunner.url();
        assertEquals(url, "https://mejuri.com/world/en");
        loginButton.shouldBe(visible).click();
        emailField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        submitButton.shouldBe(visible).click();

        //Intermediate Popup requesting Birthday after user login
        if(birthdayPopup.shouldBe(visible).isDisplayed()) {
            closePopup.shouldBe(visible).click();
        }
    }

    //Find the product 'Honey Mini Signet' in the catalog of rings
    public void findTheProductCatalogRings(String ringName) {

        NavbarRingOption.shouldBe(visible).click();
        findProduct.shouldBe(visible).click();
        productSearch.shouldBe(visible).setValue(ringName).pressEnter();
        searchedRingTile.shouldBe(visible).click();
    }

    //Add to favorites/WishList and verify product in the 'MY WISHLIST' page
    public void addVerifyFavouriteFunc(String labelText) {

        addToWishListBtn.shouldBe(visible).click();
        navBarWishList.shouldBe(visible).click();
        wishListHeading.shouldBe(visible).shouldHave(text(labelText));
        wishHMSVerify.shouldBe(visible).shouldHave();
    }

}
