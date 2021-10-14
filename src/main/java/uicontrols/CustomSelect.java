package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public class CustomSelect extends BaseControl {

    private static By base_locator = By.xpath("//span[@class='select2-search select2-search--dropdown']");
    private static String INPUT_XPATH = ".//input[@type='search']";
    private static String SEARCH_RESULT = "./ancestor::span[1]//span[@class='select2-results']";
    private static String ITEM_LOCATOR = ".//li[contains(text(), '%s')]";

    public CustomSelect(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
    }

    public CustomSelect(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
    }

    public void selectItem(String itemName) {
        try {
            searchItem(itemName, DEFAULT_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(itemName);
    }

    public void searchItem(String itemName, int timeOut) throws InterruptedException {
        click(timeOut);
        driver.getElement(new ByChained(base_locator, By.xpath(INPUT_XPATH))).sendKeys(itemName);
        Thread.sleep(1000);
    }

    public void clickElement(String itemName) {
        driver.getElement(new ByChained(base_locator, By.xpath(SEARCH_RESULT), By.xpath(String.format(ITEM_LOCATOR, itemName)))).click();
    }

}