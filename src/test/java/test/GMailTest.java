package test;

import org.testng.annotations.Test;

import com.hp.lft.report.Status;

import pages.gmail.GMailPage;
import utils.PropertiesManager;

public class GMailTest extends BaseTest{
	
	@Test(groups={"Mail"},dependsOnGroups={"Contacts"})
	public void SendMail() throws Exception
	{
		try
		{
			GMailPage gMailPage = new GMailPage(browser);
			gMailPage.gotoMail(PropertiesManager.getProperty("MailURL"));			
			gMailPage.sendMail(PropertiesManager.getProperty("ContactNameToAdd"), "Test Mail", PropertiesManager.getProperty("FileToSend"));
						
			if(!gMailPage.isMailSentPopUpPresent())
			{
					throw new Exception("Mail Sent Pop up not found");
			}
			
			StepReporter("Verify Mail should be sent","Mail Sent",Status.Passed);
			
		}
	    catch(Exception e)
	    {
	        logger.error( e);
	        StepReporter("Add Contact to Google Contacts", e.getMessage(), Status.Failed);
	    }
	}

}
