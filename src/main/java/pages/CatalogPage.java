package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CatalogPage {

    //locators block
    private SelenideElement searchingResultsTitle = $(".searching-results__title");
    private SelenideElement catalogTitle = $(".catalog-title");
    private ElementsCollection addToBasketButton = $$(".product-card__add-basket.j-add-to-basket.btn-main");


    //getters block


    public ElementsCollection getAddToBasketButton() {
        return addToBasketButton;
    }

    public SelenideElement getSearchingResultsTitle() {
        return searchingResultsTitle;
    }

    public SelenideElement getCatalogTitle() {
        return catalogTitle;
    }
}
