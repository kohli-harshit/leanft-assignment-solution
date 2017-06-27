package pages;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;

import objects.GoogleAccountLoginPageObjects;

public class GoogleAccountLoginPage {
	//Browser Instance for the Class
    private Browser browser;

    //Initialize the Browser
    public GoogleAccountLoginPage(Browser browser)
    {
        this.browser = browser;
    }
    
    public void gotoGoogleAccountLoginPage(String URL) throws GeneralLeanFtException
    {
        browser.navigate(URL);
        browser.sync();
    }

    public Boolean isLoaded(int timeOut) throws GeneralLeanFtException
    {
        return browser.describe(EditField.class,GoogleAccountLoginPageObjects.txtUsername).exists(timeOut);
    }

    public Boolean doLogin(String username,String password) throws GeneralLeanFtException, InterruptedException
    {
        //Enter Credentials
        browser.describe(EditField.class,GoogleAccountLoginPageObjects.txtUsername).setValue(username);        
        browser.describe(Button.class,GoogleAccountLoginPageObjects.btnNext).click();
        Thread.sleep(2000);
        browser.describe(EditField.class,GoogleAccountLoginPageObjects.txtPassword).setSecure(password);
        browser.describe(Button.class,GoogleAccountLoginPageObjects.btnNext).click();
        Thread.sleep(2000);

        //Check Logged in or Not
        return browser.describe(Button.class,GoogleAccountLoginPageObjects.btnLoggedIn).exists(5);
        
    }

}
