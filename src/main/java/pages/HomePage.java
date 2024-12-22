package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class HomePage extends BasePage {
    private static final String XPATH_MENU_TAB = "//button[contains(.,'%s')]";
    private static final SelenideElement pageTitle = $(byXpath("//h1"));
    private static final SelenideElement productsInBasketQuantity = $(byXpath("//nav/following-sibling::div[contains(@class,'flex')]//a[@title='Koszyk']/div"));

    public SelenideElement getPageTitle(){
        return pageTitle;
    }

    public void selectMenuTab(String tabName){
        $(byXpath(String.format(XPATH_MENU_TAB, tabName))).click();
    }
    public SelenideElement getProductsInBasketQuantity(){
        return productsInBasketQuantity;
    }
}
