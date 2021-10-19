package gloTests;

import BaseTest.BaseAbstractTest;
import Entities.HotelsSearch;
import Entities.Travellers;
import TAExceptions.TAUnknownBrowserException;
import forms.HotelForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelsPage;
import uicontrols.CustomSelect;
import uicontrols.TravellersControl;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class HotelsTests extends BaseAbstractTest {

    public HotelsTests() throws TAUnknownBrowserException {
        super("chrome");
    }

    @Test
    public void testHotelsPage() {
        getDriver().navigateTo("https://www.phptravels.net/");

        String city = "Krakow";
        Travellers travellers = new Travellers(5,10,0);

        HotelsSearch hotelsSearch = new HotelsSearch();

        new HomePage(getDriver()).switchToHotelsPage().fillPageAndSearch(hotelsSearch);
        HotelForm hotelForm = new HotelForm(getDriver());
        TravellersControl travellersControl = new TravellersControl("Hotel", getDriver(), "//*[@class='dropdown-menu dropdown-menu-wrap']/..");
        hotelForm.clickDropBoxHotelSetting();
        travellersControl.setTravellers(travellers);


    }

    @Test
    public void testHotelsPage2() {
        getDriver().navigateTo("https://www.phptravels.net/");
        CustomSelect customSelect = new CustomSelect("HotelCity", getDriver(), "(//*[@role='combobox'])[1]");
        customSelect.selectItem("Krakow");

        Travellers travellers = new Travellers(5,10,0);

        HotelForm hotelForm = new HotelForm(getDriver());

        TravellersControl travellersControl = new TravellersControl("Hotel", getDriver(), "//*[@class='dropdown-menu dropdown-menu-wrap']/..");
        hotelForm.clickDropBoxHotelSetting();
        travellersControl.setTravellers(travellers);
        getDriver().getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        hotelForm.searchHotelButton.click();


    }
}
