package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.Filter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class FiltersPageTest extends BaseTest {

    Filter filter = new Filter();

    @Test
    @Feature("Работа с фильтрами.")
    @DisplayName("Работа с фильтрами.")
    @Story("Влияние фильтров на результат поиска.")
    @Severity(SeverityLevel.MINOR)
    @Description("Выбираем нужную категорию товара, настраиваем необходимые фильтры." +
            " Фильтры активированы и отображаются ," +
            "  количество товара соответствует ожидаемому, присутствует кнопка \"Сбросить все\"")
    @Owner("Денис")
    public void workWithFilters() {
        new TopBarPage()
                .clickOnjBurgerMenuButton()
                .clickOnMainMenuByName(filter.getFirstItemInMenu())
                .clickOnDropMenuByName(filter.getSecondItemInMenu())
                .lastClickOnDropdownMenuAndGoToCatalogByName(filter.getThirdItemInMenu())
                .pageIsOpened()
                .clickOnFilterButton()
                .clearAndInputStartInPrice(filter.getPriceStartIn())
                .clearAndInputEndPrice(filter.getPriceEnd())
                .clickOnRadioAndCheckboxButton(filter.getRadioButtonName())
                .clickOnRadioAndCheckboxButton(filter.getFirstCheckboxName())
                .clickOnRadioAndCheckboxButton(filter.getSecondCheckboxName())
                .clickOnShowButton()
                .allFiltersCounterVerification(filter.getCounterValue())
                .productCounterVerification("64")
                .filtersChoiceListVerification(filter.getRadioButtonName(), filter.getFirstCheckboxName(), "от " + filter.getPriceStartIn() + " до " + filter.getPriceEnd(), filter.getSecondCheckboxName(), "Сбросить все");
    }
}
