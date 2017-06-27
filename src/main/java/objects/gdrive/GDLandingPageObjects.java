package objects.gdrive;

import com.hp.lft.sdk.web.LinkDescription;

public class GDLandingPageObjects {
	//Goto Drive Button    
    public static LinkDescription btnGotoDrive = new LinkDescription.Builder()
    		.tagName("A").innerText("Go to Google Drive").index(1).build();
}
