package objects.gcontacts;

import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.WebElementDescription;

public class ContactsPageObjects {
	public static ButtonDescription btnAddContact = new ButtonDescription.Builder()
    		.role("button").accessibilityName("Add new contact").tagName("DIV").build();

    public static EditFieldDescription txtContactName = new EditFieldDescription.Builder()
    	.accessibilityName("Name").tagName("INPUT").name("WebEdit").build();

    
    public static EditFieldDescription txtContactMail = new EditFieldDescription.Builder()
    	.accessibilityName("Email").tagName("INPUT").name("WebEdit").build();

    public static ButtonDescription btnCreate = new ButtonDescription.Builder()
		.role("button").tagName("DIV").name("Create").index(0).build();	

    public static ButtonDescription btnSave = new ButtonDescription.Builder()
		.role("button").tagName("DIV").name("Save").build();

    public static WebElementDescription contactSaved = new WebElementDescription.Builder()
    		.tagName("DIV").innerText("Contact details").build();

}
