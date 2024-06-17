package tests;

import baseEntities.BaseTest;
import models.Order;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.TopBarPage;

public class BasketPageTest extends BaseTest {

    Order newOrder = new Order();

    @Test
    public void addProductToBasketTest() {
        new TopBarPage()
                .clickOnjBurgerMenuButton()
                .clickOnMainMenuByName(newOrder.getFirstItemInMenu())
                .clickOnDropMenuByName(newOrder.getSecondItemInMenu())
                .clickOnDropMenuByName(newOrder.getThirdItemInMenu())
                .lastClickOnDropdownMenuAndGoToCatalogByName(newOrder.getFourthItemInMenu())
                .pageIsOpened()
                .catalogTitleVerification(newOrder.getFourthItemInMenu())
                .breadcrumbsLinksVerification("Главная",newOrder.getFirstItemInMenu(),
                        newOrder.getSecondItemInMenu(), newOrder.getThirdItemInMenu(),newOrder.getFourthItemInMenu())
                .clickOnAddToBasketButton(0)
                .basketNavbarNotifyBackgroundColorVerification(newOrder.getColor())
                .basketCounterNotification(newOrder.getBasketCounter())
                .clickOnBasketButton()
                .productInfoVerification(newOrder.getProductCardInfo())
                .productPricesVerification(newOrder.getPrice())
                .totalPriceVerification(newOrder.getTotalPrice())
                .toOrderButtonIsClicable();
    }
}
