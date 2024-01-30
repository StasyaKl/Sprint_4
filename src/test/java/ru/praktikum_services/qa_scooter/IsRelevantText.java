package ru.praktikum_services.qa_scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.praktikum_services.qa_scooter.pageobject.fragment.AccordionPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IsRelevantText extends BaseTest {
    private final int numberOfAccordion;
    private final String accordionHeaderName;
    private final String accordionTextName;

    public IsRelevantText(int numberOfAccordion, String accordionHeaderName, String accordionTextName) {
        this.numberOfAccordion = numberOfAccordion;
        this.accordionHeaderName = accordionHeaderName;
        this.accordionTextName = accordionTextName;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void accordionTest() {
        WebElement blockWithAccordion = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", blockWithAccordion);

        AccordionPage objAccordionPage = new AccordionPage(driver).clickBtnAccordion(numberOfAccordion);
        String assertHeader = objAccordionPage.getTextFromBtnIndex(numberOfAccordion);
        assertEquals(assertHeader, accordionHeaderName);
        String assertText = objAccordionPage.getTextFromAnswerIndex(numberOfAccordion);
        assertEquals(assertText, accordionTextName);
        driver.quit();
    }
}

