package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class TopBarPage {

    //locators block
    private SelenideElement searchInput = $("#searchInput");
    private SelenideElement mainContent = $(".main-page__content");
    private SelenideElement jMenuBurgerButton = $(".nav-element__burger-line");
    private SelenideElement basketButton = $(".navbar-pc__icon.navbar-pc__icon--basket");
    ;
    private ElementsCollection mainMenu = $$(".menu-burger__main-list-link");


    //getters block

    public ElementsCollection getMainMenu() {
        return mainMenu;
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }


    public SelenideElement getjMenuBurgerButton() {
        return jMenuBurgerButton;
    }

    public SelenideElement getBasketButton() {
        return basketButton;
    }

    public SelenideElement getMainContent() {
        return mainContent;
    }

}
