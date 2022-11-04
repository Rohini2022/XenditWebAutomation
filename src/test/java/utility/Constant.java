/*
 *Description: Control Functions library 
'Author :Sunanda Tirunagari and Ankit Kumar
 */

package utility;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;*/

public class Constant {
	
	
	public static final String TestDataFilePath = "XenditTestData.xlsx";
	public static final String Environment = "SIT";
	public static HashMap<String, HashMap<String, String>> Value = new HashMap<String,HashMap<String,String>>();
//	public static final String PropertiesFilePath = TestDataFilePath;
	public static int SeqID = 1;
	public static int StepIndex = 0;
	public static int TestStepIndex = 0;
	public static int StepStatus = 0;
	public static int TestCaseIndex = 0;
	public static int TestCaseNumber = 0;
	public static int PassedCases = 0;
	public static int FailedCases = 0;
	public static HashMap<String, HashMap<String, String>> Map = new HashMap<String,HashMap<String,String>>();
	public static HashMap<String, HashMap<String, String>> Map2 = new HashMap<String,HashMap<String,String>>();
	public static final int defaultBrowserTimeOut = 50;
	public static String UserStoryName = null;
	public static String ResultFilePath = "";
	public static String ScreenshotFolderName = null;
	public static String strScenarioDesc=null;
	public static String strExpectedResult=null;
	public static String strActualResult=null;
	public static String PageName=null;
	public static String locator=null;
	public static String RecentScreenshot=null;
	public static WebDriver driver = null;
//	public static AppiumDriver driver = null;
//	public static AndroidDriver<MobileElement> driver = null;
	public static WebElement webelement;	
	public static boolean DefaultoptionalFlag = true;
	public static final String path_to_python_scripts="C:\\Python\\Python27_Excel_PDF\\";//"C:\\python\\QtestAPI\\qTestViaApi\\";//"C:\\PythonSetup\\PythonSetup\\Python27\\";"C:\\PythonSetup\\PythonSetup\\Python27_Excel_PDF\\Python27_Excel_PDF\\"C:\\Python27_Excel_PDF\\Python27_Excel_PDF\\"
	public static final String Device_Type="PC";
	public static final String ErrorFilePath = "";
	public static final String ProjectName = "Xendit";
	public static String WorkSpace = "C:\\Python\\Python27_Excel_PDF\\";//"C:\\python\\QtestAPI\\qTestViaApi\\";
	public static boolean exittest = false;
	public static boolean confirmPopUp = true;
	public static boolean confirmPopUp1 = true;
	public static boolean PurchaseconfirmPopUp = true;
	public static String MothersMN;


	
}
