package finalProjectTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.BasePage;
import ru.yandex.FAQElement;
import ru.yandex.mainPage.MainPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainPageTest {

    private WebDriver driver;
    //Коллекция с ожидаемыми значениями
    private static List<FAQElement> expectedValues;

    @Before
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        BasePage.driver = driver;
        expectedValues = new ArrayList<>();
        expectedValues.add(new FAQElement("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
        expectedValues.add(new FAQElement("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
        expectedValues.add(new FAQElement("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
        expectedValues.add(new FAQElement("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
        expectedValues.add(new FAQElement("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
        expectedValues.add(new FAQElement("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
        expectedValues.add(new FAQElement("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
        expectedValues.add(new FAQElement("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."));

    }


    @Test
    public void accordionTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.closeCookieMessage();
        //Коллекция с фактическими значениями
        List<FAQElement> actualValues = mainPage.getFAQList();
        for (int i = 0; i < expectedValues.size(); i++) {
            assertEquals(expectedValues.get(i).getTitle(), actualValues.get(i).getTitle());
            assertEquals(expectedValues.get(i).getDescription(), actualValues.get(i).getDescription());
        }
    }

    @After
    public void after() {
        driver.quit();
    }
}
