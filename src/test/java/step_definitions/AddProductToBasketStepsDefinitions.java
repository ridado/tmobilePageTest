package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

import static com.codeborne.selenide.Condition.*;

public class AddProductToBasketStepsDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(AddProductToBasketStepsDefinitions.class);
    private static final HomePage homePage = new HomePage();
    private static final DevicesTabMenuPage devicesTabMenuPage = new DevicesTabMenuPage();
    private static final DeviceWithoutContractListPage deviceWithoutContractListPage = new DeviceWithoutContractListPage();
    private static final ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private static final BasketSummaryPage basketSummaryPage = new BasketSummaryPage();
    private static String priceAtStart;
    private static String monthlyFee;

    @Given("As a user opens main page")
    public void asAUser_opens_main_page(){
        logger.info("Test started");
        homePage.openBrowser("Chrome");
        logger.info("Page opened");
        homePage.getPageTitle().shouldHave(exactText("Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile"));
    }
    @When("User selects on main page devices tab")
    public void user_selects_on_main_page_devices_tab() {
        try{
            homePage.selectMenuTab("Urządzenia");
            logger.info("Tab clicked successfully");
        } catch (Exception e) {
            logger.error("Test error: ", e);
        }
    }

    @And("User clicks smartwatches in without contract column")
    public void user_clicks_smartwatches_in_without_contract_column() {
        devicesTabMenuPage.selectOptionFromDevicesSubmenu("Bez abonamentu", "Smartwatche");
        logger.info("Product category opened successfully");
        deviceWithoutContractListPage.checkIsPageTitleCorrect("Urządzenia bez abonamentu");
        logger.info("Page title correct");
    }
    @And("User clicks in first product ont the list")
    public void user_clicks_in_first_product_ont_the_list() {
        deviceWithoutContractListPage.selectFirstProductFromList();
        logger.info("Product selected successfully");
        priceAtStart = productDetailsPage.getPriceAtStart();
        monthlyFee = productDetailsPage.getMonthlyFee();
    }
    @And("User clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        productDetailsPage.clickAddToCartButton();
        logger.info("Product added to cart");
        basketSummaryPage.checkIsPageTitleCorrect("Twój koszyk");
        logger.info("Page title correct");
        basketSummaryPage.getPriceAtStart().shouldHave(exactText(priceAtStart));
        logger.info("Price at start correct");
        basketSummaryPage.getMonthlyFee().shouldHave(exactText(monthlyFee));
        logger.info("Monthly fee correct");

    }
    @Then("User go back to main page")
    public void user_go_back_to_main_page() {
        basketSummaryPage.clickGoBackToMainPageButton();
        logger.info("Main page displayed");
        homePage.getPageTitle().shouldHave(exactText("Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile"));
        logger.info("Page title correct");
        homePage.getProductsInBasketQuantity().shouldHave(exactText("1"));
        logger.info("Products quantity correct");
    }

}
