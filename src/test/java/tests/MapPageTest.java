package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MapPage;
import pages.TopBarPage;

public class MapPageTest extends BaseTest {
    String address = "Санкт-Петербург";

    @Test
    @Feature("Смена города.")
    @DisplayName("Смена города.")
    @Story("Изменение адреса пункта выдачи для доставки товаров.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Нажать на конопку \"Смена города\" . В Поисковую строку ввисти  название города." +
            "Выбрать первый пункт выдачи.Открылась информация о центре выдачи\n" +
            "Адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов" +
            "Нажать на кнопку \"Выбрать\"" +
            "Произошел переход на главную страницу WB \n" +
            "Отображается адрес пункта выдачи из предыдущего шага"
    )
    @Owner("Денис")
    public void changeCity() {
        new TopBarPage()
                .clickOnAddressLocator()
                .inputAddress(address)
                .selectOnAddressByIndex(0)
                .pickUpPointByIndexVerification(0)
                .clickOnSelectButtonLocator()
                .pageIsOpened()
                .addressMenuVerification("Санкт-Петербург, Санкт-Петербург, Спасский переулок, 9");
    }
}
