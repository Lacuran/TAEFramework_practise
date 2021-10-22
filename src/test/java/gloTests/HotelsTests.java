package gloTests;

import BaseTest.BaseAbstractTest;
import Entities.HotelsSearch;
import Entities.Travellers;
import TAExceptions.TAUnknownBrowserException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelsPage;
import uicontrols.CustomSelect;

public class HotelsTests extends BaseAbstractTest {

    public HotelsTests() throws TAUnknownBrowserException {
        super("chrome");
    }

    @Test
    public void shouldGetMassageNoMatchFound() {
        getDriver().navigateTo("https://www.phptravels.net/");
        String city = "Krakow";

        Travellers travellers = new Travellers(5,10,0);
        HotelsSearch hotelsSearch = new HotelsSearch(city, travellers);

        new HomePage(getDriver()).switchToHotelsPage().fillPageAndSearch(hotelsSearch);

        boolean noMatchFound = getDriver().getElement(By.xpath("//*[@*='no results']")).isDisplayed();
        Assert.assertTrue(noMatchFound,"Message with no result is not displayed");

    }

    @Test
    public void shouldSetUpTravellersWithNationality() {
        getDriver().navigateTo("https://www.phptravels.net/");
        String city = "Krakow";

        Travellers travellers = new Travellers(5,10,0,"Poland");
        HotelsSearch hotelsSearch = new HotelsSearch(city, travellers);

        new HomePage(getDriver()).switchToHotelsPage().fillPageAndSearch(hotelsSearch);

        boolean noMatchFound = getDriver().getElement(By.xpath("//*[@*='no results']")).isDisplayed();
        Assert.assertTrue(noMatchFound,"Message with no result is not displayed");
    }
}
