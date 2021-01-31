package CloudCalculationsTest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudCalculator {

    public WebDriver driver;

    public CloudCalculator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

        @FindBy(xpath = "//md-tab-item//div[@class='presets-buttons layout-sm-column layout-align-center-center layout-column']/div[text()='Compute Engine']")
        WebElement computerEngineLabel;

        @FindBy(xpath = "//input[@id='input_63']")
        WebElement numberOfInstancesField;

        @FindBy (xpath = "//*[@id='select_value_label_56']")
        WebElement operatingSystemLabel;

        @FindBy (xpath = "//*[@id='select_option_65']")
        WebElement operatingSystemOption;

        @FindBy (xpath = "//*[@id='select_value_label_57']")
        WebElement machineClassLabel;

        @FindBy (xpath = "//*[@id='select_option_78']")
        WebElement machineClassOption;

        @FindBy (xpath = "//*[@id='select_value_label_59']")
        WebElement seriesLabel;

        @FindBy (xpath = "//*[@id='select_option_188']")
        WebElement seriesLabelOption;

        @FindBy (xpath = "//*[@id='select_value_label_60']")
        WebElement machineTypeLabel;

        @FindBy (xpath = "//*[@id='select_option_360']")
        WebElement machineTypeOption;

        @FindBy (xpath = "//div[@ng-if='listingCtrl.showComputeEngine']//*[contains(text(), 'Add GPUs.')]")
        WebElement addGpuCheckbox;

        @FindBy (xpath = "//*[@id='select_value_label_392']")
        WebElement numberOfGpuLabel;

        @FindBy (xpath = "//*[@id='select_option_399']")
        WebElement numberOfGpuOption;

        @FindBy (xpath = "//*[@id='select_value_label_393']")
        WebElement gpuTypeLabel;

        @FindBy (xpath = "//*[@id='select_option_406']")
        WebElement gpuTypeOption;

        @FindBy (xpath = "//*[@id='select_value_label_354']")
        WebElement localSSDLabel;

        @FindBy (xpath = "//*[@id='select_option_381']")
        WebElement localSSDOption;

        @FindBy (xpath = "//*[@id='select_value_label_61']")
        WebElement datacenterLabel;

        @FindBy (xpath = "//*[@id='select_option_205']")
        WebElement datacenterOption;

        @FindBy (xpath = "//*[@id='select_value_label_62']")
        WebElement commitUsageLabel;

        @FindBy (xpath = "//*[@id='select_option_97']")
        WebElement commitUsageOption;

        @FindBy (xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add to Estimate']")
        WebElement estimateButton;

        @FindBy (xpath = "//button[@id='email_quote']")
        WebElement emailEstimateButton;

        @FindBy (xpath = "//input[@id='input_477']")
        WebElement sendEmailField;

        @FindBy (xpath = "//button[contains (.,'Send Email')]")
        WebElement sendEmailButton;

        public void computerEngineSelect () {computerEngineLabel.click();}
        public void numberOfInstancesClick() {numberOfInstancesField.click();}
        public void numberOfInstancesInput (String value) {numberOfInstancesField.sendKeys(value);}
        public void operatingSystemLabelClick () {operatingSystemLabel.click();}
        public void operatingSystemOptionSelect () {operatingSystemOption.click();}
        public void machineClassClick () {machineClassLabel.click();}
        public void machineClassOptionSelect () {machineClassOption.click();}
        public void seriesClick () {seriesLabel.click();}
        public void seriesOptionSelect () {seriesLabelOption.click();}
        public void machineTypeLabelClick () {machineTypeLabel.click();}
        public void machineTypeOptionSelect () {machineTypeOption.click();}
        public void addGpuCheckboxClick () {addGpuCheckbox.click();}
        public void numberOfGpuClick() {numberOfGpuLabel.click();}
        public void numberOfGpuSelect () {numberOfGpuOption.click();}
        public void gpuTypeClick() {gpuTypeLabel.click();}
        public void gpuTypeSelect () {gpuTypeOption.click();}
        public void localSSDClick() {localSSDLabel.click();}
        public void localSSDSelect () {localSSDOption.click();}
        public void datacenterClick() {datacenterLabel.click();}
        public void datacenterSelect () {datacenterOption.click();}
        public void commitUsageClick() {commitUsageLabel.click();}
        public void commitUsageSelect () {commitUsageOption.click();}
        public void estimateButtonClick () {estimateButton.click();}
        public void emailEstimateButtonClick () {emailEstimateButton.click();}
        public void sendEmailFieldInput (String email) {sendEmailField.sendKeys(email);}
        public void sendEmailButtonClick () {sendEmailButton.click();}





}
