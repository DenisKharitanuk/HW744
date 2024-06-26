package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static configuration.ReadProperties.getUrl;

public class BaseTest {


    @BeforeEach
    public void setup() {
        Allure.addAttachment("Дата запуска", getDate());
        Allure.addAttachment("Браузер", getBrowser());
        Configuration.baseUrl = getUrl();
        Configuration.reportsFolder = "target/screenshoots/";
        Configuration.browserSize = "1920x1080";
        open(getUrl());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    public String getDate() {
        return String.valueOf(LocalDate.now());
    }

    public String getBrowser() {
        return "chrome.browser";
    }
}
