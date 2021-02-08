package Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Launchbrowser {
	// Instantiate a ChromeDriver class.
	WebDriver driver;
	Properties prop;
    FileInputStream fs;
	@Test(priority = 1)
	public void launch_browser() throws IOException {
		// System Property for Chrome Driver
		System.out.print(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir");
		fs=new FileInputStream(System.getProperty("user.dir") +"\\Config.properties");
		prop=new Properties();
	    prop.load(fs);
	     String Browsername=prop.getProperty("browsername");
	  if(Browsername.equals("chrome"))
	  {
	    	System.setProperty("webdriver.chrome.driver",path + "\\src\\test\\resources\\chromedriver.exe");
	 		driver = new ChromeDriver();
	 	    // Launch calulator application
			driver.get(prop.getProperty("url"));

			//driver.get("https://www.calculator.net/");
			// Maximize the browser
			driver.manage().window().maximize();

	  }
		
	}

	@Test(priority = 2)
	public void Multiplication() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-equation"), "AC"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-operation"),"×"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "5"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "5"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-equation"), "="))).click();
		String actual1 = driver.findElement(By.xpath(prop.getProperty("xpath-getText"))).getText();
		System.out.println("Multiplication:"+actual1);
		// string actual= removeSpaces(actual01);

		String expected1 = "222075";
		Assert.assertEquals(actual1.trim(), expected1);

	}

	@Test(priority = 3)
	public void Substraction() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-equation"), "AC"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "8"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-operation"),"–"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-fun"),"("))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-operation"),"–"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "0"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "9"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "8"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-fun"),")"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-equation"), "="))).click();

		String actual4 = driver.findElement(By.xpath(prop.getProperty("xpath-getText"))).getText();
System.out.println("Substraction is:"+actual4);
		String expected4 = "23329646";
		Assert.assertEquals(actual4.trim(), expected4);
	}


	@Test(priority = 4)
	public void Addition() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-equation"), "AC"))).click();
	    driver.findElement(By.xpath(String.format(prop.getProperty("xpath-operation"),"–"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-fun"),"("))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-fun"),")"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-operation"),"+"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "5"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "3"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "5"))).click();
		driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();

		String actual3 = driver.findElement(By.xpath(prop.getProperty("xpath-getText"))).getText();
		System.out.println("Äddition is:"+actual3);
		String expected3 = "111111";
		Assert.assertEquals(actual3.trim(), expected3);
	}
	@Test(priority =5)
	public void Division()  {
//		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-equation"), "AC"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "4"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "0"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "0"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "0"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-operation"),"/"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "2"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "0"))).click();
		driver.findElement(By.xpath(String.format(prop.getProperty("xpath-number"), "0"))).click();
		driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();		
		String actual2 = driver.findElement(By.xpath(prop.getProperty("xpath-getText"))).getText();
		System.out.println("Division is:"+actual2);
		String expected="20";
		Assert.assertEquals(actual2.trim(), expected);
	}

	
}
