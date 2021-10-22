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
    public static String TITLE = "Search Hotels - PHPTRAVELS";
    CustomSelect cityDropdown;
    TravellersControl travellersControl;

    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-wrap']/..")
    public WebElement boxDropdownForHotels;
    @FindBy(xpath = "//*[@id='submit']")
    public WebElement searchHotelButton;
    @FindBy(xpath = "//*[@*='no results']")
    public WebElement noMatchFound;

    public HotelsPage(TAEDriver driver) {
        super(driver, TITLE);
        cityDropdown = new CustomSelect("HotelCity", driver, "//span[@role='combobox']");
        travellersControl = new TravellersControl("TravelersControl", driver, "//*[@class='dropdown-menu dropdown-menu-wrap']/..");
        PageFactory.initElements(driver.getDriver(), this);
    }

    public HotelsPage selectCity(String cityName) {
        cityDropdown.selectItem(cityName);
        return this;
    }

    public HotelsPage setTravellers(Travellers travellers) {
        clickDropBoxHotelSetting();
        travellersControl.setTravellers(travellers);
        return this;
    }

    public HotelsPage submit() {
        searchHotelButton.click();
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



    public HotelsPage clickDropBoxHotelSetting(){
        boxDropdownForHotels.click();
        return this;
    }

    public boolean noMatchFoundIsDisplayed(){
        return noMatchFound.isDisplayed();
    }
}
