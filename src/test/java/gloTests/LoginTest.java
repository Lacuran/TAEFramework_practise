package gloTests;

import BaseTest.BaseAbstractChromeTest;
import Entities.User;
import TAExceptions.TAUnknownBrowserException;
import forms.ProfileWidgetForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseAbstractChromeTest {
    public LoginTest() throws TAUnknownBrowserException {
    }

    @Test
    public void shouldGetErrorMessageWithInvalidCredential(){
        //arrange (given)
        String invalidUserName = "username";
        String invalidPassword = "password";

        String pageToLogin = "https://glo.globallogic.com/ ";
        getDriver().navigateTo(pageToLogin);

        User user = new User(invalidUserName, invalidPassword);
        LoginPage loginPage = new LoginPage(getDriver());

        //act (when)
        loginPage.tryLogin(user);

        //assure (then)
        Assert.assertTrue(loginPage.alertMessageVisible(),"Error massage is not displayed");

    }

    @Test
    public void shouldLoginWithValidCredential(){
        //arrange
        String username = "";
        String password = "";
        String pageTitleAfterLogin = "Glo:Home";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());


        //act
        loginPage.tryLogin(user);

        //assure
        Assert.assertEquals(getDriver().getDriver().getTitle(), pageTitleAfterLogin, "Site title do not match");
    }

    @Test
    public void shouldMatchProfileWidgetNameAndSurname(){
        //arrange
        String username = "";
        String password = "";
        String nameAndSurname = "Kornel Wrzesien";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());



        //act
        loginPage.tryLogin(user);

        ProfileWidgetForm profileWidgetForm = new ProfileWidgetForm(getDriver());
        String userName = profileWidgetForm.getUserName();

        //assure
        Assert.assertEquals(userName,nameAndSurname,"Name is not displayed");

    }

    @Test
    public void shouldMatchProfileWidgetPosition(){
        //arrange
        String username = "";
        String password = "";
        String userPosition = "Trainee Test Engineer,Quality Assurance";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());



        //act
        loginPage.tryLogin(user);

        ProfileWidgetForm profileWidgetForm = new ProfileWidgetForm(getDriver());
        String position = profileWidgetForm.getUserPosition();

        //assure
        Assert.assertEquals(position, userPosition,"Name is not displayed");

    }

    @Test
    public void shouldMatchProfileWidgetWhoFollowMe(){
        //arrange
        String username = "";
        String password = "";
        String whoFollowMe = "5";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());



        //act
        loginPage.tryLogin(user);

        ProfileWidgetForm profileWidgetForm = new ProfileWidgetForm(getDriver());
        String whoFollow = profileWidgetForm.getWhoFollowMe();

        //assure
        Assert.assertEquals(whoFollow, whoFollowMe,"Name is not displayed");

    }

    @Test
    public void shouldMatchProfileWidgetIFollow(){
        //arrange
        String username = "";
        String password = "";
        String IFollow = "6";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());



        //act
        loginPage.tryLogin(user);

        ProfileWidgetForm profileWidgetForm = new ProfileWidgetForm(getDriver());
        String peopleIFollow = profileWidgetForm.getPeopleIFollow();

        //assure
        Assert.assertEquals(peopleIFollow, IFollow,"Name is not displayed");

    }

    @Test
    public void shouldMatchProfileWidgetOfTeammates(){
        //arrange
        String username = "";
        String password = "";
        String teammates = "208";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());



        //act
        loginPage.tryLogin(user);

        ProfileWidgetForm profileWidgetForm = new ProfileWidgetForm(getDriver());
        String myTeammates = profileWidgetForm.getTeammates();

        //assure
        Assert.assertEquals(myTeammates, teammates,"Name is not displayed");

    }

    @Test
    public void shouldMatchProfileWidgetMyCommunities(){
        //arrange
        String username = "";
        String password = "";
        String communities = "24";
        String pageToLogin = "https://glo.globallogic.com/ ";

        getDriver().navigateTo(pageToLogin);

        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(getDriver());



        //act
        loginPage.tryLogin(user);

        ProfileWidgetForm profileWidgetForm = new ProfileWidgetForm(getDriver());
        String myCommunities = profileWidgetForm.getCommunities();

        //assure
        Assert.assertEquals(myCommunities, communities,"Name is not displayed");

    }


}
