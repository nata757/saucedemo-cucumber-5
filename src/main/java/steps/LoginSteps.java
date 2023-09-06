package steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    ChromeDriver driver;

    @Given("^I open the page Login$")

    public void iOpenThePageLogin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("web-driver.chrome.driver",
                //"C:\\Program Files\\Google\\Chrome\\Application\\116.0.5845.142");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @When("^I fill input user name \"([^\"]*)\"$")
    public void iFillInputUserName(String usernameValue){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInputField.sendKeys(usernameValue);
    }
}
