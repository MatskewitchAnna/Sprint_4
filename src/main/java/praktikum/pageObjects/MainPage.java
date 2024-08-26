package praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pageObjects.constant.OrderButton.HEADER_BUTTON;
import static praktikum.pageObjects.constant.OrderButton.MIDDLE_BUTTON;

public class MainPage {
    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    private static WebDriver driver;

    /**
     * Локаторы элементов главной страницы Яндекс.Самокат
     */
    //Кнопка "Заказать" в шапке
    private final By orderHeaderButton = By.className("Button_Button__ra12g");

    // Кнопка "Заказать" в середине страницы
    private final By orderMiddleButton = By.className("Button_Middle__1CSJM");

    // Кнопка "Да все привыкли" в сообщении о куки
    private final By cookieAcceptanceButton = By.className("App_CookieButton__3cvqF");

    // Вопросы блока "Вопросы о важном"
    private static final String[] questionsList = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};


    /**Методы для взаимодействия с элементами страницы*/
    //Открыть сайт
    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    // Нажать на кнопку "Заказать" в шапке
    public MainPage clickOrderHeaderButton() {
        driver.findElement(orderHeaderButton).click();
        return this;
    }

    // Нажать на кнопку "Заказать" в середине страницы
    public MainPage clickOrderMiddleButton() {
        driver.findElement(orderMiddleButton).click();
        return this;
    }

    // Прокрутка к кнопке "Заказать" в середине страницы
    public MainPage scrollToDownOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(orderMiddleButton));
        return this;
    }
    // Выбор одной из кнопок "Заказать"
    public void clickOrderButton(Enum button) {
        if (button.equals(HEADER_BUTTON)) {
            clickOrderHeaderButton();
        } else if (button.equals(MIDDLE_BUTTON)) {
            scrollToDownOrderButton();
            clickOrderMiddleButton();
        }
    }

    // Нажать на кнопку "Да все привыкли" в сообщении о куки
    public MainPage clickCookieAcceptanceButton() {
        driver.findElement(cookieAcceptanceButton).click();
        return this;
    }

    // Прокрутка до последнего вопроса в списке
    public MainPage scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(questionsList[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

    // Нажать на вопрос из блока "Вопросы о важном"
    public static void clickQuestionsList(int questionNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionsList[questionNumber])));
        driver.findElement(By.id(questionsList[questionNumber])).click();
    }
}

