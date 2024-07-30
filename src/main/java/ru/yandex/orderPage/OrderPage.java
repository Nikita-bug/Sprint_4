package ru.yandex.orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.BasePage;

import java.util.List;

public class OrderPage extends BasePage {


    //Кнопка "Далее"
    public static final By THE_NEXT_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле выбора станции метро
    public static final By METRO_SEARCH_FIELD = By.xpath(".//div[@class = 'select-search']");
    //Станция метро
    public static final By METRO_STATION = By.xpath(".//div[@class = 'select-search__select']/ul/li[4]");
    //Список полей заказа
    public static final By All_ORDER_FIELDS = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input");
    //Поле даты аренды
    private static final By DATE_PICKER = By.xpath(".//div[@class = 'react-datepicker__input-container']/input");
    //Выпадающий список срока аренды
    private static final By RENT_PERIOD = By.xpath(".//div[@class = 'Dropdown-arrow-wrapper']/span");
    //Опция срока аренды
    private static final By RENT_DROPDOWN = By.xpath(".//div[@class = 'Dropdown-option'][2]");
    //Чекбокс выбора цвета самоката
    private static final By COLOR = By.xpath(".//input[@id = 'black']");
    //Поле комментария
    private static final By COMMENT_FIELD = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //Кнопка "Заказать"
    private static final By ORDER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка подтверждения заказа
    public static final By CONFIRM_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']");
    //Текст в заголовоке модального окна
    private static final By MODAL_HEADER_TEXT = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");


    public void fillOrderFields(String name, String forename, String adress, String phone) {
        List<WebElement> orderFields = driver.findElements(All_ORDER_FIELDS);
        orderFields.get(0).sendKeys(name);
        orderFields.get(1).sendKeys(forename);
        orderFields.get(2).sendKeys(adress);
        orderFields.get(3).sendKeys(phone);
    }


    public void chooseMetroStation() {
        driver.findElement(METRO_SEARCH_FIELD).click();
        driver.findElement(METRO_STATION).click();
    }


    public void clickTheNextButton() {
        driver.findElement(THE_NEXT_BUTTON).click();
    }

    public void selectARentDate(String rentDate){
        driver.findElement(DATE_PICKER).sendKeys(rentDate);
    }

    public void selectTheRentalPeriod() {
        driver.findElement(RENT_PERIOD).click();
        driver.findElement(RENT_DROPDOWN).click();
    }

    public void selectAColor(){
        driver.findElement(COLOR).click();
    }

    public void commentForTheDeliverer(String comment){
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }

    public void clickOrderButton(){
        driver.findElement(ORDER_BUTTON).click();
    }

    public void fillRentFields(String rentDate, String comment) {
        selectARentDate(rentDate);
        selectTheRentalPeriod();
        selectAColor();
        commentForTheDeliverer(comment);
        clickOrderButton();
    }

    public void clickOrderConfirmationButton(){
        driver.findElement(CONFIRM_BUTTON).click();
    }

    public String textInHeader() {
        return driver.findElement(MODAL_HEADER_TEXT).getText();
    }







}


