package forms;

import BaseElements.BaseAbstractForm;
import Core.TAEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileWidgetForm extends BaseAbstractForm {

    public ProfileWidgetForm(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='profile-widget-content']/h2")
    public WebElement userName;
    @FindBy(xpath = "//*[@class='text-center mb-20 font-medium']")
    public WebElement userPosition;
    @FindBy(xpath = "//*[contains(text(),'People Who Follow Me')]/following-sibling::div")
    public WebElement whoFollowMe;
    @FindBy(xpath = "//*[contains(text(),'People I Follow')]/following-sibling::div")
    public WebElement peopleIFollow;
    @FindBy(xpath = "//*[contains(text(),'Teammates')]/following-sibling::div")
    public WebElement teammates;
    @FindBy(xpath = "//*[contains(text(),'My Communities')]/following-sibling::div")
    public WebElement communities;


    public String getUserName(){
        return userName.getText();
    }

    public String getUserPosition(){
        return userPosition.getText();
    }

    public String getWhoFollowMe(){
        return whoFollowMe.getText();
    }

    public String getPeopleIFollow(){
        return peopleIFollow.getText();
    }

    public String getTeammates(){
        return teammates.getText();
    }

    public String getCommunities(){
        return communities.getText();
    }

}
