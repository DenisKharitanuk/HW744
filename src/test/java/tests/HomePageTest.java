package tests;


import baseEntities.BaseTest;
import models.Search;
import org.junit.jupiter.api.Test;
import pages.TopBarPage;

public class HomePageTest extends BaseTest {
    Search search = new Search();

    @Test
    public void forkWithSearchLineTest() {
        new TopBarPage()
                .searchProduct(search.getSearchProduct())
                .searchingResultsVerification(search.getSearchProduct())
                .firstFilterVerification("")
                .secondFilterVerification(search.getFilterName())
                .productCardLabelVerification(0, search.getProductLabelName());
        new TopBarPage().clearSearchLine().searchLineIsClean();
    }
}
