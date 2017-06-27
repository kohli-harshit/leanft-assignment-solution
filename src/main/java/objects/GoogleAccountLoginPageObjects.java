package objects;

import com.hp.lft.sdk.RegExpProperty;
import com.hp.lft.sdk.web.*;

public class GoogleAccountLoginPageObjects {
	
	 //Username Text Box
    public static EditFieldDescription txtUsername = new EditFieldDescription.Builder()
		.type("email").tagName("INPUT").name("identifier").build();

    //Next Button
    public static ButtonDescription btnNext = new ButtonDescription.Builder()
		.tagName("DIV").name("Next").index(0).build();		

    //Password Text Box
    public static EditFieldDescription txtPassword = new EditFieldDescription.Builder()
		.type("password").tagName("INPUT").name("password").build();	

    //Sign In Button
    public static ButtonDescription btnSignIn = new ButtonDescription.Builder()
		.buttonType("submit").tagName("INPUT").name("Sign in").build();	

    //Logged in Account Button
    public static ButtonDescription btnLoggedIn =  new ButtonDescription.Builder()
    	.role("button").title(new RegExpProperty("Google Account: .*")).tagName("A").build();
}
