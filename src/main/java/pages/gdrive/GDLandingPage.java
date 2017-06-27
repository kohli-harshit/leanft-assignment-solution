package pages.gdrive;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;

import objects.gdrive.GDLandingPageObjects;

public class GDLandingPage {
	
	//Browser Instance for the Class
    private Browser browser;

    //Initialize the Browser
    public GDLandingPage(Browser browser)            
    {
        this.browser = browser;
    }

    public void gotoDrive(String URL) throws GeneralLeanFtException
    {
        browser.navigate(URL);
        browser.sync();
        browser.describe(Link.class, GDLandingPageObjects.btnGotoDrive).click();       
        browser.sync();
    }

}
