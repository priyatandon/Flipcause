package search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FlipcauseJobApplication {

	public static void main(String args[]) {
		String exePath = "C:/Drivers/chromedriver.exe";		
		System.setProperty("webdriver.chrome.driver", exePath);		
		WebDriver driver=new ChromeDriver();
		
		String url="https://www.flipcause.com";
		driver.get(url);
		/*Get Current Url*/
		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.linkText("ABOUT")).click();
		driver.findElement(By.partialLinkText("ABOUT FLIP")).click();
		System.out.println(driver.getCurrentUrl());
		
		/*No. of Links in About FlipCause Page*/
		int linksInPage=driver.findElements(By.tagName("a")).size();
	    System.out.println("Links in Page: "+linksInPage);
	    
	    /*No. Of Links in Footer*/
	    WebElement footer=driver.findElement(By.cssSelector("footer.pt-80"));
	    System.out.println("Links in footer section: "+footer.findElements(By.tagName("a")).size());
	    
	    /*Open the Side Bar Menu*/
	    Actions a=new Actions(driver);
	    WebElement menusidebar=driver.findElement(By.id("menu-sidebar-list-icon"));
	    a.moveToElement(menusidebar).click().build().perform();
		
	    WebElement pushmenubar=driver.findElement(By.id("pushmenu-right"));	  	
	    System.out.println("Links in menu side bar section: "+pushmenubar.findElements(By.tagName("a")).size());
	    
	    /*Print the side bar menu links*/
	    List<WebElement> pushmenu=pushmenubar.findElements(By.tagName("ul"));
	    for(WebElement e:pushmenu) {
	    	System.out.println(e.getText().toString());
	    }
	    
	    driver.findElement(By.xpath("//input[@id='username1']")).sendKeys("Job Application");
	}	
}
