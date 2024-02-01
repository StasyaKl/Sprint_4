package ru.praktikum_services.qa_scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class FirstMainPage extends BasePage {
    public FirstMainPage(WebDriver driver) {
        super(driver);
    }

    public CreateOrderPersonalInfoPage clickCreateOrder(By btn) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
        driver.findElement(btn).click();
        return new CreateOrderPersonalInfoPage(driver);
    }
}
