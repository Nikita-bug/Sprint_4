package ru.yandex;

public class FAQElement {

    //Вопрос в аккордионе   (Заголовок)
    public String title;
    //Ответ в аккордионе    (Описание)
    public String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FAQElement(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
