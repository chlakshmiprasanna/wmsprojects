package wms_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CMS_Updates {
	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette", "D:\\Ashok-Data\\Ashok\\Data\\Testing\\Java Tutorial\\G\\Firefox\\geckodriver-v0.18.0-win64.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	    driver = new FirefoxDriver();
	    driver.get("https://meanwms.p2staging.us/login");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[1]/input")).sendKeys("lakshmi.prasanna@position2.com");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div[2]/input")).sendKeys("prasanna1612");
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/button")).click();
	    driver.findElement(By.xpath("html/body/div[1]/nav/aside/div[2]/div[2]/ul/li[5]/a")).click();
	    Thread.sleep(3000);
	    
	    FileInputStream read = new FileInputStream("C:\\Users\\ashok.k\\Desktop\\CMS_Update.xls");
	    Workbook wb = Workbook.getWorkbook(read);
	    Sheet sh = wb.getSheet("Sheet1");
	    System.out.println(sh.getRows());
	    //String bodyText[] = new String[sh.getRows()];
	    for(int i=1; i<=sh.getRows(); i++)
	    {
	    	String Month = sh.getCell(0, i).getContents();
	    	String Client = sh.getCell(1, i).getContents();
	    	String Module = sh.getCell(2, i).getContents();
	    	String Criticality = sh.getCell(3, i).getContents();
	    	String Date = sh.getCell(4, i).getContents();
	    	String Description = sh.getCell(5, i).getContents();
	    
	   Select month = new Select(driver.findElement(By.xpath(".//*[@id='CmsForm']/div[1]/div[1]/select")));
	   month.selectByVisibleText(Month); 
	   Select client = new Select(driver.findElement(By.xpath(".//*[@id='CmsForm']/div[1]/div[2]/select")));
	   client.selectByVisibleText(Client);
	   driver.findElement(By.xpath(".//*[@id='clone-area']/div[1]/input")).sendKeys(Module);
	   Select criticality = new Select(driver.findElement(By.xpath(".//*[@id='clone-area']/div[2]/select")));
	   criticality.selectByVisibleText(Criticality);
	   driver.findElement(By.xpath(".//*[@id='clone-area']/div[3]/input")).sendKeys(Date);
	   //driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[6]")).click();
	   driver.findElement(By.xpath(".//*[@id='clone-area']/div[4]/textarea")).sendKeys(Description);
	   driver.findElement(By.xpath(".//*[@id='CmsForm']/button[2]")).click();
	   Thread.sleep(3000);
	   
	   Select entries = new Select(driver.findElement(By.xpath(".//*[@id='wms_datatable_length']/label/select")));
	   entries.selectByVisibleText("100"); 
	   driver.findElement(By.xpath(".//*[@id='wms_datatable_filter']/label/input")).sendKeys(Module);
	   //No.of Columns
       List<WebElement>  col = driver.findElements(By.xpath(".//*[@id='wms_datatable']/thead/tr/th[4]"));
       System.out.println("No of cols are : " +col.size()); 
       
       //No.of rows 
       List<WebElement>  rows = driver.findElements(By.xpath(".//*[@id='wms_datatable']/tbody/tr[1]/td[4]")); 
       System.out.println("No of rows are : " + rows.size());
       String Expectedresult = rows.toString();
       System.out.println("Expected result is "+ Expectedresult);
	   
//	   List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='wms_datatable']/thead/tr/th[4]"));
//	   ele.contains("Added CMS Updates");
	  
	   if(Expectedresult.contains(Module))
	   {
		   System.out.println("Test is Pass");
	   }
	   else
	   {
		   System.out.println("Test is Fail");
	   }   
	   
	}
	}
}
