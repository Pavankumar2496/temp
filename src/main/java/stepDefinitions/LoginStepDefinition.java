package stepDefinitions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import cucumber.api.java.en.Then;

public class LoginStepDefinition {

	WebDriver driver;

	@Test
	@Then("^user enters \"(.*)\"$")
	public void user_already_on_login_page(String CompanyName) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet();
		int count = 0;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();  
    	options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
		WebDriver driver = new ChromeDriver(options); 
	//	WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement link = driver.findElement(By.name("q"));
		link.sendKeys("site:linkedin.com "+CompanyName);
		link.submit();
		
		List<WebElement> next = driver.findElements(By.xpath("//*[@id=\"pnnext\"]/span[2]"));
		try {
		for(;next.size()>0;) {
			
			List<WebElement> data = driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/div[1]"));
			for(int i =0; i<=(data.size())-1;i++) {
				System.out.println(i);
				data = driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/div[1]"));
				if(data.get(i).getText().contains("hiring")) {
				//	System.out.println(data.get(i).getText());	
					continue;
				}
				else if(data.get(i).getText().toUpperCase().startsWith(CompanyName.toUpperCase())) {
					continue;
				}
				else if(data.get(i).getText().contains("Salaries")) {
					continue;
				}
				else if(data.get(i).getText().contains("jobs")) {
					continue;
				}
				else if(data.get(i).getText().contains("Powered")) {
					continue;
				}
				else {
					XSSFRow row = spreadsheet.createRow((short) ++count);
				if((data.get(i).findElements(By.tagName("h3")).size()) > 0) {
					WebElement title = data.get(i).findElement(By.tagName("h3"));
					WebElement url = data.get(i).findElement(By.tagName("a"));
					row.createCell(0).setCellValue(title.getText());
					row.createCell(1).setCellValue(url.getAttribute("href"));
					}
					else {continue;}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]")).click();
		}
		//	System.out.println("==========================================================");
			
			
		
		
		}finally {
			  FileOutputStream out = new FileOutputStream(new File("resunt" + CompanyName + ".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("typesofcells.xlsx written successfully");
		}
		

		
	
	}
}
