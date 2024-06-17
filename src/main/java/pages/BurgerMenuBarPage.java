package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BurgerMenuBarPage {

    //locator block

    private ElementsCollection mainMenu = $$(".menu-burger__main-list-link");
    private ElementsCollection dropMenu = $$(".menu-burger__link");

    private ElementsCollection lastDropMenu = $$(By.xpath("//ul[@class='menu-burger__set']/li/a[@class='menu-burger__link']"));


    //getters block

    public ElementsCollection getMainMenu() {
        return mainMenu;
    }

    public ElementsCollection getDropMenu() {
        return dropMenu;
    }

    public ElementsCollection getLastDropMenu() {
        return lastDropMenu;
    }

    //action block
    public BurgerMenuBarPage clickOnMainMenuByName(String menuName) {
        getMainMenu().find(text(menuName)).shouldBe(visible).click();
        return this;
    }

    public BurgerMenuBarPage clickOnDropMenuByName(String menuName) {
        getDropMenu().find(text(menuName)).click();
        return this;
    }

    public CatalogPage lastClickOnDropdownMenuAndGoToCatalogByName(String menuName) {
        getLastDropMenu().find(text(menuName)).shouldBe(visible).click();
        return new CatalogPage();
    }
}
