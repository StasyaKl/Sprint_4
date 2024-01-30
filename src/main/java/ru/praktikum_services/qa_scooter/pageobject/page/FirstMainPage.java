package ru.praktikum_services.qa_scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.praktikum_services.qa_scooter.pageobject.fragment.HeaderPage;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class FirstMainPage extends BasePage {
    private By btnOrderUp = By.className("Button_Button__ra12g");
    private By btnOrderDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public FirstMainPage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage clickCreateOrderUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
        driver.findElement(btnOrderUp).click();
        return new HeaderPage(driver);
    }

    public CreateOrderPersonalInfoPage clickCreateOrderDown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
        driver.findElement(btnOrderDown).click();
        return new CreateOrderPersonalInfoPage(driver);
    }
}
