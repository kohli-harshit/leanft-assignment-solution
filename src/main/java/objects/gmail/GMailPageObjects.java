package objects.gmail;

import com.hp.lft.sdk.StringProperty;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.WebElementDescription;

public class GMailPageObjects {
	
	public static ButtonDescription btnCompose =  new ButtonDescription.Builder()
			.tagName("DIV").name("COMPOSE").index(0).build();
	
	public static ListBoxDescription txtTo = new ListBoxDescription.Builder()
			.tagName("TEXTAREA").name("to").index(0).build();
	
	public static EditFieldDescription txtSubject = new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("subjectbox").index(0).build();
	
	public static ButtonDescription btnDrive =  new ButtonDescription.Builder()
			.role("button").accessibilityName("Insert files using Drive").build();
	
	public static String FileUploadXPath = "//DIV/SPAN[normalize-space()=\"fileToSend\"]"; 
	
	public static ButtonDescription btnInsert = new ButtonDescription.Builder()
			.role("button").tagName("DIV").name("Insert").build();
	
	public static ButtonDescription btnSend = new ButtonDescription.Builder()
			.role("button").tagName("DIV").name("Send").build();
	
	public static WebElementDescription messageSentPopUp =  new WebElementDescription.Builder()
			.tagName("DIV").innerText("Your message has been sent. View message").visible(true).styles(new java.util.HashMap<String, StringProperty>(){{ put("background-color", new StringProperty("rgb(249, 237, 190)")); }}).index(0).build();
	
}
