package pages.gcontacts;

import java.awt.AWTException;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.WebElement;

import objects.gcontacts.ContactsPageObjects;

public class ContactsPage 
{
	//Browser Instance for the Class
    private Browser browser;

    //Initialize the Browser
    public ContactsPage(Browser browser)
    {
        this.browser = browser;
    }
    
    public void gotoContacts(String URL) throws GeneralLeanFtException
    {
        browser.navigate(URL);
        browser.sync();            
    }

    public Boolean addContact(String contactName,String contactMail) throws GeneralLeanFtException, AWTException, InterruptedException
    {
        //Create Contact
        browser.describe(Button.class,ContactsPageObjects.btnAddContact).click();
        
        Thread.sleep(5000);
        EditField txtContact =browser.describe(EditField.class,ContactsPageObjects.txtContactName);
        txtContact.setValue(contactName);
        browser.describe(EditField.class,ContactsPageObjects.txtContactMail).setValue(contactMail);
        browser.describe(Button.class,ContactsPageObjects.btnSave).click();

        //Look for Success Message
        return browser.describe(WebElement.class,ContactsPageObjects.contactSaved).exists(10);

    }
}
