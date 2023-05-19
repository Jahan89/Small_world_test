package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.String;
import java.lang.System;

public class SearchTest {
    @Test
    public static void searchProduct() {
        System.setProperty("webdriver.chrome.driver", "/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebElement clickSearchBar = driver.findElement(By.id("keywords"));
        clickSearchBar.click();
        String toSearchProduct = "shirt";
        WebElement textToSearch = driver.findElement(By.id("keywords"));
        textToSearch.sendKeys(toSearchProduct);
        WebElement search_button = driver.findElement(By.cssSelector("#search-bar > form > input.btn.btn-success"));
        search_button.click();

    }
    @Test
    public static void ifSearchedProductIsFound(){
        System.setProperty("webdriver.chrome.driver", "/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebElement clickSearchBar = driver.findElement(By.id("keywords"));
        clickSearchBar.click();
        String toSearchProduct = "shirt";
        WebElement textToSearch = driver.findElement(By.id("keywords"));
        textToSearch.sendKeys(toSearchProduct);
        WebElement search_button = driver.findElement(By.cssSelector("#search-bar > form > input.btn.btn-success"));
        search_button.click();
        //SearchTest.searchProduct();
        //driver.get(SearchTest.searchProduct());
        String showResults = driver.findElement(By.className("search-results-title")).getText();
        Assert.assertNotEquals(showResults,"No products found");
        //driver.close();
    }
    @Test
    public static void ifSearchedProductIsNotFound(){
        System.setProperty("webdriver.chrome.driver", "/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        //driver.get(SearchTest.searchProduct());
        WebElement clickSearchBar = driver.findElement(By.id("keywords"));
        clickSearchBar.click();
        String toSearchProduct = "shirts";
        WebElement textToSearch = driver.findElement(By.id("keywords"));
        textToSearch.sendKeys(toSearchProduct);
        WebElement search_button = driver.findElement(By.cssSelector("#search-bar > form > input.btn.btn-success"));
        search_button.click();
        String showResults = driver.findElement(By.className("search-results-title")).getText();
        Assert.assertEquals(showResults,"No products found");
        //driver.close();
    }
    @Test
    public static void MessageIfItemGotAddedToCart() {
        System.setProperty("webdriver.chrome.driver", "/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebElement clickSearchBar = driver.findElement(By.id("keywords"));
        clickSearchBar.click();
        String toSearchProduct = "shirt";
        WebElement textToSearch = driver.findElement(By.id("keywords"));
        textToSearch.sendKeys(toSearchProduct);
        WebElement search_button = driver.findElement(By.cssSelector("#search-bar > form > input.btn.btn-success"));
        search_button.click();
        //SearchTest.searchProduct();
        //driver.get(SearchTest.searchProduct());
        String showResults = driver.findElement(By.className("search-results-title")).getText();
        Assert.assertNotEquals(showResults, "No products found");
        WebElement clickOnFirstProduct = driver.findElement(By.xpath("//*[@id=\"product_5\"]/div/div[1]/a/img"));
        clickOnFirstProduct.click();
        WebElement clickAddToCart = driver.findElement(By.id("add-to-cart-button"));
        clickAddToCart.click();
       // String cartTitle = driver.findElement(By.cssSelector("#content > div > h1")).getText();
        //Assert.assertEquals(cartTitle,"Shopping Cart");
    }
}
