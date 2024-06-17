package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketPage {
    //Locators block
    private SelenideElement listItem = $(".list-item__good");
    private SelenideElement product = $(".good-info__title.j-product-popup");
    private SelenideElement productPriceCard = $(".list-item__price-new");
    private SelenideElement productPriceWithWBWallet = $(".list-item__price-wallet");
    private SelenideElement totalPrice = $(By.xpath("//p[@class='b-top__total line' ]/span/span"));
    private SelenideElement toOrderButton = $(".b-btn-do-order");


    //getters block

    private SelenideElement getProduct() {
        return product;
    }

    public SelenideElement getListItem() {
        return listItem;
    }

    private SelenideElement getProductPriceWithWBWallet() {
        return productPriceWithWBWallet;
    }

    private SelenideElement getProductPriceCard() {
        return productPriceCard;
    }

    private SelenideElement getTotalPrice() {
        return totalPrice;
    }

    private SelenideElement getToOrderButton() {
        return toOrderButton;
    }

    //verifications block

    public BasketPage productInfoVerification(String infoText) {
        assertEquals(infoText, getProduct().getText());
        return this;
    }

    public BasketPage productPricesVerification(String price) {
        getProductPriceCard().shouldBe(visible).shouldHave(text(price));
        return this;
    }

    public BasketPage totalPriceVerification(String totalPrice) {
        getTotalPrice().shouldBe(visible).shouldHave(text(totalPrice));
        return this;
    }

    public BasketPage toOrderButtonIsClicable() {
        getToOrderButton();
        return this;
    }
}
