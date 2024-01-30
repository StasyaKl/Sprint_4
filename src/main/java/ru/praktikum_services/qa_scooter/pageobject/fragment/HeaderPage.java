package ru.praktikum_services.qa_scooter.pageobject.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.pageobject.page.FirstMainPage;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class HeaderPage extends BasePage {

    private By logoSamokat = By.xpath(".//img[@alt='Scooter']");
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public FirstMainPage logoSamokatClick() {
        driver.navigate().refresh();
        driver.findElement(logoSamokat).click();
        return new FirstMainPage(driver);
    }
}
