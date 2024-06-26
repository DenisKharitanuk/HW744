package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.TopBarPage;

public class BasketPageTest extends BaseTest {

    Order newOrder = new Order();

    @Test
    @Feature("Добавление товара в корзину.")
    @DisplayName("Добавление товара в корзину.")
    @Story("Добавление пылесоса в корзину, найденного с помощью фильтров в шапке страницы.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("С помощью фильтров выбираем нужный тип товара, выбираем нужный товар  и " +
            "нажимаем кнопку \"В корзину\". Переходим в корзину - стоимость и наименование товара совпадают, " +
            "в  правом верхнем углу над логотипом \"Корзина\" появилась красная цифра \"1\"")
    @Owner("Денис")
    public void addProductToBasketTest() {
        new TopBarPage()
                .clickOnjBurgerMenuButton()
                .clickOnMainMenuByName(newOrder.getFirstItemInMenu())
                .clickOnDropMenuByName(newOrder.getSecondItemInMenu())
                .clickOnDropMenuByName(newOrder.getThirdItemInMenu())
                .lastClickOnDropdownMenuAndGoToCatalogByName(newOrder.getFourthItemInMenu())
                .pageIsOpened()
                .catalogTitleVerification(newOrder.getFourthItemInMenu())
                .breadcrumbsLinksVerification("Главная", newOrder.getFirstItemInMenu(),
                        newOrder.getSecondItemInMenu(), newOrder.getThirdItemInMenu(), newOrder.getFourthItemInMenu())
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
