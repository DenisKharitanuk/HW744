package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapPage {
    //locators block
    private SelenideElement placeHolder = $(By.xpath("//input[@placeholder='Введите адрес'][@autocomplete='off']"));
    private SelenideElement selectButton = $(".details-self__btn");
    private SelenideElement pickUpPointerName = $(".details-self__name-text");
    private ElementsCollection address = $$(By.xpath("//span[@class='address-item__name-text']/span"));
    private SelenideElement map = $("..ymaps-2-1-79-events-pane.ymaps-2-1-79-user-selection-none");

    //getters block

    public SelenideElement getMap() {
        return map;
    }

    private SelenideElement getPlaceHolder() {
        return placeHolder;
    }

    private SelenideElement getSelectButton() {
        return selectButton;
    }

    private SelenideElement getPickUpPointerName() {
        return pickUpPointerName;
    }

    private ElementsCollection getAddress() {
        return address;
    }


    // actions block
    public MapPage inputAddress(String address) {
        getPlaceHolder().shouldBe(clickable).shouldBe(visible).sendKeys(address, Keys.ENTER);
        return this;
    }

    public MapPage selectOnAddressByIndex(int index) {
        getAddress().filter(visible).get(index).click();
        return this;
    }

    public TopBarPage clickOnSelectButtonLocator() {
        getSelectButton().click();
        return new TopBarPage();
    }


    // verifications block
    public MapPage pickUpPointByIndexVerification(int index) {
        getAddress().get(index).shouldBe(visible).shouldHave(text(getPickUpPointerName().getText()));
        return this;
    }
}
