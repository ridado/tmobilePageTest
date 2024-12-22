package pages;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    private static final String BASE_URL = "http://t-mobile.pl";

    public void setBrowser(String browserName){
        Configuration.browser = browserName;
    }

    public void openBrowser(String browserName){
        setBrowser(browserName);
        open(BASE_URL);
        $(byId("didomi-notice-agree-button")).click();
    }
}
