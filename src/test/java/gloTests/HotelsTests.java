package gloTests;

import BaseTest.BaseAbstractTest;
import Entities.Travellers;
import TAExceptions.TAUnknownBrowserException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HotelsPage;
import uicontrols.CustomSelect;

public class HotelsTests extends BaseAbstractTest {

    public HotelsTests() throws TAUnknownBrowserException {
        super("chrome");
    }

    @BeforeTest
    public void setUp(){
        getDriver().navigateTo("https://www.phptravels.net/");
        String city = "Krakow";
        CustomSelect customSelect = new CustomSelect("HotelCity", getDriver(), "(//*[@role='combobox'])[1]");
        customSelect.selectItem(city);
    }

    @Test
    public void shouldGetMassageNoMatchFound() {
        Travellers travellers = new Travellers(5,10,0);

        HotelsPage hotelsPage = new HotelsPage(getDriver());
        hotelsPage.clickDropBoxHotelSetting();
        hotelsPage.clearForm();
        hotelsPage.setTravellers(travellers);
        hotelsPage.submit();

        Assert.assertTrue(hotelsPage.noMatchFoundIsDisplayed(),"Message with no result is not displayed");

    }

    @Test
    public void shouldSetUpTravellersWithNationality() {
        String nationality = "Poland";

        Travellers travellers = new Travellers(5,10,0, nationality);

        HotelsPage hotelsPage = new HotelsPage(getDriver());
        hotelsPage.clickDropBoxHotelSetting();
        hotelsPage.clearForm();
        hotelsPage.setTravellersWithNationality(travellers);
        hotelsPage.submit();

        Assert.assertTrue(hotelsPage.noMatchFoundIsDisplayed(),"Message with no result is not displayed");

    }
}
