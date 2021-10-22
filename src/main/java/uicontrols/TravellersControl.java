package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import Entities.Travellers;
import forms.HotelForm;
import forms.HotelForm.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TravellersControl extends BaseControl {
    public TravellersControl(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public TravellersControl(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
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


    public void setTravellers(Travellers travellers){
        clearForm();
        rooms.sendKeys(String.valueOf(travellers.getRooms()));
        adults.sendKeys(String.valueOf(travellers.getAdults()));
        children.sendKeys(String.valueOf(travellers.getChild()));
        try {
            nationality.sendKeys(travellers.getNationality());
        } catch (Exception e){}

    }

    public void clearForm(){
        rooms.clear();
        adults.clear();
        children.clear();
    }

}
