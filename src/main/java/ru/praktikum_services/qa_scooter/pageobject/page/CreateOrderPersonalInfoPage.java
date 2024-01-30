package ru.praktikum_services.qa_scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class CreateOrderPersonalInfoPage extends BasePage {
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private By inputSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By select = By.xpath(".//input[@placeholder='* Станция метро']");
    private By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By btnContinue = By.xpath(".//button[text()='Далее']");


    public CreateOrderPersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public CreateOrderPersonalInfoPage chooseSelect(String field) {
        driver.findElement(select).click();
        final String clickTest = ".//div[@class='select-search__select']//div[text()='%s']";
        String locator = String.format(clickTest, field);
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

    public CreateOrderPersonalInfoPage fillInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    public CreateOrderPersonalInfoPage fillInputSecondName(String secondName) {
        driver.findElement(inputSecondName).sendKeys(secondName);
        return this;
    }

    public CreateOrderPersonalInfoPage fillInputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
        return this;
    }

    public CreateOrderPersonalInfoPage fillInputPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
        return this;
    }

    public CreateOrderDetailsPage nextPageOnButtonContinue() {
        driver.findElement(btnContinue).click();
        return new CreateOrderDetailsPage(driver);
    }
}
