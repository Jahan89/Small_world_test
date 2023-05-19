package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class performance_glitch_user {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com//");
    }

    @Test
    public void LoginAndLogoutIntoperformance_glitch_user() throws ExceptionInInitializerError {
        Login login = new Login(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("link-to-login")));
        WebElement loginIcon = driver.findElement(By.id("link-to-login"));
        loginIcon.click();
        login.loginAs ("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(login.getLoginMessage(), "Logged in successfully");
        Logout logout = new Logout(driver);
        logout.logoutMethod();
        Assert.assertEquals(logout.getLoginMessage(), "Signed out successfully.");
    }

}