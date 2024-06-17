package pages;


import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopBarPage {

    //locators block
    private SelenideElement searchInput = $("#searchInput");
    private SelenideElement mainContent = $(".main-page__content");
    private SelenideElement searchButton = $("#applySearchBtn");
    private SelenideElement clearButton = $(".search-catalog__btn.search-catalog__btn--clear");
    private SelenideElement addressMenu = $(".simple-menu__link.simple-menu__link--address");
    private SelenideElement jMenuBurgerButton = $(".nav-element__burger-line");
    private SelenideElement basketButton = $(".navbar-pc__icon.navbar-pc__icon--basket");
    private SelenideElement basketNavbarNotify = $(By.xpath("//span[@class='navbar-pc__notify']"));


    //getters block

    private SelenideElement getSearchInput() {
        return searchInput;
    }

    private SelenideElement getSearchButton() {
        return searchButton;
    }

    private SelenideElement getClearButton() {
        return clearButton;
    }

    private SelenideElement getAddressMenu() {
        return addressMenu;
    }

    private SelenideElement getjMenuBurgerButton() {
        return jMenuBurgerButton;
    }

    private SelenideElement getBasketButton() {
        return basketButton;
    }

    private SelenideElement getBasketNavbarNotify() {
        return basketNavbarNotify;
    }

    public SelenideElement getMainContent() {
        return mainContent;
    }
    //action block

    public CatalogPage searchProduct(String productName) {
        getSearchInput().sendKeys(productName, Keys.ENTER);
        return new CatalogPage();
    }

    public CatalogPage clickOnSearchButton() {
        getSearchButton().click();
        return new CatalogPage();
    }

    public TopBarPage clearSearchLine() {
        getClearButton().click();
        return this;
    }

    public MapPage clickOnAddressLocator() {
        getAddressMenu().shouldBe(visible).shouldBe(clickable).click();
        return new MapPage();
    }

    public BurgerMenuBarPage clickOnjBurgerMenuButton() {
        getMainContent().shouldBe(visible);
        getjMenuBurgerButton().shouldBe(visible).click();
        return new BurgerMenuBarPage();
    }

    public BasketPage clickOnBasketButton() {
        getBasketButton().click();
        return new BasketPage();
    }

    // verifications block
    public TopBarPage searchLineIsClean() {
        assertEquals("", getSearchInput().getText());
        return this;
    }

    public TopBarPage addressMenuVerification(String address) {
        getAddressMenu().shouldBe(visible).shouldHave(text(address));
        return this;
    }

    public TopBarPage pageIsOpened() {
        getSearchInput().shouldBe(visible);
        return this;
    }

    public TopBarPage basketNavbarNotifyBackgroundColorVerification(String background) {
        assertEquals(background, getBasketNavbarNotify().getCssValue("background-color"));
        return this;
    }

    public TopBarPage basketCounterNotification(String number) {
        assertEquals(number, getBasketButton().getText());
        return this;
    }
}
