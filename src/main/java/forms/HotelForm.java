package forms;

import BaseElements.BaseAbstractForm;
import Core.TAEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelForm extends BaseAbstractForm {
    public HotelForm(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='rooms']")
    public WebElement rooms;
    @FindBy(xpath = "//*[@id='adults']")
    public WebElement adults;
    @FindBy(xpath = "//*[@id='childs']")
    public WebElement children;
    @FindBy(xpath = "//*[@id='nationality']")
    public WebElement nationality;
    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-wrap']/..")
    public WebElement boxDropdownForHotels;
    @FindBy(xpath = "//*[@id='submit']")
    public WebElement searchHotelButton;

    public void clearForm(){
        rooms.clear();
        adults.clear();
        children.clear();
    }

    public void clickDropBoxHotelSetting(){
        boxDropdownForHotels.click();
    }

    public void submit(){
        searchHotelButton.click();
    }
}
