package finalProjectTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.BasePage;
import ru.yandex.mainPage.MainPage;
import ru.yandex.orderPage.OrderPage;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderPageTest {

    private WebDriver driver;


    private final String foreName;
    private final String sureName;
    private final String address;
    private final String phoneNumber;
    private final String rentDate;
    private final String comment;
    private final String expectedText;

    public OrderPageTest(String foreName, String sureName, String address, String phoneNumber, String rentDate, String comment, String expectedText) {
        this.foreName = foreName;
        this.sureName = sureName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rentDate = rentDate;
        this.comment = comment;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderDetails() {
        return new Object[][]{
                {"Николай", "Крутов", "Рязань,390048", "88888888888", "23.10.2024", "Комментарий 1", "Хотите оформить заказ?"},
                {"Максим", "Иванов", "Москва,400055", "87777777777", "25.10.2024", "Комментарий 2", "Заказ оформлен"},
        };
    }


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        BasePage.driver = driver;
    }


    @Test
    public void checkingOrderPath1() {
        MainPage mainPage = new MainPage();
        OrderPage orderPage = new OrderPage();
        mainPage.openMainPage();
        mainPage.clickOrderButtonInHeader();
        orderPage.fillOrderFields(foreName, sureName, address, phoneNumber);
        orderPage.chooseMetroStation();
        orderPage.clickTheNextButton();
        orderPage.fillRentFields(rentDate, comment);
        orderPage.clickOrderConfirmationButton();
        String modalText = orderPage.textInHeader();
        assertThat("Дефект в GoogleChrome",modalText, containsString(expectedText));
    }

    @Test
    public void checkingOrderPath2() {
        MainPage mainPage = new MainPage();
        OrderPage orderPage = new OrderPage();
        mainPage.openMainPage();
        mainPage.closeCookieMessage();
        mainPage.clickOrderButton();
        orderPage.fillOrderFields(foreName, sureName, address, phoneNumber);
        orderPage.chooseMetroStation();
        orderPage.clickTheNextButton();
        orderPage.fillRentFields(rentDate, comment);
        orderPage.clickOrderConfirmationButton();
        String modalText = orderPage.textInHeader();
        assertThat("Дефект в GoogleChrome",modalText, containsString(expectedText));
    }

    @After
    public void after() {
        driver.quit();
    }
}
