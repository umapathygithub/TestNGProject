package org.tets.paefactory;

import org.flipkart.utils.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage  extends Common{
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	private WebElement userName;
	@FindBy(id="pass")
	private WebElement password;
	
	
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	
	
	
}
