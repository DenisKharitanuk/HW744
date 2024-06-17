package tests;

import baseEntities.BaseTest;
import models.Filter;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class FiltersPageTest extends BaseTest {

    Filter filter = new Filter();

    @Test
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
                .productCounterVerification("38")
                .filtersChoiceListVerification(filter.getRadioButtonName(), filter.getFirstCheckboxName(), "от " + filter.getPriceStartIn() + " до " + filter.getPriceEnd(), filter.getSecondCheckboxName(), "Сбросить все");
    }
}
