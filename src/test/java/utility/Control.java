/*
 *Description: Control Functions library 
'Author :Sunanda Tirunagari & Ankit Kumar
 */

package utility;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constant;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;*/

public class Control {

	public static void delete(File file) throws IOException {
		if (file.isDirectory()) { 
			if (file.list().length == 0) {
				file.delete();
			} else {
				// list all the directory contents
				String files[] = file.list();
				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);
					// recursive delete
					delete(fileDelete);
				}
				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					//System.out.println("Directory is deleted : "
						//	+ file.getAbsolutePath());
				}
			}
		} else {
			// if file, then delete it
			file.delete();
		}
	}
	public static void deleteTempFile() throws UnknownHostException {
		String property = "java.io.tmpdir";
		String temp = System.getProperty(property);
		File directory = new File(temp);
		try {
			delete(directory);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void OpenApplication(String browserName, String URL, String User) throws UnknownHostException {

        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\geckodriver.exe");
            Constant.driver= new FirefoxDriver();
} else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.SafariDriver.driver", "D:\\WebDriver\\SafariDriver.exe");
            Constant.driver = new SafariDriver();
} else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\Chrome\\chromedriver.exe");//"C:\\Webdriver\\chromedriver.exe"D:\\WebDriver\\ChromeNewdriver\\chromedriver.exe"
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
           //  options.addArguments("user-data-dir=C:\\ChromeData"); //e.g.: options.addArguments("user-data-dir=C:\\ChromeData");
            //options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            options.addArguments("user-data-dir=D:\\Xendit\\ChromeData\\UserDetails\\"+User);
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.silentOutput", "true");
            Constant.driver= new ChromeDriver(options);
            //Constant.driver= new ChromeDriver();

            
            //options.setExperimentalOption("debuggerAddress", "localhost:616061");
            //Constant.driver= new ChromeDriver(options);
            //Constant.driver= new ChromeDriver();
} else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "D:\\WebDriver\\IEDriverServer.exe");
            Constant.driver =  new InternetExplorerDriver();
           //Constant.driver.manage().deleteAllCookies();
} else if (browserName.equalsIgnoreCase("Opera")) {
			String path= "E:\\WebDriver\\operadriver.exe";
			OperaOptions options = new OperaOptions();
			options.setBinary("C:\\Users\\aahmad\\AppData\\Local\\Programs\\Opera\\58.0.3135.53\\opera.exe");
			System.setProperty("webdriver.opera.driver", path);
			Constant.driver = new OperaDriver(options);
} else if (browserName.equalsIgnoreCase("Edge")) {
            //System.setProperty("webdriver.edge.driver", "E:\\WebDriver\\MicrosoftWebDriver.exe");
            Constant.driver = new EdgeDriver();

}
        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
        //Constant.driver.manage().deleteAllCookies();
        //Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().window().maximize();
        //return driver;
        //Added By Ankit
        try {
                        //Thread.sleep(10000);
                        Constant.driver.get(URL);            
                        Generic.WriteTestData("Open the Browser and URL",browserName,URL,"Able to Open the URL in Browser '"+browserName+"'","Opened  the URL in the Browser '"+browserName+"' successfully","Passed");
                        } catch (Exception e) {    
        }
	}
	

	
	
	public static void OpenApplicationBeeceptor(String browserName, String URL, String User) throws UnknownHostException {

 if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\geckodriver.exe");
            Constant.driver= new FirefoxDriver();
} else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.SafariDriver.driver", "D:\\WebDriver\\SafariDriver.exe");
            Constant.driver = new SafariDriver();
} else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\Chrome\\chromedriver.exe");//"C:\\Webdriver\\chromedriver.exe"D:\\WebDriver\\ChromeNewdriver\\chromedriver.exe"
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
           //  options.addArguments("user-data-dir=C:\\ChromeData"); //e.g.: options.addArguments("user-data-dir=C:\\ChromeData");
            //options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            options.addArguments("chrome.exe --remote-debugging-port=1405 --user-data-dir=D:\\Xendit\\ChromeData\\UserDetails\\"+User);
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.silentOutput", "true");
            Constant.driver= new ChromeDriver(options);
            //Constant.driver= new ChromeDriver();

            
            //options.setExperimentalOption("debuggerAddress", "localhost:616061");
            //Constant.driver= new ChromeDriver(options);
            //Constant.driver= new ChromeDriver();
} else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "D:\\WebDriver\\IEDriverServer.exe");
            Constant.driver =  new InternetExplorerDriver();
           //Constant.driver.manage().deleteAllCookies();
} else if (browserName.equalsIgnoreCase("Opera")) {
			String path= "E:\\WebDriver\\operadriver.exe";
			OperaOptions options = new OperaOptions();
			options.setBinary("C:\\Users\\aahmad\\AppData\\Local\\Programs\\Opera\\58.0.3135.53\\opera.exe");
			System.setProperty("webdriver.opera.driver", path);
			Constant.driver = new OperaDriver(options);
} else if (browserName.equalsIgnoreCase("Edge")) {
            //System.setProperty("webdriver.edge.driver", "E:\\WebDriver\\MicrosoftWebDriver.exe");
            Constant.driver = new EdgeDriver();

}
        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
        //Constant.driver.manage().deleteAllCookies();
        //Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().window().maximize();
        //return driver;
        //Added By Ankit
        try {
                        //Thread.sleep(10000);
                        Constant.driver.get(URL);            
                        Generic.WriteTestData("Open the Browser and URL",browserName,URL,"Able to Open the URL in Browser '"+browserName+"'","Opened  the URL in the Browser '"+browserName+"' successfully","Passed");
                        } catch (Exception e) {    
        }
	}

	
	
	
	
	
	public static void OpenApplicationOld2(String browserName, String URL) throws UnknownHostException {

        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\WebDriver\\geckodriver.exe");
            Constant.driver= new FirefoxDriver();
} else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.SafariDriver.driver", "E:\\WebDriver\\SafariDriver.exe");
            Constant.driver = new SafariDriver();
} else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAVYA\\Documents\\Automation\\WebDriver\\Chrome\\chromedriver.exe");
            Constant.driver= new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
             options.addArguments("user-data-dir=C:\\ChromeData"); //e.g.: options.addArguments("user-data-dir=C:\\ChromeData");
             desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            // Constant.driver= new ChromeDriver(options);
} else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "E:\\WebDriver\\IEDriverServer.exe");
            Constant.driver =  new InternetExplorerDriver();
           //Constant.driver.manage().deleteAllCookies();
} else if (browserName.equalsIgnoreCase("Opera")) {
			String path= "E:\\WebDriver\\operadriver.exe";
			OperaOptions options = new OperaOptions();
			options.setBinary("C:\\Users\\aahmad\\AppData\\Local\\Programs\\Opera\\58.0.3135.53\\opera.exe");
			System.setProperty("webdriver.opera.driver", path);
			Constant.driver = new OperaDriver(options);
} else if (browserName.equalsIgnoreCase("Edge")) {
            //System.setProperty("webdriver.edge.driver", "E:\\WebDriver\\MicrosoftWebDriver.exe");
            Constant.driver = new EdgeDriver();

}
        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().window().maximize();
        //return driver;
        //Added By Ankit
        try {
                        //Thread.sleep(10000);
                        Constant.driver.get(URL);            
                        Generic.WriteTestData("Open the Browser and URL",browserName,URL,"Able to Open the URL '"+URL+"' in Browser '"+browserName+"'","Opened  the URL '"+URL+"' in the Browser '"+browserName+"' successfully","Passed");
                        } catch (Exception e) {    
        }
	}
	
	
	public static void OpenApplicationOld(String browserName, String URL) throws UnknownHostException {

		
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\WebDriver\\geckodriver.exe");
            Constant.driver= new FirefoxDriver();
} else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.SafariDriver.driver", "E:\\WebDriver\\SafariDriver.exe");
            Constant.driver = new SafariDriver();
} else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAVYA\\Documents\\Automation\\WebDriver\\Chrome\\chromedriver.exe");
            Constant.driver= new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
             options.addArguments("user-data-dir=C:\\ChromeData"); //e.g.: options.addArguments("user-data-dir=C:\\ChromeData");
             desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            // Constant.driver= new ChromeDriver(options);
} else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "E:\\WebDriver\\IEDriverServer.exe");
            Constant.driver =  new InternetExplorerDriver();
           //Constant.driver.manage().deleteAllCookies();
} else if (browserName.equalsIgnoreCase("Opera")) {
			String path= "E:\\WebDriver\\operadriver.exe";
			OperaOptions options = new OperaOptions();
			options.setBinary("E:\\Workspace_Automation\\Projects\\Broadway\\Opera\\56.0.3051.104\\opera.exe");
			System.setProperty("webdriver.opera.driver", path);
			Constant.driver = new OperaDriver(options);
} else if (browserName.equalsIgnoreCase("Edge")) {
            //System.setProperty("webdriver.edge.driver", "E:\\Globe Selenium\\Selenium Installation Material\\WebDriver\\MicrosoftWebDriver.exe");
            Constant.driver = new EdgeDriver();

}


        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().window().maximize();

        try 
        {
            Constant.driver.get(URL);
            Constant.driver.get(URL);
            Constant.driver.get(URL);
            Generic.WriteTestData("Open the Browser and URL",browserName,URL,"Able to Open the URL '"+URL+"' in Browser '"+browserName+"'","Opened  the URL '"+URL+"' in the Browser '"+browserName+"' successfully","Passed");
                        
    	} 
        catch (Exception e) 
        {    
        	e.printStackTrace();
        }
	
		
	}
	
	public static void OpenApplicationSeleniumGrid(String browserName, String URL) throws UnknownHostException {
		//deleteTempFile();
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		try
		{
			Constant.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception during Remote WebDriver creation : "+e.getMessage());
			e.printStackTrace();
		}
		/*
		
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\WebDriver\\geckodriver.exe");
            Constant.driver= new FirefoxDriver();
} else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.SafariDriver.driver", "E:\\WebDriver\\SafariDriver.exe");
            Constant.driver = new SafariDriver();
} else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\WebDriver\\chromedriver.exe");
            Constant.driver= new ChromeDriver();
} else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "E:\\WebDriver\\IEDriverServer.exe");
            Constant.driver =  new InternetExplorerDriver();
           //Constant.driver.manage().deleteAllCookies();
} else if (browserName.equalsIgnoreCase("Opera")) {
			String path= "E:\\WebDriver\\operadriver.exe";
			OperaOptions options = new OperaOptions();
			options.setBinary("E:\\Workspace_Automation\\Projects\\Broadway\\Opera\\56.0.3051.104\\opera.exe");
			System.setProperty("webdriver.opera.driver", path);
			Constant.driver = new OperaDriver(options);
} else if (browserName.equalsIgnoreCase("Edge")) {
            //System.setProperty("webdriver.edge.driver", "E:\\Globe Selenium\\Selenium Installation Material\\WebDriver\\MicrosoftWebDriver.exe");
            Constant.driver = new EdgeDriver();

}

*/
        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().window().maximize();

        try 
        {
            Constant.driver.get(URL);            
            Generic.WriteTestData("Open the Browser and URL",browserName,URL,"Able to Open the URL '"+URL+"' in Browser '"+browserName+"'","Opened  the URL '"+URL+"' in the Browser '"+browserName+"' successfully","Passed");
                        
    	} 
        catch (Exception e) 
        {    
        	e.printStackTrace();
        }
	}
	
	
	
	public static void scrollright(String PageName, String locator) {
		 Constant.PageName=PageName;
		 Constant.locator=locator;
		 WebElement element = findElement(PageName,locator);
	   try {
			if (element != null) {
				JavascriptExecutor js = (JavascriptExecutor) Constant.driver; 
				//js.executeScript("arguments[0].scrollTop = arguments[1];",element, 250);
				js.executeScript("window.scrollBy(250,0)");
				Thread.sleep(1000); 
				System.out.println("Scrolled");
				Generic.WriteTestData("Able to Scroll '"+locator+"'",locator,"","Able to Scroll  '"+locator+"'","Successfully scroll operation is performed","Passed");
			}
			else {
				System.out.println("Not Scrolled");
				Generic.WriteTestData("Not Able to Scroll '"+locator+"'",locator,"","Not Able to Scroll '"+locator+"'","Scroll operation is not performed","Failed");
			}
			element = null;		

		} catch (Exception e) {
			System.out.println(" Error occured whlie click on the element "
					+ locator + " *** " + e.getMessage());
		}
	}

	
	
	
	public static void OpenApplication2(String browserName, String URL) throws UnknownHostException {
		//deleteTempFile();
		
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\WebDriver\\geckodriver.exe");
            Constant.driver= new FirefoxDriver();
} else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.SafariDriver.driver", "C:\\WebDrivers\\SafariDriver.exe");
            Constant.driver = new SafariDriver();
} else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAVYA\\Documents\\Automation\\WebDriver\\Chrome\\chromedriver.exe");
            Constant.driver= new ChromeDriver();
} else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "D:\\Selenium\\WebDriver\\IEDriverServer.exe");
            Constant.driver =  new InternetExplorerDriver();
           //Constant.driver.manage().deleteAllCookies();
} else if (browserName.equalsIgnoreCase("Opera")) {
OperaOptions options = new OperaOptions();
options.setBinary("C:\\Users\\KT00363653\\AppData\\Local\\Programs\\Opera\\56.0.3051.104\\opera.exe");
System.setProperty("webdriver.opera.driver", "D:\\Selenium\\WebDriver\\operadriver.exe");
Constant.driver = new OperaDriver(options);
} else if (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "D:\\Selenium\\WebDriver\\MicrosoftWebDriver.exe");
            Constant.driver = new EdgeDriver();

}
        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().deleteAllCookies();
        Constant.driver.manage().window().maximize();
        //return driver;
        //Added By Ankit
        try {
                        //Thread.sleep(10000);
                        Constant.driver.get(URL);            
                        Generic.WriteTestData("Open the Browser and URL",browserName,URL,"Able to Open the URL '"+URL+"' in Browser '"+browserName+"'","Opened  the URL '"+URL+"' in the Browser '"+browserName+"' successfully","Passed");
                        } catch (Exception e) {    
        }
	}
	public static void highlightElement(WebDriver driver, WebElement element) {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "border: 1px solid DeepPink;");
 	}
	
	
	
	
	
	public static WebElement findElement(String PageName, String locatorName)   {
		
		String locator,locatorTag,objectLocator;
		if (locatorName != null) {
			locator= Constant.Map.get(PageName).get(locatorName);
			String[] arrLocator = locator.split("#");
			 locatorTag = arrLocator[0].trim();
			 objectLocator = arrLocator[1].trim();
			 System.out.println(locatorTag);
			 System.out.println(objectLocator);
			 //System.out.println("ExecutionStarted");			
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					Constant.webelement = Constant.driver.findElement(By.id(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else if (locatorTag.equalsIgnoreCase("name")) {
					Constant.webelement = Constant.driver.findElement(By.name(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					Constant.webelement = Constant.driver.findElement(By.xpath(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					Constant.webelement = Constant.driver.findElement(By.linkText(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else if (locatorTag.equalsIgnoreCase("Text")) {
					Constant.webelement = Constant.driver.findElement(By.partialLinkText(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else if (locatorTag.equalsIgnoreCase("class")) {
					Constant.webelement = Constant.driver.findElement(By.className(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else if (locatorTag.equalsIgnoreCase("tagName")) {
					Constant.webelement = Constant.driver.findElement(By.tagName(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);	
				} else if (locatorTag.equalsIgnoreCase("css")) {
					Constant.webelement = Constant.driver.findElement(By.cssSelector(objectLocator));
					highlightElement(Constant.driver, Constant.webelement);
				} else {
					String error = "Please Check the Given Locator Syntax :"+ locator;
					error = error.replaceAll("'", "\"");
					return null;
				}
				 Actions actions = new Actions(Constant.driver);
				actions.moveToElement(Constant.webelement);
				try
				{
					actions.perform();
				}
				catch (Exception e) {}
			} catch (Exception exception) {
				exception.printStackTrace();
				/*String error = "Please Check the Given Locator Syntax :"
						+ locator;
				error = error.replaceAll("'", "\"");
								exception.printStackTrace();*/
				return null;
			}
		}

		return Constant.webelement;
	}
	public static String getAttribute(String PageName,String locator, String attributeName) {
		String attributeValue = null;
		try {

			WebElement element = findElement( PageName,locator);
			if (element != null)
				attributeValue = element.getAttribute(attributeName);
			element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return attributeValue;
	}
	public static void enterText(String PageName, String locator, String value) throws Exception {
		Constant.PageName=PageName;
		Constant.locator=locator;
		try {
			WebElement element = findElement(PageName,locator);
			if (element != null) {
				Capabilities caps = ((RemoteWebDriver) Constant.driver).getCapabilities();
				  String browserName = caps.getBrowserName();			
				if (browserName.equalsIgnoreCase("internet explorer")) {	
					element.sendKeys(value);
					//JavascriptExecutor js = (JavascriptExecutor) Constant.driver;	
					//js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, "value",value);
				}
				else
				{
					element.clear();
					element.sendKeys(value);
				}
				if(locator.toLowerCase().contains("password"))
				{
			       value=value.replace(value, "*********");
				}
					Generic.WriteTestData("Entering text '"+value+"' in '"+locator+"' text field",locator,value,"Should able to enter data'"+value+"' into  '"+locator+"' text field","Entered data'"+value+"' into  '"+locator+"' text field successfully","Passed");
			}else {
				Generic.WriteTestData("Entering text '"+value+"' in '"+locator+"' text field",locator,value,"Unable to identify the '"+locator+"' text field","Not able to identify the  '"+locator+"' text field","Failed");
			}
			
			element = null;
		} catch (Exception e) {
			Generic.WriteTestData("Entering text '"+value+"' in '"+locator+"' text field",locator,value,"Should able to enter data'"+value+"' into  '"+locator+"' text field","Not able to enter data'"+value+"' into  '"+locator+"' text field successfully","Failed");
			e.printStackTrace();
		}
		
	}
	public static void click(String PageName, String locator) throws Exception {
		Constant.PageName=PageName;
		Constant.locator=locator;
		
		try {
			WebElement element = findElement(PageName,locator);
			if (element != null) {
				element.click();	
				Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' button.","Clicked on '"+locator+"' button.","Passed");
			}
			else {
				Generic.WriteTestData("Click on '"+locator+"'",locator,"","Element should be available '"+locator+"' button.","Element was not found  '"+locator+"'","Failed");
			}
			element = null;		

		} catch (Exception e) {
			e.printStackTrace();
			Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' button.","Clicking on '"+locator+"' button is unsuccessful.","Failed");
			System.out.println(" Error occured whlie click on the element "
					+ locator + " *** " + e.getMessage());
			
		}
		
	}
	
	public static void hover(String PageName, String locator) throws Exception {
		Constant.PageName=PageName;
		Constant.locator=locator;
		
		try {
			WebElement element = findElement(PageName,locator);
			Actions action = new Actions(Constant.driver);
			if (element != null) {
				action.moveToElement(element).build().perform();
				Generic.WriteTestData("Hover on '"+locator+"'",locator,"","Able to Hover on '"+locator+"' button.","Hovered on '"+locator+"' .","Passed");
			}
			else {
				Generic.WriteTestData("Hover on '"+locator+"'",locator,"","Element should be available '"+locator+"' .","Element was not found  '"+locator+"'","Failed");
			}
			element = null;		

		} catch (Exception e) {
			Generic.WriteTestData("Hover on '"+locator+"'",locator,"","Able to Hover on '"+locator+"' .","Hover on '"+locator+"'  is unsuccessful.","Failed");
			System.out.println(" Error occured whlie Hover on the element "
					+ locator + " *** " + e.getMessage());
			
		}
		
	}
	
	public static void GoToUrl(String url) {
		try {
			Constant.driver.get(url);			
			} catch (Exception e) {

		}
	}
	public static void listSelect(String PageName, String locator, String listValue) {
		Constant.PageName=PageName;
		Constant.locator=locator;
		
		try {
			WebElement element = findElement(PageName,locator);
		
			if (element != null) {
				Select dropdown= new Select(element);
				dropdown.selectByVisibleText(listValue);
				element.click();			
				Generic.WriteTestData("select from '"+locator+"'",locator,"","Able to select '"+listValue+"' from '"+locator+ "'" ,"Able to select '"+listValue+"' from '"+locator ,"Passed");
			}
			else {
				
				Generic.WriteTestData("select from '"+locator+"'",locator,"","Able to select '"+listValue+"' from '"+locator+ "'" ,"Not able to select '"+listValue+"' from '"+locator ,"Failed");
			}
			element = null;		

		} catch (Exception e) {
			System.out.println(" Error occured whlie click on the element "
					+ locator + " *** " + e.getMessage());
			
		}
		
	}
	public static void Checkbox(String PageName, String locator, String CheckBoxVal) {
		Constant.PageName=PageName;
		Constant.locator=locator;
		boolean boxVal ;
		if (CheckBoxVal == "ON") {
			boxVal = true;
		}
		else {
				boxVal = false;
		}
		
		boolean bValue = false;
		try {
			WebElement element = findElement(PageName,locator);
			
			//WebElement element = findElement(PageName,locator);
			if (element != null) {
				bValue =  element.isSelected();
				if (bValue != boxVal) {
					element.click();	
				}
				Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' Checkbox/RadioButton.","Clicked on '"+locator+"' Checkbox/RadioButton.","Passed");
			}
			else {
				
				Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' Checkbox/RadioButton.","Clicking on '"+locator+"' Checkbox/ is unsuccessful.","Failed");
			}
			element = null;		

		} catch (Exception e) {
			System.out.println(" Error occured whlie click on the element "
					+ locator + " *** " + e.getMessage());
			
		}
		
	}	
	public static void RadioButton(String PageName, String locator) {
		Constant.PageName=PageName;
		Constant.locator=locator;
		//System.out.println("inside radio button Function");
		//System.out.println(locator);
		try {
			WebElement element = findElement(PageName,locator);
			System.out.println(element);
			

			if (element != null) {
				element.click();	
				Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' button.","Clicked on '"+locator+"' button.","Passed");
			}
			else {
				
				Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' button.","Clicking on '"+locator+"' button is unsuccessful.","Failed");
			}
			element = null;		

		} catch (Exception e) {
			System.out.println(" Error occured whlie click on the element "
					+ locator + " *** " + e.getMessage());
			
		}
	}

	public static void compareText(String PageName,String locator,String ExpectedText) throws Exception{
        Thread.sleep(5000);
         Constant.PageName=PageName;
        Constant.locator=locator;
        String text = null;
        
         WebElement element = findElement(PageName,locator);      
         if(element==null)
         {
        	 element = findElement(PageName,locator); 
         }
        try {
            if (element != null)                
                text = element.getText();
            if(ExpectedText.equals(text)) {
                Generic.WriteTestData("Comparing text of field '"+locator+"' in Page '"+PageName,locator,ExpectedText,"The ExpectedText '"+ExpectedText+"' should be equal to Actual text from Application","The ExpectedText '"+ExpectedText+"' is same as the Acutal Text '"+text+"'","Passed");
            }
            else if(text.contains(ExpectedText)) {
                Generic.WriteTestData("Comparing text of field '"+locator+"' in Page '"+PageName,locator,ExpectedText,"The ExpectedText '"+ExpectedText+"' should be equal to Actual text from Application","The ExpectedText '"+ExpectedText+"' is same as the Acutal Text '"+text+"'","Passed");
            }
            else
            {
            	//Control.takeScreenshot();
            	Generic.WriteTestData("Comparing text of field '"+locator+"' in Page '"+PageName,locator,ExpectedText,"The ExpectedText '"+ExpectedText+"' should be equal to Actual text from Application","The ExpectedText '"+ExpectedText+"' is not same as the Acutal Text '"+text+"'","Failed");
            }
            
        }catch (Exception e) {
        	//Control.takeScreenshot();
        	Generic.WriteTestData("Comparing text of field '"+locator+"' in Page '"+PageName,locator,ExpectedText,"The ExpectedText '"+ExpectedText+"' should be equal to Actual text from Application","The ExpectedText '"+ExpectedText+"' is not same as the Acutal Text '"+text+"'","Failed");
            e.printStackTrace();
        }
        element = null;
        
        
    }    
    public static void objProperty(String PageName,String locator,String ExpectedPropertyToBeVerified, String ExpectedPropertyValue) {
        Constant.PageName=PageName;
        Constant.locator=locator;
        String text = null;
    
        WebElement element = findElement(PageName,locator);
        try {
            if (element != null)    
            
                text = element.getAttribute(ExpectedPropertyToBeVerified);
            if(ExpectedPropertyValue.equalsIgnoreCase(text)) {
                Generic.WriteTestData("Comparing property of field '"+locator+"' in Page '"+PageName+"'",locator,ExpectedPropertyValue,"The Expected property '"+ExpectedPropertyValue+"' should be equal to Actual property from Application","Acutal Property '"+text+"' equals to Expected Property '"+ExpectedPropertyValue+"'","Passed");
            }
            
            else
            {
                takeScreenshot();
                Generic.WriteTestData("Comparing property of field '"+locator+"' in Page '"+PageName+"'",locator,ExpectedPropertyValue,"The Expected property '"+ExpectedPropertyValue+"' should be equal to Actual property from Application","Acutal property '"+text+"' is NOT equals to Expected property '"+ExpectedPropertyValue+"'","Failed");
            }            
        }catch (Exception e) {
            e.printStackTrace();
        }
        element = null;
    }
 /*   public static void objExists(String PageName,String locator,boolean ExistsOnPage) throws Exception {
        
        Constant.PageName=PageName;
        Constant.locator=locator;
        boolean text;
        WebElement element = findElement(PageName,locator);
        try {
            //if (element != null)   
            	text = element.isDisplayed();
                //text = element.getAttribute("aria-disabled");
            if(ExistsOnPage) {
                if(text= true) {
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be visible on the Application","'"+locator+"' is visbile on the page '"+PageName+"'","Passed");    
                }
                else
                {
                    takeScreenshot();
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be visible on the Application","'"+locator+"' is Not visbile on the page '"+PageName+"'","Failed");
                }                
            }            
            else
            {
                if(text = true) {
                    takeScreenshot();
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should not be visible on the Application","'"+locator+"' is visbile on the page '"+PageName+"'","Failed");
                }
                else
                {
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should not be visible on the Application","'"+locator+"' is not visbile on the page '"+PageName+"'","Passed");
                }
                
            }        
        }catch (Exception e) {
            e.printStackTrace();
            Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be visible on the Application","'"+locator+"' is Not visbile on the page '"+PageName+"'","Failed");
            
        }
        element = null;
    }*/
    
    
public static boolean objExists(String PageName,String locator,boolean ExistsOnPage) throws Exception  {
        System.out.println("ExecutionStarting");
        Constant.PageName=PageName;
        Constant.locator=locator;
        boolean text=false;
        WebElement element = findElement(PageName,locator);
        try {
           if (element != null)   
             text = element.isDisplayed();
                //text = element.getAttribute("aria-disabled");
            if(ExistsOnPage) {
                if(text== true) {
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be visible on the Application","'"+locator+"' is visbile on the page '"+PageName+"'","Passed");    
                    return true;
                }
                else
                {
                    takeScreenshot();
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be visible on the Application","'"+locator+"' is Not visbile on the page '"+PageName+"'","Failed");
                    return false;
                }                
            }            
            else
            {
                if(text == true) {
                    takeScreenshot();
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should not be visible on the Application","'"+locator+"' is visbile on the page '"+PageName+"'","Failed");
                    return true;
                }
                else
                {
                    Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should not be visible on the Application","'"+locator+"' is not visbile on the page '"+PageName+"'","Passed");
                    return false;
                }
                
            }        
            
           }catch (Exception e) {
             Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be visible on the Application","'"+locator+"' is not visbile on the page '"+PageName+"'","Failed");
            e.printStackTrace();
        }
        element = null;
		return false;
        
}

    public static String HandleWebAlert(boolean Accept) throws Exception{
    	Thread.sleep(20000);
        Alert alert = Constant.driver.switchTo().alert();
        String textonalert = alert.getText();
        if(Accept) { 
            alert.accept();
//            Generic.WriteTestData("Check visibility of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should not be visible on the Application","'"+locator+"' is not visbile on the page '"+PageName+"'","Passed");
        }
        else
        {
            alert.dismiss();
        }
        return textonalert;
        
    }
    public static void takeScreenshot()throws Exception {
    	takeScreenshot(Constant.DefaultoptionalFlag);
    }
    public static void takeScreenshot(boolean optionalFlag)throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date= new Date();
		String Date1 = dateFormat.format(date);
		DateFormat dateFormat1 = new SimpleDateFormat("HHMMSS");
		Date date2= new Date();
		String screenshotFilePath;
		String Date3 = dateFormat1.format(date2); 		
		 screenshotFilePath=Constant.ScreenshotFolderName+File.separator+Constant.PageName+"_" + Constant.locator + "_"+Date1+"_"+Date3+".png";
		Constant.RecentScreenshot = Constant.PageName+"_" + Constant.locator + "_"+Date1+"_"+Date3+".png";
		try{                                        
	        TakesScreenshot scrShot = ((TakesScreenshot)Constant.driver);
	        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile = new File(screenshotFilePath);
	        FileHandler.copy(srcFile,DestFile);	        
			    if(optionalFlag) {
			        Generic.setScreenshothyperlink(screenshotFilePath);}
			    else {
			    	Constant.DefaultoptionalFlag = true;
			    	
			    }
	         }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   /* public static void LaunchMobileApp(String BrowserName,String Version, String deviceName, String platformName, String appPackage, String appActivity,String ServerIP, String HostID, String URL ) throws Exception{
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        if(!BrowserName.equals("")) {
        	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserName);
        }

        //capabilities.setCapability("acceptInsecureCerts", true);
       // capabilities.setCapability("acceptSslCerts", true);
        if(!appPackage.equals("")) {
        capabilities.setCapability("appPackage",appPackage );
        capabilities.setCapability("appActivity",appActivity);
        }   
        capabilities.setCapability("noReset", true);
        Constant.driver = new AndroidDriver(new URL("http://"+ServerIP+":"+HostID+"/wd/hub"), capabilities);
        Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);    
        if(!BrowserName.equals("")) {
        	Constant.driver.get(URL);
        }
         
    }*/
    
    public static String getMessageContent(String PageName, String locator) {
    	 Constant.PageName=PageName;
         Constant.locator=locator;
         String Messagecontent = null;
         WebElement element = findElement(PageName,locator);
         try {
 			if (element != null) {
 				Messagecontent = element.getText();	
 				Generic.WriteTestData("Able to get the text '"+locator+"'",locator,"","Able to fetch  '"+locator+"'","text value is : "+Messagecontent,"Passed");
 			}
 			else {
 				
 				Generic.WriteTestData("Not Able to get the text '"+locator+"'",locator,"","Not Able to fetch  '"+locator+"'","text value is not found :","Failed");
 			}
 			element = null;		

 		} catch (Exception e) {
 			System.out.println(" Error occured whlie click on the element "
 					+ locator + " *** " + e.getMessage());
 			
 		}
		return Messagecontent;
    	    	
    }
    
	/*public static void DriverScriptForUSSD(int TotalTestCases) throws Exception {    	
			String InputValue=null;
			String CheckValue=null; 
			String InputValue2 = null;
			for(int RowNo=1; RowNo<=TotalTestCases;RowNo++) {
				Generic.WriteTestCase(Constant.Map2.get("TestCase"+ RowNo).get("TestCaseNo"), Constant.Map2.get("TestCase"+ RowNo).get("TestCaseName"), Constant.Map2.get("TestCase"+ RowNo).get("Expected_result"), Constant.Map2.get("TestCase"+ RowNo).get("Actual Result"));
				click("DialerApp", "btnNumbers");    		
				for(int Col_input= 1; Col_input<=20; Col_input++) {
					InputValue=Constant.Map2.get("TestCase"+ RowNo).get("Input_"+Col_input);
					
					if(InputValue.equals("")) {
						break;
						}
					WebElement element = findElement("DialerApp","tfldDialling");
					if (element != null) { 
							enterText("DialerApp","tfldDialling",InputValue);
							takeScreenshot();
							click("DialerApp","tfldDialling");
							click("DialerApp","btnDialler");
							takeScreenshot();
						}else{
						  	click("DialerApp","Input_field");
							enterText("DialerApp","Input_field",InputValue);
							takeScreenshot();
							click("DialerApp","SendButton");
						    takeScreenshot();
					    }	
					    
						CheckValue=Constant.Map2.get("TestCase"+ RowNo).get("CheckPoint_"+Col_input);
						System.out.println("\n************\n"+CheckValue+"\n************\n");
						compareText("DialerApp_Response","txtOutputMessage",CheckValue);
						takeScreenshot();
					}	  
						WebElement element = findElement("DialerApp","okButton");
					if (element==null) {
						element = findElement("DialerApp","okButton");	
					}
					if (element != null) {
						click("DialerApp","okButton");
					}
					else {
						click("DialerApp","CancelButton");
					     }
					//write 
					
					String Unsubscribe_KW = Constant.Map2.get("TestCase"+ RowNo).get("Unsubscribe_Via_SMS");
					String Notification = Constant.Map2.get("TestCase"+ RowNo).get("SMS_Notification");
					
					if(Unsubscribe_KW != "") {
						Control.LaunchMobileApp("", "8.1.0", "OnePlus5T", "Android", "com.android.mms", "com.android.mms.ui.ConversationList", "10.225.138.136", "4723","");
						Control.click("MessageNotification", "messgeMenu");
						Control.enterText("MessageNotification", "messageEditBox", Unsubscribe_KW);
						Control.click("MessageNotification", "messageSendButton");
						Thread.sleep(1000);
						Control.compareText("MessageNotification", "messagetext", Notification);
					}else {
						Control.LaunchMobileApp("", "8.1.0", "OnePlus5T", "Android", "com.android.mms", "com.android.mms.ui.ConversationList", "10.225.138.136", "4723","");
						Control.click("MessageNotification", "messgeMenu");
						Control.compareText("MessageNotification", "messagetext", Notification);
						//Control.getMessageContent("MessageNotification", "messagetext");
					}
						Generic.TestScriptEnds();
						Thread.sleep(10000);
			}
		}*/
    
	/*public static void DriverScriptForUSSD1(int TotalTestCases) throws Exception {    	
		String InputValue=null;
		String CheckValue=null; 
		String InputValue2 = null;
		for(int RowNo=1; RowNo<=TotalTestCases;RowNo++) {
			Generic.WriteTestCase(Constant.Map2.get("TestCase"+ RowNo).get("TestCaseNo"), Constant.Map2.get("TestCase"+ RowNo).get("TestCaseName"), Constant.Map2.get("TestCase"+ RowNo).get("Expected_result"), Constant.Map2.get("TestCase"+ RowNo).get("Actual Result"));
			String Unsubscribe_KW = Constant.Map2.get("TestCase"+ RowNo).get("Unsubscribe_Via_SMS");
			String Notification = Constant.Map2.get("TestCase"+ RowNo).get("SMS_Notification");
			if(Unsubscribe_KW != "") {
				LaunchMobileApp("",Generic.ReadFromExcel("DeviceDetails","AI_TestData",1),Generic.ReadFromExcel("DeviceDetails","AI_TestData",2) , "Android", Generic.ReadFromExcel("DeviceDetails","AI_TestData",3), Generic.ReadFromExcel("DeviceDetails","AI_TestData",4),Generic.ReadFromExcel("DeviceDetails","AI_TestData",5) , "4723","");
				Control.click("MessageNotification", "messageSenderIcon");
				Control.enterText("MessageNotification", "noEnterText", "8080");
				Control.enterText("MessageNotification", "messageEditBox", Unsubscribe_KW);
				Control.click("MessageNotification", "messageSendButton");
				takeScreenshot();
//				 TouchAction Ac = new TouchAction(Constant.driver);
//				 Ac.longPress(Constant.driver.findElementByXPath("\\android.widget.TextView[@text='"+Unsubscribe_KW+"']")).release().perform();
				//longPress("MessageNotification", "messagetext");
				Control.click("MessageNotification", "deleteMessage");
				Control.click("MessageNotification", "deleteConfirmation");
				Thread.sleep(6000);
				//Control.click("MessageNotification", "messgeMenu");
				Control.compareText("MessageNotification", "messagetext", Notification);
				takeScreenshot();
				longPress("MessageNotification", "messagetext");
				Control.click("MessageNotification", "deleteMessage");
				Control.click("MessageNotification", "deleteConfirmation");
			}else {
//				Date date= new Date();
//		    	long time1 = date.getTime();
//		    	Timestamp ts = new Timestamp(time1);
				LaunchMobileApp("", Generic.ReadFromExcel("DeviceDetails","AI_TestData",1),Generic.ReadFromExcel("DeviceDetails","AI_TestData",2), "Android", "com.simpler.dialer", "com.simpler.ui.activities.ContactsAppActivity", Generic.ReadFromExcel("DeviceDetails","AI_TestData",5), "4723","");
				click("DialerApp", "DialPad"); 
				for(int Col_input= 1; Col_input<=20; Col_input++) {
					InputValue=Constant.Map2.get("TestCase"+ RowNo).get("Input_"+Col_input);
					if(InputValue.equals("")) {
						break;
						}
					WebElement element = findElement("DialerApp","Dialer");
					if (element != null) { 
							enterText("DialerApp","Dialer",InputValue);
							takeScreenshot();
							click("DialerApp","Dialer");
							click("DialerApp","btnDialler");
							takeScreenshot();
						}else{
						  	click("DialerApp","InputOption");
							enterText("DialerApp","InputOption",InputValue);
							takeScreenshot();
							click("DialerApp","Send");
						    takeScreenshot();
					    }	
						CheckValue=Constant.Map2.get("TestCase"+ RowNo).get("CheckPoint_"+Col_input);
						//System.out.println("\n************\n"+CheckValue+"\n************\n");
						compareText("DialerApp_Response","txtOutputMessage",CheckValue);
						takeScreenshot();
					}	
					WebElement element = findElement("DialerApp","ok");
					if (element==null) {
						element = findElement("DialerApp","ok");	
					}
					if (element != null) {
						click("DialerApp","ok");
					}
					else {
						click("DialerApp","Cancel");
					     }	
				Control.LaunchMobileApp("",Generic.ReadFromExcel("DeviceDetails","AI_TestData",1),Generic.ReadFromExcel("DeviceDetails","AI_TestData",2), "Android", Generic.ReadFromExcel("DeviceDetails","AI_TestData",3), Generic.ReadFromExcel("DeviceDetails","AI_TestData",4), Generic.ReadFromExcel("DeviceDetails","AI_TestData",5), "4723","");
				Control.click("MessageNotification", "messgeMenu");
				Control.compareText("MessageNotification", "messagetext", Notification);
				takeScreenshot();
				longPress("MessageNotification", "messagetext");
				Control.click("MessageNotification", "deleteMessage");
				Control.click("MessageNotification", "deleteConfirmation");
			}		
			Generic.TestScriptEnds();
			Thread.sleep(10000);
		}
	}*/
	
	public static void scroll(String PageName, String locator) {
		 Constant.PageName=PageName;
         Constant.locator=locator;
         WebElement element = findElement(PageName,locator);
         try {
 			if (element != null) {
 				JavascriptExecutor js = (JavascriptExecutor) Constant.driver; 
 				//js.executeScript("arguments[0].scrollTop = arguments[1];",element, 250);
 				js.executeScript("window.scrollBy(0,250)");
 				Thread.sleep(1000); 
 				Generic.WriteTestData("Able to Scroll '"+locator+"'",locator,"","Able to Scroll  '"+locator+"'","Successfully scroll operation is performed","Passed");
 			}
 			else {
 				
 				Generic.WriteTestData("Not Able to Scroll '"+locator+"'",locator,"","Not Able to Scroll '"+locator+"'","Scroll operation is not performed","Failed");
 			}
 			element = null;		

 		} catch (Exception e) {
 			System.out.println(" Error occured whlie click on the element "
 					+ locator + " *** " + e.getMessage());
 			
 		}
	}

	
	public static void longPress(String PageName, String locator) {
//		Constant.PageName=PageName;
//        Constant.locator=locator;
//        WebElement element = findElement(PageName,locator);
//        //uncomment for mobile device testing
//        TouchAction Ac = new TouchAction(Constant.driver);
//        
//        try {
//			if (element != null) {
//				Ac.longPress(element).release().perform();
//				//Generic.WriteTestData("Able to get the text '"+locator+"'",locator,"","Able to fetch  '"+locator+"'","text value is : "+Messagecontent,"Passed");
//			}
//			else {
//				
//				//Generic.WriteTestData("Not Able to get the text '"+locator+"'",locator,"","Not Able to fetch  '"+locator+"'","text value is not found :","Failed");
//			}
//			element = null;		
//
//		} catch (Exception e) {
//			System.out.println(" Error occured whlie click on the element "
//					+ locator + " *** " + e.getMessage());
//			
//		}
//		
	}
	
	public static void GeneratePDFReport() throws Exception
	{
		String excel_path=Constant.ResultFilePath.substring(0,Constant.ResultFilePath.lastIndexOf("\\"))+"\\";
		System.out.println("Path to Result : "+excel_path);
        JavaReport jr=new JavaReport();
        //jr.qTestReportUpdate(excel_path);
        jr.GenerateReport(Constant.path_to_python_scripts, Constant.ResultFilePath, excel_path, Constant.ResultFilePath, "Report_Test_Summary"+".pdf");
		JavaReport.GenerateJunitReport(Constant.ResultFilePath);
	}

    public static void GenerateJunitReport(String path_to_input_excel)
    {
    	Constant.WorkSpace = System.getProperty("user.dir");
    	String python_command="python.exe createJUnitReport.py "+ Constant.ProjectName +" DevopsTCsTest "+ path_to_input_excel +" JunitReport.xml";
                   try
                    {               	   
                	   Constant.WorkSpace=URLDecoder.decode(Constant.WorkSpace, "UTF-8");
                        System.out.println("Path to python script : "+Constant.WorkSpace);
                        python_command=URLDecoder.decode(python_command, "UTF-8");
                         System.out.println("Python command: "+python_command);
                    }
                catch(Exception e)
                    {
                            System.out.println("Exception while setting Python Path : "+e.getMessage());
                            System.exit(-1);
                    }
        
        
                ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd "+Constant.WorkSpace+" && "+python_command);
                builder.redirectErrorStream(true);
                try
                {
                							String line=null;
                							builder.directory(new File(Constant.WorkSpace));
                                            Process p = builder.start();
                                            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                                            System.out.println("Buffered Reader : "+r.readLine());

                                            while (true) 
                                            {
                                                try
                                                {
                                                    line =r.readLine();
                                                    if(line==null)
                                                        break;

                                                    System.out.println(""+line);
                                                }

                                                catch(Exception e)
                                                {
                                                    System.out.println("Execption while receiving output from Python Script : "+e.getMessage());
                                                    break;
                                                }
                                            }

                    

                }
                catch(Exception e)
                {
                    System.out.println("Exception while triggering process to initialize PDF Generation Script  : "+e.getMessage());
                }    
    }

	
	public static String RunProcessWithOutput(String command,int timeout,Boolean returnOutput) 
    {String line="",line1="";
	try
	{
		ProcessBuilder builder = new ProcessBuilder(
		      "cmd.exe", "/c", command);
		  builder.redirectErrorStream(true);
		  Process p=builder.start();
		  p.waitFor(15,TimeUnit.SECONDS);
		 
		  if(p.isAlive())
		  {
			  System.out.println("Destryoing forcibly");
			  p.destroyForcibly();     
			  
		  }
		  
		  if(returnOutput)
		  {
			  
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                
                while (r.ready() && ((line1=r.readLine())!=null)) 
                {
                	
                	try
                	{
                		line+=line1+" ";
                	}
                    catch(Exception e)
                    {
                        System.out.println("Exception reading from prompt "+e.getMessage());
                        e.printStackTrace();
                        break;
                    }
                }
                //System.out.println("Returning from shell : "+line);
                
                if(line==null)
                {
                	line="";
                }
                
                try
                {
                	line=line.trim();
                }
                catch(Exception e)
                {
                	System.out.println("Exception RunProcessWithOutput() while trimming line. Line is <Start>"+line+"<end>");
                	e.printStackTrace();
                }
                return line;
		  
		  	}
	}
	catch(Exception e)
	{
		System.out.println("Exception in process of executing the following command : "+command+"\nException is : "+e.getMessage());
		e.printStackTrace();
	}
	//System.out.println("Returning : null");
	return null;
	
    }

	public static void ReadCookie()		
    {		
        		
        // create file named Cookies to store Login Information		
        File file = new File("Cookies.data");		
        for (String handle : Constant.driver.getWindowHandles()){	  	 
	  	    Constant.driver.switchTo().window(handle);}
        try		
        {  
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWrite = new FileWriter(file);							
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
            // loop for getting the cookie information 		
            	
            // loop for getting the cookie information 		
            for(Cookie ck : Constant.driver.manage().getCookies()){	
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()+";"+ck.isHttpOnly()));																									
                Bwrite.newLine();             
            }			
            Bwrite.close();			
            fileWrite.close();
            
        }
        catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }		
    }
	
	public static void AppendCookie(){		
    try{    
        File file = new File("Cookies.data");							
        FileReader fileReader = new FileReader(file);							
        BufferedReader Buffreader = new BufferedReader(fileReader);							
        String strline;			
        while((strline=Buffreader.readLine())!=null){									
        StringTokenizer token = new StringTokenizer(strline,";");									
        while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();					
	        Date expiry = null;					
	        		
	        String val;			
	        if(!(val=token.nextToken()).equals("null"))
			{		
	        	//expiry = new Date(val);	
	        	SimpleDateFormat DtSource = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
	            expiry = DtSource.parse(val);
	        }		
	        Boolean isSecure = new Boolean(token.nextToken()).booleanValue();		
	        Boolean isHTTP = new Boolean(token.nextToken()).booleanValue();
	        Cookie ck = new Cookie(name,value,domain,path,expiry,isHTTP,isSecure);			
	        //System.out.println(ck);
	        
	        Constant.driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
	        }		
        }		
        }catch(Exception ex){					
        ex.printStackTrace();			
        }	
			
	}
	
	public static void DragAndDropFile(String PageName, String locatorName, String path, String PageName_file, String locatorName_file) throws Exception{
		try {
		WebDriverWait wait = new WebDriverWait(Constant.driver,60);
	       final String JS_DROP_FILE =
	                       "var tgt=arguments[0],e=document.createElement('input');e.type='" +
	                       "file';e.addEventListener('change',function(event){var dataTrans" +
	                       "fer={dropEffect:'',effectAllowed:'all',files:e.files,items:{},t" +
	                       "ypes:[],setData:function(format,data){},getData:function(format" +
	                       "){}};var emit=function(event,target){var evt=document.createEve" +
	                       "nt('Event');evt.initEvent(event,true,false);evt.dataTransfer=da" +
	                       "taTransfer;target.dispatchEvent(evt);};emit('dragenter',tgt);em" +
	                       "it('dragover',tgt);emit('drop',tgt);document.body.removeChild(e" +
	                       ");},false);document.body.appendChild(e);return e;";


       WebElement droparea = Control.findElement(PageName, locatorName);
       JavascriptExecutor js = (JavascriptExecutor)Constant.driver;
       ((WebElement) js.executeScript(JS_DROP_FILE, new Object[]{droparea})).sendKeys(path);
       Thread.sleep(4000);
	   Boolean Loader = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("Loader")));
/*	   if(PageName_file!="" && locatorName_file!="")
	      {
	    	  			FluentWait_function(PageName_file, locatorName_file);
	                   String file_name = Control.findElement(PageName_file, locatorName_file).getText();
	                     if(file_name.equals(null))
	                     {
	                           Generic.WriteTestData("Drag and drop files", "", "", "Should be able to drag and drop files", "unable to atach file", "Failed");
	                           Control.takeScreenshot();
	                     }
	                     else
	                     {
	                           Generic.WriteTestData("Drag and drop files", "", "", "Should be able to drag and drop files", "Able to atach file and file name is:"+file_name, "Passed");
	                           Control.takeScreenshot();
	                     }
      }
	      else
	      {
	    	  System.out.println("uploaded file verification is not done here");
	      }
*/			}catch (Exception ex){
			ex.printStackTrace();
			Generic.WriteTestData("Drag and drop files", "", "", "Should be able to drag and drop files", "unable to atach file", "Failed");
            Control.takeScreenshot();
		}
	}

public static boolean FluentWait_function(final String PageName, final String locatorName) throws Exception
{
  try {	
	WebDriverWait wait = new WebDriverWait(Constant.driver, 100);
	wait.withTimeout(100, TimeUnit.SECONDS);
	wait.pollingEvery(5, TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.until(new ExpectedCondition<Boolean>(){
	    @Override
	    public Boolean apply(WebDriver driver) {
	        WebElement ele;
			try {
				ele = Control.findElement(PageName, locatorName);
				if(ele==null)
		        {
		            return false;
		        }
		        else
		        {
		            System.out.println("found");
		            return true;
		        }  
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
 
	    }
	});
  }catch (Exception e){
	  
  }
return false;
}

public static void WaitForLoader(long ShortDuration,long LongDuration) throws Exception{
	try {
		WebDriverWait wait = new WebDriverWait(Constant.driver,LongDuration);
		WebDriverWait shortwait = new WebDriverWait(Constant.driver,ShortDuration);
		Boolean IsLoader;
		WebElement Loader;
		try {
			 //Loader = shortwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'la-pacman')]")));
			Constant.driver.manage().timeouts().implicitlyWait(ShortDuration, TimeUnit.SECONDS);
		}catch (Exception e){e.printStackTrace();}		 
		//IsLoader = wait.until(ExpectedConditions.);
		Constant.driver.manage().timeouts().implicitlyWait(ShortDuration, TimeUnit.SECONDS);
		for(int i=0;i<LongDuration;i++) {
			try {
				IsLoader = Control.findElement("DashboardPage", "LoadingButton").isDisplayed();
			}catch(Exception E) {				
				break;
			}		
		}
		Constant.driver.manage().timeouts().implicitlyWait(Constant.defaultBrowserTimeOut, TimeUnit.SECONDS);
//		try {
//			 Loader = shortwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'la-pacman')]")));				 
//		}catch (Exception e){}	
	}catch (Exception ex){	System.out.println("LongWaitFaile");		
	}
}
public static void objStatus(String PageName,String locator,String Status) throws Exception  {
    Constant.PageName=PageName;
    Constant.locator=locator;
    boolean text=false;
    WebElement element =Control.findElement(PageName,locator);
    try {
      if(Status == "Enabled") {
        text = element.isEnabled();
       	System.out.println(text);
        if(text== true) {
        System.out.println("Enabled"); 
        Generic.WriteTestData("Check status of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be enabled on the Application","'"+locator+"' is enabled on the page '"+PageName+"'","Passed");    
        }else{
        Control.takeScreenshot();
        System.out.println("Not Enabled"); 
        Generic.WriteTestData("Check status of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be enabled on the Application","'"+locator+"' is Not enabled on the page '"+PageName+"'","Failed");
       }                
      }else{
       if(Status == "Disabled") {
         text = (!(element.isEnabled()));
         System.out.println(text);
         if(text == true) {
         Control.takeScreenshot();
         System.out.println("Not Disabled"); 
         Generic.WriteTestData("Check status of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be disabled on the Application","'"+locator+"' is not disabled on the page '"+PageName+"'","Failed");
         }else{
         System.out.println("Disabled"); 
         Generic.WriteTestData("Check status of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be disabled on the Application","'"+locator+"' is disabled on the page '"+PageName+"'","Passed");
         }
       }}        
       }catch (Exception e) {
         Generic.WriteTestData("Check status of locator '"+locator+"' in Page '"+PageName+"'",locator,"","'"+locator+"' should be enabled/disabled on the Application","'"+locator+"' is not enabled/disabled on the page '"+PageName+"'","Failed");
        e.printStackTrace();
    }
}

public static void LoadWait( long Shortwait, long Longwait) throws Exception {
	//Alert IsLoader;
	 try {
	WebDriverWait wait = new WebDriverWait(Constant.driver, Shortwait);
	wait.withTimeout(Longwait, TimeUnit.SECONDS);
	wait.pollingEvery(Shortwait, TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.until(new ExpectedCondition<Boolean>(){
	public Boolean apply(WebDriver driver) {
	      WebElement Element = driver.findElement(By.xpath("//div[contains(@class,'la-pacman')]"));
	             try {
						if(Element == null)
						{
						return false;
						}
						else
						{
						System.out.println("Element Present");
						return true;
						}  
	              	} catch (Exception e) {
	                   e.printStackTrace();
					      }
					      return true;   
	      }            
	      });
	wait.until(ExpectedConditions.alertIsPresent());
	System.out.println("Element Found");
	       }
	 catch (Exception e){
	       
	      System.out.println("Element Not Present");
	       return;
	       }
	      }

public static void WaitUntil(final String PageName, final String locatorName) throws Exception
{
  try {	
	WebDriverWait wait = new WebDriverWait(Constant.driver, 60);
	wait.withTimeout(60, TimeUnit.SECONDS);
	wait.pollingEvery(5, TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	wait.until(new ExpectedCondition<Boolean>(){
	    @Override
	    public Boolean apply(WebDriver driver) {
	        WebElement ele;
			try {
				ele = Control.findElement(PageName, locatorName);
				if(!(ele==null))
		        {
		            return false;
		        }
		        else
		        {
		            //System.out.println("found");
		            return true;
		        }  
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
 
	    }
	});
  }catch (Exception e){
	  return;
  }
}

public static void ScrollToView(String PageName, String locatorName) throws Exception
{
	WebElement element = Control.findElement(PageName, locatorName);
	JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
	js.executeScript("arguments[0].scrollIntoView(true);",element);  
}



public static void js_click(String PageName, String locator) throws Exception {
	Thread.sleep(3000);
	Constant.PageName=PageName;
	Constant.locator=locator;
	
	try {
		WebElement element = findElement(PageName,locator);
		if (element != null)
		{
			JavascriptExecutor js = (JavascriptExecutor) Constant.driver;  
	//Perform Click on LOGIN button using JavascriptExecutor    
			 js.executeScript("arguments[0].click();", element);
			
			 
			Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' button.","Clicked on '"+locator+"' button.","Passed");
		}
		else {
			Generic.WriteTestData("Click on '"+locator+"'",locator,"","Element should be available '"+locator+"' button.","Element was not found  '"+locator+"'","Failed");
		}
		element = null;		

	} catch (Exception e) {
		Generic.WriteTestData("Click on '"+locator+"'",locator,"","Able to click on '"+locator+"' button.","Clicking on '"+locator+"' button is unsuccessful.","Failed");
		System.out.println(" Error occured whlie click on the element "
				+ locator + " *** " + e.getMessage());
		
	}

}

public static WebElement regularFindElement(String PageName, String locatorName,int implicitTimeOut)   {
	//doesnt check for overlap 
	//doesnt swipe
		
	WebElement elem=null;
	try
	{
		setDriverTimeOut(implicitTimeOut);
		long startTime=System.currentTimeMillis();
		String locator="",locatorTag="",objectLocator="";
		if (locatorName != null) {
			if(PageName != "")
				locator= Constant.Map.get(PageName).get(locatorName);
			else
				locator= locatorName;
			String[] arrLocator = locator.split("#");

			try
			{
				 locatorTag = arrLocator[0].trim();
				 objectLocator = arrLocator[1].trim();
			}
			catch(Exception e)
			{
				e.printStackTrace();
//				Generic.WriteTestData("Incorrect Test Data", "", "", "locator Tag : "+locatorTag+" and object Locator : "+objectLocator+" shall exist in Object Repository", "locator Tag : "+locatorTag+" and object Locator : "+objectLocator+" does NOT exist in Object Repository", "Fail");
				
			}
			 
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					elem = Constant.driver.findElement(By.id(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("name")) {
					elem = Constant.driver.findElement(By.name(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					elem = Constant.driver.findElement(By.xpath(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					elem = Constant.driver.findElement(By.linkText(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("Text")) {
					elem = Constant.driver.findElement(By.partialLinkText(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("class")) {
					elem = Constant.driver.findElement(By.className(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("tagName")) {
					elem= Constant.driver.findElement(By.tagName(objectLocator));

				} else if (locatorTag.equalsIgnoreCase("css")) {
					elem = Constant.driver.findElement(By.cssSelector(objectLocator));

				} else {
					String error = "Please Check the Given Locator Syntax :"+ locator;
					error = error.replaceAll("'", "\"");
					Control.setDriverTimeOut(Constant.defaultBrowserTimeOut);
					return null;
				}
			} 
			catch (Exception e) 
			{
//				e.printStackTrace();
			}
		}
		long totalTime=System.currentTimeMillis()-startTime;
//		if(elem!=null)
//		{
//			highlightElement(Constant.driver, elem);
//		}
//		}
//
//    		System.out.println("Found Element: ["+elem+"] in ms : "+totalTime);
//			System.out.println("Element found at : "+elem.getLocation().getX()+","+elem.getLocation().getY());
//		}
		Control.setDriverTimeOut(Constant.defaultBrowserTimeOut);
	}	
	catch(Exception e)
	{Control.setDriverTimeOut(Constant.defaultBrowserTimeOut);}
	//Control.setDriverTimeOut(Constant.defaultBrowserTimeOut);
	return elem;

	}
public static void setDriverTimeOut(int timeInSeconds)
{
	try	{
//		System.out.println("\n[INFO] Setting Driver Timeout to : "+timeInSeconds);
		Constant.driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS); 
	}catch(Exception e)
	{
//		System.out.println("[ERROR] Unable to set Driver TimeOut");
		e.printStackTrace();
	}
}


public static void MovetoElement(String PageName, String locatorName) throws Exception{
	   Thread.sleep(2000);
	   Control.WaitForLoader(2,500);
	   try	{
	   Control.WaitForLoader(3,500);		
	   WebElement ele = Control.findElement(PageName, locatorName);
	   Actions actions = new Actions(Constant.driver);
	   actions.moveToElement(ele);
	   actions.perform();	
	   Control.WaitForLoader(3,500);
	   Control.takeScreenshot();
	   Generic.WriteTestData("Move to Element " ,"","","Should get moved to Element " +locatorName,"Moved to Element","Passed");
	   }catch(Exception e){
	   Generic.WriteTestData("Move to Element "+locatorName ,"","","Should get moved to Element " +locatorName,"Error in Moving to Element","Failed");
	   System.out.println("Exception "+e.getMessage());
	   e.printStackTrace();
	   }
	}
  












}
