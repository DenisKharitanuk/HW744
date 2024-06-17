package tests;

import baseEntities.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MapPage;
import pages.TopBarPage;

public class MapPageTest extends BaseTest {
    String address="Санкт-Петербург";
    @Test
    public void changeCity(){
        new TopBarPage()
                .clickOnAddressLocator()
                .inputAddress(address)
                .selectOnAddressByIndex(0)
                .pickUpPointByIndexVerification(0)
                .clickOnSelectButtonLocator()
                .pageIsOpened()
                .addressMenuVerification("г. Санкт-Петербург, м. Лесная, ул. Александра Матросова, 20 корп.2А");
    }
}
