import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class WebTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            WebElement coockie = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            if (coockie.isDisplayed()) {
                coockie.click();
            }
        } catch (NoSuchElementException ignored) {
        }
        driver.navigate().refresh();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия блока")
    public void blockNameTest() {
        Data data = new Data(driver);
        assertEquals("Онлайн пополнение\nбез комиссии", data.getPaymentBlockTitle());
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    public void paymentTest() {
        Data data = new Data(driver);
        assertFalse(data.getLogos().isEmpty());

    }

    @Test
    @DisplayName("Проверка работы ссылки")
    public void hrefTest() {
        Data data = new Data(driver);
        String current = driver.getCurrentUrl();
        assertNotEquals(current, data.movingToLink());
    }

    @Test
    @DisplayName("Проверка кнопки Продолжить")
    public void buttonTest() {
        Data data = new Data(driver);
        data.openFrame("297777777", "100");
        assertDoesNotThrow(data::findFrame);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке Оплата услуг")
    public void paymentForServicesTest() {
        Data data = new Data(driver);
        assertEquals("Номер телефона", data.getPhoneNumberPH());
        assertEquals("Сумма", data.getSumPH());
        assertEquals("E-mail для отправки чека", data.getEmailPH());
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке Домашний интернет")
    public void homeInternetTest() {
        Data data = new Data(driver);
        data.openHomeInternet();
        assertEquals("Номер абонента", data.getInternetPhonePH());
        assertEquals("Сумма", data.getInternetSumPH());
        assertEquals("E-mail для отправки чека", data.getInternetEmailPH());
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке Рассрочка")
    public void installmentTest() {
        Data data = new Data(driver);
        data.openInstallment();
        assertEquals("Номер счета на 44", data.getInstalmentNumber44PH());
        assertEquals("Сумма", data.getInstalmentSumPH());
        assertEquals("E-mail для отправки чека", data.getInstalmentEmailPH());
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке Задолженность")
    public void arrearsTest() {
        Data data = new Data(driver);
        data.openArrears();
        assertEquals("Номер счета на 2073", data.getArrearsScore2073PH());
        assertEquals("Сумма", data.getArrearsSumPH());
        assertEquals("E-mail для отправки чека", data.getArrearsEmailPH());
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на фрейме оплаты")
    public void frameTest() {
        Data data = new Data(driver);
        data.openFrame("297777777", "100");
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
        assertEquals("100.00 BYN", data.getCostHader());
        assertEquals("Оплата: Услуги связи\nНомер:375297777777", data.getPhonetHader());
        assertEquals("Номер карты", data.getCardNumber());
        assertEquals("Срок действия", data.getTermOfAction());
        assertEquals("CVC", data.getCvc());
        assertEquals("Имя держателя (как на карте)", data.getNameSub());
        assertEquals(" Оплатить  100.00 BYN ", data.getPaySumButtonText());
        assertFalse(data.getLogosInFrame().isEmpty());
    }
}