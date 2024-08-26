package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserSettings {
    WebDriver driver;

    /** Выбор браузера для тестов*/
    @Before
    public void setUp() {
/*        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
