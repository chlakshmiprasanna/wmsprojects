package wms_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Spellchecker {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("localhost:4444");
//		System.out.println( sc.getValue() );
		
	}

}
