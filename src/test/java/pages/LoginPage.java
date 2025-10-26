package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    private By signInBtn = By.xpath("//div[@id=\"page-container\"]//a[contains(@href,\"login/\")]");
    private By userName = By.xpath("//input[contains(@id,\"user_login_\")]");
    private By password = By.xpath("//input[contains(@id,\"user_pass_\")]");
    private By loginBtn = By.xpath("//button[@type=\"submit\"]");
    private By careerImg = By.xpath("//*[@id=\"career_img\"]//img");
    private By forgotPasswordBtn = By.xpath("//p[contains(@class,\"forgot_password\")]/a");
    private By signInTxt = By.xpath("//h2[text()=\"Sign In\"]");
    private By alongSignTxt = By.xpath("//div[contains(@class,\"newsletter_description_content\")]/p");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String username){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userName)));
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String pass){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void enterLoginBtn(){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginBtn)));
        driver.findElement(loginBtn).click();
    }

    public void loginToApp(String username, String Password){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userName)));
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(Password);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        driver.findElement(loginBtn).click();
    }

    public void navigateToForgotPass(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(forgotPasswordBtn)));
        driver.findElement(forgotPasswordBtn).click();
    }

    // Getter for career image
    public WebElement getCareerImg(){
        return driver.findElement(careerImg);
    }

    // Getter for signIn Text
    public WebElement getSignInTxt(){
        return driver.findElement(signInTxt);
    }

    // Getter for alongSignIn Text
    public WebElement getAlongSignTxt(){
        return driver.findElement(alongSignTxt);
    }

    // Getter for forgot password button
    public WebElement getForgotpassBtn(){
        return driver.findElement(forgotPasswordBtn);
    }
}
