import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


public class WebTest {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            WebElement coockieBtn = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            if (coockieBtn.isDisplayed()) {
                coockieBtn.click();
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
        WebElement payWindow = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", payWindow.getText());
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    public void paymentTest() {
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img"));
        assertFalse(logos.isEmpty());
    }

    @Test
    @DisplayName("Проверка работы ссылки")
    public void hrefTest() {
        WebElement href = driver.findElement(By.linkText("Подробнее о сервисе"));
        String current = driver.getCurrentUrl();
        href.click();
        assertNotEquals(current, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка кнопки Продолжить")
    public void buttonTest() {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.sendKeys("100");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        assertDoesNotThrow(() -> {
            driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        });
    }
}