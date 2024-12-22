package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class DeviceWithoutContractListPage extends BasePage {

    private static final SelenideElement pageTitle = $(byXpath("//h1[@data-qa='LST_Header']"));
    private static final SelenideElement firstProductOnList = $(byXpath("//div[@data-qa='LST_ProductCard0']"));

    public void checkIsPageTitleCorrect(String pageTitle){
        DeviceWithoutContractListPage.pageTitle.shouldHave(exactText(pageTitle));
    }

    public void selectFirstProductFromList(){
        firstProductOnList.click();
    }
}
