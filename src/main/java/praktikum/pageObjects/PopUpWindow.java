package praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpWindow {
    WebDriver driver;

    public PopUpWindow(WebDriver driver) {
        this.driver = driver;
    }


    // Кнопка "Да"
    private final By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Заголовок "Заказ оформлен"
    private final By popUpHeaderCreatedOrder = By.xpath(".//div[text()='Заказ оформлен']");

    /**
     * Методы
     */
    // Ожидание загрузки окна подтверждения заказа
    public PopUpWindow waitForLoadPopUpWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        return this;
    }

    // Нажатие на кнопку "Да"
    public PopUpWindow clickButtonYes() {
        driver.findElement(buttonYes).click();
        return this;
    }

    // Проверка отображения заголовока "Заказ оформлен"
    public boolean isHeaderCreatedOrderDisplayed() {
        return driver.findElement(popUpHeaderCreatedOrder).isDisplayed();
    }
}

