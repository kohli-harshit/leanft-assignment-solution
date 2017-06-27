package pages.gmail;

import java.awt.Point;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.Keyboard;
import com.hp.lft.sdk.Mouse;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;

import objects.gmail.GMailPageObjects;

public class GMailPage {
	//Browser Instance for the Class
    private Browser browser;

    //Initialize the Browser
    public GMailPage(Browser browser)
    {
        this.browser = browser;
    }
    
    public void gotoMail(String URL) throws GeneralLeanFtException
    {
        browser.navigate(URL);
        browser.sync();            
    }
    
    public void sendMail(String to,String subject,String driveFileToAttach) throws Exception
    {
    	browser.describe(Button.class, GMailPageObjects.btnCompose).click();
    	Point position = browser.describe(ListBox.class, GMailPageObjects.txtTo).getAbsoluteLocation();    	
    	Mouse.move(position);
    	Mouse.click(position);    	
    	Keyboard.sendString(to);
    	Thread.sleep(1000);
    	Keyboard.pressKey((byte)28);
    	
    	browser.describe(EditField.class, GMailPageObjects.txtSubject).setValue(subject);
    	browser.describe(Button.class, GMailPageObjects.btnDrive).click();
    	
    	WebElement fileToAttach = browser.describe(WebElement.class,new XPathDescription(GMailPageObjects.FileUploadXPath.replace("fileToSend", driveFileToAttach)));
    	
    	if(!fileToAttach.exists(10))
    	{
    		throw new Exception(driveFileToAttach + " not present in Google Drive");
    	}
    	
    	fileToAttach.click();
    	
    	browser.describe(Button.class, GMailPageObjects.btnInsert).click();
    	browser.describe(Button.class, GMailPageObjects.btnSend).click(); 	
    	
    }
    
    public Boolean isMailSentPopUpPresent() throws GeneralLeanFtException
    {
    	return browser.describe(WebElement.class, GMailPageObjects.messageSentPopUp).exists(10);
    }
}
