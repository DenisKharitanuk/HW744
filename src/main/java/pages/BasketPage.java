package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


public class BasketPage {
    //Locators block
    private SelenideElement product = $(".good-info__title.j-product-popup");

    public SelenideElement getProduct() {
        return product;
    }
}
