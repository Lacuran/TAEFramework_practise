package pages;

import BaseElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.HotelsSearch;
import Entities.Travellers;
import uicontrols.CustomSelect;
import uicontrols.TravellersControl;


public class HotelsPage extends BaseAbstractPage {
    public static String TITLE = "Search Hotels - PHPTRAVELS";
    CustomSelect cityDropdown;

    public HotelsPage(TAEDriver driver) {
        super(driver, TITLE);
        cityDropdown = new CustomSelect("HotelCity", driver, "//span[@role='combobox']");
    }

    public HotelsPage selectCity(String cityName) {
        cityDropdown.selectItem(cityName);
        return this;
    }

    public HotelsPage setTravellers(Travellers travellers) {

        return this;
    }

    public HotelsPage submit() {

        return this;
    }

    public HotelsPage setTravellersWithNationality(Travellers travellers){

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
}
