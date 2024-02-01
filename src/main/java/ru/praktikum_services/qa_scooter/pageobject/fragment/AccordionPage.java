package ru.praktikum_services.qa_scooter.pageobject.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.pageobject.setup.BasePage;

public class AccordionPage extends BasePage {
    private final By btnAccordion = By.className("accordion__item");
    private final By textAnswerAccordion = By.className("accordion__panel");

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public AccordionPage clickBtnAccordion(int index) {
        driver.findElements(btnAccordion).get(index).click();
        return this;
    }

    public String getTextFromAnswerIndex(int index) {
        return driver.findElements(textAnswerAccordion).get(index).getText();
    }
}
