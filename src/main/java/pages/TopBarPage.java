package pages;


import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("нажать на поисковую строку , ввести  {string}  и нажать Enter")
    public CatalogPage searchProduct(String productName) {
        getSearchInput().sendKeys(productName, Keys.ENTER);
        return new CatalogPage();
    }

    @When("нажать на крестик")
    public TopBarPage clearSearchLine() {
        getClearButton().click();
        return this;
    }

    @When("нажать на кнопку \"Смена города\"")
    public MapPage clickOnAddressLocator() {
        getAddressMenu().shouldBe(visible).shouldBe(clickable).click();
        return new MapPage();
    }

    @When("нажать “Фильтры”")
    public BurgerMenuBarPage clickOnjBurgerMenuButton() {
        getMainContent().shouldBe(visible);
        getjMenuBurgerButton().shouldBe(visible).click();
        return new BurgerMenuBarPage();
    }

    @When("нажать на кнопку “Корзина”")
    public BasketPage clickOnBasketButton() {
        getBasketButton().click();
        return new BasketPage();
    }

    // verifications block
    @Then("строка поиска стала пустой")
    public TopBarPage searchLineIsClean() {
        assertEquals("", getSearchInput().getText());
        return this;
    }

    @Then("отображается адрес пункта выдачи {string}")
    public TopBarPage addressMenuVerification(String address) {
        getAddressMenu().shouldBe(visible).shouldHave(text(address));
        return this;
    }

    @Then("произошел переход на главную страницу WB")
    public TopBarPage pageIsOpened() {
        getSearchInput().shouldBe(visible);
        return this;
    }

    @Then("в правом верхнем углу над логотипом “Корзина” появилась цифра которая имеет {string} цвет")
    public TopBarPage basketNavbarNotifyBackgroundColorVerification(String background) {
        assertEquals(background, getBasketNavbarNotify().getCssValue("background-color"));
        return this;
    }

    @Then("значение счетчика корзины {string}")
    public TopBarPage basketCounterNotification(String number) {
        assertEquals(number, getBasketButton().getText());
        return this;
    }
}
