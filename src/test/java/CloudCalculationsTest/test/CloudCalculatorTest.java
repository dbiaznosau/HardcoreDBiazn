package CloudCalculationsTest.test;

import CloudCalculationsTest.page.CloudCalculator;
import CloudCalculationsTest.page.CloudLandingPage;
import CloudCalculationsTest.page.CloudSearchResults;
import CloudCalculationsTest.page.EmailPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CloudCalculatorTest {

    public static WebDriver driver;
   // public static WebDriver driver2;

    @BeforeClass
    public static void calculatorPageWindow() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("cloudPage"));
        String calculatorWindow = driver.getWindowHandle();
        }

    @BeforeClass
    public static void emailPageWindow() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("emailServicePage"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String emailWindow = driver.getWindowHandle();
        }

    @Test
    public void cloudCalculatorTest() throws InterruptedException {
        driver.switchTo().window("calculatorWindow");

        //landing page for Google Cloud
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        CloudLandingPage cloudLandingPage = new CloudLandingPage(driver);

        cloudLandingPage.searchButtonPress();
        cloudLandingPage.searchButtonInputText(ConfProperties.getProperty("searchRequest"));
        cloudLandingPage.searchGo();

        //search results page
        new WebDriverWait(driver, 15).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='gsc-thumbnail-inside']//b[text()[contains (., 'Google Cloud Platform Pricing Calculator')]]")));

        CloudSearchResults cloudSearchResults = new CloudSearchResults(driver);
        cloudSearchResults.searchResultClick();

        //calculator page
        //wait until main iFrame is loaded
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        //switch to the frame that contains necessary elements
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='myFrame']")));

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//md-tab-item[child::div[contains(.,'Compute Engine')]]")));

        //start to enter required data into the fields
        CloudCalculator cloudCalculator = new CloudCalculator(driver);

        cloudCalculator.computerEngineSelect();

        cloudCalculator.numberOfInstancesClick();
        cloudCalculator.numberOfInstancesInput(ConfProperties.getProperty("numberOfInstances"));

        cloudCalculator.operatingSystemLabelClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_65']")));
        cloudCalculator.operatingSystemOptionSelect();

        cloudCalculator.machineClassClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_78']")));
        cloudCalculator.machineClassOptionSelect();

        cloudCalculator.seriesClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_188']")));
        cloudCalculator.seriesOptionSelect();

        cloudCalculator.machineTypeLabelClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_360']")));
        cloudCalculator.machineTypeOptionSelect();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@ng-if='listingCtrl.showComputeEngine']//*[contains(text(), 'Add GPUs.')]")));
        cloudCalculator.addGpuCheckboxClick();

        cloudCalculator.numberOfGpuClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_399']")));
        cloudCalculator.numberOfGpuSelect();

        cloudCalculator.gpuTypeClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_406']")));
        cloudCalculator.gpuTypeSelect();

        cloudCalculator.localSSDClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_381']")));
        cloudCalculator.localSSDSelect();

        cloudCalculator.datacenterClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_205']")));
        cloudCalculator.datacenterSelect();

        cloudCalculator.commitUsageClick();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_97']")));
        cloudCalculator.commitUsageSelect();


        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='ComputeEngineForm']//*[@aria-label='Add to Estimate']")));
        cloudCalculator.estimateButtonClick();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='resultBlock']")));

        /*
        get and store calculated price
        */

        cloudCalculator.emailEstimateButtonClick();

        //check that email form is opened

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='emailForm']")));

        driver.switchTo().window("emailWindow");
        //create new emailPage element to call procedures
        EmailPage emailPage = new EmailPage(driver);
        //click Copy Email button
        emailPage.copyAddressButtonClick();

        driver.switchTo().window("calculatorWindow");
        //paste copied email address
        cloudCalculator.sendEmailFieldInput(Keys.CONTROL + "v"); //get temporary email
        //driver.findElement(By.xpath("//input[@id='input_477']")).sendKeys(Keys.CONTROL + "v");

        //send email to pasted address
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains (.,'Send Email')]")));
        cloudCalculator.sendEmailButtonClick();

        Thread.sleep(5000); //remove it after
    }



    /*@AfterClass
    public static void tearDown () {

        driver.quit();
    }*/
}
