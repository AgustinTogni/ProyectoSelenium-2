package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import java.time.Duration;

public class TestingIDHM {

    private String url = "https://www.maximus.com.ar/";

    WebDriver chromeDriver;
    WebDriver edDriver;
    Logger log;
    WebDriverWait chromeWait;
    WebDriverWait edWait;

    @BeforeMethod
    public void setBaseConfig() {

        System.setProperty("webdriver.chrome.driver", "E:\\ProyectosSelenium\\ProyectoSelenium-2\\src\\main\\resources\\drivers\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

        System.setProperty("webdriver.edge.driver", "E:\\ProyectosSelenium\\ProyectoSelenium-2\\src\\main\\resources\\drivers\\msedgedriver.exe");
        edDriver = new EdgeDriver();
        edWait = new WebDriverWait(edDriver, Duration.ofSeconds(5));

        log = LogManager.getLogger(TestingIDHM.class);

        log.info("#######");
        log.info("[ Drivers Status ] initializing");
        log.info("#######");
        chromeDriver.get(url);
        chromeDriver.manage().window().maximize();
        edDriver.get(url);
        edDriver.manage().window().maximize();
    }

    @Test(priority = 6)
    public void FindAValidProductHM006() throws InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with valid product.
        WebElement searcherCD = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCD.sendKeys("motherboard");

        // It is verified that field is complete.
        String searcherCheckCD = searcherCD.getAttribute("value");
        if (!searcherCheckCD.isEmpty()) {
            System.out.println("The field is complete in Chrome.");
        } else {
            Assert.fail("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the valid product was searched.
        WebElement motherboardResult = chromeDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (motherboardResult.isDisplayed()) {
            System.out.println("The motherboard was searched in Chrome.");
        } else {
            System.out.println("The session wasn't searched in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with valid product.
        WebElement searcherED = edDriver.findElement(By.id("buscadorDesktop"));
        searcherED.sendKeys("motherboard");

        // It is verified that field is complete.
        String searcherCheckED = searcherED.getAttribute("value");
        if (!searcherCheckED.isEmpty()) {
            System.out.println("The field is complete in Microsoft Edge.");
        } else {
            Assert.fail("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the valid product was searched.
        WebElement motherboardResultED = edDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (motherboardResultED.isDisplayed()) {
            System.out.println("The motherboard was searched in Microsoft Edge.");
        } else {
            System.out.println("The session wasn't searched in Microsoft Edge.");
        }
    }

    @AfterMethod
    public void CloseSession(){
        log.info("#######");
        log.info("[ Drivers Status ] clean and close controller instance");
        log.info("#######");
        chromeDriver.quit();
        edDriver.quit();
    }
}
