package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasketSummaryPage extends BasePage {
    private static final SelenideElement pageTitle = $(byXpath("//h1"));
    private static final SelenideElement summaryPriceAtStart = $(byXpath("//div[contains(@class,'summaryUpfront')]//div[@data-qa='BKT_TotalupFrontCurrCOde']"));
    private static final SelenideElement summaryMonthlyFee = $(byXpath("//section[contains(@class,'summaryMonthly')]//article/span[@class='main-amount']"));
    private static final SelenideElement backToMainPageButton = $(byXpath("//a[@class='logoWrap']"));

    public void checkIsPageTitleCorrect(String pageTitle){
        BasketSummaryPage.pageTitle.shouldHave(exactText(pageTitle));
    }

    public SelenideElement getPriceAtStart(){
        return summaryPriceAtStart;
    }

    public SelenideElement getMonthlyFee() {
        return summaryMonthlyFee;
    }

    public void clickGoBackToMainPageButton(){
        backToMainPageButton.click();
    }
}
