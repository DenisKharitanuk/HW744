package baseEntities;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static configuration.ReadProperties.getUrl;

public class BaseTest {


    @BeforeEach
    public void setup() {
        Configuration.baseUrl = getUrl();
        Configuration.reportsFolder = "target/screenshoots/";
        Configuration.browserSize="1920x1080";
        open(getUrl());
    }

}
