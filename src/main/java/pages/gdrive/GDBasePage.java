package pages.gdrive;

import java.awt.Point;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.Mouse;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;

import objects.gdrive.GDBasePageObjects;


public class GDBasePage {
	//Browser Instance for the Class
    private Browser browser;

    //Initialize the Browser
    public GDBasePage(Browser browser)
    {
        this.browser = browser;
    }

    public void selectNewOption(String optionName) throws Exception
    {
        //Click on New Menu
        browser.describe(Button.class,GDBasePageObjects.btnNew).click();

        //Select the Option
        WebElement newMenuItem = browser.describe(WebElement.class, new XPathDescription(GDBasePageObjects.newMenuItemXPath.replace("menuItemToSelect", optionName)));
        
        if(!newMenuItem.exists(5))
        {
            throw new Exception("Menu Item - " + optionName + " not found");
        }        

        Point position = new Point((int)newMenuItem.getAbsoluteLocation().getX(),(int)newMenuItem.getAbsoluteLocation().getY());
        Mouse.move(position);
        Thread.sleep(1000);
        Mouse.click(position);
        Thread.sleep(1000);
        browser.sync();
    }

    public void uploadFile(String filePath) throws Exception
    {
        Window window = Desktop.describe(Window.class,GDBasePageObjects.winFileUpload);
        Dialog dialog = window.describe(Dialog.class,GDBasePageObjects.dialogFileUpload);

        //Set File Name Path            
        com.hp.lft.sdk.stdwin.EditField fileName = dialog.describe(com.hp.lft.sdk.stdwin.EditField.class,GDBasePageObjects.txtUploadFileName);
        fileName.setText(filePath);

        //Click Open
        com.hp.lft.sdk.stdwin.Button open = dialog.describe(com.hp.lft.sdk.stdwin.Button.class,GDBasePageObjects.btnOpen);
        open.click();
    }

    public Boolean isUploadComplete(int noOfItems,int waitTimeOut) throws GeneralLeanFtException
    {
        //Keep Polling for the Upload Complete Message for the Selected no. of Items
        GDBasePageObjects.uploadComplete.setInnerText(GDBasePageObjects.uploadComplete.getInnerText().toString().replaceAll("ItemCount",Integer.toString(noOfItems)));

        for(int tryCount=1;tryCount<=waitTimeOut;tryCount++)
        {
            if(browser.describe(WebElement.class,GDBasePageObjects.uploadComplete).exists(1))
            {
                return true;
            }
        }

        return false;
    }

}
