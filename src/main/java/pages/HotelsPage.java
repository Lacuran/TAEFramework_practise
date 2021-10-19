package pages;

import BaseElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.HotelsSearch;
import Entities.Travellers;
import forms.HotelForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uicontrols.CustomSelect;
import uicontrols.TravellersControl;


public class HotelsPage extends BaseAbstractPage {
    public static String TITLE = "PHPTRAVELS - PHPTRAVELS";
    CustomSelect cityDropdown;

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
    @FindBy(xpath = "//*[@*='no results']")
    public WebElement noMatchFound;

    public HotelsPage(TAEDriver driver) {
        super(driver, TITLE);
        cityDropdown = new CustomSelect("HotelCity", driver, "//span[@role='combobox']");
        PageFactory.initElements(driver.getDriver(), this);
    }

    public HotelsPage selectCity(String cityName) {
        cityDropdown.selectItem(cityName);
        return this;
    }

    public HotelsPage setTravellers(Travellers travellers) {
        clearForm();
        rooms.sendKeys(String.valueOf(travellers.getRooms()));
        adults.sendKeys(String.valueOf(travellers.getAdults()));
        children.sendKeys(String.valueOf(travellers.getChild()));
        return this;
    }

    public HotelsPage submit() {
        searchHotelButton.click();
        return this;
    }

    public HotelsPage setTravellersWithNationality(Travellers travellers){
        rooms.sendKeys(String.valueOf(travellers.getRooms()));
        adults.sendKeys(String.valueOf(travellers.getAdults()));
        children.sendKeys(String.valueOf(travellers.getChild()));
        nationality.sendKeys(travellers.getNationality());
        return this;
    }

    public HotelsPage fillPage(HotelsSearch hotelsSearch) {
        selectCity(hotelsSearch.getCityName());
        setTravellers(hotelsSearch.getTravellers());
        return this;
    }

    public HotelsPage fillPageAndSearch(HotelsSearch hotelsSearch) {
        fillPage(hotelsSearch);
        submit();
        return this;
    }

    public HotelsPage clearForm(){
        rooms.clear();
        adults.clear();
        children.clear();
        return this;
    }

    public HotelsPage clickDropBoxHotelSetting(){
        boxDropdownForHotels.click();
        return this;
    }

    public boolean noMatchFoundIsDisplayed(){
        return noMatchFound.isDisplayed();
    }
}
