package com.qi.testcases;


import java.io.File;
import java.io.IOException;
/*import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;*/

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qi.base.TestQuant;

public class QiTask extends TestQuant {

	@Test
	public void loginAsUser() throws InterruptedException,IOException{
		
		// Login in  QuantInsti and navigate to profile 
		
		String currentWindow = driver.getWindowHandle();	
		driver.findElement(By.xpath(OR.getProperty("LoginBtn"))).click();
			
		WebElement ReminderClick=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Reminder"))));
		ReminderClick.click();
		
				
		for (String NewWinHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(NewWinHandle); 
		}
		
		WebElement uname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("UserName"))));

		uname.sendKeys("sachin.p+dummy1@quantinsti.com");		
	
		driver.findElement(By.xpath(OR.getProperty("Password"))).sendKeys("sachintest");
		driver.findElement(By.xpath(OR.getProperty("SignBtn"))).click();
		 
		 driver.switchTo().window(currentWindow);
		 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("ProfileIcon")))).click();	
		    
			driver.findElement(By.xpath(OR.getProperty("ProfileLink"))).click();
			driver.close();
			
			//Edit profile of the user and take screenshot of successful message
			
			for (String ProfileWinHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(ProfileWinHandle); 
			}
			
			WebElement EmailId= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("EmailTBox"))));
			System.out.println("Email id: "+ EmailId.getAttribute("value"));
			
			WebElement MobileBox=driver.findElement(By.xpath(OR.getProperty("Mobile")));

			Actions action=new Actions(driver);
			action.doubleClick(MobileBox).perform();
			MobileBox.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE ));
			action.clickAndHold(MobileBox).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"222222").build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			
			driver.findElement(By.xpath(OR.getProperty("SaveBtn")));
			
			WebElement InvalidBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("InvalidOkBtn"))));
			InvalidBtn.click();
 
			action.doubleClick(MobileBox).perform();
			MobileBox.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE ));
			action.clickAndHold(MobileBox).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"9768226717").build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			
			Select DropDown= new Select(driver.findElement(By.xpath(OR.getProperty("YOEList"))));
			DropDown.selectByIndex(2);
			driver.findElement(By.xpath(OR.getProperty("SaveBtn")));
			
			WebElement SuccessBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("SuccessOkBtn"))));
			
			File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("D:/Successful.png"));
			SuccessBtn.click();
			
			// Use My Service to get Title details of EPAT and Quantra Launch screen
			
			WebElement MyService=driver.findElement(By.xpath(OR.getProperty("MServeLink")));
			MyService.click();
			
			String serviceWindow = driver.getWindowHandle();
			
			WebElement EEnrollBtn=driver.findElement(By.xpath(OR.getProperty("EpatEnroll")));
			EEnrollBtn.click();
			
			Thread.sleep(4000);
			for (String EPATWinHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(EPATWinHandle); 
			}
		
			System.out.println("EPAT Title is :" + driver.getTitle());
			/*Alert alert= driver.switchTo().alert();
			alert.dismiss();*/
			driver.close();
			driver.switchTo().window(serviceWindow);
			WebElement QLaunchBtn=driver.findElement(By.xpath(OR.getProperty("QLaunch")));
			QLaunchBtn.click();
			driver.close();
			
			Thread.sleep(8000);
			
			for (String DashWinHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(DashWinHandle); 
			}
						
			String MainPageTitle = driver.getTitle();
			System.out.println("MainPagetitle is :" + MainPageTitle);
			
			//LogOut the user
			
			wait = new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("ProfileIcon")))).click();	
			driver.findElement(By.xpath(OR.getProperty("LogOut"))).click();
					
	}
		
}
