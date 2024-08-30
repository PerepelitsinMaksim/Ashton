import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Data {

    private final WebDriver driver;

    private By payWindow = By.xpath("//div[@class = 'pay__wrapper']/h2");
    private By logos = By.xpath("//div[@class = 'pay__partners']/ul/li/img");
    private By link = By.linkText("Подробнее о сервисе");
    private By phoneNumberField = By.id("connection-phone");
    private By sumField = By.id("connection-sum");
    private By continueButton = By.xpath("//form[@class = 'pay-form opened']/button");
    private By frame = By.xpath("//iframe[@class='bepaid-iframe']");
    private By internetPhoneField = By.id("internet-phone");
    private By internetSumField = By.id("internet-sum");
    private By emailField = By.id("connection-email");
    private By internetEmailField = By.id("internet-email");
    private By selectHeader = By.xpath("//button[@class = 'select__header']");
    private By homeInternet = By.xpath("//li[@class = 'select__item'][1]");
    private By installment = By.xpath("//li[@class = 'select__item'][2]");
    private By arrears = By.xpath("//li[@class = 'select__item'][3]");
    private By instalmentScore44 = By.id("score-instalment");
    private By instalmentSum = By.id("instalment-sum");
    private By instalmentEmail = By.id("instalment-email");
    private By arrearsScore2073 = By.id("score-arrears");
    private By arrearsSum = By.id("arrears-sum");
    private By arrearsEmail = By.id("arrears-email");
    private By costHader = By.xpath("//div[@class = 'pay-description__cost']");
    private By phoneHader = By.xpath("//div[@class = 'pay-description__text']");
    private By cardNumber = By.xpath("//label[@class = 'ng-tns-c46-1 ng-star-inserted']");
    private By termOfAction = By.xpath("//label[@class = 'ng-tns-c46-4 ng-star-inserted']");
    private By cvc = By.xpath("//label[@class = 'ng-tns-c46-5 ng-star-inserted']");
    private By nameSub = By.xpath("//label[@class = 'ng-tns-c46-3 ng-star-inserted']");
    private By paySumButtonText = By.xpath("//button[@class = 'colored disabled']");
    private By logosInFrame = By.xpath("//div[@class = 'cards-brands ng-tns-c46-1']/div/img");


    public Data(WebDriver driver) {
        this.driver = driver;
    }

    public String getPaymentBlockTitle() {
        return driver.findElement(payWindow).getText();
    }

    public List<WebElement> getLogos() {
        return driver.findElements(logos);
    }

    public String movingToLink() {
        driver.findElement(link).click();
        return driver.getCurrentUrl();
    }

    public void findFrame() {
        driver.findElement(frame);
    }

    public Data openFrame(String phone, String summa) {
        driver.findElement(phoneNumberField).sendKeys(phone);
        driver.findElement(sumField).sendKeys(summa);
        driver.findElement(continueButton).click();
        return new Data(driver);
    }

    public String getPhoneNumberPH() {
        String phone1 = driver.findElement(phoneNumberField).getAttribute("placeholder");
        return phone1;
    }

    public String getSumPH() {
        String sum1 = driver.findElement(sumField).getAttribute("placeholder");
        return sum1;
    }

    public String getInternetSumPH() {
        String sum2 = driver.findElement(internetSumField).getAttribute("placeholder");
        return sum2;
    }

    public String getInstalmentSumPH() {
        String sum3 = driver.findElement(instalmentSum).getAttribute("placeholder");
        return sum3;
    }

    public String getArrearsSumPH() {
        String sum4 = driver.findElement(arrearsSum).getAttribute("placeholder");
        return sum4;
    }

    public String getEmailPH() {
        String email1 = driver.findElement(emailField).getAttribute("placeholder");
        return email1;
    }

    public String getInternetEmailPH() {
        String email2 = driver.findElement(internetEmailField).getAttribute("placeholder");
        return email2;
    }

    public String getInstalmentEmailPH() {
        String email3 = driver.findElement(instalmentEmail).getAttribute("placeholder");
        return email3;
    }

    public String getArrearsEmailPH() {
        String email4 = driver.findElement(arrearsEmail).getAttribute("placeholder");
        return email4;
    }

    public String getInternetPhonePH() {
        String phone2 = driver.findElement(internetPhoneField).getAttribute("placeholder");
        return phone2;
    }

    public String getInstalmentNumber44PH() {
        String score1 = driver.findElement(instalmentScore44).getAttribute("placeholder");
        return score1;
    }

    public String getArrearsScore2073PH() {
        String score2 = driver.findElement(arrearsScore2073).getAttribute("placeholder");
        return score2;
    }

    public Data openHomeInternet() {
        driver.findElement(selectHeader).click();
        driver.findElement(homeInternet).click();
        return new Data(driver);
    }

    public Data openInstallment() {
        driver.findElement(selectHeader).click();
        driver.findElement(installment).click();
        return new Data(driver);
    }

    public Data openArrears() {
        driver.findElement(selectHeader).click();
        driver.findElement(arrears).click();
        return new Data(driver);
    }

    public String getCostHader() {
        String cost = driver.findElement(costHader).getAttribute("textContent");
        return cost;
    }

    public String getPhonetHader() {
        String ph = driver.findElement(phoneHader).getAttribute("textContent");
        return ph;
    }

    public String getCardNumber() {
        String n = driver.findElement(cardNumber).getAttribute("textContent");
        return n;
    }

    public String getTermOfAction() {
        String ter = driver.findElement(termOfAction).getAttribute("textContent");
        return ter;
    }

    public String getCvc() {
        String c = driver.findElement(cvc).getAttribute("textContent");
        return c;
    }

    public String getNameSub() {
        String c = driver.findElement(nameSub).getAttribute("textContent");
        return c;
    }

    public String getPaySumButtonText() {
        String pey = driver.findElement(paySumButtonText).getAttribute("textContent");
        return pey;
    }

    public List<WebElement> getLogosInFrame() {
        return driver.findElements(logosInFrame);
    }
}