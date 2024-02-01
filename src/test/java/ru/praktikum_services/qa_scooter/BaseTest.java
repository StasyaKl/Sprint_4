package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum_services.qa_scooter.pageobject.setup.MainPage;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        driver.get(MainPage.URL);

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
    }

    private void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    private WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/geckodriver");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
