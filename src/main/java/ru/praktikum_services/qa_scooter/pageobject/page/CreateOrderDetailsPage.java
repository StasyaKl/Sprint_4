package ru.praktikum_services.qa_scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class CreateOrderDetailsPage extends BasePage {
    private final By inputData = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By selectDay = By.xpath(".//div[@class='Dropdown-control']");
    private final By chooseCheckBox = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and @for='black']");
    private final By putComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By makeOrder = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    private final By btnYes = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    private final By modalWindow = By.xpath(".//*[text()='Заказ оформлен']");

    public CreateOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isModalWindowDisplayed() {
        return driver.findElement(modalWindow).isDisplayed();
    }

    public CreateOrderDetailsPage chooseData(String data, By pathToData) {
        driver.findElement(inputData).click();
        driver.findElement(inputData).sendKeys(data);
        driver.findElement(pathToData).click();
        return this;
    }

    public CreateOrderDetailsPage chooseSelectDay(String choosePeriod) {
        driver.findElement(selectDay).click();
        final String clickTest = ".//div[@class='Dropdown-menu']//div[text()='%s']";
        String locator = String.format(clickTest, choosePeriod);
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

    public CreateOrderDetailsPage clickChooseCheckBox() {
        driver.findElement(chooseCheckBox).click();
        return this;
    }

    public CreateOrderDetailsPage btnMakeOrder() {
        driver.findElement(makeOrder).click();
        return this;
    }

    public CreateOrderDetailsPage stayComment(String comment) {
        driver.findElement(putComment).sendKeys(comment);
        return this;
    }

    public void setBtnYes() {
        driver.findElement(btnYes).click();
    }
}
