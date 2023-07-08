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
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
public class TestingIDCRT {

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

    @Test (priority = 1, enabled = true)
    public void AddProductToTheCartCRT001() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "PC Basic" section is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // Wait for the section to charge.
        By seeMoreBtnSelectorCM = By.xpath("//*[@id=\"9555\"]/div/div[3]/div[4]/a");
        WebElement seeMoreBtnCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBtnSelectorCM));

        // The "Ver mas" button is clicked.
        seeMoreBtnCM.click();

        // Wait for the "AGREGAR AL CARRITO" button to appear.
        By addToCartSelectorCM = By.xpath("//*[@id=\"contenedorproducto\"]/div[2]/input");
        WebElement addToCartCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelectorCM));

        // The "AGREGAR AL CARRITO" button is clicked.
        addToCartCM.click();

        // Wait for the "No" button to appear.
        By optionNoSelectorCM = By.xpath("//*[@id=\"modalseguircomprando\"]/div/div/div[2]/div/div/button[2]");
        WebElement optionNoCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(optionNoSelectorCM));

        // The "No" button is clicked.
        optionNoCM.click();

        // It is verified that the product was added to the cart.
        WebElement productInTheCartCM = chromeDriver.findElement(By.xpath("//*[@id=\"checkout_opc\"]/div/div/div[1]/div"));
        if (productInTheCartCM.isDisplayed()) {
            System.out.println("The product was added in the cart in Chrome.");
        } else {
            Assert.fail("The product was not added in the cart in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "PC Basic" section is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // Wait for the section to charge.
        By seeMoreBtnSelectorME = By.xpath("//*[@id=\"9555\"]/div/div[3]/div[4]/a");
        WebElement seeMoreBtnME = edWait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBtnSelectorME));

        // The "Ver mas" button is clicked.
        seeMoreBtnME.click();

        // Wait for the "AGREGAR AL CARRITO" button to appear.
        By addToCartSelectorME = By.xpath("//*[@id=\"contenedorproducto\"]/div[2]/input");
        WebElement addToCartME = edWait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelectorME));

        // The "AGREGAR AL CARRITO" button is clicked.
        addToCartME.click();

        // Wait for the "No" button to appear.
        By optionNoSelectorME = By.xpath("//*[@id=\"modalseguircomprando\"]/div/div/div[2]/div/div/button[2]");
        WebElement optionNoME = edWait.until(ExpectedConditions.visibilityOfElementLocated(optionNoSelectorME));

        // The "No" button is clicked.
        optionNoME.click();

        // It is verified that the product was added to the cart.
        WebElement productInTheCartME = edDriver.findElement(By.xpath("//*[@id=\"checkout_opc\"]/div/div/div[1]/div"));
        if (productInTheCartME.isDisplayed()) {
            System.out.println("The product was added in the cart in Microsoft Edge.");
        } else {
            Assert.fail("The product was not added in the cart in Microsoft Edge.");
        }
    }

    @Test (priority = 2, enabled = true)
    public void AddTakeOutProductToTheCartCRT002() throws InterruptedException {}

    @Test (priority = 3, enabled = true)
    public void DeleteProductToTheCartWithLightBlueTrashCRT003() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "PC Basic" section is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // Wait for the section to charge.
        By seeMoreBtnSelectorCM = By.xpath("//*[@id=\"9555\"]/div/div[3]/div[4]/a");
        WebElement seeMoreBtnCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBtnSelectorCM));

        // The "Ver mas" button is clicked.
        seeMoreBtnCM.click();

        // Wait for the "AGREGAR AL CARRITO" button to appear.
        By addToCartSelectorCM = By.xpath("//*[@id=\"contenedorproducto\"]/div[2]/input");
        WebElement addToCartCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelectorCM));

        // The "AGREGAR AL CARRITO" button is clicked.
        addToCartCM.click();

        // Wait for the "No" button to appear.
        By optionNoSelectorCM = By.xpath("//*[@id=\"modalseguircomprando\"]/div/div/div[2]/div/div/button[2]");
        WebElement optionNoCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(optionNoSelectorCM));

        // The "No" button is clicked.
        optionNoCM.click();

        // The "Light Blue Trash" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"eliminar\"]/img")).click();

        // Wait for the alert to appear.
        By removedProductAlertSelectorCM = By.xpath("//*[@id=\"modalError\"]/div/div");
        WebElement removedProductAlertCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(removedProductAlertSelectorCM));

        // It is verified that the product was removed the cart.
        if (removedProductAlertCM.isDisplayed()) {
            System.out.println("The product was removed the cart in Chrome.");
        } else {
            Assert.fail("The product was not removed the cart in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "PC Basic" section is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // Wait for the section to charge.
        By seeMoreBtnSelectorME = By.xpath("//*[@id=\"9555\"]/div/div[3]/div[4]/a");
        WebElement seeMoreBtnME = edWait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBtnSelectorME));

        // The "Ver mas" button is clicked.
        seeMoreBtnME.click();

        // Wait for the "AGREGAR AL CARRITO" button to appear.
        By addToCartSelectorME = By.xpath("//*[@id=\"contenedorproducto\"]/div[2]/input");
        WebElement addToCartME = edWait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelectorME));

        // The "AGREGAR AL CARRITO" button is clicked.
        addToCartME.click();

        // Wait for the "No" button to appear.
        By optionNoSelectorME = By.xpath("//*[@id=\"modalseguircomprando\"]/div/div/div[2]/div/div/button[2]");
        WebElement optionNoME = edWait.until(ExpectedConditions.visibilityOfElementLocated(optionNoSelectorME));

        // The "No" button is clicked.
        optionNoME.click();

        // The "Light Blue Trash" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"eliminar\"]/img")).click();

        // Wait for the alert to appear.
        By removedProductAlertSelectorME = By.xpath("//*[@id=\"modalError\"]/div/div");
        WebElement removedProductAlertME = edWait.until(ExpectedConditions.visibilityOfElementLocated(removedProductAlertSelectorME));

        // It is verified that the product was removed the cart.
        if (removedProductAlertME.isDisplayed()) {
            System.out.println("The product was removed the cart in Microsoft Edge.");
        } else {
            Assert.fail("The product was not removed the cart in Microsoft Edge.");
        }

    }

    @Test (priority = 4, enabled = true)
    public void DeleteProductToTheCartWithRedButtonCRT004() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "PC Basic" section is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // Wait for the section to charge.
        By seeMoreBtnSelectorCM = By.xpath("//*[@id=\"9555\"]/div/div[3]/div[4]/a");
        WebElement seeMoreBtnCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBtnSelectorCM));

        // The "Ver mas" button is clicked.
        seeMoreBtnCM.click();

        // Wait for the "AGREGAR AL CARRITO" button to appear.
        By addToCartSelectorCM = By.xpath("//*[@id=\"contenedorproducto\"]/div[2]/input");
        WebElement addToCartCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelectorCM));

        // The "AGREGAR AL CARRITO" button is clicked.
        addToCartCM.click();

        // Wait for the "No" button to appear.
        By optionNoSelectorCM = By.xpath("//*[@id=\"modalseguircomprando\"]/div/div/div[2]/div/div/button[2]");
        WebElement optionNoCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(optionNoSelectorCM));

        // The "No" button is clicked.
        optionNoCM.click();

        // The "Red Trash" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"cart-del-btn\"]/img")).click();

        // Wait for the alert to appear.
        By noticeProductRemovedSelectorCM = By.xpath("//*[@id=\"checkout_opc\"]/div/div/div[1]/div/div/div[1]");
        WebElement noticeProductRemovedCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(noticeProductRemovedSelectorCM));

        // It is verified that the product was removed the cart.
        if (noticeProductRemovedCM.isDisplayed()) {
            System.out.println("The product was removed the cart in Chrome.");
        } else {
            Assert.fail("The product was not removed the cart in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "PC Basic" section is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // Wait for the section to charge.
        By seeMoreBtnSelectorME = By.xpath("//*[@id=\"9555\"]/div/div[3]/div[4]/a");
        WebElement seeMoreBtnME = edWait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBtnSelectorME));

        // The "Ver mas" button is clicked.
        seeMoreBtnME.click();

        // Wait for the "AGREGAR AL CARRITO" button to appear.
        By addToCartSelectorME = By.xpath("//*[@id=\"contenedorproducto\"]/div[2]/input");
        WebElement addToCartME = edWait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSelectorME));

        // The "AGREGAR AL CARRITO" button is clicked.
        addToCartME.click();

        // Wait for the "No" button to appear.
        By optionNoSelectorME = By.xpath("//*[@id=\"modalseguircomprando\"]/div/div/div[2]/div/div/button[2]");
        WebElement optionNoME = edWait.until(ExpectedConditions.visibilityOfElementLocated(optionNoSelectorME));

        // The "No" button is clicked.
        optionNoME.click();

        // The "Red Trash" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"cart-del-btn\"]/img")).click();

        // Wait for the alert to appear.
        By noticeProductRemovedSelectorME = By.xpath("//*[@id=\"checkout_opc\"]/div/div/div[1]/div/div/div[1]");
        WebElement noticeProductRemovedME = edWait.until(ExpectedConditions.visibilityOfElementLocated(noticeProductRemovedSelectorME));

        // It is verified that the product was removed the cart.
        if (noticeProductRemovedME.isDisplayed()) {
            System.out.println("The product was removed the cart in Microsoft Edge.");
        } else {
            Assert.fail("The product was not removed the cart in Microsoft Edge.");
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
