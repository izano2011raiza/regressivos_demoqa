package regressivo_demoqa_selenium.elementos;

import org.openqa.selenium.By;


public class Elementos {

	public By userName = By.id("userName");
	public By email = By.id("userEmail");
	public By cAddress = By.id("currentAddress");
	public By pAddress = By.id("permanentAddress");
	public By btnSubmit = By.xpath("//button[@id='submit']");

}
