package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class ProductDetailsPage extends BasePage {

    private static final SelenideElement priceAtStart = $(byXpath("//span//div[@data-qa='PRD_TotalUpfrontLabel']/following-sibling::div[@data-qa='PRD_TotalUpfront']"));
    private static final SelenideElement monthlyFee = $(byXpath("//span//div[contains(@class,'priceRightSection')]//div[@class='dt_price_change']"));
    private static final SelenideElement addToCartButton = $(By.xpath("//div[contains(@class,'vertical_view')]//button[contains(.,'Dodaj do koszyka')]"));

    public String getPriceAtStart(){
    return priceAtStart.getAttribute("textContent");
    }

    public String getMonthlyFee(){
        return monthlyFee.getAttribute("textContent");
    }

    public void clickAddToCartButton() {
        addToCartButton.shouldBe(enabled).click();
    }


}
