package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private WebDriver driver;
    WebDriverWait wait;

    private By signInBtn = By.xpath("//div[@id=\"page-container\"]//a[contains(@href,\"login/\")]");
    private By userName = By.xpath("//input[contains(@id,\"user_login_\")]");
    private By password = By.xpath("//input[contains(@id,\"user_pass_\")]");
    private By loginBtn = By.xpath("//button[@type=\"submit\"]");
    private By careerImg = By.xpath("//*[@id=\"career_img\"]//img");
    private By forgotPasswordBtn = By.xpath("//p[contains(@class,\"forgot_password\")]/a");
    private By signInTxt = By.xpath("//h2[text()=\"Sign In\"]");
    private By alongSignTxt = By.xpath("//div[contains(@class,\"newsletter_description_content\")]/p");


    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterUserName(String username){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userName)));
        getElement(userName).clear();
        type(userName,username);
    }

    public void enterPassword(String pass){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        getElement(password).clear();
        type(password,pass);
    }

    public void enterLoginBtn(){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginBtn)));
        click(loginBtn);
    }

    public void loginToApp(String username, String Password){

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userName)));
        getElement(userName).clear();
        type(userName,username);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        getElement(password).clear();
        type(password,Password);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(password)));
        click(password);
    }

    public void navigateToForgotPass(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(forgotPasswordBtn)));
        getElement(forgotPasswordBtn).click();
    }

    // Getter for career image
    public WebElement getCareerImg(){
        return getElement(careerImg);
    }

    // Getter for signIn Text
    public WebElement getSignInTxt(){
        return getElement(signInTxt);
    }

    // Getter for alongSignIn Text
    public WebElement getAlongSignTxt(){
        return getElement(alongSignTxt);
    }

    // Getter for forgot password button
    public WebElement getForgotpassBtn(){
        return getElement(forgotPasswordBtn);
    }
}
