package ru.praktikum_services.qa_scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.pageobject.fragment.HeaderPage;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class CreateOrderDetailsPage extends BasePage {
    private By inputData = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By selectDay = By.xpath(".//div[@class='Dropdown-control']");
    private By chooseCheckBox = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and @for='black']");
    private By putComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By makeOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private By btnYes = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    private final By modalWindow = By.xpath(".//*[text()='Заказ оформлен']");

    public CreateOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isModalWindowDisplayed() {
        return driver.findElement(modalWindow).isDisplayed();
    }

    public CreateOrderDetailsPage chooseData() {
        driver.findElement(inputData).click();
        driver.findElement(inputData).sendKeys("12.12.2012");
        final By chosenDate = By.xpath(".//div[@aria-label='Choose среда, 12-е декабря 2012 г.']");
        driver.findElement(chosenDate).click();
        return this;
    }

    public CreateOrderDetailsPage chooseSelectDay() {
        driver.findElement(selectDay).click();
        final String clickTest = ".//div[@class='Dropdown-menu']//div[text()='%s']";
        String locator = String.format(clickTest, "двое суток");
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

    public HeaderPage setBtnYes() {
        driver.findElement(btnYes).click();
        return new HeaderPage(driver);
    }
}
