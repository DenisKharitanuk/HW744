package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    //locators block
    private SelenideElement addToBasketButton = $(".product-page__aside .order__for-fixed");
    private SelenideElement basketButton = $(".navbar-pc__icon.navbar-pc__icon--basket");

    //getters block
    private SelenideElement getAddToBasketButton() {
        return addToBasketButton;
    }
    private SelenideElement getBasketButton() {
        return basketButton;
    }
}
