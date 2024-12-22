package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class DevicesTabMenuPage extends BasePage{

    private static final String XPATH_SUBMENU_OPTION = "//li[contains(.,'%s')]/ul//a[contains(.,'%s')]";

    public void selectOptionFromDevicesSubmenu(String columnName, String productName){
        $(byXpath(String.format(XPATH_SUBMENU_OPTION, columnName, productName))).click();

    }
}
