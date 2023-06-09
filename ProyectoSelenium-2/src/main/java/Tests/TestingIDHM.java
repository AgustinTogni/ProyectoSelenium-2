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

    @Test(priority = 1, enabled = false)
    public void FollowMyOrderUPSBtnHM001() throws InterruptedException {}

    @Test(priority = 2, enabled = false)
    public void FollowMyOrderOCABtnHM002() throws InterruptedException {}

    @Test(priority = 3, enabled = true)
    public void UploadReceiptsBtnHM003() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "Subir Comprobantes" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"abircomprobantenologueado\"]")).click();

        // It is verified that the "Upload Receipt window" is visible.
        WebElement uploadReceiptWindowCM = chromeDriver.findElement(By.xpath("//*[@id=\"appProfile\"]/div[3]"));
        if (uploadReceiptWindowCM.isDisplayed()) {
            System.out.println("The 'Upload Receipt Window' is visible in Chrome.");
        } else {
            Assert.fail("The 'Upload Receipt Window' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "Subir Comprobantes" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"abircomprobantenologueado\"]")).click();

        // It is verified that the "Upload Receipt window" is visible.
        WebElement uploadReceiptWindowME = edDriver.findElement(By.xpath("//*[@id=\"appProfile\"]/div[3]"));
        if (uploadReceiptWindowME.isDisplayed()) {
            System.out.println("The 'Upload Receipt Window' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'Upload Receipt Window' isn't visible in Microsoft Edge.");
        }

    }

    @Test(priority = 4, enabled = true)
    public void WarrantyRMABtnHM004() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "RMA - Garantia" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[1]/a[5]/span")).click();

        // Wait for "RMA - Garantia" window to load.
        By warrantyRMAWindowSelectorCM = By.xpath("//*[@id=\"modaldisclaimer\"]/div/div/div[1]");
        WebElement warrantyRMAWindowCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(warrantyRMAWindowSelectorCM));

        // It is verified that the "RMA - Garantia" window is visible.
        if (warrantyRMAWindowCM.isDisplayed()) {
            System.out.println("The 'RMA - Garantia window' is visible in Chrome.");
        } else {
            Assert.fail("The 'RMA - Garantia window' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "RMA - Garantia" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[1]/a[5]/span")).click();

        // Wait for "RMA - Garantia" window to load.
        By warrantyRMAWindowSelectorME = By.xpath("//*[@id=\"modaldisclaimer\"]/div/div/div[1]");
        WebElement warrantyRMAWindowME = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(warrantyRMAWindowSelectorME));

        // It is verified that the "RMA - Garantia" window is visible.
        if (warrantyRMAWindowME.isDisplayed()) {
            System.out.println("The 'RMA - Garantia window' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'RMA - Garantia window' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 5, enabled = false)
    public void HelpBtnHM005() throws InterruptedException {}

    @Test(priority = 6, enabled = true)
    public void FindAValidProductHM006() throws InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with valid product.
        WebElement searcherCM = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCM.sendKeys("motherboard");

        // It is verified that the field is complete.
        String searcherCheckCM = searcherCM.getAttribute("value");
        if (!searcherCheckCM.isEmpty()) {
            System.out.println("The field is complete in Chrome.");
        } else {
            Assert.fail("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the valid product was searched.
        WebElement motherboardResultCM = chromeDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (motherboardResultCM.isDisplayed()) {
            System.out.println("The motherboard was searched in Chrome.");
        } else {
            Assert.fail("The motherboard wasn't searched in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with valid product.
        WebElement searcherME = edDriver.findElement(By.id("buscadorDesktop"));
        searcherME.sendKeys("motherboard");

        // It is verified that the field is complete.
        String searcherCheckME = searcherME.getAttribute("value");
        if (!searcherCheckME.isEmpty()) {
            System.out.println("The field is complete in Microsoft Edge.");
        } else {
            Assert.fail("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the valid product was searched.
        WebElement motherboardResultME = edDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (motherboardResultME.isDisplayed()) {
            System.out.println("The motherboard was searched in Microsoft Edge.");
        } else {
            Assert.fail("The motherboard wasn't searched in Microsoft Edge.");
        }
    }

    @Test(priority = 7, enabled = true)
    public void FindInvalidProductHM007() throws  InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with invalid product.
        WebElement searcherCM = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCM.sendKeys("chocolate");

        // It is verified that the field is complete.
        String searcherCheckCM = searcherCM.getAttribute("value");
        if (!searcherCheckCM.isEmpty()) {
            System.out.println("The field is complete in Chrome.");
        } else {
            Assert.fail("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the alert "not result" is visible.
        WebElement alertResultCM = chromeDriver.findElement(By.id("contenedornoproducto"));
        if (alertResultCM.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Chrome.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with invalid product.
        WebElement searcherME = edDriver.findElement(By.id("buscadorDesktop"));
        searcherME.sendKeys("chocolate");

        // It is verified that the field is complete.
        String searcherCheckME = searcherME.getAttribute("value");
        if (!searcherCheckME.isEmpty()) {
            System.out.println("The field is complete in Microsoft Edge.");
        } else {
            Assert.fail("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the alert "not result" is visible.
        WebElement motherboardResultME = edDriver.findElement(By.id("contenedornoproducto"));
        if (motherboardResultME.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Microsoft Edge.");
        }
    }

    @Test (priority = 8, enabled = true)
    public void SpecialCharactersInTheSearchBarHM008() throws InterruptedException {

        // ----- Test for Chrome -----

        // The field is complete with 'special characters'.
        WebElement searcherCM = chromeDriver.findElement(By.id("buscadorDesktop"));
        searcherCM.sendKeys("@#!#!@#!@#");

        // It is verified that the field isn't complete.
        String searcherCheckCM = searcherCM.getAttribute("value");
        if (!searcherCheckCM.isEmpty()) {
            Assert.fail("The field is complete in Chrome.");
        } else {
            System.out.println("The field is empty in Chrome.");
        }

        // The "magnifying glass" icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the alert "not result" is visible.
        WebElement alertResultCM = chromeDriver.findElement(By.id("contenedornoproducto"));
        if (alertResultCM.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Chrome.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The field is complete with 'special characters'.
        WebElement searcherME = edDriver.findElement(By.id("buscadorDesktop"));
        searcherME.sendKeys("@#!#!@#!@#");

        // It is verified that the field isn't complete.
        String searcherCheckME = searcherME.getAttribute("value");
        if (!searcherCheckME.isEmpty()) {
            Assert.fail("The field is complete in Microsoft Edge.");
        } else {
            System.out.println("The field is empty in Microsoft Edge.");
        }

        // The "magnifying glass" icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[2]/div[1]/button/img")).click();

        // It is verified that the alert "not result" is visible.
        WebElement motherboardResultME = edDriver.findElement(By.id("contenedornoproducto"));
        if (motherboardResultME.isDisplayed()) {
            System.out.println("The alert 'not result' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The alert 'not result' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 9, enabled = true)
    public void LoginBtnHM009() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "Ingresar" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"cuentanologueada\"]/p")).click();

        // It is verified that the "Login window" is visible.
        WebElement loginWindowCM = chromeDriver.findElement(By.id("loginBody"));
        if (loginWindowCM.isDisplayed()) {
            System.out.println("The 'login window' is visible in Chrome.");
        } else {
            Assert.fail("The 'login window' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "Ingresar" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"cuentanologueada\"]/p")).click();

        // It is verified that the "Login window" is visible.
        WebElement loginWindowME = edDriver.findElement(By.id("loginBody"));
        if (loginWindowME.isDisplayed()) {
            System.out.println("The 'login window' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'login window' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 10, enabled = true)
    public void MyCartBtnHM010() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "Mi carrito" text is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[3]/a[4]/p[1]")).click();

        // Wait for cart alert to appear.
        By myCartAlertSelectorCM = By.xpath("//*[@id=\"busqueda\"]/div[3]/div");
        WebElement myCartAlertCM = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(myCartAlertSelectorCM));

        // It is verified that the "My cart alert" is visible.
        if (myCartAlertCM.isDisplayed()) {
            System.out.println("The 'My cart alert' is visible in Chrome.");
        } else {
            Assert.fail("The 'My cart alert' isn't visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "Mi carrito" text is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[3]/a[4]/p[1]")).click();

        // Wait for cart alert to appear.
        By myCartAlertSelectorME = By.xpath("//*[@id=\"busqueda\"]/div[3]/div");
        WebElement myCartAlertME = edWait.until(ExpectedConditions.visibilityOfElementLocated(myCartAlertSelectorME));

        // It is verified that the "My cart alert" is visible.
        if (myCartAlertME.isDisplayed()) {
            System.out.println("The 'My cart alert' is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'My cart alert' isn't visible in Microsoft Edge.");
        }
    }

    @Test(priority = 11, enabled = false)
    public void SearchForCategoryHM011() throws InterruptedException {}

    @Test(priority = 12, enabled = true)
    public void createYourPcBtnHM012() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "ARMA TU PC" button is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"armarpc\"]/a/span")).click();

        // It is verified that the "ARMA TU PC" section is visible.
        WebElement createYourPcSectionCM = chromeDriver.findElement(By.xpath("//*[@id=\"divBody\"]/div[8]/div/div/div[2]/div[1]/div/span/h1"));
        if (createYourPcSectionCM.isDisplayed()) {
            System.out.println("The 'ARMA TU PC' section is visible in Chrome.");
        } else {
            Assert.fail("The 'ARMA TU PC' section is not visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "ARMA TU PC" button is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"armarpc\"]/a/span")).click();

        // It is verified that the "ARMA TU PC" section is visible.
        WebElement createYourPcSectionME = edDriver.findElement(By.xpath("//*[@id=\"divBody\"]/div[8]/div/div/div[2]/div[1]/div/span/h1"));
        if (createYourPcSectionME.isDisplayed()) {
            System.out.println("The 'ARMA TU PC' section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'ARMA TU PC' section is not visible in Microsoft Edge.");
        }
    }

    @Test(priority = 13, enabled = true)
    public void toggleLightModeDarkModeHM013() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "toggle" button is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/label/div")).click();

        // It is verified that the light mode is visible.
        WebElement darkModeCM = chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/p[1]"));
        if (darkModeCM.isDisplayed()) {
            System.out.println("The dark mode is visible in Chrome.");
        } else {
            Assert.fail("The dark mode is not visible in Chrome.");
        }

        // The "toggle" button is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/label/div")).click();

        // It is verified that the dark mode is visible.
        WebElement lightModeCM = chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/p[2]"));
        if (lightModeCM.isDisplayed()) {
            System.out.println("The light mode is visible in Chrome.");
        } else {
            Assert.fail("The light mode is not visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "toggle" button is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/label/div")).click();

        // It is verified that the light mode is visible.
        WebElement darkModeME = edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/p[1]"));
        if (darkModeME.isDisplayed()) {
            System.out.println("The dark mode is visible in Microsoft Edge.");
        } else {
            Assert.fail("The dark mode is not visible in Microsoft Edge.");
        }

        // The "toggle" button is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/label/div")).click();

        // It is verified that the dark mode is visible.
        WebElement lightModeME = edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/nav/div/div[3]/div/p[2]"));
        if (lightModeME.isDisplayed()) {
            System.out.println("The light mode is visible in Microsoft Edge.");
        } else {
            Assert.fail("The light mode is not visible in Microsoft Edge.");
        }

    }

    @Test(priority = 14, enabled = true)
    public void imageCarouselHM014() throws InterruptedException {

        // ----- Test for Chrome -----

        // js executor is set.
        JavascriptExecutor jsExecutorCM = (JavascriptExecutor) chromeDriver;

        // The "right arrow" is clicked.
        WebElement rightArrowCM = chromeDriver.findElement(By.xpath("//*[@id='mainSlider']/div/ul/li[2]/a/img"));
        jsExecutorCM.executeScript("arguments[0].click();", rightArrowCM);

        // The "left arrow" is clicked.
        WebElement leftArrowCM = chromeDriver.findElement(By.xpath("//*[@id=\"mainSlider\"]/div/ul/li[1]/a/img"));
        jsExecutorCM.executeScript("arguments[0].click();", leftArrowCM);

        // ----- Test for Microsoft Edge -----

        // js executor is set.
        JavascriptExecutor jsExecutorME = (JavascriptExecutor) edDriver;

        // The "right arrow" is clicked.
        WebElement rightArrowME = edDriver.findElement(By.xpath("//*[@id='mainSlider']/div/ul/li[2]/a/img"));
        jsExecutorME.executeScript("arguments[0].click();", rightArrowME);

        // The "left arrow" is clicked.
        WebElement leftArrowME = edDriver.findElement(By.xpath("//*[@id=\"mainSlider\"]/div/ul/li[1]/a/img"));
        jsExecutorME.executeScript("arguments[0].click();", leftArrowME);

    }

    @Test(priority = 15, enabled = false)
    public void imageWithTheBestPricesHM015() throws InterruptedException {}

    @Test(priority = 16, enabled = true)
    public void sectionComputersRecommendedsHM016() throws InterruptedException {

        // ----- Test for Chrome -----

        // The "PC BASIC" section is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // It is verified that the "PC BASIC" section is visible.
        WebElement basicPcSectionCM = chromeDriver.findElement(By.xpath("//*[@id=\"catysub\"]/li/a/span"));
        if (basicPcSectionCM.isDisplayed()) {
            System.out.println("The 'PC BASIC' section is visible in Chrome.");
        } else {
            Assert.fail("The 'PC BASIC' section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // The "PC MEDIA" section is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[2]/div/div/div/a/picture/img")).click();

        // It is verified that the "PC MEDIA" section is visible.
        WebElement mediumPcSectionCM = chromeDriver.findElement(By.xpath("//*[@id=\"catysub\"]/li/a/span"));
        if (mediumPcSectionCM.isDisplayed()) {
            System.out.println("The 'PC MEDIA' section is visible in Chrome.");
        } else {
            Assert.fail("The 'PC MEDIA' section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // The "PC ALTA" section is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[3]/div/div/div/a/picture/img")).click();

        // It is verified that the "PC ALTA" section is visible.
        WebElement highPcSectionCM = chromeDriver.findElement(By.xpath("//*[@id=\"catysub\"]/li/a/span"));
        if (highPcSectionCM.isDisplayed()) {
            System.out.println("The 'PC ALTA' section is visible in Chrome.");
        } else {
            Assert.fail("The 'PC ALTA' section is not visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The "PC BASIC" section is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[1]/div/div/div/a/picture/img")).click();

        // It is verified that the "PC BASIC" section is visible.
        WebElement basicPcSectionME = edDriver.findElement(By.xpath("//*[@id=\"catysub\"]/li/a/span"));
        if (basicPcSectionME.isDisplayed()) {
            System.out.println("The 'PC BASIC' section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'PC BASIC' section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // The "PC MEDIA" section is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[2]/div/div/div/a/picture/img")).click();

        // It is verified that the "PC MEDIA" section is visible.
        WebElement mediumPcSectionME = edDriver.findElement(By.xpath("//*[@id=\"catysub\"]/li/a/span"));
        if (mediumPcSectionME.isDisplayed()) {
            System.out.println("The 'PC MEDIA' section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'PC MEDIA' section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // The "PC ALTA" section is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div[2]/div/div/div[3]/div/div/div/a/picture/img")).click();

        // It is verified that the "PC ALTA" section is visible.
        WebElement highPcSectionME = edDriver.findElement(By.xpath("//*[@id=\"catysub\"]/li/a/span"));
        if (highPcSectionME.isDisplayed()) {
            System.out.println("The 'PC ALTA' section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The 'PC ALTA' section is not visible in Microsoft Edge.");
        }

    }

    @Test(priority = 17, enabled = false)
    public void sectionFeaturedProductsHM017() throws InterruptedException {

        // This test is not possibility because the section featured products no longer available

    }

    @Test(priority = 18, enabled = true)
    public void sectionBrandsHM018() throws InterruptedException {

        // ----- Test for Chrome -----

        // The Intel brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[1]/a")).click();

        // It is verified that Intel section is visible.
        WebElement sectionIntelCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionIntelCM.isDisplayed()) {
            System.out.println("The Intel Section is visible in Chrome.");
        } else {
            Assert.fail("The Intel Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Genesis brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[2]/a")).click();

        // It is verified that Genesis section is visible.
        WebElement sectionGenesisCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionGenesisCM.isDisplayed()) {
            System.out.println("The Genesis Section is visible in Chrome.");
        } else {
            Assert.fail("The Genesis Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The AMD brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[3]/a")).click();

        // It is verified that AMD section is visible.
        WebElement sectionAMDCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionAMDCM.isDisplayed()) {
            System.out.println("The AMD Section is visible in Chrome.");
        } else {
            Assert.fail("The AMD Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The ASUS brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[4]/a")).click();

        // It is verified that ASUS section is visible.
        WebElement sectionASUSCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionASUSCM.isDisplayed()) {
            System.out.println("The ASUS Section is visible in Chrome.");
        } else {
            Assert.fail("The ASUS Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The NVIDIA brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[5]/a")).click();

        // It is verified that NVIDIA section is visible.
        WebElement sectionNVIDIACM = chromeDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (sectionNVIDIACM.isDisplayed()) {
            System.out.println("The NVIDIA Section is visible in Chrome.");
        } else {
            Assert.fail("The NVIDIA Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Logitech brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"logitech-logo-1\"]")).click();

        // It is verified that Logitech section is visible.
        WebElement sectionLogitechCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[3]/ul/li[1]/div"));
        if (sectionLogitechCM.isDisplayed()) {
            System.out.println("The Logitech Section is visible in Chrome.");
        } else {
            Assert.fail("The Logitech Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Gygabyte brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"Gigabyte_Technology-Logo.wine\"]")).click();

        // It is verified that Gygabyte section is visible.
        WebElement sectionGygabyteCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionGygabyteCM.isDisplayed()) {
            System.out.println("The Gygabyte Section is visible in Chrome.");
        } else {
            Assert.fail("The Gygabyte Section is not visible in Chrome.");
        }

        // The "home" logo is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Redragon brand icon is clicked.
        chromeDriver.findElement(By.xpath("//*[@id=\"redragon\"]")).click();

        // It is verified that Redragon section is visible.
        WebElement sectionRedragonCM = chromeDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionRedragonCM.isDisplayed()) {
            System.out.println("The Redragon Section is visible in Chrome.");
        } else {
            Assert.fail("The Redragon Section is not visible in Chrome.");
        }

        // ----- Test for Microsoft Edge -----

        // The Intel brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[1]/a")).click();

        // It is verified that Intel section is visible.
        WebElement sectionIntelME = edDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (sectionIntelME.isDisplayed()) {
            System.out.println("The Intel Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The Intel Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Genesis brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[2]/a")).click();

        // It is verified that Genesis section is visible.
        WebElement sectionGenesisME = edDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionGenesisME.isDisplayed()) {
            System.out.println("The Genesis Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The Genesis Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The AMD brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[3]/a")).click();

        // It is verified that AMD section is visible.
        WebElement sectionAMDME = edDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionAMDME.isDisplayed()) {
            System.out.println("The AMD Section is visible in Microsoft Edgee.");
        } else {
            Assert.fail("The AMD Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The ASUS brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[4]/a")).click();

        // It is verified that ASUS section is visible.
        WebElement sectionASUSME = edDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionASUSME.isDisplayed()) {
            System.out.println("The ASUS Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The ASUS Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The NVIDIA brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"content-desktop\"]/div/ul/li[5]/a")).click();

        // It is verified that NVIDIA section is visible.
        WebElement sectionNVIDIAME = edDriver.findElement(By.xpath("//*[@id=\"resbusqueda\"]/strong"));
        if (sectionNVIDIAME.isDisplayed()) {
            System.out.println("The NVIDIA Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The NVIDIA Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Logitech brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"logitech-logo-1\"]")).click();

        // It is verified that Logitech section is visible.
        WebElement sectionLogitechME = edDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[3]/ul/li[1]/div"));
        if (sectionLogitechME.isDisplayed()) {
            System.out.println("The Logitech Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The Logitech Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Gygabyte brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"Gigabyte_Technology-Logo.wine\"]")).click();

        // It is verified that Gygabyte section is visible.
        WebElement sectionGygabyteME = edDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionGygabyteME.isDisplayed()) {
            System.out.println("The Gygabyte Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The Gygabyte Section is not visible in Microsoft Edge.");
        }

        // The "home" logo is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"busqueda\"]/div[6]/div[1]/div[1]/a/img")).click();

        // Wait of 3 seconds.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Redragon brand icon is clicked.
        edDriver.findElement(By.xpath("//*[@id=\"redragon\"]")).click();

        // It is verified that Redragon section is visible.
        WebElement sectionRedragonME = edDriver.findElement(By.xpath("//*[@id=\"filtros_left\"]/div[4]/ul/li[1]/div"));
        if (sectionRedragonME.isDisplayed()) {
            System.out.println("The Redragon Section is visible in Microsoft Edge.");
        } else {
            Assert.fail("The Redragon Section is not visible in Microsoft Edge.");
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
