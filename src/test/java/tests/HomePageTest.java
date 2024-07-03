package tests;


import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class HomePageTest extends BaseTest {
    Search search = new Search();

    @Test
    @Feature("Работа с поисковой строкой.")
    @DisplayName("Работа с поисковой строкой.")
    @Story("Поиск товара с помощью поисковой строки.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Ввести в поисковую строку наименование товара, нажать кнопку \"Поиск\". " +
            "Присутствует текс с наименованием товара ," +
            " в фильтре указано имя товара, применен фильтр \"По популярности\"," +
            " имя бренда соостетствует ожидаемому.")
    @Owner("Денис")
    public void forkWithSearchLineTest() {
        new TopBarPage()
                .searchProduct(search.getSearchProduct())
                .searchingResultsVerification(search.getSearchProduct())
//                .firstFilterVerification("")
                .secondFilterVerification(search.getFilterName())
                .productCardLabelVerification(0, search.getProductLabelName());
        new TopBarPage().clearSearchLine().searchLineIsClean();
    }
}
