package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.Search;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class FailAndDisableTests extends BaseTest {
    Search search = new Search();
    @Feature("Падающий тест")
    @Story("Падающий тест")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Денис")
    @Test
    @DisplayName("Падающий тест")
    @Description("Тест падает")
    public void badTest() {
        new TopBarPage()
                .searchProduct(search.getSearchProduct())
                .searchingResultsVerification("Капуста")
                .firstFilterVerification("")
                .secondFilterVerification(search.getFilterName())
                .productCardLabelVerification(0, search.getProductLabelName());
    }

    @Disabled
    @Feature("Отключенный тест")
    @Story("Отключенный тест")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Денис")
    @Test
    @DisplayName("Отключенный тест")
    @Description("Тест отключен")
    public void disTest() {
        new TopBarPage()
                .searchProduct(search.getSearchProduct())
                .searchingResultsVerification(search.getSearchProduct())
                .firstFilterVerification("")
                .secondFilterVerification(search.getFilterName())
                .productCardLabelVerification(0, search.getProductLabelName());
    }
}
