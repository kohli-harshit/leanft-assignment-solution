package test;


import org.testng.annotations.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;

import pages.gcontacts.ContactsPage;
import utils.PropertiesManager;

public class ContactsTest extends BaseTest
{	
	@Test(groups={"Contacts"}, dependsOnGroups={"Drive"})
	public void createContact() throws ReportException, GeneralLeanFtException
    {
        try
        {
            ContactsPage contactsPage = new ContactsPage(browser);
            contactsPage.gotoContacts(PropertiesManager.getProperty("ContactsURL"));
            String name = PropertiesManager.getProperty("ContactNameToAdd");
            String mail = PropertiesManager.getProperty("ContactMailToAdd");
            if(!contactsPage.addContact(name, mail))
            {
                throw new Exception("Not able to add contact");
            }
            StepReporter("Add Contact to Google Contacts", "Contact - " + name + " added successfully", Status.Passed);

        }
        catch(Exception e)
        {
            logger.error( e);
            StepReporter("Add Contact to Google Contacts", e.getMessage(), Status.Failed);
        }            
    }
}
