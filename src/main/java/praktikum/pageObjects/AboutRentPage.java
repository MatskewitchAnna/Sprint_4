package praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AboutRentPage {
    WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле "Когда привезти самокат"
    private final By rentalDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Выпадающий список "Срок аренды"
    private final By rentalTime = By.className("Dropdown-arrow");
    // Локатор для срока аренды "двое суток"
    private final By rentalTimeTwo = By.xpath(".//*[(@role ='option' and text()='двое суток')]");


    // Чекбокс "Цвет самоката"
    private final By blackColour = By.id("black");

    // Поле "Комментарий для курьера"
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать" внизу страницы
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");


    /** Методы для работы с элементами страницы */
    // Ожидание загрузки страницы
    public AboutRentPage waitForLoadAboutRentPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(rentalDate));
        return this;
    }

    // Выбор даты доставки
    public AboutRentPage inputRentalDate(String newDate) {
        driver.findElement(rentalDate).sendKeys(newDate);
        return this;
    }

    // Выбор срока аренды
    public AboutRentPage setRentalTime() {
        driver.findElement(rentalTime).click();
        driver.findElement(rentalTimeTwo).click();
        return this;
    }

    // Выбор цвета самоката
    public AboutRentPage clickBlackColour() {
        driver.findElement(blackColour).click();
        return this;
    }

    // Ввод комментария
    public AboutRentPage inputComment(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
        return this;
    }

    // Нажатие на кнопку "Заказать"
    public AboutRentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
}
