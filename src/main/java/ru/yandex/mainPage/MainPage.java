package ru.yandex.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.yandex.BasePage;
import ru.yandex.FAQElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {



    //Кнопка "Заказать" в хедере
    public static final By ORDER_BUTTON_IN_HEADER = By.xpath(".//div/button[@class = 'Button_Button__ra12g']");
    //Вопрос в аккордионе   (Заголовок)
    public static final String TITLE = ".//div[@class = 'accordion__button']";
    //Ответ в аккордионе    (Описание)
    public static final String DESCRIPTION = ".//p";
    //Кнопка принять куки
    public static final By COOKIE_ACCEPT = By.xpath(".//button[@class = 'App_CookieButton__3cvqF']");
    //Кнопка "Заказать" в центре страницы
    public static final By ORDER_BUTTON = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");


    //Открыть главную страницу сайта по аренде самокатов
    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    public void clickOrderButtonInHeader() {
        driver.findElement(ORDER_BUTTON_IN_HEADER).click();
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void closeCookieMessage(){
        driver.findElement(COOKIE_ACCEPT).click();
    }

    //Получить коллекцию аккордиона "Вопросы о важном!"
    public List<FAQElement> getFAQList() {
        List<WebElement> accordionItems = driver.findElements(By.xpath("//div[@data-accordion-component = 'AccordionItem']"));
        List<FAQElement> FAQElements = new ArrayList<>() {
        };
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        for (int i = 0; i < accordionItems.size(); i++) {
            accordionItems.get(i).click();
            FAQElements.add(new FAQElement(
                    accordionItems.get(i).findElement(By.xpath(TITLE)).getText(),
                    accordionItems.get(i).findElement(By.xpath(DESCRIPTION)).getText()));
        }
        return FAQElements;
    }


}
