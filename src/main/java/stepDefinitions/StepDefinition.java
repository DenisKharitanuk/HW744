package stepDefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.BasketPage;
import pages.CatalogPage;
import pages.TopBarPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static configuration.ReadProperties.getUrl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    BasketPage basketPage = new BasketPage();
    CatalogPage catalogPage = new CatalogPage();
    TopBarPage topBarPage = new TopBarPage();


    public void productInfoVerification(String infoText) {
        assertEquals(infoText, basketPage.getProduct().getText());
    }

    @When("он добавляет товар в корзину")
    public void clickOnAddToBasketButton() {
        catalogPage.getAddToBasketButton().get(0).shouldBe(visible).shouldBe(clickable).click();
    }

    @Then("он видит товар {string} в результатах поиска")
    public void searchingResultsVerification(String expectedText) {
        catalogPage.getSearchingResultsTitle().shouldBe(visible).shouldHave(text(expectedText));
    }


    @Then("он видит список товаров этой категории")
    public void catalogTitleVerification(String catalogTitleName) {
        catalogPage.getCatalogTitle().shouldBe(visible).shouldHave(text(catalogTitleName));
    }

    @When("он вводит {string} в строку поиска")
    public void searchProduct(String productName) {
        topBarPage.getSearchInput().sendKeys(productName, Keys.ENTER);
    }

    @Given("пользователь нашел товар {string}")
    public void searchAndAddToBasket(String productName) {
        Configuration.baseUrl = getUrl();
        Configuration.browserSize = "1920x1080";
        open(getUrl());
        searchProduct(productName);
    }

    @When("он переходит в категорию {string}")
    public void clickOnjBurgerMenuButton(String productType) {
        topBarPage.getMainContent().shouldBe(visible);
        topBarPage.getjMenuBurgerButton().shouldBe(visible).click();
        topBarPage.getMainMenu().find(text(productType)).shouldBe(visible).click();
    }

    @When("в его корзине находится товар {string}")
    public void clickOnBasketButton(String productName) {
        BasketPage basketPage = new BasketPage();
        topBarPage.getBasketButton().click();
        productInfoVerification("Смартфон Apple iPhone 13 128Gb 4Gb розовый, Apple");
    }
}
