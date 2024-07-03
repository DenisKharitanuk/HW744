package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v125.indexeddb.model.Key;

import java.time.Duration;
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
    private ElementsCollection searchButton = $$(".ymaps-2-1-79-searchbox-button-text");

    //getters block


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
    @When("в поисковую строку ввести {string}")
    public MapPage inputAddress(String address) {
        getPlaceHolder().shouldBe(clickable, Duration.ofSeconds(15)).shouldBe(visible).sendKeys(address, Keys.ENTER);
        return this;
    }

    @When("выбрать адрес номер {int} из списка адресов")
    public MapPage selectOnAddressByIndex(int index) {
        getAddress().filter(text("Санкт-Петербург")).get(index - 1).shouldBe(visible).click();
        return this;
    }

    @When("нажать на кнопку “Выбрать”")
    public TopBarPage clickOnSelectButtonLocator() {
        getSelectButton().click();
        return new TopBarPage();
    }


    // verifications block
    @Then("открылась информация центра выдачи номер {int}, адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов")
    public MapPage pickUpPointByIndexVerification(int index) {
        getAddress().get(index - 1).shouldBe(visible).shouldHave(text(getPickUpPointerName().getText()));
        return this;
    }
}
