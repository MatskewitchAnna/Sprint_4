package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pageObjects.AboutRentPage;
import praktikum.pageObjects.MainPage;
import praktikum.pageObjects.OrderFormPage;
import praktikum.pageObjects.PopUpWindow;

import static org.junit.Assert.assertTrue;
import static praktikum.pageObjects.constant.OrderButton.HEADER_BUTTON;
import static praktikum.pageObjects.constant.OrderButton.MIDDLE_BUTTON;

@RunWith(Parameterized.class)
public class OrderFormTest extends BrowserSettings {
    private final Enum button;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final int stateMetroNumber;
    private final String phoneNumber;
    private final String date;
    private final String comment;


    public OrderFormTest(Enum button, String firstName, String lastName, String address, int stateMetroNumber, String phoneNumber,
                         String date, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.stateMetroNumber = stateMetroNumber;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {HEADER_BUTTON, "Имя", "Фамилия", "Адрес 1", 123, "76665554433", "28.05.2024", "комментарий"},
                {HEADER_BUTTON, "Иван", "Иванов", "Адресок 2", 12, "76665554433", "28.06.2024", "славного денёчка"},
                {MIDDLE_BUTTON, "Полина", "Петрова", "Жилище 3", 1, "76665554433", "28.07.2024", "хорошего настроения"},
                {MIDDLE_BUTTON, "Зинаида", "Лютая", "Землянка 4", 50, "76665554433", "28.10.2024", "ляля"},
        };
    }

    @Test
    public void testCreateOrderWithUpButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieAcceptanceButton()
                .clickOrderButton(button);

        new OrderFormPage(driver)
                .waitForLoadOrderPage()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputAddress(address)
                .changeStateMetro(stateMetroNumber)
                .inputPhoneNumber(phoneNumber)
                .clickNextButton();

        new AboutRentPage(driver)
                .waitForLoadAboutRentPage()
                .inputRentalDate(date)
                .setRentalTime()
                .clickBlackColour()
                .inputComment(comment)
                .clickOrderButton();

        boolean isDisplayed = new PopUpWindow(driver)
                .waitForLoadPopUpWindow()
                .clickButtonYes()
                .isHeaderCreatedOrderDisplayed(); //в Chrome на этом этапе баг
        assertTrue("Окно 'Заказ оформлен' отсутствует", isDisplayed);
    }
}



