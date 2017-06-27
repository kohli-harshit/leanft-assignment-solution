package test;

import org.testng.annotations.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;

import pages.gdrive.GDBasePage;
import pages.gdrive.GDLandingPage;
import utils.PropertiesManager;

public class GDriveTest extends BaseTest {

	@Test(groups={"Drive"})
	public void UploadFileToDrive() throws ReportException, GeneralLeanFtException
	{
		try
		{
			GDLandingPage landingPage = new GDLandingPage(browser);
			landingPage.gotoDrive(PropertiesManager.getProperty("DriveURL"));

			GDBasePage basePage = new GDBasePage(browser);
			basePage.selectNewOption("File upload");
			String filePath = PropertiesManager.getProperty("FileToUpload");
			basePage.uploadFile(filePath);

			if(!basePage.isUploadComplete(1,30))
			{
				throw new Exception("File Upload did not complete in 30 seconds");
			}

			StepReporter("Upload a File to Google Drive", "File - " + filePath + " uploaded successfully", Status.Passed);

		}
		catch(Exception e)
		{
			logger.error(e);
			StepReporter("Upload a File to Google Drive", e.getMessage(), Status.Failed);
		}          
	}
}