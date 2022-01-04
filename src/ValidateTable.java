// Name: Vrund Shah
// Date: January 04,2022
// Description: Validate whether 2 tables are the same

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ValidateTable {

	public static void main(String[] args) {

		// Declare ArrayLists to store WebElement data
		List<String> header1Values=new ArrayList<String>();
		List<String> header2Values=new ArrayList<String>();
		List<String> table1Values=new ArrayList<String>();
		List<String> table2Values=new ArrayList<String>();
		
		//Create Chrome Driver object and open webpage	
		String driverLocation = System.getProperty("user.dir") + "/ChromeDriver/chromedriver.exe";
	    	System.setProperty("webdriver.chrome.driver",driverLocation);  
        	WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		
		// Locators to obtain information about the 2 tables (Example 1, Example 2) 
		List <WebElement> header1 = driver.findElements(By.xpath("//*[@id=\"table1\"]/thead/tr/th"));
		List <WebElement> header2 = driver.findElements(By.xpath("//*[@id=\"table2\"]/thead/tr/th"));
		List <WebElement> rowCountTable1 = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr"));
		List <WebElement> rowCountTable2 = driver.findElements(By.xpath("//*[@id=\"table2\"]/tbody/tr"));
		List <WebElement> table1Content = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr/td"));
		List <WebElement> table2Content = driver.findElements(By.xpath("//*[@id=\"table2\"]/tbody/tr/td"));
		
		// Store header data in ArrayLists
		for(WebElement h1: header1) {
			header1Values.add(h1.getText());
		}
		for(WebElement h2: header2) {
			header2Values.add(h2.getText());
		}
		
		// Display Header content 
		System.out.println("Table 1 has " + header1.size()+" columns ");
		System.out.println("Table 2 has " + header2.size()+ " columns");
		
		if(header1.size()==header2.size()) {
			System.out.println("Column count is the same between the 2 tables");
		}else {
			System.out.println("Column count is not the same");
		}
		System.out.println("Table 1 header values: " + header1Values);
		System.out.println("Table 2 header values: " + header2Values);
		
		// Validate Header data between 2 tables 
		boolean headerMatches = header1Values.equals(header2Values);
		if(headerMatches) {
			System.out.println("Header values match between two tables");
		}else {
			System.out.println("Header values does not match between two tables");	
		}
			
		// Store header data in ArrayLists 
		for(WebElement tab1: table1Content) {
			table1Values.add(tab1.getText());
		}
		for(WebElement tab2: table2Content) {
			table2Values.add(tab2.getText());
		}
		
		// Display data content
		System.out.println("Table 1 has " + rowCountTable1.size()+" rows");
		System.out.println("Table 2 has " + rowCountTable2.size()+" rows");
		
		if(rowCountTable1.size()==rowCountTable2.size()) {
			System.out.println("Row count is the same between the 2 tables");
		}else {
			System.out.println("Row count is not the same");
		}
		System.out.println("Table 1 values: " + table1Values);
		System.out.println("Table 2 values: " + table2Values);
		
		//Validate Table data between 2 tables  
		boolean tableMatches = table1Values.equals(table2Values);
		if(tableMatches) {
			System.out.println("Table data match between two tables");
		}else {
			System.out.println("Table data does not match between two tables");	
		}
		
	
		// Validation to ensure previous 2 data validations are successful  
		if(tableMatches && headerMatches &&(rowCountTable1.size()==rowCountTable2.size()) && header1.size()==header2.size()) {
			System.out.println("The two tables are the same");
		} else {
			System.out.println("The two tables are not the same");
		}

		driver.quit();
	}

}

