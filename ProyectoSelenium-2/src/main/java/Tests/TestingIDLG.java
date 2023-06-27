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
public class TestingIDLG {

    private String url = "https://www.maximus.com.ar/LOGIN/login/maximus.aspx";
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
    public void LoginWithValidDataLG001() throws InterruptedException {

        // Credentials

        String email = "Admin123@gmail.com";
        String password = "Admin";


        // ----- Test for Chrome -----

        // The email field is completed.
        chromeDriver.findElement(By.xpath("//*[@id=\"usuario\"]")).sendKeys(email);

        // The password field is completed.
        chromeDriver.findElement(By.xpath("//*[@id=\"clave\"]")).sendKeys(password);

        // The "LOGIN" button is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"loginBody\"]/div[2]/div[4]/button")).click();

        // Wait for the home to appear.
        By homeSelectorCM = By.xpath("//*[@id=\"home\"]");
        WebElement homeCM = chromeWait.until(ExpectedConditions.presenceOfElementLocated(homeSelectorCM));

        // It is verified that the login is successful.
        if (homeCM.isDisplayed()) {
            System.out.println("The login was successful in Chrome.");
        } else {
            Assert.fail("The login was not successful in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The email field is completed.
        edDriver.findElement(By.xpath("//*[@id=\"usuario\"]")).sendKeys(email);

        // The password field is completed.
        edDriver.findElement(By.xpath("//*[@id=\"clave\"]")).sendKeys(password);

        // The "LOGIN" button is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"loginBody\"]/div[2]/div[4]/button")).click();

        // Wait for the home to appear.
        By homeSelectorME = By.xpath("//*[@id=\"home\"]");
        WebElement homeME = edWait.until(ExpectedConditions.presenceOfElementLocated(homeSelectorME));

        // It is verified that the login is successful.
        if (homeME.isDisplayed()) {
            System.out.println("The login was successful in Microsoft Edge.");
        } else {
            Assert.fail("The login was not successful in Microsoft Edge.");
        }
    }

    @Test (priority = 2, enabled = true)
    public void LoginWithInvalidDataLG002() throws InterruptedException {

        // Credentials

        String email = "EmailInvalido@yahoo.com";
        String password = "ContraseñaInvalida";


        // ----- Test for Chrome -----

        // The email field is completed.
        chromeDriver.findElement(By.xpath("//*[@id=\"usuario\"]")).sendKeys(email);

        // The password field is completed.
        chromeDriver.findElement(By.xpath("//*[@id=\"clave\"]")).sendKeys(password);

        // The "LOGIN" button is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"loginBody\"]/div[2]/div[4]/button")).click();

        // Wait for the alert to appear.
        By alertInvalidDataSelectorCM = By.xpath("//*[@id=\"errorlogin\"]/div");
        WebElement alertInvalidDataCM = chromeWait.until(ExpectedConditions.presenceOfElementLocated(alertInvalidDataSelectorCM));

        // It is verified that the login is successful.
        if (alertInvalidDataCM.isDisplayed()) {
            System.out.println("The login was not successful in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The email field is completed.
        edDriver.findElement(By.xpath("//*[@id=\"usuario\"]")).sendKeys(email);

        // The password field is completed.
        edDriver.findElement(By.xpath("//*[@id=\"clave\"]")).sendKeys(password);

        // The "LOGIN" button is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"loginBody\"]/div[2]/div[4]/button")).click();

        // Wait for the alert to appear.
        By alertInvalidDataSelectorME = By.xpath("//*[@id=\"errorlogin\"]/div");
        WebElement alertInvalidDataME = edWait.until(ExpectedConditions.presenceOfElementLocated(alertInvalidDataSelectorME));

        // It is verified that the login is successful.
        if (alertInvalidDataME.isDisplayed()) {
            System.out.println("The login was not successful in Microsoft Edge.");
        }
    }

    @Test (priority = 3, enabled = true)
    public void RegistrationTextLinkLG003() throws InterruptedException {

        // ----- Test for Chrome -----

        // The text "Registrarse" is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"cajaRegistro\"]/a")).click();

        // It is verified that the registration text link works.
        WebElement formRegisterCM = chromeDriver.findElement(By.xpath("//*[@id=\"form-registro\"]/div/div"));
        if (formRegisterCM.isDisplayed()) {
            System.out.println("The registration text link works in Chrome");
        } else {
            Assert.fail("The registration text link not work in Chrome");
        }

        // ----- Test for Microsoft Edge -----

        // The text "Registrarse" is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"cajaRegistro\"]/a")).click();

        // It is verified that the registration text link works.
        WebElement formRegisterME = edDriver.findElement(By.xpath("//*[@id=\"form-registro\"]/div/div"));
        if (formRegisterME.isDisplayed()) {
            System.out.println("The registration text link works in Microsoft Edge.");
        } else {
            Assert.fail("The registration text link not work in Microsoft Edge.");
        }
    }

    @Test (priority = 4, enabled = true)
    public void ForgotMyPasswordTextLinkLG004() throws InterruptedException {

        // ----- Test for Chrome -----

        // The text "Olvide mi clave" is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"#abrirrecuperocontra\"]")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // It is verified that the alert recovery is visible.
        WebElement alertRecoveryCM = chromeDriver.findElement(By.xpath("//*[@id=\"modalrecuperocontra\"]/div/div/div[1]/h5"));
        if (alertRecoveryCM.isDisplayed()) {
            System.out.println("The alert recovery is visible in Chrome.");
        } else {
            Assert.fail("The alert recovery is not visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The text "Olvide mi clave" is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"#abrirrecuperocontra\"]")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // It is verified that the alert recovery is visible.
        WebElement alertRecoveryME = edDriver.findElement(By.xpath("//*[@id=\"modalrecuperocontra\"]/div/div/div[1]/h5"));
        if (alertRecoveryME.isDisplayed()) {
            System.out.println("The alert recovery is visible in Microsoft Edge.");
        } else {
            Assert.fail("The alert recovery is not visible in Microsoft Edge.");
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
