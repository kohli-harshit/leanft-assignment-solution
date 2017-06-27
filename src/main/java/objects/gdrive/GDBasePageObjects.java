package objects.gdrive;

import com.hp.lft.sdk.RegExpProperty;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.web.*;

public class GDBasePageObjects {
	
	//New Button
    public static ButtonDescription btnNew = new ButtonDescription.Builder()
    	.tagName("BUTTON").name("New").index(0).build();

    //New Menu
    public static MenuDescription menu = new MenuDescription.Builder()
    	.topLevelMenuItems(new String[] { "New folder..." , "File upload" , "Google Docs" , "Google Sheets" , "Google Slides" , "More" })
    	.role("menu").tagName("DIV").build();

    //Menu Item in New Menu
    public static String newMenuItemXPath = "//DIV[@role=\"menuitem\"]/DIV/SPAN/SPAN[normalize-space()=\"menuItemToSelect\"]/DIV[1]";

    //Window for File Upload
    public static WindowDescription winFileUpload = new WindowDescription.Builder()
		.ownedWindow(false).childWindow(false).text(new RegExpProperty("My Drive.*")).build();

    //Dialog for File Upload
    public static DialogDescription dialogFileUpload = new DialogDescription.Builder()
    		.ownedWindow(true).childWindow(false).text(new RegExpProperty("File Upload|Open")).nativeClass("#32770").build();

    //File Upload Text Box
    public static com.hp.lft.sdk.stdwin.EditFieldDescription txtUploadFileName = new com.hp.lft.sdk.stdwin.EditFieldDescription.Builder()
		.attachedText("File &name:").nativeClass("Edit").build();

    //File Open Button
    public static com.hp.lft.sdk.stdwin.ButtonDescription btnOpen = new com.hp.lft.sdk.stdwin.ButtonDescription.Builder()
    	.text("&Open").nativeClass("Button").build();

    //Upload Complete Message
    public static WebElementDescription uploadComplete = new WebElementDescription.Builder()
		.tagName("SPAN").innerText("ItemCount upload complete").build();	
}
