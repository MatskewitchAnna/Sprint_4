package praktikum.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormPage {

    private final WebDriver driver;

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле "Имя"
    private final By firstName = By.xpath(".//input[@placeholder='* Имя']");

    // Поле "Фамилия"
    private final By lastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес"
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле "Станция метро"
    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final String nameMetroStation = ".//button[@value='%s']";

    // Поле "Телефон"
    private final By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");


    /** Методы для работы с элементами страницы */
    // Ожидание загрузки страницы
    public OrderFormPage waitForLoadOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(firstName));
        return this;
    }

    // Ввод имени
    public OrderFormPage inputFirstName(String newFirstName) {
        driver.findElement(firstName).sendKeys(newFirstName);
        return this;
    }

    // Ввод фамилии
    public OrderFormPage inputLastName(String newLastName) {
        driver.findElement(lastName).sendKeys(newLastName);
        return this;
    }

    // Ввод адреса
    public OrderFormPage inputAddress(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
        return this;
    }

    // Выбор станции метро
    public OrderFormPage changeStateMetro(int stateNumber) {
        driver.findElement(metroStation).click();
        By newStateMetro = By.xpath(String.format(nameMetroStation, stateNumber));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(newStateMetro));
        driver.findElement(newStateMetro).click();
        return this;
    }

    // Ввод телефона
    public OrderFormPage inputPhoneNumber(String newPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(newPhoneNumber);
        return this;
    }

    // Нажатие на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
