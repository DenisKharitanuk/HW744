package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FiltersPage {
    //locators block
    private SelenideElement priceStartIn = $(By.name("startN"));
    private SelenideElement endPrice = $(By.name("endN"));
    private SelenideElement showButton = $(".filters-desktop__btn-main");

    //constructors block

    private SelenideElement getPriceStartIn() {
        return priceStartIn;
    }

    private SelenideElement getEndPrice() {
        return endPrice;
    }

    private SelenideElement getShowButton() {
        return showButton;
    }

    private SelenideElement getRadioOrCheckboxButton(String OrCheckbox) {
        return $(By.xpath("//span[text()='" + OrCheckbox + "']/preceding-sibling::span"));
    }

    //actions block
    public FiltersPage clearAndInputStartInPrice(String priceStartIn) {
        getPriceStartIn().clear();
        getPriceStartIn().sendKeys(priceStartIn);
        return this;
    }

    public FiltersPage clearAndInputEndPrice(String endPrice) {
        getEndPrice().clear();
        getEndPrice().sendKeys(endPrice);
        return this;
    }

    public FiltersPage clickOnRadioAndCheckboxButton(String radioOrCheckboxButtonName) {
        getRadioOrCheckboxButton(radioOrCheckboxButtonName).click();
        return this;
    }

    public CatalogPage clickOnShowButton() {
        getShowButton().click();
        return new CatalogPage();
    }
}
