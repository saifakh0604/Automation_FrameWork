package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Dashboard extends BasePage {

    private WebDriver driver;
    WebDriverWait wait;


    private By accountBtn = By.xpath("//a[text()=\"Account\"]");
    private By navLogoutBtn = By.xpath("//a[contains(@href',\"/login\")]");
    private By cartBtn = By.xpath("//a[contains(@href,\"/cart/\")]");
    private By dashBoardBtn = By.xpath("//nav[@aria-label=\"Account pages\"]//li[1]/a");
    private By AddressBookBtn = By.xpath("//nav[@aria-label=\"Account pages\"]//li[2]/a");
    private By ordersBtn = By.xpath("//nav[@aria-label=\"Account pages\"]//li[3]/a");
    private By accountDetailsBtn = By.xpath("//nav[@aria-label=\"Account pages\"]//li[4]/a");
    private By logoutBtn = By.xpath("//nav[@aria-label=\"Account pages\"]//li[5]/a");
    private By logoutLink = By.xpath("//a[contains(@href,\"?action=logout&redirect\")]");
    private By headerText = By.xpath("//h1[@class=\"entry-title\"]");
    private By mainHeader = By.xpath("//div[@class=\"header-content-container center\"]");



    public Dashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }


    public void navigateTo(By locator){
        String str = getElement(locator).getText();
        moveToElement(locator);
        click(locator);
        System.out.println("Click on "+str+" button");
    }

    public void clickOnOpt(By locator, Function<By, WebElement> elementFetch){
        WebElement ele = elementFetch.apply(locator);
    }

    public void navigateToDashboard(){
        navigateTo(this.dashBoardBtn);
    }

    public void navigateAddressBookBtn(){
        navigateTo(this.AddressBookBtn);
    }

    public void navigateOrdersBtn(){
        navigateTo(this.ordersBtn);
    }

    public void navigateAccountDetailsBtn(){
        navigateTo(this.accountDetailsBtn);
    }

    public void navigateLogoutBtn() {
        navigateTo(logoutBtn);
    }


    public By getAccountBtn() {
        return accountBtn;
    }

    public By getNavLogoutBtn() {
        return navLogoutBtn;
    }

    public By getCartBtn() {
        return cartBtn;
    }

    public By getDashBoardBtn() {
        return dashBoardBtn;
    }

    public By getAddressBookBtn() {
        return AddressBookBtn;
    }

    public By getOrdersBtn() {
        return ordersBtn;
    }

    public By getAccountDetailsBtn() {
        return accountDetailsBtn;
    }

    public By getLogoutBtn() {
        return logoutBtn;
    }

    public By getLogoutLink() {
        return logoutLink;
    }

    public By getHeaderText() {
        return headerText;
    }

    public By getMainHeader() {
        return mainHeader;
    }
}
