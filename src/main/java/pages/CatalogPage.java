package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogPage {

    //locators block
    private SelenideElement firstProductInCatalog = $(By.xpath("//*[@id=\"c165760752\"]/div/div[1]"));
    private SelenideElement mainContent = $(".main-page__content");
    private SelenideElement searchingResultsTitle = $(".searching-results__title");
    private SelenideElement firstFilter = $(By.xpath("//div/button[@class='dropdown-filter__btn dropdown-filter__btn--burger']"));
    private SelenideElement secondFilter = $(By.xpath("//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter']"));
    private SelenideElement catalogTitle = $(".catalog-title");
    private SelenideElement filterDropdownMenuButton = $((".dropdown-filter.j-show-all-filtres"));
    private SelenideElement allFiltersCounter = $(By.xpath("//div[@class='dropdown-filter j-show-all-filtres']/span"));
    private SelenideElement productCounter = $(By.xpath("//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']"));
    private SelenideElement productCardList = $(".product-card-list");
    private ElementsCollection productCard = $$(".product-card__wrapper");
    private ElementsCollection filtersChoice = $$(".your-choice__btn");
    private ElementsCollection breadcrumbsLink = $$(By.xpath("//span[@itemprop='name']"));
    private ElementsCollection addToBasketButton = $$(".product-card__add-basket.j-add-to-basket.btn-main");
    private ElementsCollection productCardBrand = $$(".product-card__brand");


    //getters block

    public SelenideElement getMainContent() {
        return mainContent;
    }

    public SelenideElement getProductCardList() {
        return productCardList;
    }

    public ElementsCollection getProductCardBrand() {
        return productCardBrand;
    }

    private SelenideElement getFirstProductInCatalog() {
        return firstProductInCatalog;
    }

    private ElementsCollection getAddToBasketButton() {
        return addToBasketButton;
    }

    private ElementsCollection getProductCardBrande() {
        return productCard;
    }

    private SelenideElement getSearchingResultsTitle() {
        return searchingResultsTitle;
    }

    private SelenideElement getFirstFilter() {
        return firstFilter;
    }

    private SelenideElement getSecondFilter() {
        return secondFilter;
    }

    private SelenideElement getCatalogTitle() {
        return catalogTitle;
    }

    private SelenideElement getFilterDropdownMenuButton() {
        return filterDropdownMenuButton;
    }

    private SelenideElement getAllFiltersCounter() {
        return allFiltersCounter;
    }

    private SelenideElement getProductCounter() {
        return productCounter;
    }

    private ElementsCollection getProductCard() {
        return productCard;
    }

    private ElementsCollection getFiltersChoice() {
        return filtersChoice;
    }

    private ElementsCollection getBreadcrumbsLink() {
        return breadcrumbsLink;
    }

    //actions block

    public TopBarPage clickOnAddToBasketButton(int index) {
        getAddToBasketButton().get(index).shouldBe(visible).shouldBe(clickable).click();
        return new TopBarPage();
    }

    public FiltersPage clickOnFilterButton() {
        getFilterDropdownMenuButton().click();
        return new FiltersPage();
    }

    //verifications block
    public CatalogPage searchingResultsVerification(String expectedText) {
        getSearchingResultsTitle().shouldBe(visible).shouldHave(text(expectedText));
        return this;
    }

    public CatalogPage firstFilterVerification(String filterName) {
        getFirstFilter().shouldBe(visible).shouldHave(exactText(filterName));
        return this;
    }

    public CatalogPage secondFilterVerification(String filterName) {
        getSecondFilter().shouldBe(visible).shouldHave(text(filterName));
        return this;
    }

    public CatalogPage firstProductIsVerification(String productName) {
        assertEquals(productName, getFirstProductInCatalog().getText());
        return this;
    }

    public CatalogPage productCardLabelVerification(int index, String productLabel) {
        getProductCardBrande().get(0).shouldBe(visible).shouldHave(text(productLabel));
        return this;
    }

    public CatalogPage catalogTitleVerification(String catalogTitleName) {
        getCatalogTitle().shouldBe(visible).shouldHave(text(catalogTitleName));
        return this;
    }

    public CatalogPage breadcrumbsLinksVerification(String... linksArray) {
        for (int i = 0; i < linksArray.length; i++) {
            assertEquals(linksArray[i], getBreadcrumbsLink().get(i).getText());
        }
        return this;
    }

    public CatalogPage filtersChoiceListVerification(String... filterArray) {
        for (int i = 0; i < filterArray.length; i++) {
            assertEquals(filterArray[i], getFiltersChoice().get(i).getText());
        }
        return this;
    }

    public CatalogPage allFiltersCounterVerification(String counterValue) {
        getAllFiltersCounter().shouldBe(visible).shouldHave(text(counterValue));
        return new CatalogPage();
    }

    public CatalogPage productCounterVerification(String size) {
        getProductCounter().shouldBe(text(size));
        return this;
    }

    public CatalogPage pageIsOpened() {
        getCatalogTitle().shouldBe(visible);
        return this;
    }
}
