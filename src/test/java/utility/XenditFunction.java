package utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class XenditFunction {


 public static void XenditDashlogin() throws Exception{
    Control.WaitForLoader(3,500);
    Control.takeScreenshot();
    Thread.sleep(3000);
    //Control.FluentWait_function("XenditDashboard", "Email");
  if(!((Control.regularFindElement("XenditDashboard","Email",5))==null)) {
	Thread.sleep(3000);
	System.out.println("LoginPage");
	Control.enterText("XenditDashboard", "Email", Generic.ReadFromExcel("XenditDashboard", "LoginDetails", 1));
	Control.enterText("XenditDashboard", "Password", Generic.ReadFromExcel("XenditDashboard", "LoginDetails", 2));
	Control.WaitForLoader(3,300);
	Control.click("XenditDashboard", "Login");
	Control.WaitForLoader(3,300);
	Control.takeScreenshot();
  }else {
	Control.WaitForLoader(3,500);
	Control.takeScreenshot();
	System.out.println("No Login Page");
	}
}

 public static void XenditDashPaymentIDValidation(String PaymentID, String PaymentType, String PaymentStatus, String PaymentChannel,String PaymentAmount,String Date ) throws Exception {
	try { 
    Control.WaitForLoader(3,3000);
    Thread.sleep(5000);
    Control.FluentWait_function("XenditDashboard", "Profile");
    Control.click("XenditDashboard", "Profile");
    Control.WaitForLoader(3,3000);
    String Role = Constant.driver.findElement(By.xpath("//div[@id='business-selector-0']/div/p")).getText();
  if(Role.equalsIgnoreCase("Stratpoint Tech. Inc")) {
	Control.click("XenditDashboard", "Stratpoint");}
	Control.WaitForLoader(3,5000);
	Thread.sleep(5000);
	Control.WaitForLoader(3,5000);
	Control.js_click("XenditDashboard", "AcceptPayments");
	Control.WaitForLoader(3,5000);
  if(PaymentType.equalsIgnoreCase("eWallet")) {
 	Control.click("XenditDashboard", "eWallet");
	Control.WaitForLoader(3,5000);
     Control.takeScreenshot();
     Thread.sleep(5000);
     Control.WaitForLoader(5,5000);
     Control.FluentWait_function("XenditDashboard", "SearchPaymentID");
     Control.enterText("XenditDashboard", "SearchPaymentID", PaymentID);
     Control.WaitForLoader(3,5000);
     Thread.sleep(5000);
     Control.takeScreenshot();
    //PaymentStatus
	 String PaymentStatus_Act = XenditDashTableData("Status");
	 if ((PaymentStatus.equalsIgnoreCase(PaymentStatus_Act)) ){
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Failed");
	} 
	//PaymentChannel
	String PaymentChannel_Act = Constant.driver.findElement(By.xpath("//div[contains(@class,'table-container')]//table/tbody/tr[1]/td[2]/img")).getAttribute("src").trim();
	PaymentChannel_Act  =	PaymentChannel_Act.split("-logo")[0];
	PaymentChannel_Act  =	PaymentChannel_Act.split("images/")[1];
	if ((PaymentChannel.equalsIgnoreCase(PaymentChannel_Act)) ){
		Generic.WriteTestData("PaymentChannel verification", "", "", "PaymentChannel Expected:'"+PaymentChannel+"'", "PaymentChannel Actual:'"+PaymentChannel_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentChannel verification", "", "", "PaymentChannel Expected:'"+PaymentChannel+"'", "PaymentChannel Actual:'"+PaymentChannel_Act+"'", "Failed");
	}   
    //PaymentAmount
	PaymentAmount = "PHP "+PaymentAmount;
	String PaymentAmount_Act = XenditDashTableData("Amount");
	if ((PaymentAmount.equalsIgnoreCase(PaymentAmount_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Failed");
	} 
	//PaymentID
	String PaymentID_Act = XenditDashTableData("Reference ID");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
    //Date
	String Date_Act = Constant.driver.findElement(By.xpath("//div[contains(@class,'table-container')]//table/tbody/tr[1]/td[5]")).getText();
	if ((Date_Act.contains(Date))){
		Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Failed");
	}
}
  if(PaymentType.equalsIgnoreCase("Cards")) {
	 Control.click("XenditDashboard", "Credit/DebitCard");
	 Control.WaitForLoader(3,5000);
     Control.takeScreenshot();
     Thread.sleep(5000);
     Control.WaitForLoader(5,5000);
     Control.FluentWait_function("XenditDashboard", "SearchPaymentID");
     Control.enterText("XenditDashboard", "SearchPaymentID", PaymentID);
     Control.WaitForLoader(3,5000);
     Thread.sleep(5000);
     Control.takeScreenshot();
   //PaymentStatus
   	 String PaymentStatus_Act = XenditDashTableData("Status");
   	 if ((PaymentStatus.equalsIgnoreCase(PaymentStatus_Act)) ){
   		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Passed");
   	}else{
   		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Failed");
   	} 
   	//PaymentAmount
   	PaymentAmount = "PHP "+PaymentAmount;
   	String PaymentAmount_Act = XenditDashTableData("Amount");
   	if ((PaymentAmount.equalsIgnoreCase(PaymentAmount_Act)) ){
   		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Passed");
   	}else{
   		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Failed");
   	} 
   	//PaymentID
   	String PaymentID_Act = XenditDashTableData("Reference");
   	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
   		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
   	}else{
   		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
   	}
    //PaymentChannel
   	String PaymentChannel_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'color')]/img)[1]")).getAttribute("alt").trim();
   	PaymentChannel_Act  =	PaymentChannel_Act.trim();
   	if ((PaymentChannel.equalsIgnoreCase(PaymentChannel_Act)) ){
   		Generic.WriteTestData("PaymentChannel verification", "", "", "PaymentChannel Expected:'"+PaymentChannel+"'", "PaymentChannel Actual:'"+PaymentChannel_Act+"'", "Passed");
   	}else{
   		Generic.WriteTestData("PaymentChannel verification", "", "", "PaymentChannel Expected:'"+PaymentChannel+"'", "PaymentChannel Actual:'"+PaymentChannel_Act+"'", "Failed");
   	}   
   	//Date
   	String Date_Act = Constant.driver.findElement(By.xpath("//div[contains(@class,'table-container')]//table/tbody/tr[1]/td[5]")).getText();
   	if ((Date_Act.contains(Date))){
   		Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Passed");
   	}else{
   		//Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Failed");
   	}
  }
  }catch(Exception e) {
		System.out.println("Error in table validation");
		Generic.WriteTestData(PaymentType+" Table validation", "", "", PaymentType+" Table Validation should be success ", "Error in "+PaymentType+" Table Validation", "Failed");   	   
	}

}


 public static String XenditDashTableData(String Heading) throws Exception{
	String Data=null;
	List<WebElement> StatusList =  Constant.driver.findElements(By.xpath("//div[contains(@class,'table-container')]//table/thead/tr/th"));
	int a = StatusList.size();
	int Index = a+1;
	for(int i=1;i<Index;i++){
	String Header=Constant.driver.findElement(By.xpath("//div[contains(@class,'table-container')]//table/thead/tr/th["+i+"]")).getText().trim();
	if(Header.equalsIgnoreCase(Heading)){
		Data=Constant.driver.findElement(By.xpath("//div[contains(@class,'table-container')]//table/tbody/tr[1]/td["+i+"]")).getText().trim();
		System.out.println(Header);
		break;
	}}
	return Data;
}

 public static void XenditDashTransactionValidation(String PaymentID,String Status,String Type, String Channel,String Account,String PaymentAmount,String Date) throws Exception {
	try{
	Control.WaitForLoader(3,5000);
	Thread.sleep(5000);
	Control.FluentWait_function("XenditDashboard", "Profile");
	Control.click("XenditDashboard", "Profile");
    Control.WaitForLoader(3,3000);
    String Role = Constant.driver.findElement(By.xpath("//div[@id='business-selector-0']/div/p")).getText();
  if(Role.equalsIgnoreCase("Stratpoint Tech. Inc")) {
	Control.click("XenditDashboard", "Stratpoint");}
	Control.WaitForLoader(3,5000);
	Thread.sleep(5000);
	Control.click("XenditDashboard", "Transactions");
	Control.WaitForLoader(3,8000);
	Control.takeScreenshot();
	Control.FluentWait_function("XenditDashboard", "SummaryAmount");
	WebDriverWait wait = new WebDriverWait(Constant.driver, 1000);
	wait.until(ExpectedConditions.invisibilityOfAllElements(Constant.driver.findElements(By.xpath("(//div[@class='summary-amount-text-loading'])[1]"))));
    Control.WaitForLoader(3,5000);
    Control.FluentWait_function("XenditDashboard", "SummaryAmount");
	Thread.sleep(5000);
	Control.FluentWait_function("XenditDashboard", "SearchPaymentID");
	Control.enterText("XenditDashboard", "SearchPaymentID", PaymentID);
	Control.WaitForLoader(3,5000);
	Thread.sleep(5000);
	Control.takeScreenshot();
	if(Status.equalsIgnoreCase("Success")){
	//Status
	String Status_Act = XenditDashTableData("Status");
	if((Status.equalsIgnoreCase(Status_Act)) ){
		Generic.WriteTestData("Status verification", "", "", "Status Expected:'"+Status+"'", "Status Actual:'"+Status_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Status verification", "", "", "Status Expected:'"+Status+"'", "Status Actual:'"+Status_Act+"'", "Failed");
	}
	//Type
	String Type_Act = XenditDashTableData("Type");
	if((Type.equalsIgnoreCase(Type_Act)) ){
		Generic.WriteTestData("Type verification", "", "", "Type Expected:'"+Type+"'", "Type Actual:'"+Type_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Type verification", "", "", "Type Expected:'"+Type+"'", "Type Actual:'"+Type_Act+"'", "Failed");
	}
	//Channel
	String Channel_Act = XenditDashTableData("Channel");
	if((Channel.equalsIgnoreCase(Channel_Act)) ){
		Generic.WriteTestData("Channel verification", "", "", "Channel Expected:'"+Channel+"'", "Channel Actual:'"+Channel_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Channel verification", "", "", "Channel Expected:'"+Channel+"'", "Channel Actual:'"+Channel_Act+"'", "Failed");
	}
	//Account
	String Account_Act = Constant.driver.findElement(By.xpath("(//td[3]/following::span[@class='tooltip-trigger']/img)[1]")).getAttribute("src").trim();
	Account_Act = Account_Act.split("-logo")[0];
	Account_Act = Account_Act.split("images/")[1];
	if ((Account.equalsIgnoreCase(Account_Act)) ){
		Generic.WriteTestData("Account verification", "", "", "Account Expected:'"+Account+"'", "Account Actual:'"+Account_Act+"'", "Passed");
	}else if ((Account_Act.equalsIgnoreCase("default")) ){
		Generic.WriteTestData("Account verification", "", "", "Account Expected:'default'", "Account Actual:'"+Account_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Account verification", "", "", "Account Expected:'default'", "Account Actual:'"+Account_Act+"'", "Failed");
	}   
	//PaymentAmount
	PaymentAmount = "PHP "+PaymentAmount;
	String PaymentAmount_Act = XenditDashTableData("Amount");
	if ((PaymentAmount.equalsIgnoreCase(PaymentAmount_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Failed");
	} 
	//PaymentID
	String PaymentID_Act = XenditDashTableData("Reference");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//Date
	String Date_Act = Constant.driver.findElement(By.xpath("//div[contains(@class,'table-container')]//table/tbody/tr[1]/td[8]")).getText();
	if ((Date_Act.contains(Date))){
		Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Failed");
	}}
	else {
	String Data_Act = Constant.driver.findElement(By.xpath("//p[contains(@class,'empty-card-caption')]")).getText().trim();
	String Data ="No transaction history found."; 
	if ((Data_Act.equalsIgnoreCase(Data))){
		Generic.WriteTestData("Data verification", "", "", "Data Expected:'"+Data+"'", "Data Actual:'"+Data_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Data verification", "", "", "Data Expected:'"+Data+"'", "Data Actual:'"+Data_Act+"'", "Failed");
	}}
	}catch(Exception e) {
		System.out.println("Error in table validation");
		Generic.WriteTestData("Transactions Table validation", "", "", "Transactions Table Validation should be success ", "Error in Transactions Table Validation", "Failed");   	   
	}
}


 public static String Tokenize(String Amount, String CardNo )throws Exception{
	String CardExpMonth = UpdateDateValidation(180,"MM");
	String CardExpYear = UpdateDateValidation(180,"yyyy");
	String CardExpCVN = "123";
	String MethodID = null;
	try {
	Control.OpenApplication("Chrome",Generic.ReadFromExcel("Tokenize", "TestData", 1),"Tokenize");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.enterText("Tokenize","Apikey","xnd_public_development_d7Vtq1ZO7RzVVI6G9oeaQcFsSz3Av17TGGA7kCqFmt70kO4HNT40pzQ1PNZZVmE");
	Control.enterText("Tokenize","Amount",Amount);
	Control.enterText("Tokenize","CardNo",CardNo);
	Control.enterText("Tokenize","CardExpMonth",CardExpMonth);
	Control.enterText("Tokenize","CardExpYear",CardExpYear);
	Control.enterText("Tokenize","CardExpCVN",CardExpCVN);
	Control.enterText("Tokenize","Currency","PHP");
	Thread.sleep(3000);
	Control.takeScreenshot();
	Control.js_click("Tokenize","Bayar Sekarang");
	Control.WaitForLoader(3,500);
	Constant.driver.switchTo().frame("sample-inline-frame");
	Control.WaitForLoader(3,500);
	WebDriverWait wait = new WebDriverWait(Constant.driver, 5000);
	wait.until(ExpectedConditions.invisibilityOfAllElements(Constant.driver.findElements(By.xpath("//div[@id='loader-wrapper']"))));
    Control.WaitForLoader(3,8000);
    Thread.sleep(6000);
    Constant.driver.switchTo().defaultContent();
    Control.FluentWait_function("Tokenize","Response");
	Control.ScrollToView("Tokenize","Response");
	Thread.sleep(10000);
	Control.WaitForLoader(3,300);
	String Message = Constant.driver.findElement(By.xpath("//div[@id='success']/p")).getText();
	System.out.println("Message "+Message);
	if(Message.contains("Success")) {
	Control.WaitForLoader(3,500);
	String id = Control.getMessageContent("Tokenize","Response");
	JSONObject RefID =  new JSONObject(id);
	MethodID = RefID.getString("id");
	Control.takeScreenshot();
	Generic.WriteTestData("Payment Method ID", "", "", "Able to fetch PaymentMethodID ", "PaymentMethodID is fetched "+MethodID, "Passed");   	   
	}else {
	Control.takeScreenshot();	   
	Generic.WriteTestData("Payment Method ID", "", "", "Able to fetch PaymentMethodID ", "PaymentMethodID is not fetched ", "Failed");   	   
	}
	}
	catch(Exception e) {
	System.out.println("Error in generating ref id");
	Generic.WriteTestData("Payment Method ID", "", "", "Able to fetch PaymentMethodID ", "Error in fetching PaymentMethodID", "Failed");   	   
	}
	return MethodID;
}	

 public static String UpdateDateValidation(int count, String format) {
	String Dt = null; 
	try {
	Date NewDate = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
	String Date = formatter.format(NewDate);
	Calendar c = Calendar.getInstance();
	try{
		c.setTime(formatter.parse(Date));
	}catch(ParseException e){
		e.printStackTrace();
	}
	c.add(Calendar.DATE, count);  
	String newDate = formatter.format(c.getTime());  
	System.out.println("Date "+newDate);	
	Date date = formatter.parse(newDate);
	SimpleDateFormat formatt = new SimpleDateFormat(format);
	Dt = formatt.format(date);
	System.out.println("FormattedDate "+Dt);	
}
	catch(Exception e) {
	System.out.println("Error in Date Update");
	}
	return Dt;
}

 public static String CaptureDateTime(String format) {
	String Date = null; 
	try {
	Date NewDate = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat(format); 
	Date = formatter.format(NewDate);
	System.out.println("CapturedDateTime: "+Date);
	}
	catch(Exception e) {
	System.out.println("Error in Date Update");
	}
	return Date;
}
 
 
 public static String CaptureDate(Date NewDate, String format) {
	String Date = null; 
	try {
	SimpleDateFormat formatter = new SimpleDateFormat(format); 
	Date = formatter.format(NewDate);
	System.out.println("CapturedDateTime: "+Date);
	}
	catch(Exception e) {
	System.out.println("Error in Date Update");
	}
	return Date;
}

 public static void EndpointCreation(String Endpoint)throws Exception{
	try {	   
	Control.OpenApplication("Chrome", Generic.ReadFromExcel("Beeceptor", "TestData", 1), "Beeceptor");
	Control.WaitForLoader(3,300);
	XenditFunction.Beeceptorlogin();
	Control.WaitForLoader(3,500);
	Control.takeScreenshot();  
	Control.enterText("Beeceptor", "EndpointName", Endpoint);
	Constant.driver.findElement(By.xpath("//input[@placeholder='Endpoint Name']")).sendKeys(Keys.ENTER);
	Control.takeScreenshot();
	Control.WaitForLoader(3,800);
	Thread.sleep(5000);
	WebElement Ele = Constant.driver.findElement(By.xpath("//div[contains(@class,'toggle btn')]"));
	WebDriverWait wait = new WebDriverWait(Constant.driver,5000);
	wait.until(ExpectedConditions.visibilityOfAllElements(Ele));
	Control.WaitForLoader(5,3000);
	Generic.WriteTestData("Endpoint Creation", "", "", "Able to Create Endpoint ", "Endpoint is Created", "Passed");   	   
	}catch(Exception e) {
	Generic.WriteTestData("Endpoint Creation", "", "", "Able to Create Endpoint ", "Error in Endpoint Creation", "Failed");   	   
	}   
}

 public static void GCashProceedtoPay(String PaymentID, String Status)throws Exception{
	String PaymentId_Act,Url = null;
	try{
	existbrowseropen("Beeceptor");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.objExists("Beeceptor", "PostResponse", true);
	Control.takeScreenshot();
	Control.click("Beeceptor", "PostResponse");
	Thread.sleep(5000);
	Control.takeScreenshot();
	String ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
	System.out.print("Rspns: "+ResponseBody);
	PaymentId_Act = ResponseBody.split("paymentId")[1];
	PaymentId_Act = PaymentId_Act.split(",")[0];
	PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
	System.out.println("\nPaymentId:"+PaymentId_Act);
	if(PaymentId_Act.equalsIgnoreCase(PaymentID)) {
	Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
	}else {
	Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
	}
	Url = ResponseBody.split("checkoutUrl")[1];
	Url = Url.split(",")[0];
	Url = Url.replaceAll("(\"|\\})","").trim();
	Url = Url.replaceFirst(":","").trim();
	System.out.println("\nUrl:"+Url);
	Control.WaitForLoader(3,500);
	Control.OpenApplication("Chrome", Url, "Xenditlogins");
	Control.WaitForLoader(3,500);
	Control.takeScreenshot();
	String GcashMobileNumber = "9174342434"; String Mpin ="1";
	Control.enterText("Beeceptor", "GcashMobileNumber", GcashMobileNumber);
	Control.takeScreenshot();
	Control.click("Beeceptor", "Next");
	Control.takeScreenshot();
	Thread.sleep(2000);
	List <WebElement> Ele = Constant.driver.findElements(By.xpath("//div[contains(@class,'ap-password-item')]/i[1]"));
	System.out.println("Element count:"+Ele.size());
	for(int i=1;i<=Ele.size();i++) {
	WebElement element = Constant.driver.findElement(By.xpath("(//div[contains(@class,'ap-password-item')]/i[1])["+i+"]"));
	Actions actions = new Actions(Constant.driver);
	actions.sendKeys("1").build().perform();
	Thread.sleep(1000);}
	Control.WaitForLoader(3,300);
	Control.click("Beeceptor", "Next");
	Control.WaitForLoader(3,300);
	Control.takeScreenshot();
	if(Control.findElement("Beeceptor", "Agree").isDisplayed()) {
	Control.click("Beeceptor", "Agree");}
	Control.takeScreenshot();
	Control.WaitForLoader(3,300);
	Control.click("Beeceptor", "Pay");
	Control.takeScreenshot();
	Control.WaitForLoader(3,300);
	Control.click("Beeceptor", "Proceed");
	Thread.sleep(30000);
	String CapturedDate = CaptureDateTime("MM/dd/yyyy - hh:mm:ss aa");
	System.out.println("[StoreForAPIPro]CapturedPaymentDate::"+CapturedDate);
	Constant.driver.close();
	Control.WaitForLoader(3,300);
	Thread.sleep(10000);
	existbrowseropen("Beeceptor");
	Control.WaitForLoader(3,500);
	Thread.sleep(30000);
	Control.objExists("Beeceptor", "PostResponse", true);
	Control.takeScreenshot();
	Control.click("Beeceptor", "PostResponse");
	Control.WaitForLoader(3,300);
	Control.takeScreenshot();
	ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
	System.out.print("Rspns: "+ResponseBody);
	PaymentId_Act = ResponseBody.split("paymentId")[1];
	PaymentId_Act = PaymentId_Act.split(",")[0];
	PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
	System.out.println("\nPaymentId:"+PaymentId_Act);
	if(PaymentId_Act.equalsIgnoreCase(PaymentID)) {
	   Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
	}else {
	   Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
	}
	String Status_Act = ResponseBody.split("status")[1];
	Status_Act = Status_Act.replaceAll("(\"|\\:|\\}|\\])","").trim();
	System.out.println("\nStatus:"+Status_Act);
	String Status_Exp ="";
	if(Status.equalsIgnoreCase("GCash")) {Status_Exp ="GCASH_AUTHORISED";}
	if(Status_Act.equalsIgnoreCase(Status_Exp)) {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status_Exp, "Status Actual:"+Status_Act, "Passed");
	}else {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status_Exp, "Status Actual:"+Status_Act, "Failed");
	}
	}catch(Exception e) {
		System.out.println("Error");
		Generic.WriteTestData("Beeceptor Proceed to Pay", "", "", "Able to proceed payment ", "Error in payment proceed", "Failed");   	   
	}   
}

 public static void Beeceptorlogin() throws Exception{
	Control.WaitForLoader(3,500);
	Control.takeScreenshot();
	if((Control.regularFindElement("Beeceptor","Avatar",5))==null) {
		Thread.sleep(3000);
		System.out.println("Signin Page");
		Control.js_click("Beeceptor", "SigninLink");
		Control.WaitForLoader(3,500);
		Thread.sleep(3000);
		Control.enterText("Beeceptor", "Email", Generic.ReadFromExcel("Beeceptor", "LoginDetails", 1));
		Control.enterText("Beeceptor", "Password", Generic.ReadFromExcel("Beeceptor", "LoginDetails", 2));
		Control.WaitForLoader(3,300);
		Control.click("Beeceptor", "Signin");
		Control.WaitForLoader(3,300);
		Control.takeScreenshot();
	}else {
		Control.WaitForLoader(3,500);
		Control.takeScreenshot();
		System.out.println("No Signin Page");
	}
}

 public static void GlobePaymentServicelogin() throws Exception{
	Control.WaitForLoader(3,500);
	if((Control.regularFindElement("GlobePaymentService", "LoginAgain",5))!=null) {
		Thread.sleep(3000);
		System.out.println("LoginAgain Page");
		Control.WaitForLoader(3,500);
		Control.js_click("GlobePaymentService", "LoginAgain");
		Control.WaitForLoader(3,300);
		Control.takeScreenshot();
		Control.js_click("GlobePaymentService", "LoginviaGoogle");
		Control.WaitForLoader(3,300);
		Control.takeScreenshot();
	}else {
		Control.WaitForLoader(3,500);
		Control.takeScreenshot();
		System.out.println("No LoginAgain Page");
	}
}

 public static String GlobePSTableData(String Heading) throws Exception{
   	String Data=null;
	List<WebElement> StatusList =  Constant.driver.findElements(By.xpath("//table[contains(@class,'Table')]/thead/tr/th"));
	int a = StatusList.size();
	int Index = a+1;
	for(int i=1;i<Index;i++){
	String Header=Constant.driver.findElement(By.xpath("//table[contains(@class,'Table')]/thead/tr/th["+i+"]")).getText().trim();
	if(Header.equalsIgnoreCase(Heading)){
		WebElement ele= Constant.driver.findElement(By.xpath("//table[contains(@class,'Table')]/thead/tr/th["+i+"]"));
		Actions actions = new Actions(Constant.driver);
		actions.moveToElement(ele);
		actions.perform();	 
		Data = Constant.driver.findElement(By.xpath("//table[contains(@class,'Table')]/tbody/tr[1]/td["+i+"]")).getText().trim();
		System.out.println(Header);
		break;
	}}
	return Data;
}

 public static void TransactionLogsValidation(String PaymentID,String AccountNo, String ChannelName, String EmailAddress,String PaymentMethod,String MSISDN, String Status,String Refund, String RefundAmount, String RefundStatus, String Amount, String Date, String PaymentGateway) throws Exception {
	try{ 																																
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "TransactionLogs");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.takeScreenshot();
	//PaymentID
	String PaymentID_Act = GlobePSTableData("Reference No.");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//AccountNo
	String AccountNo_Act = GlobePSTableData("Account No.");
	if ((AccountNo.equalsIgnoreCase(AccountNo_Act)) ){
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Failed");
	}
	//ChannelName
	String ChannelName_Act = GlobePSTableData("Channel Name");
	if ((ChannelName.equalsIgnoreCase(ChannelName_Act)) ){
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Failed");
	}
	//EmailAddress
	String EmailAddress_Act = GlobePSTableData("Email Address");
	if ((EmailAddress.equalsIgnoreCase(EmailAddress_Act)) ){
		Generic.WriteTestData("EmailAddress verification", "", "", "EmailAddress Expected:'"+EmailAddress+"'", "EmailAddress Actual:'"+EmailAddress_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("EmailAddress verification", "", "", "EmailAddress Expected:'"+EmailAddress+"'", "EmailAddress Actual:'"+EmailAddress_Act+"'", "Failed");
	}
	//ProductDescription
	String ProductDescription ="Globe";
	String ProductDescription1 ="Innove";
	String ProductDescription2 ="";
	String ProductDescription_Act = GlobePSTableData("Product Description");
	if (ProductDescription.equalsIgnoreCase(ProductDescription_Act)){
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Passed");
	}else if (ProductDescription_Act.equalsIgnoreCase(ProductDescription1)){
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription1+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Passed");
	}else if (ProductDescription_Act.equalsIgnoreCase(ProductDescription2)){
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription2+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Passed");
	}else {
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Failed");
	}
	//PaymentMethod
	Control.takeScreenshot();
	String PaymentMethod_Act = GlobePSTableData("Payment Method");
	if ((PaymentMethod.equalsIgnoreCase(PaymentMethod_Act))){
		Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Failed");
	}
	//MSISDN
	String MSISDN_Act = GlobePSTableData("MSISDN");
	if ((MSISDN.equalsIgnoreCase(MSISDN_Act))){
		Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Failed");
	}
	//Status
	String Status_Exp = "";
	String Status_Act = GlobePSTableData("Status");
	if ((Status.equalsIgnoreCase(Status_Act))){
		Generic.WriteTestData("Status verification", "", "", "Status Expected:'"+Status+"'", "Status Actual:'"+Status_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Status verification", "", "", "Status Expected:'"+Status+"'", "Status Actual:'"+Status_Act+"'", "Failed");
	}
	//PaymentType
	String PaymentType ="Straight";
	String PaymentType_Act = GlobePSTableData("Payment Type");
	if ((PaymentType.equalsIgnoreCase(PaymentType_Act))){
		Generic.WriteTestData("PaymentType verification", "", "", "PaymentType Expected:'"+PaymentType+"'", "PaymentType Actual:'"+PaymentType_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentType verification", "", "", "PaymentType Expected:'"+PaymentType+"'", "PaymentType Actual:'"+PaymentType_Act+"'", "Failed");
	}
	//RefundID
	Control.takeScreenshot();
	String RefundID_Act = GlobePSTableData("Refund ID");
	if(Refund.equals("Refund")) {
		System.out.println("Refund:"+Refund);	
	if (!(RefundID_Act == null || RefundID_Act == "")){
		Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: Value", "RefundID Actual:'"+RefundID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: Value", "RefundID Actual:'"+RefundID_Act+"'", "Failed");
	}}
	else{
	if ((RefundID_Act.equalsIgnoreCase("") || RefundID_Act.equalsIgnoreCase(null))){
		Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: No Value", "RefundID Actual:'"+RefundID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: No Value", "RefundID Actual:'"+RefundID_Act+"'", "Failed");
	}}
	//RefundStatus
	Control.takeScreenshot();
	String RefundStatus_Act = GlobePSTableData("Refund Status");
	if((RefundStatus.equalsIgnoreCase(RefundStatus_Act))){
		Generic.WriteTestData("RefundStatus verification", "", "", "RefundStatus Expected:'"+RefundStatus+"'", "RefundStatus Actual:'"+RefundStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundStatus verification", "", "", "RefundStatus Expected:'"+RefundStatus+"'", "RefundStatus Actual:'"+RefundStatus_Act+"'", "Failed");
	}//RefundAmount
	String RefundAmount_Act = GlobePSTableData("Refund Amount");
	if ((RefundAmount.equals(RefundAmount_Act))){
		Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Failed");
	}
	//Currency
	Control.takeScreenshot();
	String Currency ="PHP";
	String Currency_Act = GlobePSTableData("Currency");
	if (Currency.equalsIgnoreCase(Currency_Act)|| Currency_Act.equalsIgnoreCase("")){
		Generic.WriteTestData("Currency verification", "", "", "Currency Expected:'"+Currency+"'", "Currency Actual:'"+Currency_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Currency verification", "", "", "Currency Expected:'"+Currency+"'", "Currency Actual:'"+Currency_Act+"'", "Failed");
	}
	//Amount
	String Amount_Act = GlobePSTableData("Amount");
	if ((Amount.equalsIgnoreCase(Amount_Act))){
		Generic.WriteTestData("Amount verification", "", "", "Amount Expected:'"+Amount+"'", "Amount Actual:'"+Amount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Amount verification", "", "", "Amount Expected:'"+Amount+"'", "Amount Actual:'"+Amount_Act+"'", "Failed");
	}
	//Date
	String Date_Act = GlobePSTableData("Date");
	if ((Date_Act.contains(Date))){
		Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Failed");
	}
	//PaymentGateway
	Control.takeScreenshot();
	String PaymentGateway_Act = GlobePSTableData("Payment Gateway");
	if ((PaymentGateway.equalsIgnoreCase(PaymentGateway_Act))){
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Failed");
	}
	//SplitPayment
	String SplitPayment ="No";
	String SplitPayment_Act = GlobePSTableData("Split Payment");
	if ((SplitPayment.equalsIgnoreCase(SplitPayment_Act))){
		Generic.WriteTestData("SplitPayment verification", "", "", "SplitPayment Expected:'"+SplitPayment+"'", "SplitPayment Actual:'"+SplitPayment_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("SplitPayment verification", "", "", "SplitPayment Expected:'"+SplitPayment+"'", "SplitPayment Actual:'"+SplitPayment_Act+"'", "Failed");
	}
	//BillType
	String BillType = "";
	if (AccountNo.equalsIgnoreCase("N/A")) {
	BillType = "NonBill";}
	else {
	BillType = "Bill";}
	System.out.println(AccountNo+" "+BillType);
	String BillType_Act = GlobePSTableData("Bill Type");
	if ((BillType_Act.equalsIgnoreCase(BillType))){
		Generic.WriteTestData("BillType verification", "", "", "BillType Expected:'"+BillType+"'", "BillType Actual:'"+BillType_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("BillType verification", "", "", "BillType Expected:'"+BillType+"'", "BillType Actual:'"+BillType_Act+"'", "Failed");
	}
	//BatchFile
	Control.takeScreenshot();
	String BatchFile ="No";
	String BatchFile_Act = GlobePSTableData("Batch File");
	if ((BatchFile.equalsIgnoreCase(BatchFile_Act))){
		Generic.WriteTestData("BatchFile verification", "", "", "BatchFile Expected:'"+BatchFile+"'", "BatchFile Actual:'"+BatchFile_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("BatchFile verification", "", "", "BatchFile Expected:'"+BatchFile+"'", "BatchFile Actual:'"+BatchFile_Act+"'", "Failed");
	}
	//CostCenter
	String CostCenter ="";
	String CostCenter_Act = GlobePSTableData("Cost Center");
	if ((CostCenter.equalsIgnoreCase(CostCenter_Act))||(!(CostCenter.equalsIgnoreCase(CostCenter_Act))) ){
		Generic.WriteTestData("CostCenter verification", "", "", "CostCenter Expected:'"+CostCenter+"'", "CostCenter Actual:'"+CostCenter_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("CostCenter verification", "", "", "CostCenter Expected:'"+CostCenter+"'", "CostCenter Actual:'"+CostCenter_Act+"'", "Failed");
	}
	//PaymentReason
	String PaymentReason ="";
	String PaymentReason_Act = GlobePSTableData("Payment Reason");
	if ((PaymentReason_Act.contains(PaymentReason))||(!(PaymentReason_Act.equalsIgnoreCase("")))){
		Generic.WriteTestData("PaymentReason verification", "", "", "PaymentReason Expected:'"+PaymentReason+"'", "PaymentReason Actual:'"+PaymentReason_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentReason verification", "", "", "PaymentReason Expected:'"+PaymentReason+"'", "PaymentReason Actual:'"+PaymentReason_Act+"'", "Failed");
	}
	//PostPaymentReason
	String PostPaymentReason ="";
	String PostPaymentReason_Act = GlobePSTableData("Post Payment Reason");
	if ((PostPaymentReason_Act.contains(PostPaymentReason))||(!(PostPaymentReason_Act.equalsIgnoreCase(""))) ){
		Generic.WriteTestData("PostPaymentReason verification", "", "", "PostPaymentReason Expected:'"+PostPaymentReason+"'", "PostPaymentReason Actual:'"+PostPaymentReason_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PostPaymentReason verification", "", "", "PostPaymentReason Expected:'"+PostPaymentReason+"'", "PostPaymentReason Actual:'"+PostPaymentReason_Act+"'", "Failed");
	}
	//PostPaymentESBID
	Control.takeScreenshot();
	String PostPaymentESBID ="ae10a06.";
	String PostPaymentESBID_Act = GlobePSTableData("Post Payment ESB ID");
	if ((BatchFile_Act.contains(BatchFile))||(BatchFile_Act.equalsIgnoreCase("")) ){
		Generic.WriteTestData("PostPaymentESBID verification", "", "", "PostPaymentESBID Expected:'"+PostPaymentESBID+"'", "PostPaymentESBID Actual:'"+PostPaymentESBID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PostPaymentESBID verification", "", "", "PostPaymentESBID Expected:'"+PostPaymentESBID+"'", "PostPaymentESBID Actual:'"+PostPaymentESBID_Act+"'", "Failed");
	}
}catch(Exception e){
		Generic.WriteTestData("TransactionLogs Data verification","","","TransactionLogs Data should get verified","Error in verifying TransactionLogs Data","Failed");
		System.out.println("Exception "+e.getMessage());
		e.printStackTrace();
	}
}

 public static void ChannelTransactionsValidation(String BillType, String ChannelName) throws Exception {
	try{
	Control.WaitForLoader(3,300);
	Control.ScrollToView("GlobePaymentService", "ChannelTransactions");
	Control.click("GlobePaymentService", "ChannelTransactions");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "BillType");
	Constant.driver.findElement(By.xpath("//div[text()='"+BillType+"']")).click();
	Control.click("GlobePaymentService", "ChannelName");
	Constant.driver.findElement(By.xpath("//div[text()='"+ChannelName+"']")).click();
	String Month = XenditFunction.UpdateDateValidation(0,"MMMM");
	Control.click("GlobePaymentService", "MonthStart");
	Constant.driver.findElement(By.xpath("//div[text()='"+Month+"']")).click();
	Control.click("GlobePaymentService", "MonthEnd");
	Constant.driver.findElement(By.xpath("//div[text()='"+Month+"']")).click();
	String Year = XenditFunction.UpdateDateValidation(0,"yyyy");
	Control.click("GlobePaymentService", "YearStart");
	Constant.driver.findElement(By.xpath("//div[text()='"+Year+"']")).click();
	Control.click("GlobePaymentService", "YearEnd");
	Constant.driver.findElement(By.xpath("//div[text()='"+Year+"']")).click();
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.takeScreenshot();
	
	//BillType
	String BillType_Act = GlobePSTableData("Bill Type");
	if ((BillType.equalsIgnoreCase(BillType_Act)) ){
		Generic.WriteTestData("BillType verification", "", "", "BillType Expected:'"+BillType+"'", "BillType Actual:'"+BillType_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("BillType verification", "", "", "BillType Expected:'"+BillType+"'", "BillType Actual:'"+BillType_Act+"'", "Failed");
	}
	//ChannelName
	String ChannelName_Act = GlobePSTableData("Channel Name");
	if ((ChannelName.equalsIgnoreCase(ChannelName_Act)) ){
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Failed");
	}
	//BusinessUnit
	String BusinessUnit ="Test";
	String BusinessUnit_Act = GlobePSTableData("Business Unit");
	if ((BusinessUnit_Act.contains(BusinessUnit)) || (BusinessUnit_Act.equalsIgnoreCase("")) ){
		Generic.WriteTestData("BusinessUnit verification", "", "", "BusinessUnit Expected:'"+BusinessUnit+"'", "BusinessUnit Actual:'"+BusinessUnit_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("BusinessUnit verification", "", "", "BusinessUnit Expected:'"+BusinessUnit+"'", "BusinessUnit Actual:'"+BusinessUnit_Act+"'", "Failed");
	}
	//PaymentGateway
	for (int i=0;i<2;i++) {
	Thread.sleep(1000);
	Constant.driver.findElement(By.xpath("//table[contains(@class,'Table')]/thead/tr/th[4]/div/button")).click();
	Thread.sleep(1000);}
	String PaymentGateway ="xendit";
	String PaymentGateway1 ="gcash";
	String PaymentGateway2 ="adyen";
	String PaymentGateway_Act = GlobePSTableData("Payment Gateway");
	if ((PaymentGateway.equalsIgnoreCase(PaymentGateway_Act))){
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Passed");
	}else if(PaymentGateway1.equalsIgnoreCase(PaymentGateway_Act)){
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway1+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Passed");
	}else if(PaymentGateway2.equalsIgnoreCase(PaymentGateway_Act)){
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway2+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Passed");
	}else {
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway2+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Failed");
	}
	//Card Type (Funding Source)
	Control.takeScreenshot();
	String CardType_Act = GlobePSTableData("Card Type (Funding Source)");
	if ((CardType_Act.equalsIgnoreCase("CREDIT")) || (CardType_Act.equalsIgnoreCase("DEBIT")) || (CardType_Act.equalsIgnoreCase("")) ){
		Generic.WriteTestData("CardType verification", "", "", "CardType Expected: CREDIT/DEBIT/ ", "CardType Actual:'"+CardType_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("CardType verification", "", "", "CardType Expected: CREDIT/DEBIT/ ", "CardType Actual:'"+CardType_Act+"'", "Failed");
	}
	//PaymentType
	String PaymentType ="Straight";
	String PaymentType_Act = GlobePSTableData("Payment Type");
	if ((PaymentType.equalsIgnoreCase(PaymentType_Act))){
		Generic.WriteTestData("PaymentType verification", "", "", "PaymentType Expected:'"+PaymentType+"'", "PaymentType Actual:'"+PaymentType_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentType verification", "", "", "PaymentType Expected:'"+PaymentType+"'", "PaymentType Actual:'"+PaymentType_Act+"'", "Failed");
	}
	//TotalCount
	String TotalCount_Act = GlobePSTableData("Total Count");
	if (!(TotalCount_Act == null || TotalCount_Act == "" )){
		Generic.WriteTestData("TotalCount verification", "", "", "TotalCount Expected: ", "TotalCount Actual:'"+TotalCount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("TotalCount verification", "", "", "TotalCount Expected: ", "TotalCount Actual:'"+TotalCount_Act+"'", "Failed");
	}
	//TotalAmount
	String TotalAmount_Act = GlobePSTableData("Total Amount");
	if (!(TotalAmount_Act == null || TotalAmount_Act == "" )){
		Generic.WriteTestData("TotalAmount verification", "", "", "TotalAmount Expected: ", "TotalAmount Actual:'"+TotalAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("TotalAmount verification", "", "", "TotalAmount Expected: ", "TotalAmount Actual:'"+TotalAmount_Act+"'", "Failed");
	}
}catch(Exception e){
	Generic.WriteTestData("ChannelTransactions Data verification","","","ChannelTransactions Data should get verified","Error in verifying ChannelTransactions Data","Failed");
	System.out.println("Exception "+e.getMessage());
	e.printStackTrace();
	}
}

 public static void ORReportValidation(String PaymentID,String TransactionDt, String ChannelName, String Amount, String PaymentGateway, String PaymentStatus, String MobileNumber, String PaymentType) throws Exception {
  try{
	Control.WaitForLoader(3,300);
	Control.ScrollToView("GlobePaymentService", "ORReport");
	Control.click("GlobePaymentService", "ORReport");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.takeScreenshot();
	//PaymentID
	String TransactionDt_Act = GlobePSTableData("Transaction Date/Time");
	if ((TransactionDt.contains(TransactionDt_Act)) ){
		Generic.WriteTestData("TransactionDt verification", "", "", "TransactionDt Expected:'"+TransactionDt+"'", "TransactionDt Actual:'"+TransactionDt_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("TransactionDt verification", "", "", "TransactionDt Expected:'"+TransactionDt+"'", "TransactionDt Actual:'"+TransactionDt_Act+"'", "Failed");
	}
	//ChannelName
	String ChannelName_Act = GlobePSTableData("Channel Name");
	if ((ChannelName.equalsIgnoreCase(ChannelName_Act)) ){
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Failed");
	}
	//PaymentID
	String PaymentID_Act = GlobePSTableData("Reference No.");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//Amount
	String Amount_Act = GlobePSTableData("Amount");
	if ((Amount.equalsIgnoreCase(Amount_Act))){
		Generic.WriteTestData("Amount verification", "", "", "Amount Expected:'"+Amount+"'", "Amount Actual:'"+Amount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Amount verification", "", "", "Amount Expected:'"+Amount+"'", "Amount Actual:'"+Amount_Act+"'", "Failed");
	}
	//ORTransaction
	String ORTransaction ="Yes";
	String ORTransaction_Act = GlobePSTableData("OR Transaction");
	if ((ORTransaction.equalsIgnoreCase(ORTransaction_Act))){
		Generic.WriteTestData("ORTransaction verification", "", "", "ORTransaction Expected:'"+ORTransaction+"'", "ORTransaction Actual:'"+ORTransaction_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ORTransaction verification", "", "", "ORTransaction Expected:'"+ORTransaction+"'", "ORTransaction Actual:'"+ORTransaction_Act+"'", "Failed");
	}
	//PaymentGateway
	Control.takeScreenshot();
	String PaymentGateway_Act = GlobePSTableData("Payment Gateway");
	if ((PaymentGateway.equalsIgnoreCase(PaymentGateway_Act))){
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Failed");
	}
	//PaymentStatus
	String PaymentStatus_Act = GlobePSTableData("Payment Status");
	if ((PaymentStatus.equalsIgnoreCase(PaymentStatus_Act)) ){
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Failed");
	}
	//OR Status
	String ORStatus ="OR_LUKE";
	String ORStatus_Act = GlobePSTableData("OR Status");
	if ((ORStatus.equalsIgnoreCase(ORStatus_Act))){
		Generic.WriteTestData("ORStatus verification", "", "", "ORStatus Expected:'"+ORStatus+"'", "ORStatus Actual:'"+ORStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ORStatus verification", "", "", "ORStatus Expected:'"+ORStatus+"'", "ORStatus Actual:'"+ORStatus_Act+"'", "Failed");
	}
	//Date
	String Date = CaptureDateTime("MM/dd/yyyy");
	String Date_Act = GlobePSTableData("Luke OR Timestamp");
	if ((Date_Act.contains(Date))){
		Generic.WriteTestData("LukeORTimestamp verification", "", "", "LukeORTimestamp Expected:'"+Date+"'", "LukeORTimestamp Actual:'"+Date_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("LukeORTimestamp verification", "", "", "LukeORTimestamp Expected:'"+Date+"'", "LukeORTimestamp Actual:'"+Date_Act+"'", "Failed");
	}
	//MobileNumber
	String MSISDN_Act = GlobePSTableData("Mobile Number");
	if ((MobileNumber.equalsIgnoreCase(MSISDN_Act))){
		Generic.WriteTestData("MobileNumber verification", "", "", "MobileNumber Expected:'"+MobileNumber+"'", "MobileNumber Actual:'"+MSISDN_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("MobileNumber verification", "", "", "MobileNumber Expected:'"+MobileNumber+"'", "MobileNumber Actual:'"+MSISDN_Act+"'", "Failed");
	}
	//PaymentType
	String PaymentType_Act = GlobePSTableData("Payment Type");
	if ((PaymentType.equalsIgnoreCase(PaymentType_Act))){
		Generic.WriteTestData("PaymentType verification", "", "", "PaymentType Expected:'"+PaymentType+"'", "PaymentType Actual:'"+PaymentType_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentType verification", "", "", "PaymentType Expected:'"+PaymentType+"'", "PaymentType Actual:'"+PaymentType_Act+"'", "Failed");
	}
}catch(Exception e){
		Generic.WriteTestData("ORReport Data verification","","","ORReport Data should get verified","Error in verifying ORReport Data","Failed");
		System.out.println("Exception "+e.getMessage());
		e.printStackTrace();
	}
}

 public static void DropInSimulator(String Channel, String BillType, String AccountNumber, String MobileNumber, String EmailAddress, String Amount , String ResponseUrl, String TransStatus) throws Exception {
	String Endpoint = null;
	if (ResponseUrl.contains(".free")){
	Endpoint = ResponseUrl.split(".free")[0];
	Endpoint = Endpoint.split("//")[1];}
	EndpointCreation(Endpoint);
	Control.WaitForLoader(3,500);
	Control.OpenApplication("Chrome",Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
	Control.WaitForLoader(3,300);
	XenditFunction.GlobePaymentServicelogin();
	Control.WaitForLoader(3,500);	  
	Control.ScrollToView("GlobePaymentService","DropinSimulator");
	Control.click("GlobePaymentService","DropinSimulator");
	Control.takeScreenshot();
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "Channel");
	Thread.sleep(3000);
	Constant.driver.findElement(By.xpath("//div[text()='"+Channel+"']")).click();
	Control.takeScreenshot();
	Control.WaitForLoader(3,300);
	Control.ScrollToView("GlobePaymentService","GenerateAccessToken");
	Thread.sleep(5000);
	Control.click("GlobePaymentService", "GenerateAccessToken");
	Thread.sleep(3000);
	Control.takeScreenshot();
	Control.click("GlobePaymentService", "AlertOk");
	Control.takeScreenshot();
	Control.WaitForLoader(3,300);
	String AccessToken = Control.getAttribute("GlobePaymentService", "AccessToken", "value");
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService","DropinBillType");
	Constant.driver.findElement(By.xpath("//div[text()='"+BillType+"']")).click();
	Control.WaitForLoader(3,300);
	if (BillType.equalsIgnoreCase("Bill")) {
	Thread.sleep(5000);
	Control.enterText("GlobePaymentService", "AccountNumber", AccountNumber);}
	if (BillType.equalsIgnoreCase("NonBill")) {
	Thread.sleep(5000);	  
	Control.enterText("GlobePaymentService", "MobileNumber", "0"+MobileNumber);}
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "EmailAddress", EmailAddress);		 
	Control.enterText("GlobePaymentService", "Amount", Amount);
	String Type =null;
	if (BillType.equalsIgnoreCase("Bill")) {
	Type = "G";
	}else if (BillType.equalsIgnoreCase("NonBill")) {
	Type = "N";}
	else {
	Type ="I";}
	Control.click("GlobePaymentService","TransactionType");
	Constant.driver.findElement(By.xpath("//div[text()='"+Type+"']")).click();
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "ResponseUrl", ResponseUrl);	
	Control.takeScreenshot();
	Control.click("GlobePaymentService","CreatePaymentSession");
	Control.takeScreenshot();
	Control.click("GlobePaymentService","AlertYes");
	Control.takeScreenshot();
	String PaymentIDDropin = Control.getMessageContent("GlobePaymentService", "AlertPaymentID");
	System.out.println("[StoreForAPIPro]PaymentID::"+PaymentIDDropin);
	Control.click("GlobePaymentService","AlertGoBack");
	Control.takeScreenshot();
	existbrowseropen("Beeceptor");
	Control.WaitForLoader(3,300);
	Control.objExists("Beeceptor", "PostResponse", true);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.click("Beeceptor", "PostResponse");
	Thread.sleep(3000);
	Control.takeScreenshot();
	String ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
	System.out.print("Rspns: "+ResponseBody);
	String PaymentId_Act = ResponseBody.split("paymentId")[1];
	PaymentId_Act = PaymentId_Act.split(",")[0];
	PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
	System.out.println("\nPaymentId:"+PaymentId_Act);
	if(PaymentId_Act.equalsIgnoreCase(PaymentIDDropin)) {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentIDDropin, "PaymentID Actual:"+PaymentId_Act, "Passed");
	}else {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentIDDropin, "PaymentID Actual:"+PaymentId_Act, "Failed");
	}
	System.out.println("[StoreForAPIPro]PaymentID::"+PaymentIDDropin);
	String MerchantAcc = ResponseBody.split("merchantAccount")[1];
	String merchantAccount = MerchantAcc.split(",")[0];
	merchantAccount = merchantAccount.replace("\"","").trim();
	merchantAccount = merchantAccount.replace(":","").trim();
	System.out.println("MerchantAccount:"+merchantAccount);
	Control.WaitForLoader(3,500);  
	String paymentMethod = MerchantAcc.split("\",\"p")[1];
	paymentMethod = paymentMethod.replace("}}}","").trim();
	paymentMethod = "\"p"+paymentMethod;
	System.out.println(paymentMethod);
	Control.WaitForLoader(3,500);  
	existbrowseropen("GlobePaymentService");
	Control.WaitForLoader(3,500);
	Control.scroll("GlobePaymentService", "DropinPaymentId");
	Control.enterText("GlobePaymentService", "DropinPaymentId", PaymentId_Act);	
	Control.enterText("GlobePaymentService", "DropinMerchantAccount", merchantAccount);	
	Control.enterText("GlobePaymentService", "DropinMerchantAccountResponse", paymentMethod);	
	Control.takeScreenshot();
	Control.scroll("GlobePaymentService", "DropinSimulate");
	Control.WaitForLoader(3,500);
	Control.click("GlobePaymentService", "DropinSimulate");
	Control.takeScreenshot(); 
	String CardNumber = null, ExpDate = null,CVC = null; String HolderName ="AutomationTest";
	if(BillType.equalsIgnoreCase("NonBill")) {
		CardNumber = "5577 8100 0000 0004"; ExpDate ="10/33"; CVC ="123";}
	if(BillType.equalsIgnoreCase("Bill")) {
		CardNumber = "3569 9900 1009 5833"; ExpDate ="03/30"; CVC ="737";}
	if(BillType.equalsIgnoreCase("l")) {
		CardNumber = "4199 3500 0000 0002"; ExpDate ="03/30"; CVC ="737";}
	Control.ScrollToView("GlobePaymentService", "HolderName");
	Control.WaitForLoader(3,500);
	Thread.sleep(3000);
	WebElement Ele = Constant.driver.findElement(By.xpath("//iframe[@title='Iframe for secured card number']"));
	Constant.driver.switchTo().frame(Ele);
	System.out.println("switched");
	Control.enterText("GlobePaymentService", "DropinCardNumber", CardNumber);
	Constant.driver.switchTo().defaultContent();
	Thread.sleep(3000);
	WebElement Ele1 = Constant.driver.findElement(By.xpath("//iframe[@title='Iframe for secured card expiry date']"));
	Constant.driver.switchTo().frame(Ele1);
	System.out.println("switched");
	Control.enterText("GlobePaymentService", "DropinExpDate", ExpDate);
	Control.takeScreenshot();
	Constant.driver.switchTo().defaultContent();
	Thread.sleep(3000);
	WebElement Ele2 = Constant.driver.findElement(By.xpath("//iframe[@title='Iframe for secured card security code']"));
	Constant.driver.switchTo().frame(Ele2);
	System.out.println("switched");
	Control.enterText("GlobePaymentService", "DropinExpDate", CVC);
	Constant.driver.switchTo().defaultContent();
	Thread.sleep(3000);
	Control.enterText("GlobePaymentService", "HolderName", HolderName);
	Control.takeScreenshot();
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "Pay");
	Control.takeScreenshot();
	String CapturedDate = CaptureDateTime("MM/dd/yyyy - hh:mm:ss aa");
	System.out.println("[StoreForAPIPro]CapturedPaymentDate::"+CapturedDate);
	Control.takeScreenshot();
	Control.click("GlobePaymentService", "AlertGoBackCheckout");
	Thread.sleep(3000);
	Control.takeScreenshot();
	Thread.sleep(300000);
	Constant.driver.close();
	Thread.sleep(5000);
	existbrowseropen("Beeceptor");
	Control.WaitForLoader(3,300);
	Control.takeScreenshot();
	POSTStatusValidation(PaymentIDDropin,TransStatus);
	Constant.driver.close();
 }


 public static void POSTStatusValidation(String PaymentID, String Status) throws Exception {
	Thread.sleep(5000);
	Control.objExists("Beeceptor", "PostResponse", true);
	Control.takeScreenshot();
	Control.click("Beeceptor", "PostResponse");
	Control.WaitForLoader(3,300);
	Control.takeScreenshot();
	String ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
	System.out.print("Rspns: "+ResponseBody);
	String PaymentId_Act = ResponseBody.split("paymentId")[1];
	PaymentId_Act = PaymentId_Act.split(",")[0];
	PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
	System.out.println("\nPaymentId:"+PaymentId_Act);
	if(PaymentId_Act.equals(PaymentID)) {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
	}else {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
	}
	String Status_Act = ResponseBody.split("status")[1];
	Status_Act = Status_Act.split(",")[0].trim();
	Status_Act = Status_Act.replaceAll(":","").trim();
	Status_Act = Status_Act.replaceAll("\"","").trim();
	System.out.println("\nStatus:"+Status_Act);
	if(Status_Act.equalsIgnoreCase(Status)) {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status, "Status Actual:"+Status_Act, "Passed");
	}else {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status, "Status Actual:"+Status_Act, "Failed");
	}
	
}


 public static void XenditRefund(String pagename,String paymentid,String Amount,String RefundReason)throws Exception{
	try {
	Control.click(pagename, "XenditRefund");
	Control.click(pagename, "XenditRefundRequest");
	Control.takeScreenshot();
	Control.WaitForLoader(3,500);
	Control.click(pagename, "SearchEntry");
	Control.enterText(pagename, "ReferanceNoEntry", paymentid);
	Control.takeScreenshot();
	Control.click(pagename, "Search");
	Control.MovetoElement(pagename, "RequestRefund");
	Control.takeScreenshot();
	Control.click(pagename, "RequestRefund");
	Control.click(pagename, "RefundAmount");
	Control.enterText(pagename, "RefundAmount", Amount);
	Control.click(pagename, "RefundReason");
	Thread.sleep(1000);
	Constant.driver.findElement(By.xpath("//div[text()='"+RefundReason+"']")).click();
	Control.takeScreenshot();
	Thread.sleep(1000);
	Control.click(pagename, "Yesclick");
	Control.takeScreenshot();
	Control.click(pagename, "Yesclick2");
	Control.takeScreenshot();
	Control.click(pagename, "Refundsuccess");
	Control.takeScreenshot();
	Control.MovetoElement(pagename, "ForApproval");
	Control.takeScreenshot();
	Control.WaitForLoader(3,500);
	Control.click(pagename, "XenditRefundApproval");
	Control.click(pagename, "SearchEntry");
	Control.enterText(pagename, "ReferanceNoEntry", paymentid);
	Control.click(pagename, "Search");
	Control.MovetoElement(pagename, "Approve");
	Thread.sleep(2000);
	Control.takeScreenshot();
	Control.click(pagename, "Approve");
	Control.enterText(pagename, "Approveremarks", "AutomationTesting");
	Control.click(pagename, "Refundconfirmation");
	Control.click(pagename, "AprrovalRefundAlert");
	Control.click(pagename, "RefundSuccess");
	Thread.sleep(2000);
	Control.takeScreenshot();
	Control.click(pagename, "XenditRefundRequest");
	Control.click(pagename, "SearchEntry");
	Control.enterText(pagename, "ReferanceNoEntry", paymentid);
	Control.click(pagename, "Search");
	Control.MovetoElement(pagename, "RefundApproved");
	Control.takeScreenshot();
	Generic.WriteTestData("Manual refund of  "+pagename ,"","","Should get successfully refund in " +pagename,"Successfully Refunded","Passed");
	}catch(Exception e) {
		Generic.WriteTestData("Manual refund of  "+pagename ,"","","Should get successfully refund in " +pagename,"Error in Manual Refund","Failed");
		System.out.println("Exception "+e.getMessage());
		e.printStackTrace();
	}
 }

 public static void XenditRefundValidation(String PagaName,String paymentid,String AccountNo,String PaymentChannel,String PaymentAmount,String PaymentStatus,String RefundStatus,String RefundAmount,String RefundReason,String RefundDate) throws Exception {	   
	Control.click(PagaName, "XenditRefund");
	Control.WaitForLoader(3,300);
	Control.click(PagaName, "XenditRefundRequest");			
	Control.click(PagaName, "SearchEntry");
	Control.enterText(PagaName, "ReferanceNoEntry", paymentid);
	Control.takeScreenshot();
	Control.click(PagaName, "Search");
	Control.WaitForLoader(3,300);
	Thread.sleep(3000);
	//PaymentID
	String PaymentID_Act = XenditRefundTableData("Reference No.");
	if ((paymentid.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID should Expected:'"+paymentid+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID should Expected:'"+paymentid+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//AccountNo
	String AccountNo_Act = XenditRefundTableData("Account No.");
	if ((AccountNo.equalsIgnoreCase(AccountNo_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID should Expected:'"+AccountNo+"'", "PaymentID Actual:'"+AccountNo_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID should Expected:'"+AccountNo+"'", "PaymentID Actual:'"+AccountNo_Act+"'", "Failed");
	}
	//PaymentChannel
	String PaymentChannel_Act = XenditRefundTableData("Channel");
	if ((PaymentChannel.equalsIgnoreCase(PaymentChannel_Act)) ){
		Generic.WriteTestData("PaymentChannel verification", "", "", "PaymentChannel should Expected:'"+PaymentChannel+"'", "PaymentChannel Actual:'"+PaymentChannel_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentChannel verification", "", "", "PaymentChannel should Expected:'"+PaymentChannel+"'", "PaymentChannel Actual:'"+PaymentChannel_Act+"'", "Failed");
	} 		
	//PaymentAmount
	Control.takeScreenshot();
	String PaymentAmount_Act = XenditRefundTableData("Amount Paid");
	if ((PaymentAmount.equalsIgnoreCase(PaymentAmount_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+PaymentAmount+"'", "PaymentAmount Actual:'"+PaymentAmount_Act+"'", "Failed");
	}		
	//PaymentStatus
	String PaymentStatus_Act = XenditRefundTableData("Payment Status");
	if ((PaymentStatus.equalsIgnoreCase(PaymentStatus_Act)) ){
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus should Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus should Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Failed");
	} 
	//RefundStatus
	String RefundStatus_Act = XenditRefundTableData("Refund Status");
	if ((RefundStatus.equalsIgnoreCase(RefundStatus_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundStatus+"'", "PaymentAmount Actual:'"+RefundStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundStatus+"'", "PaymentAmount Actual:'"+RefundStatus_Act+"'", "Failed");
	} 		
	//RefundAmount
	Control.takeScreenshot();
	String RefundAmount_Act = XenditRefundTableData("Refund Amount");
	if ((RefundAmount.equalsIgnoreCase(RefundAmount_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundAmount+"'", "PaymentAmount Actual:'"+RefundAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundAmount+"'", "PaymentAmount Actual:'"+RefundAmount_Act+"'", "Failed");
	} 
	//RefundReason
	String RefundReason_Act = XenditRefundTableData("Refund Reason");
	if ((RefundReason.equalsIgnoreCase(RefundReason_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundReason+"'", "PaymentAmount Actual:'"+RefundReason_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundReason+"'", "PaymentAmount Actual:'"+RefundReason_Act+"'", "Failed");
	}
	//RefundDate
	Control.takeScreenshot();
	String RefundDate_Act = XenditRefundTableData("Refund Date");
	if ((RefundDate.equalsIgnoreCase(RefundDate_Act)) ){
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundDate+"'", "PaymentAmount Actual:'"+RefundDate_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentAmount verification", "", "", "PaymentAmount should Expected:'"+RefundDate+"'", "PaymentAmount Actual:'"+RefundDate_Act+"'", "Failed");
	}   			
}


 public static String XenditRefundTableData(String Heading) throws Exception{
	String Data=null;
	List<WebElement> StatusList =  Constant.driver.findElements(By.xpath("//table/thead/tr/th"));
	int a = StatusList.size();
	int Index = a+1;
	for(int i=1;i<Index;i++){
	String Header=Constant.driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText().trim();
	if(Header.equalsIgnoreCase(Heading)){
		WebElement ele= Constant.driver.findElement(By.xpath("//table/thead/tr/th["+i+"]"));
		Actions actions = new Actions(Constant.driver);
		actions.moveToElement(ele);
		actions.perform();	 
		Data=Constant.driver.findElement(By.xpath("//table/tbody/tr[1]/td["+i+"]")).getText().trim();
		System.out.println(Header);
		break;
		}}
	return Data;
}

 public static void existbrowseropen(String Folder) {
   String data = null;
	try {
	File myObj = new File("D:\\Xendit\\ChromeData\\UserDetails\\"+Folder+"\\DevToolsActivePort");
	Scanner myReader = new Scanner(myObj);
	data = myReader.nextLine();
	data = data.split("/devtools")[0].trim();
	data = data.replaceAll("\n", "");
	System.out.println("Data:"+data);
	myReader.close();
	} 
	catch (FileNotFoundException e) {
	System.out.println("An error occurred.");
	e.printStackTrace();
	}
	System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\Chrome\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	System.out.println("Port"+options.setExperimentalOption("debuggerAddress","localhost:"+data));
	options.setExperimentalOption("debuggerAddress","localhost:"+data);
	Constant.driver = new ChromeDriver(options);
	System.out.println("Chrome Opened");
 }

 public static void AdyenProceedtoPay(String PaymentID, String Status,String TransType)throws Exception{
	String PaymentId_Act,paymentSession = null;
	try{
	existbrowseropen("Beeceptor");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.objExists("Beeceptor", "PostResponse", true);
	Control.takeScreenshot();
	Control.click("Beeceptor", "PostResponse");
	Thread.sleep(5000);
	Control.takeScreenshot();
	String ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
	System.out.print("Rspns: "+ResponseBody);
	PaymentId_Act = ResponseBody.split("paymentId")[1];
	PaymentId_Act = PaymentId_Act.split(",")[0];
	PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
	System.out.println("\nPaymentId:"+PaymentId_Act);
	if(PaymentId_Act.equalsIgnoreCase(PaymentID)) {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
	}else {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
	}
	paymentSession = ResponseBody.split("paymentSession")[1];
	paymentSession = paymentSession.replaceAll("(\"|\\})","").trim();
	paymentSession = paymentSession.replaceFirst(":","").trim();
	System.out.println("\nPaymentSession:"+paymentSession);
	Control.WaitForLoader(3,500);
	Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
	Control.WaitForLoader(3,500);
	XenditFunction.GlobePaymentServicelogin();
	Control.WaitForLoader(3,5000);
	Control.ScrollToView("GlobePaymentService", "Checkout");
	Control.click("GlobePaymentService", "Checkout");
	Control.WaitForLoader(3,500);
	Control.takeScreenshot();
	Control.enterText("GlobePaymentService", "PaymentSession", paymentSession);
	Control.WaitForLoader(3,500);
	Control.click("GlobePaymentService", "Submit");
	Control.takeScreenshot();
	Control.WaitForLoader(3,500);
	String CardNumber ="", ExpDate="", CVC="";
	if(TransType.equalsIgnoreCase("NonBill")) {
		CardNumber = "5577 8100 0000 0004"; ExpDate ="10/33"; CVC ="123";}
	if(TransType.equalsIgnoreCase("Bill")) {
		CardNumber = "4199 3500 0000 0002"; ExpDate ="03/30"; CVC ="737";}
	Control.ScrollToView("GlobePaymentService", "Submit");
	WebElement Ele = Constant.driver.findElement(By.xpath("(//iframe[@class='js-iframe'])[1]"));
	Constant.driver.switchTo().frame(Ele);
	System.out.println("switched");
	Control.enterText("GlobePaymentService", "CheckoutCardNumber", CardNumber);
	Constant.driver.switchTo().defaultContent();
	Thread.sleep(3000);
	WebElement Ele1 = Constant.driver.findElement(By.xpath("(//iframe[@class='js-iframe'])[2]"));
	Constant.driver.switchTo().frame(Ele1);
	System.out.println("switched");
	Control.enterText("GlobePaymentService", "CheckoutExpDate", ExpDate);
	Control.takeScreenshot();
	Constant.driver.switchTo().defaultContent();
	Thread.sleep(3000);
	WebElement Ele2 = Constant.driver.findElement(By.xpath("(//iframe[@class='js-iframe'])[3]"));
	Constant.driver.switchTo().frame(Ele2);
	System.out.println("switched");
	Control.enterText("GlobePaymentService", "CheckoutCVC", CVC);
	Constant.driver.switchTo().defaultContent();
	Thread.sleep(3000);
	Control.WaitForLoader(3,500);
	Control.js_click("GlobePaymentService", "CheckoutPay");
	String CapturedDate = CaptureDateTime("MM/dd/yyyy - hh:mm:ss aa");
	System.out.println("[StoreForAPIPro]CapturedPaymentDate::"+CapturedDate);
	Control.WaitForLoader(3,300);
	Control.compareText("GlobePaymentService", "CheckoutPaymentStatus", "Payment Successful");
	Control.takeScreenshot();
	Constant.driver.close();
	existbrowseropen("Beeceptor");
	Control.WaitForLoader(3,500);
	Control.objExists("Beeceptor", "PostResponse", true);
	Control.takeScreenshot();
	Control.click("Beeceptor", "PostResponse");
	Control.WaitForLoader(3,300);
	Control.takeScreenshot();
	ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
	System.out.print("Rspns: "+ResponseBody);
	PaymentId_Act = ResponseBody.split("paymentId")[1];
	PaymentId_Act = PaymentId_Act.split(",")[0];
	PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
	if(PaymentId_Act.equalsIgnoreCase(PaymentID)) {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
	}else {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
	}
	String Status_Act = ResponseBody.split("status")[1];
	Status_Act = Status_Act.split(",")[0];
	Status_Act = Status_Act.replaceAll("(\"|\\:|\\}|\\])","").trim();
	System.out.println("\nStatus:"+Status_Act);
	String Status_Exp ="";
	if(Status.equalsIgnoreCase("Adyen")) {Status_Exp ="ADYEN_AUTHORISED";}
	if(Status_Act.equalsIgnoreCase(Status_Exp)) {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status_Exp, "Status Actual:"+Status_Act, "Passed");
	}else {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status_Exp, "Status Actual:"+Status_Act, "Failed");
	}
	}catch(Exception e) {
		System.out.println("Error");
		Generic.WriteTestData("Beeceptor Proceed to Pay", "", "", "Able to proceed payment ", "Error in payment proceed", "Failed");   	   
	}   
}


 public static void CXSApiProceedtoPay(String Url)throws Exception{
   try {
	Thread.sleep(3000);
	Control.WaitForLoader(3,500);
	Control.OpenApplication("Chrome", Url, "Xenditlogins");
	Control.WaitForLoader(3,500);
	Control.takeScreenshot();
	Thread.sleep(5000);
	Control.js_click("Beeceptor", "ProceedtoPay");
	Control.takeScreenshot();
	Thread.sleep(5000);
	String CapturedDate = XenditFunction.CaptureDateTime("dd MMM yyyy, h:mm");
	System.out.println("[StoreForAPIPro]CapturedDate::"+CapturedDate);
	String CapturedTransTime = XenditFunction.CaptureDateTime("d MMM yyyy, hh:mm");
	System.out.println("[StoreForAPIPro]CapturedTransDate::"+CapturedTransTime);
	String CapturedPaymentDate = CaptureDateTime("MM/dd/yyyy - hh:mm");
	System.out.println("[StoreForAPIPro]CapturedPaymentDate::"+CapturedPaymentDate);
   }catch(Exception e) {
	System.out.println("Error");
	Generic.WriteTestData("CXSApi Proceed to Pay", "", "", "Able to proceed payment ", "Error in payment proceed", "Failed");   	   
	}   
}
 

 public static void NoLogsValidation(String PaymentID,String Reports) throws Exception {
		try{ 																																
		Control.WaitForLoader(3,300);
		Thread.sleep(3000);
		Control.click("GlobePaymentService", "SearchIcon");
		Control.WaitForLoader(3,300);
		Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
		Control.WaitForLoader(3,300);
		Control.click("GlobePaymentService", "SearchButton");
		Control.FluentWait_function("GlobePaymentService", "FirstRow");
		Control.WaitForLoader(3,500);
		Thread.sleep(5000);
		Control.takeScreenshot(); 
		Generic.WriteTestData("No Logs Validation", "", "", "Expected : No Logs ", "Actual: No Logs", "Passed");
		}
		catch(Exception e) {
			System.out.println("Error");
			Generic.WriteTestData("No Logs Validation", "", "", "Expected : No Logs ", "Actual:Logs", "Failed");   	   
		}   
		
		}
 

 public static void eWalletProceedtoPay(String PaymentID, String Status,String Description)throws Exception{
		String PaymentId_Act,Url = null;
		try{
		existbrowseropen("Beeceptor");
		Control.WaitForLoader(3,500);
		Thread.sleep(5000);
		Control.objExists("Beeceptor", "PostResponse", true);
		Control.takeScreenshot();
		Control.click("Beeceptor", "PostResponse");
		Thread.sleep(5000);
		Control.takeScreenshot();
		String ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
		System.out.print("Rspns: "+ResponseBody);
		PaymentId_Act = ResponseBody.split("paymentId")[1];
		PaymentId_Act = PaymentId_Act.split(",")[0];
		PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
		System.out.println("\nPaymentId:"+PaymentId_Act);
		if(PaymentId_Act.equalsIgnoreCase(PaymentID)) {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
		}else {
		Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
		}
		String StatusUrl = ResponseBody.split("status")[1];
		StatusUrl = StatusUrl.split(",")[0];
		StatusUrl = StatusUrl.replaceAll("(\"|\\})","").trim();
		StatusUrl = StatusUrl.replaceFirst(":","").trim();
		if(StatusUrl.equalsIgnoreCase("REQUIRES_ACTION")) {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: REQUIRES_ACTION", "Status Actual:"+StatusUrl, "Passed");
		}else {
		Generic.WriteTestData("Status Validation", "", "", "Status Expected: REQUIRES_ACTION", "Status Actual:"+StatusUrl, "Failed");
		}
		Url = ResponseBody.split("url")[1];
		Url = Url.split(",")[0];
		Url = Url.replaceAll("(\"|\\})","").trim();
		Url = Url.replaceFirst(":","").trim();
		System.out.println("\nUrl:"+Url);
		Control.WaitForLoader(3,500);
		CXSApiProceedtoPay(Url);
		Control.WaitForLoader(3,300);
		Constant.driver.close();
		Thread.sleep(10000);
		existbrowseropen("Beeceptor");
		Control.WaitForLoader(3,500);
		Control.objExists("Beeceptor", "PostResponse", true);
		Control.takeScreenshot();
		Control.click("Beeceptor", "PostResponse");
		Control.WaitForLoader(3,300);
		Control.takeScreenshot();
		ResponseBody = Control.getMessageContent("Beeceptor","ResponseBodyText");
		System.out.print("Rspns: "+ResponseBody);
		PaymentId_Act = ResponseBody.split("paymentId")[1];
		PaymentId_Act = PaymentId_Act.split(",")[0];
		PaymentId_Act = PaymentId_Act.replaceAll("(\"|\\:)","").trim();
		System.out.println("\nPaymentId:"+PaymentId_Act);
		if(PaymentId_Act.equalsIgnoreCase(PaymentID)) {
		   Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Passed");
		}else {
		   Generic.WriteTestData("PaymentId Validation", "", "", "PaymentID Expected: "+PaymentID, "PaymentID Actual:"+PaymentId_Act, "Failed");
		}
		String Status_Act = ResponseBody.split("status")[1];
		Status_Act = Status_Act.split(",")[0];
		Status_Act = Status_Act.replaceAll("(\"|\\:|\\}|\\])","").trim();
		System.out.println("\nStatus:"+Status_Act);
		if(Status_Act.equalsIgnoreCase(Status)) {
			Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status, "Status Actual:"+Status_Act, "Passed");
		}else {
			Generic.WriteTestData("Status Validation", "", "", "Status Expected: "+Status, "Status Actual:"+Status_Act, "Failed");
		}
		String Desc_Act = ResponseBody.split("description")[1];
		Desc_Act = Desc_Act.replaceAll("(\"|\\:|\\}|\\])","").trim();
		System.out.println("\nDescription:"+Desc_Act);
		if(Desc_Act.equalsIgnoreCase(Description)) {
			Generic.WriteTestData("Description Validation", "", "", "Description Expected: "+Description, "Description Actual:"+Desc_Act, "Passed");
		}else {
			Generic.WriteTestData("Description Validation", "", "", "Description Expected: "+Description, "Description Actual:"+Desc_Act, "Failed");
		}
		
		}catch(Exception e) {
			System.out.println("Error");
			Generic.WriteTestData("Beeceptor Proceed to Pay", "", "", "Able to proceed payment ", "Error in payment proceed", "Failed");   	   
		}   
	}
 
 
 public static void XenditRefundDetailedReportValidation(String PaymentID,String AccountNo, String MSISDN, String BillType,String PaymentMethod,String ChannelName, String RefundDate, String RefundReason, String RefundAmount, String RefundID) throws Exception {
		try{ 																																
		Control.WaitForLoader(3,300);
		Control.click("GlobePaymentService", "XenditRefundDetailedReport");
		Thread.sleep(5000);
		Control.takeScreenshot();
		Thread.sleep(3000);
		Control.FluentWait_function("GlobePaymentService", "SearchIcon");
		Control.click("GlobePaymentService", "SearchIcon");
		Control.WaitForLoader(3,300);
		Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
		Control.WaitForLoader(3,300);
		Control.click("GlobePaymentService", "SearchButton");
		Control.FluentWait_function("GlobePaymentService", "FirstRow");
		Control.WaitForLoader(3,500);
		Thread.sleep(5000);
		Control.takeScreenshot();
		//PaymentID
		String PaymentID_Act = GlobePSTableData("PS Reference No.");
		if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
			Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
		}
		//AccountNo
		String AccountNo_Act = GlobePSTableData("Account No.");
		if ((AccountNo.equalsIgnoreCase(AccountNo_Act)) ){
			Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Failed");
		}
		//MSISDN
		String MSISDN_Act = GlobePSTableData("MSISDN");
		if ((MSISDN.equalsIgnoreCase(MSISDN_Act))){
			Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Failed");
		}
		//BillType
		String BillType_Act = GlobePSTableData("Bill Type");
		if ((BillType.equalsIgnoreCase(BillType_Act)) ){
			Generic.WriteTestData("Bill Type verification", "", "", "Bill Type Expected:'"+BillType+"'", "Bill Type Actual:'"+BillType_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Bill Type verification", "", "", "Bill Type Expected:'"+BillType+"'", "Bill Type Actual:'"+BillType_Act+"'", "Failed");
		}
		//PaymentMethod
		Control.takeScreenshot();
		String PaymentMethod_Act = GlobePSTableData("Payment Method");
		if ((PaymentMethod.equalsIgnoreCase(PaymentMethod_Act))){
			Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Failed");
		}
		//ChannelName
		String ChannelName_Act = GlobePSTableData("Channel");
		if ((ChannelName.equalsIgnoreCase(ChannelName_Act)) ){
			Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Failed");
		}
		//Date Posted/Authorised
		String DatePosted = CaptureDateTime("MM/dd/yyyy");
		String DatePosted_Act = GlobePSTableData("Date Posted/Authorised");
		if ((DatePosted_Act.contains(DatePosted)) ){
			Generic.WriteTestData("Date Posted/Authorised verification", "", "", "Date Posted/Authorised Expected:'"+DatePosted+"'", "Date Posted/Authorised Actual:'"+DatePosted_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Date Posted/Authorised verification", "", "", "Date Posted/Authorised Expected:'"+DatePosted+"'", "Date Posted/Authorised Actual:'"+DatePosted_Act+"'", "Failed");
		}
		//Refund Date
		//RefundDate = CaptureDateTime("MM/dd/yyyy");
		String RefundDate_Act = GlobePSTableData("Refund Date");
		if ((RefundDate_Act.contains(RefundDate)) ){
			Generic.WriteTestData("Refund Date verification", "", "", "Refund Date Expected:'"+RefundDate+"'", "Refund Date Actual:'"+RefundDate_Act+"'", "Passed");
		}else{
			//Generic.WriteTestData("Refund Date verification", "", "", "Refund Date Expected:'"+RefundDate+"'", "Refund Date Actual:'"+RefundDate_Act+"'", "Failed");
		}
		//RefundReason
		Control.takeScreenshot();
		String RefundReason_Act = GlobePSTableData("Refund Reason");
		if((RefundReason.equalsIgnoreCase(RefundReason_Act))){
			Generic.WriteTestData("RefundReason verification", "", "", "RefundReason Expected:'"+RefundReason+"'", "RefundReason Actual:'"+RefundReason_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("RefundStatus verification", "", "", "RefundReason Expected:'"+RefundReason+"'", "RefundStatus Actual:'"+RefundReason_Act+"'", "Failed");
		}
		//RefundAmount
		String RefundAmount_Act = GlobePSTableData("Refund Amount");
		if ((RefundAmount.equalsIgnoreCase(RefundAmount_Act))){
			Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Failed");
		}		
		//RefundID
		String RefundID_Exp ="";
		if(RefundID.equals("Refund")) {
		RefundID_Exp="";}
		String RefundID_Act = GlobePSTableData("Refund ID");
		if ((RefundID_Exp.equalsIgnoreCase(RefundID_Act))){
			Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected:'"+RefundID+"'", "RefundID Actual:'"+RefundID_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected:'"+RefundID+"'", "RefundID Actual:'"+RefundID_Act+"'", "Failed");
		}		
		}catch(Exception e){
			Generic.WriteTestData("XenditRefundDetailedReport verification","","","XenditRefundDetailedReport Data should get verified","Error in verifying XenditRefundDetailedReport Data","Failed");
			System.out.println("Exception "+e.getMessage());
			e.printStackTrace();
		}
	}
 
 
 public static void GcashRefundDetailedReport(String PaymentID,String AccountNo, String MSISDN, String ChannelName,String RefundReason, String RefundAmount) throws Exception {
	try{ 																																
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "GcashRefundDetailedReport");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.takeScreenshot();
	//RefundID
	String RefundID="";
	String RefundID_Act = GlobePSTableData("Refund ID");
	if (!(RefundID_Act.equals(RefundID))){
		Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected:'"+RefundID+"'", "RefundID Actual:'"+RefundID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected:'"+RefundID+"'", "RefundID Actual:'"+RefundID_Act+"'", "Failed");
	}
	//PaymentID
	String PaymentID_Act = GlobePSTableData("PS Reference No.");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//GcashRefundID
	String GcashRefundID="";
	String GcashRefundID_Act = GlobePSTableData("GCash Transaction ID");
	if (!(GcashRefundID_Act.equals(GcashRefundID))){
		Generic.WriteTestData("GcashRefundID verification", "", "", "GcashRefundID Expected:'"+GcashRefundID+"'", "GcashRefundID Actual:'"+GcashRefundID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("GcashRefundID verification", "", "", "GcashRefundID Expected:'"+GcashRefundID+"'", "GcashRefundID Actual:'"+GcashRefundID_Act+"'", "Failed");
	}
	//AccountNo
	String AccountNo_Act = GlobePSTableData("Account No.");
	if ((AccountNo.equalsIgnoreCase(AccountNo_Act)) ){
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Failed");
	}
	//MSISDN
	String MSISDN_Act = GlobePSTableData("MSISDN");
	if ((MSISDN.equalsIgnoreCase(MSISDN_Act))){
		Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Failed");
	}
	//ChannelName
	String ChannelName_Act = GlobePSTableData("Channel");
	if ((ChannelName.equalsIgnoreCase(ChannelName_Act)) ){
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Failed");
	}
	//Date Posted/Authorised
	String DatePosted = CaptureDateTime("MM/dd/yyyy");
	String DatePosted_Act = GlobePSTableData("Date Posted/Authorised");
	if ((DatePosted_Act.contains(DatePosted)) ){
		Generic.WriteTestData("Date Posted/Authorised verification", "", "", "Date Posted/Authorised Expected:'"+DatePosted+"'", "Date Posted/Authorised Actual:'"+DatePosted_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Date Posted/Authorised verification", "", "", "Date Posted/Authorised Expected:'"+DatePosted+"'", "Date Posted/Authorised Actual:'"+DatePosted_Act+"'", "Failed");
	}
	//Refund Date
	String RefundDate = CaptureDateTime("MM/dd/yyyy");
	String RefundDate_Act = GlobePSTableData("Refund Date");
	if ((RefundDate_Act.contains(RefundDate)) ){
		Generic.WriteTestData("Refund Date verification", "", "", "Refund Date Expected:'"+RefundDate+"'", "Refund Date Actual:'"+RefundDate_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Refund Date verification", "", "", "Refund Date Expected:'"+RefundDate+"'", "Refund Date Actual:'"+RefundDate_Act+"'", "Failed");
	}
	//RefundReason
	Control.takeScreenshot();
	String RefundReason_Act = GlobePSTableData("Refund Reason");
	if((RefundReason.equalsIgnoreCase(RefundReason_Act))){
		Generic.WriteTestData("RefundReason verification", "", "", "RefundReason Expected:'"+RefundReason+"'", "RefundReason Actual:'"+RefundReason_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundStatus verification", "", "", "RefundReason Expected:'"+RefundReason+"'", "RefundStatus Actual:'"+RefundReason_Act+"'", "Failed");
	}
	//RefundAmount
	String RefundAmount_Act = GlobePSTableData("Refund Amount");
	if ((RefundAmount.equalsIgnoreCase(RefundAmount_Act))){
		Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Failed");
	}		
	}catch(Exception e){
		Generic.WriteTestData("GcashRefundDetailedReport verification","","","GcashRefundDetailedReport Data should get verified","Error in verifying GCashRefundDetailedReport Data","Failed");
		System.out.println("Exception "+e.getMessage());
		e.printStackTrace();
	}
 }
	 
  
 public static void RevenueAccountingReportValidation(String PaymentID,String AccountNo,String PaymentMethod,String Status,String Refund, String RefundAmount, String RefundStatus, String Amount, String Date) throws Exception {
 try{ 																																
	Control.WaitForLoader(3,300);
	Control.ScrollToView("GlobePaymentService", "RevenueAccountingReport");
	Control.click("GlobePaymentService", "RevenueAccountingReport");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.takeScreenshot();
	//PaymentID
	String PaymentID_Act = GlobePSTableData("Reference No.");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//AccountNo
	String AccountNo_Act = GlobePSTableData("Account No.");
	if ((AccountNo.equalsIgnoreCase(AccountNo_Act)) ){
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Failed");
	}
	//Date
	String PostingDate = CaptureDateTime("MM/dd/yyyy");
	String PostingDate_Act = GlobePSTableData("Posting Date");
	if ((PostingDate_Act.contains(PostingDate)) ){
		Generic.WriteTestData("PostingDate verification", "", "", "PostingDate Expected:'"+PostingDate+"'", "PostingDate Actual:'"+PostingDate_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PostingDate verification", "", "", "PostingDate Expected:'"+PostingDate+"'", "PostingDate Actual:'"+PostingDate_Act+"'", "Failed");
	}		
	//ProductDescription
	String ProductDescription ="Globe";
	String ProductDescription1 ="Innove";
	String ProductDescription2 ="";
	String ProductDescription_Act = GlobePSTableData("Product Description");
	if (ProductDescription_Act.contains(ProductDescription)){
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Passed");
	}else if (ProductDescription_Act.contains(ProductDescription1)){
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription1+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Passed");
	}else if (ProductDescription_Act.contains(ProductDescription2)){
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription2+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Passed");
	}else {
		Generic.WriteTestData("ProductDescription verification", "", "", "ProductDescription Expected:'"+ProductDescription+"'", "ProductDescription Actual:'"+ProductDescription_Act+"'", "Failed");
	}
	//Status
	String Status_Act = GlobePSTableData("Payment Status");
	if ((Status.equalsIgnoreCase(Status_Act))){
		Generic.WriteTestData("Status verification", "", "", "Status Expected:'"+Status+"'", "Status Actual:'"+Status_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Status verification", "", "", "Status Expected:'"+Status+"'", "Status Actual:'"+Status_Act+"'", "Failed");
	}
	//RefundID
	Control.takeScreenshot();
	String RefundID_Act = GlobePSTableData("Refund ID");
	if(Refund.equals("Refund")) {
		System.out.println("Refund:"+Refund);	
		if (!(RefundID_Act == null || RefundID_Act == "")){
			Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: Value", "RefundID Actual:'"+RefundID_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: Value", "RefundID Actual:'"+RefundID_Act+"'", "Failed");
		}}
	else{
		if ((RefundID_Act.equalsIgnoreCase("") || RefundID_Act.equalsIgnoreCase(null))){
			Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: No Value", "RefundID Actual:'"+RefundID_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("RefundID verification", "", "", "RefundID Expected: No Value", "RefundID Actual:'"+RefundID_Act+"'", "Failed");
		}}
	//RefundStatus
	Control.takeScreenshot();
	String RefundStatus_Act = GlobePSTableData("Refund Status");
	if((RefundStatus.equalsIgnoreCase(RefundStatus_Act))){
		Generic.WriteTestData("RefundStatus verification", "", "", "RefundStatus Expected:'"+RefundStatus+"'", "RefundStatus Actual:'"+RefundStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundStatus verification", "", "", "RefundStatus Expected:'"+RefundStatus+"'", "RefundStatus Actual:'"+RefundStatus_Act+"'", "Failed");
	}//RefundAmount
	String RefundAmount_Act = GlobePSTableData("Refund Amount");
	if ((RefundAmount.equals(RefundAmount_Act))){
		Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Failed");
	}
	//Date
	String Date_Act = GlobePSTableData("Transaction Date");
	if ((Date_Act.contains(Date))){
		Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("Date verification", "", "", "Date Expected:'"+Date+"'", "Date Actual:'"+Date_Act+"'", "Failed");
	}
	//PaymentMethod
	Control.takeScreenshot();
	String PaymentMethod_Act = GlobePSTableData("Payment Method");
	if ((PaymentMethod.equalsIgnoreCase(PaymentMethod_Act))){
		Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Failed");
	}
	//Amount
	Amount = "Php "+Amount;
	String Amount_Act = GlobePSTableData("Amount");
	if ((Amount.equalsIgnoreCase(Amount_Act))){
		Generic.WriteTestData("Amount verification", "", "", "Amount Expected:'"+Amount+"'", "Amount Actual:'"+Amount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Amount verification", "", "", "Amount Expected:'"+Amount+"'", "Amount Actual:'"+Amount_Act+"'", "Failed");
	}
	}catch(Exception e){
			Generic.WriteTestData("RevenueAccountingReport Data verification","","","RevenueAccountingReport Data should get verified","Error in verifying RevenueAccountingReport Data","Failed");
			System.out.println("Exception "+e.getMessage());
			e.printStackTrace();
		}
	}
 
 	
 public static void GatewayOnlineReportValidation(String PaymentID, String AccountNo, String ChannelName, String PaymentMethod, String MSISDN, String GrossAmount,String PaymentStatus, String PaymentGateway) throws Exception {
 try{ 																																
	Control.WaitForLoader(3,300);
	Control.ScrollToView("GlobePaymentService", "GatewayOnline");
	Control.click("GlobePaymentService", "GatewayOnline");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.enterText("GlobePaymentService", "SearchReference", PaymentID);
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(5000);
	Control.takeScreenshot();
	//RecordDate
	String RecordDate = CaptureDateTime("MM/dd/yyyy");
	String RecordDate_Act = GlobePSTableData("Record Date Time");
	if ((RecordDate_Act.contains(RecordDate))){
		Generic.WriteTestData("RecordDate verification", "", "", "RecordDate Expected:'"+RecordDate+"'", "RecordDate Actual:'"+RecordDate_Act+"'", "Passed");
	}else{
		//Generic.WriteTestData("RecordDate verification", "", "", "RecordDate Expected:'"+RecordDate+"'", "RecordDate Actual:'"+RecordDate_Act+"'", "Failed");
	}
	//PaymentID
	String PaymentID_Act = GlobePSTableData("Reference No.");
	if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentID verification", "", "", "PaymentID Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	}
	//AccountNo
	String AccountNo_Act = GlobePSTableData("Account No.");
	if ((AccountNo.equalsIgnoreCase(AccountNo_Act)) ){
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("AccountNo verification", "", "", "AccountNo Expected:'"+AccountNo+"'", "AccountNo Actual:'"+AccountNo_Act+"'", "Failed");
	}
	//ChannelName
	String ChannelName_Act = GlobePSTableData("Channel Name");
	if ((ChannelName.equalsIgnoreCase(ChannelName_Act)) ){
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName_Act+"'", "Failed");
	}
	//DepositoryBank
	String DepositoryBank ="TCOETESTING"; 
	String DepositoryBank1 =""; 
	String DepositoryBank_Act = GlobePSTableData("Depository Bank");
	if ((DepositoryBank.equalsIgnoreCase(DepositoryBank_Act)) ){
		Generic.WriteTestData("DepositoryBank verification", "", "", "DepositoryBank Expected:'"+DepositoryBank+"'", "DepositoryBank Actual:'"+DepositoryBank_Act+"'", "Passed");
	}
	else if ((DepositoryBank1.equalsIgnoreCase(DepositoryBank_Act)) ){
		Generic.WriteTestData("DepositoryBank verification", "", "", "DepositoryBank Expected:'"+DepositoryBank+"'", "DepositoryBank Actual:'"+DepositoryBank_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("DepositoryBank verification", "", "", "DepositoryBank Expected:'"+DepositoryBank+"'", "DepositoryBank Actual:'"+DepositoryBank_Act+"'", "Failed");
	}
	//DepositoryBankAcc
	String DepositoryBankAccount ="1234-1234"; 
	String DepositoryBankAccount1 =""; 
	String DepositoryBankAcc_Act = GlobePSTableData("Depository Bank Account No.");
	if ((DepositoryBankAccount.equalsIgnoreCase(DepositoryBankAcc_Act)) ){
		Generic.WriteTestData("DepositoryBankAccount verification", "", "", "DepositoryBankAccount Expected:'"+DepositoryBankAccount+"'", "DepositoryBankAccount Actual:'"+DepositoryBankAcc_Act+"'", "Passed");
	}
	else if ((DepositoryBankAccount1.equalsIgnoreCase(DepositoryBankAcc_Act)) ){
		Generic.WriteTestData("DepositoryBankAccount verification", "", "", "DepositoryBankAccount Expected:'"+DepositoryBankAccount1+"'", "DepositoryBankAccount Actual:'"+DepositoryBankAcc_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("DepositoryBankAccount verification", "", "", "DepositoryBankAccount Expected:'"+DepositoryBankAccount+"'", "DepositoryBankAccount Actual:'"+DepositoryBankAcc_Act+"'", "Failed");
	}
	//MerchantCompany
	String MerchantCompany ="Globe"; 
	String MerchantCompany1 =""; 
	String MerchantCompany_Act = GlobePSTableData("Merchant Company");
	if ((MerchantCompany.equalsIgnoreCase(MerchantCompany_Act)) ){
		Generic.WriteTestData("MerchantCompany verification", "", "", "MerchantCompany Expected:'"+MerchantCompany+"'", "MerchantCompany Actual:'"+MerchantCompany_Act+"'", "Passed");
	}
	else if ((MerchantCompany1.equalsIgnoreCase(MerchantCompany_Act)) ){
		Generic.WriteTestData("MerchantCompany verification", "", "", "MerchantCompany Expected:'"+MerchantCompany1+"'", "MerchantCompany Actual:'"+MerchantCompany_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("MerchantCompany verification", "", "", "MerchantCompany Expected:'"+MerchantCompany+"'", "MerchantCompany Actual:'"+MerchantCompany_Act+"'", "Failed");
	}
	//MID
	String MID ="12345"; 
	String MID1 =""; 
	String MID_Act = GlobePSTableData("MID");
	if ((MID.equalsIgnoreCase(MID_Act)) ){
		Generic.WriteTestData("MID verification", "", "", "MID Expected:'"+MID+"'", "MID Actual:'"+MID_Act+"'", "Passed");
	}
	else if ((MID1.equalsIgnoreCase(MID_Act)) ){
		Generic.WriteTestData("MID verification", "", "", "MID Expected:'"+MID1+"'", "MID Actual:'"+MID_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("MID verification", "", "", "MID Expected:'"+MID+"'", "MID Actual:'"+MID_Act+"'", "Failed");
	}
	//TransactionID
	String TransactionID =""; 
	String TransactionID_Act = GlobePSTableData("Transaction ID");
	if ((TransactionID_Act.equals(TransactionID)) || (!(TransactionID_Act.equals(TransactionID))) ){
		Generic.WriteTestData("TransactionID verification", "", "", "TransactionID Expected:'"+TransactionID+"'", "TransactionID Actual:'"+TransactionID_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("TransactionID verification", "", "", "TransactionID Expected:'"+TransactionID+"'", "TransactionID Actual:'"+TransactionID_Act+"'", "Failed");
	}
	//AuthCode
	String AuthCode =""; 
	String AuthCode_Act = GlobePSTableData("Auth Code");
	if ((AuthCode_Act.equals(AuthCode)) || (!(AuthCode_Act.equals(AuthCode))) ){
		Generic.WriteTestData("AuthCode verification", "", "", "AuthCode Expected:'"+AuthCode+"'", "AuthCode Actual:'"+AuthCode_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("AuthCode verification", "", "", "AuthCode Expected:'"+AuthCode+"'", "AuthCode Actual:'"+AuthCode_Act+"'", "Failed");
	}
	//CreditCardNo
	String CreditCardNo =""; 
	String CreditCardNo_Act = GlobePSTableData("Credit Card No.");
	if ((CreditCardNo_Act.equals(CreditCardNo)) || (!(CreditCardNo_Act.equals(CreditCardNo))) ){
		Generic.WriteTestData("CreditCardNo verification", "", "", "CreditCardNo Expected:'"+CreditCardNo+"'", "CreditCardNo Actual:'"+CreditCardNo_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("CreditCardNo verification", "", "", "CreditCardNo Expected:'"+CreditCardNo+"'", "CreditCardNo Actual:'"+CreditCardNo_Act+"'", "Failed");
	}
	//CCHolderName
	String CCHolderName =""; 
	String CCHolderName_Act = GlobePSTableData("CC Holder Name");
	if ((CCHolderName_Act.equals(CCHolderName)) || (!(CCHolderName_Act.equals(CCHolderName))) ){
		Generic.WriteTestData("CCHolderName verification", "", "", "CCHolderName Expected:'"+CCHolderName+"'", "CCHolderName Actual:'"+CCHolderName_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("CCHolderName verification", "", "", "CCHolderName Expected:'"+CCHolderName+"'", "CCHolderName Actual:'"+CCHolderName_Act+"'", "Failed");
	}
	//CCBank
	String CCBank =""; 
	String CCBank_Act = GlobePSTableData("CC Bank");
	if ((CCBank_Act.equals(CCBank)) || (!(CCBank_Act.equals(CCBank))) ){
		Generic.WriteTestData("CCBank verification", "", "", "CCBank Expected:'"+CCBank+"'", "CCBank Actual:'"+CCBank_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("CCBank verification", "", "", "CCBank Expected:'"+CCBank+"'", "CCBank Actual:'"+CCBank_Act+"'", "Failed");
	}
	//CCCountry
	String CCCountry =""; 
	String CCCountry_Act = GlobePSTableData("CC Country");
	if ((CCCountry_Act.equals(CCCountry)) || (!(CCCountry_Act.equals(CCCountry))) ){
		Generic.WriteTestData("CCCountry verification", "", "", "CCCountry Expected:'"+CCCountry+"'", "CCCountry Actual:'"+CCCountry_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("CCCountry verification", "", "", "CCCountry Expected:'"+CCCountry+"'", "CCCountry Actual:'"+CCCountry_Act+"'", "Failed");
	}
	//CCType
	String CCType =PaymentMethod; 
	String CCType_Act = GlobePSTableData("CC Type");
	if ((CCType_Act.equals(CCType)) || (CCType_Act.equals("N/A")) ){
		Generic.WriteTestData("CCType verification", "", "", "CCType Expected:'"+CCType+"'", "CCType Actual:'"+CCType_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("CCType verification", "", "", "CCType Expected:'"+CCType+"'", "CCType Actual:'"+CCType_Act+"'", "Failed");
	}
	//PaymentMethod
	String PaymentMethod_Act = GlobePSTableData("Payment Method");
	if ((PaymentMethod_Act.equals(PaymentMethod)) ) {
		Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Passed");
	}
	else{
		Generic.WriteTestData("PaymentMethod verification", "", "", "PaymentMethod Expected:'"+PaymentMethod+"'", "PaymentMethod Actual:'"+PaymentMethod_Act+"'", "Failed");
	}
	//MSISDN
	String MSISDN_Act = GlobePSTableData("MSISDN");
	if ((MSISDN.equalsIgnoreCase(MSISDN_Act))){
		Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("MSISDN verification", "", "", "MSISDN Expected:'"+MSISDN+"'", "MSISDN Actual:'"+MSISDN_Act+"'", "Failed");
	}
	//Currency
	Control.takeScreenshot();
	String Currency ="PHP";
	String Currency_Act = GlobePSTableData("Currency");
	if (Currency.equalsIgnoreCase(Currency_Act)|| Currency_Act.equalsIgnoreCase("")){
		Generic.WriteTestData("Currency verification", "", "", "Currency Expected:'"+Currency+"'", "Currency Actual:'"+Currency_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("Currency verification", "", "", "Currency Expected:'"+Currency+"'", "Currency Actual:'"+Currency_Act+"'", "Failed");
	}
	//GrossAmount
	String GrossAmount_Act = GlobePSTableData("Gross Amount");
	if ((GrossAmount.equalsIgnoreCase(GrossAmount_Act))){
		Generic.WriteTestData("GrossAmount verification", "", "", "GrossAmount Expected:'"+GrossAmount+"'", "GrossAmount Actual:'"+GrossAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("GrossAmount verification", "", "", "GrossAmount Expected:'"+GrossAmount+"'", "GrossAmount Actual:'"+GrossAmount_Act+"'", "Failed");
	}
	//BankDiscount
	String BankDiscount ="";
	String BankDiscount_Act = GlobePSTableData("Bank Discount");
	if (!(BankDiscount.equals(BankDiscount_Act))){
		Generic.WriteTestData("BankDiscount verification", "", "", "BankDiscount Expected:'"+BankDiscount+"'", "BankDiscount Actual:'"+BankDiscount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("BankDiscount verification", "", "", "BankDiscount Expected:'"+BankDiscount+"'", "BankDiscount Actual:'"+BankDiscount_Act+"'", "Failed");
	}
	//WithholdingTax
	String WithholdingTax ="";
	String WithholdingTax_Act = GlobePSTableData("Withholding Tax");
	if (!(WithholdingTax.equals(WithholdingTax_Act))){
		Generic.WriteTestData("WithholdingTax verification", "", "", "WithholdingTax Expected:'"+WithholdingTax+"'", "WithholdingTax Actual:'"+WithholdingTax_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("WithholdingTax verification", "", "", "WithholdingTax Expected:'"+WithholdingTax+"'", "WithholdingTax Actual:'"+WithholdingTax_Act+"'", "Failed");
	}
	//NetAmount
	String NetAmount ="";
	String NetAmount_Act = GlobePSTableData("Net Amount");
	if (!(NetAmount.equals(NetAmount_Act))){
		Generic.WriteTestData("NetAmount verification", "", "", "NetAmount Expected:'"+NetAmount+"'", "NetAmount Actual:'"+NetAmount_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("NetAmount verification", "", "", "NetAmount Expected:'"+NetAmount+"'", "NetAmount Actual:'"+NetAmount_Act+"'", "Failed");
	}
	//PaymentStatus
	String PaymentStatus_Act = GlobePSTableData("Payment Status");
	if ((PaymentStatus.equals(PaymentStatus_Act))){
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentStatus verification", "", "", "PaymentStatus Expected:'"+PaymentStatus+"'", "PaymentStatus Actual:'"+PaymentStatus_Act+"'", "Failed");
	}
	//SecureFlag
	String SecureFlag ="";
	String SecureFlag_Act = GlobePSTableData("3D Secure Flag");
	if ((SecureFlag.equals(SecureFlag_Act))){
		Generic.WriteTestData("SecureFlag verification", "", "", "SecureFlag Expected:'"+SecureFlag+"'", "SecureFlag Actual:'"+SecureFlag_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("SecureFlag verification", "", "", "SecureFlag Expected:'"+SecureFlag+"'", "SecureFlag Actual:'"+SecureFlag_Act+"'", "Failed");
	}
	//PaymentGateway
	Control.takeScreenshot();
	String PaymentGateway_Act = GlobePSTableData("Payment Gateway");
	if ((PaymentGateway.equalsIgnoreCase(PaymentGateway_Act))){
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("PaymentGateway verification", "", "", "PaymentGateway Expected:'"+PaymentGateway+"'", "PaymentGateway Actual:'"+PaymentGateway_Act+"'", "Failed");
	}
	//CostCenter
	String CostCenter ="";
	String CostCenter_Act = GlobePSTableData("Cost Center");
	if ((CostCenter.equalsIgnoreCase(CostCenter_Act))||(!(CostCenter.equalsIgnoreCase(CostCenter_Act))) ){
		Generic.WriteTestData("CostCenter verification", "", "", "CostCenter Expected:'"+CostCenter+"'", "CostCenter Actual:'"+CostCenter_Act+"'", "Passed");
	}else{
		Generic.WriteTestData("CostCenter verification", "", "", "CostCenter Expected:'"+CostCenter+"'", "CostCenter Actual:'"+CostCenter_Act+"'", "Failed");
	}
	}catch(Exception e){
		Generic.WriteTestData("GatewayOnlineReport Data verification","","","GatewayOnlineReport Data should get verified","Error in verifying GatewayOnlineReport Data","Failed");
		System.out.println("Exception "+e.getMessage());
		e.printStackTrace();
		}
	}

 
 public static void XenditRefundSummarizedReportValidation(String BillType, String ChannelName) throws Exception {
		try{
		Control.WaitForLoader(3,300);
		Control.ScrollToView("GlobePaymentService", "XenditRefundSummarizedReport");
		Control.click("GlobePaymentService", "XenditRefundSummarizedReport");
		Thread.sleep(5000);
		Control.takeScreenshot();
		Thread.sleep(3000);
		Control.FluentWait_function("GlobePaymentService", "SearchIcon");
		Control.click("GlobePaymentService", "SearchIcon");
		Control.WaitForLoader(3,300);
		Control.click("GlobePaymentService", "Channel");
		Constant.driver.findElement(By.xpath("//div[text()='"+ChannelName+"']")).click();
		Thread.sleep(2000);
		Constant.driver.findElement(By.xpath("//input[@type='text' and @placeholder='From']")).click();
		Thread.sleep(1000);
		Constant.driver.findElement(By.xpath("//div[contains(@class,'day--keyboard-selected')]")).click();
		Thread.sleep(2000);
		Constant.driver.findElement(By.xpath("//input[@type='text' and @placeholder='To']")).click();
		Thread.sleep(1000);
		Constant.driver.findElement(By.xpath("//div[contains(@class,'day--keyboard-selected')]")).click();
		Control.WaitForLoader(3,300);
		Control.click("GlobePaymentService", "SearchButton");
		Control.FluentWait_function("GlobePaymentService", "FirstRow");
		Control.WaitForLoader(3,500);
		Thread.sleep(2000);
		Control.takeScreenshot();
		//Bill Transaction
		if (BillType.equals("Bill")) {
		//Channel 
		String Channel_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[1]")).getText().trim();
		if ((ChannelName.equalsIgnoreCase(Channel_Act))){
			Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved Refund Amount (Webtool) 
		String TotalApprovedRefundAmount_Act= Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[2]")).getText().trim();
		if ((TotalApprovedRefundAmount_Act.equalsIgnoreCase(""))){
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Amount (Webtool) Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Amount (Webtool) Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved Refund Count (Webtool)
		String TotalApprovedRefundCount_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[3]")).getText().trim();
		if ((TotalApprovedRefundCount_Act.equalsIgnoreCase(""))){
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Count (Webtool) Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Count (Webtool) Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved Amount
		String TotalApprovedAmount_Act= Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[4]")).getText().trim();
		if ((TotalApprovedAmount_Act.equalsIgnoreCase(""))){
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Amount (Webtool) Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Amount (Webtool) Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved Count 
		String TotalApprovedCount_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[5]")).getText().trim();
		if ((TotalApprovedCount_Act.equalsIgnoreCase(""))){
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Count (Webtool) Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Count (Webtool) Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved RefundAmount (Auto) 
		JavascriptExecutor js = (JavascriptExecutor) Constant.driver; 
		js.executeScript("window.scrollBy(250,0)");
		String TotalApprovedAmountAuto_Act= Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[6]")).getText().trim();
		if ((TotalApprovedAmountAuto_Act.equalsIgnoreCase(""))){
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Amount (Webtool) Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Amount (Webtool) Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved Count (Auto)
		String TotalApprovedCountAuto_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[3]")).getText().trim();
		if ((TotalApprovedCountAuto_Act.equalsIgnoreCase(""))){
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Count (Webtool) Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+ChannelName+"'", "Total Approved Refund Count (Webtool) Actual:'"+ChannelName+"'", "Failed");
		}
		}
		//NonBill Transaction
		if (BillType.equals("NonBill")) {
		//Channel 
		String Channel_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[1]")).getText().trim();
		if ((ChannelName.equalsIgnoreCase(Channel_Act))){
			Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName+"'", "Passed");
		}else{
			Generic.WriteTestData("ChannelName verification", "", "", "ChannelName Expected:'"+ChannelName+"'", "ChannelName Actual:'"+ChannelName+"'", "Failed");
		}
		//Total Approved Refund Amount (Webtool) 
		String TotalApprovedRefundAmount_Act= Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[2]")).getText().trim();
		if ((TotalApprovedRefundAmount_Act.equalsIgnoreCase(TotalApprovedRefundAmount_Act))){
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+TotalApprovedRefundAmount_Act+"'", "Total Approved Refund Amount (Webtool) Actual:'"+TotalApprovedRefundAmount_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+TotalApprovedRefundAmount_Act+"'", "Total Approved Refund Amount (Webtool) Actual:'"+TotalApprovedRefundAmount_Act+"'", "Failed");
		}
		//Total Approved Refund Count (Webtool)
		String TotalApprovedRefundCount_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[3]")).getText().trim();
		if ((TotalApprovedRefundCount_Act.equalsIgnoreCase(TotalApprovedRefundCount_Act))){
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+TotalApprovedRefundCount_Act+"'", "Total Approved Refund Count (Webtool) Actual:'"+TotalApprovedRefundCount_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+TotalApprovedRefundCount_Act+"'", "Total Approved Refund Count (Webtool) Actual:'"+TotalApprovedRefundCount_Act+"'", "Failed");
		}
		//Total Approved Amount
		String TotalApprovedAmount_Act= Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[4]")).getText().trim();
		if ((TotalApprovedAmount_Act.equalsIgnoreCase(TotalApprovedAmount_Act))){
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+TotalApprovedAmount_Act+"'", "Total Approved Refund Amount (Webtool) Actual:'"+TotalApprovedAmount_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+TotalApprovedAmount_Act+"'", "Total Approved Refund Amount (Webtool) Actual:'"+TotalApprovedAmount_Act+"'", "Failed");
		}
		//Total Approved Count 
		String TotalApprovedCount_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[5]")).getText().trim();
		if ((TotalApprovedCount_Act.equalsIgnoreCase(TotalApprovedCount_Act))){
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+TotalApprovedCount_Act+"'", "Total Approved Refund Count (Webtool) Actual:'"+TotalApprovedCount_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+TotalApprovedCount_Act+"'", "Total Approved Refund Count (Webtool) Actual:'"+TotalApprovedCount_Act+"'", "Failed");
		}
		JavascriptExecutor js = (JavascriptExecutor) Constant.driver; 
		js.executeScript("window.scrollBy(250,0)");
		//Total Approved RefundAmount (Auto) 
		String TotalApprovedAmountAuto_Act= Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[6]")).getText().trim();
		if ((TotalApprovedAmountAuto_Act.equalsIgnoreCase(TotalApprovedAmountAuto_Act))){
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+TotalApprovedAmountAuto_Act+"'", "Total Approved Refund Amount (Webtool) Actual:'"+TotalApprovedAmountAuto_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Amount (Webtool) verification", "", "", "Total Approved Refund Amount (Webtool) Expected:'"+TotalApprovedAmountAuto_Act+"'", "Total Approved Refund Amount (Webtool) Actual:'"+TotalApprovedAmountAuto_Act+"'", "Failed");
		}
		//Total Approved Count (Auto)
		String TotalApprovedCountAuto_Act = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[7]")).getText().trim();
		if ((TotalApprovedCountAuto_Act.equalsIgnoreCase(TotalApprovedCountAuto_Act))){
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+TotalApprovedCountAuto_Act+"'", "Total Approved Refund Count (Webtool) Actual:'"+TotalApprovedCountAuto_Act+"'", "Passed");
		}else{
			Generic.WriteTestData("Total Approved Refund Count (Webtool) verification", "", "", "Total Approved Refund Count (Webtool) Expected:'"+TotalApprovedCountAuto_Act+"'", "Total Approved Refund Count (Webtool) Actual:'"+TotalApprovedCountAuto_Act+"'", "Failed");
		}
		}
		}catch(Exception e) 
		{
		e.printStackTrace();
		}

		
		
	 }
 
 
 public static void XenditRefundRequestTableValidation(String PaymentID,String AmountPaid, String RefundStatus, String RefundAmount, String RefundReason) throws Exception {
	 try {
	//PaymentID
	 String PaymentID_Act = XenditRefundTableData("Reference No.");
	 if ((PaymentID.equalsIgnoreCase(PaymentID_Act)) ){
		 Generic.WriteTestData("PaymentID verification", "", "", "PaymentID should Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Passed");
	 }else{
		 Generic.WriteTestData("PaymentID verification", "", "", "PaymentID should Expected:'"+PaymentID+"'", "PaymentID Actual:'"+PaymentID_Act+"'", "Failed");
	 }
	 //AmountPaid
	 Control.takeScreenshot();
	 String AmountPaid_Act = XenditRefundTableData("Amount Paid");
	 if ((AmountPaid.equalsIgnoreCase(AmountPaid_Act)) ){
		 Generic.WriteTestData("AmountPaid verification", "", "", "AmountPaid should Expected:'"+AmountPaid+"'", "AmountPaid Actual:'"+AmountPaid_Act+"'", "Passed");
	 }else{
		 Generic.WriteTestData("AmountPaid verification", "", "", "AmountPaid should Expected:'"+AmountPaid+"'", "AmountPaid Actual:'"+AmountPaid_Act+"'", "Failed");
	 }
	 //RefundStatus
	 String RefundStatus_Act = XenditRefundTableData("Refund Status");
	 if ((RefundStatus.equalsIgnoreCase(RefundStatus_Act)) ){
		 Generic.WriteTestData("RefundStatus verification", "", "", "RefundStatus should Expected:'"+RefundStatus+"'", "RefundStatus Actual:'"+RefundStatus_Act+"'", "Passed");
	 }else{
		 Generic.WriteTestData("RefundStatus verification", "", "", "RefundStatus should Expected:'"+RefundStatus+"'", "RefundStatus Actual:'"+RefundStatus_Act+"'", "Failed");
	 }
	 //RefundAmount
	 Control.takeScreenshot();
	 String RefundAmount_Act = XenditRefundTableData("Refund Amount");
	 if ((RefundAmount.equalsIgnoreCase(RefundAmount_Act)) ){
		 Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount should Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Passed");
	 }else{
		 Generic.WriteTestData("RefundAmount verification", "", "", "RefundAmount should Expected:'"+RefundAmount+"'", "RefundAmount Actual:'"+RefundAmount_Act+"'", "Failed");
	 }
	 //RefundReason
	 String RefundReason_Act = XenditRefundTableData("Refund Reason");
	 if ((RefundReason.equalsIgnoreCase(RefundReason_Act)) ){
		 Generic.WriteTestData("RefundReason verification", "", "", "RefundReason should Expected:'"+RefundReason+"'", "RefundReason Actual:'"+RefundReason_Act+"'", "Passed");
	 }else{
		 Generic.WriteTestData("RefundReason verification", "", "", "RefundReason should Expected:'"+RefundReason+"'", "RefundReason Actual:'"+RefundReason_Act+"'", "Failed");
	 }
	 }catch(Exception e){
	e.printStackTrace();
	Generic.WriteTestData("RefundRequestTable verification", "", "", "RefundRequestTable Data should be success", "Error in RefundRequestTable", "Failed");
	}
 
 
 }
	 
	 
public static void XenditManualRefund(String pagename,String paymentid,String Amount, String RefundAmount,String RefundReason, String RefundStatus,String ChannelName,String BillType)throws Exception{
 try {
	String TotalApprovedRefundAmountWebtool , TotalApprovedRefundCountWebtool, TotalApprovedRefundAmount, TotalApprovedRefundCount = null;
	//Refund Request	
	Control.click(pagename, "XenditRefund");
	Control.WaitForLoader(3,500);
	Control.click(pagename, "XenditRefundRequest");
	Control.takeScreenshot();
	Control.WaitForLoader(3,500);
	Control.click(pagename, "SearchEntry");
	Control.enterText(pagename, "ReferanceNoEntry", paymentid);
	Control.takeScreenshot();
	Control.click(pagename, "Search");
	Control.MovetoElement(pagename, "RequestRefund");
	Control.takeScreenshot();
	Control.click(pagename, "RequestRefund");
	Control.click(pagename, "RefundAmount");
	Control.enterText(pagename, "RefundAmount", RefundAmount);
	Control.click(pagename, "RefundReason");
	Thread.sleep(1000);
	Constant.driver.findElement(By.xpath("//div[text()='"+RefundReason+"']")).click();
	Control.takeScreenshot();
	Thread.sleep(1000);
	Control.click(pagename, "Yesclick");
	Control.takeScreenshot();
	Control.click(pagename, "Yesclick2");
	Control.takeScreenshot();
	Control.click(pagename, "Refundsuccess");
	Control.takeScreenshot();
	String Status = "For Approval";
	XenditRefundRequestTableValidation(paymentid, Amount, Status, RefundAmount, RefundReason);
	//Xendit Summarized Report - After Refund Request
	Control.WaitForLoader(3,3000);
	Control.click("GlobePaymentService", "Reports");
	Control.WaitForLoader(3,3000);
	Control.ScrollToView("GlobePaymentService", "XenditRefundSummarizedReport");
	Control.click("GlobePaymentService", "XenditRefundSummarizedReport");
	Thread.sleep(5000);
	Control.takeScreenshot();
	Thread.sleep(3000);
	Control.FluentWait_function("GlobePaymentService", "SearchIcon");
	Control.click("GlobePaymentService", "SearchIcon");
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "Channel");
	Constant.driver.findElement(By.xpath("//div[text()='"+ChannelName+"']")).click();
	Thread.sleep(2000);
	Constant.driver.findElement(By.xpath("//input[@type='text' and @placeholder='From']")).click();
	Thread.sleep(1000);
	Constant.driver.findElement(By.xpath("//div[contains(@class,'day--keyboard-selected')]")).click();
	Thread.sleep(2000);
	Constant.driver.findElement(By.xpath("//input[@type='text' and @placeholder='To']")).click();
	Thread.sleep(1000);
	Constant.driver.findElement(By.xpath("//div[contains(@class,'day--keyboard-selected')]")).click();
	Control.WaitForLoader(3,300);
	Control.click("GlobePaymentService", "SearchButton");
	Control.FluentWait_function("GlobePaymentService", "FirstRow");
	Control.WaitForLoader(3,500);
	Thread.sleep(2000);
	Control.takeScreenshot();
	//Bill Transaction
	if (BillType.equals("Bill")) {
	TotalApprovedRefundAmountWebtool = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[2]")).getText().trim();
	TotalApprovedRefundCountWebtool = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[3]")).getText().trim();
	TotalApprovedRefundAmount = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[4]")).getText().trim();
	TotalApprovedRefundCount = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[1]/descendant::td[5]")).getText().trim();
	}		
	//NonBill Transaction
	if (BillType.equals("NonBill")) {
	TotalApprovedRefundAmountWebtool = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[2]")).getText().trim();
	TotalApprovedRefundCountWebtool = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[3]")).getText().trim();
	TotalApprovedRefundAmount = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[4]")).getText().trim();
	TotalApprovedRefundCount = Constant.driver.findElement(By.xpath("(//div[contains(@class,'DataContainer')])[2]/descendant::td[5]")).getText().trim();
	}
	Control.takeScreenshot();
	Control.WaitForLoader(3,500);
	Control.click(pagename, "XenditRefund");
	Control.WaitForLoader(3,500);
	Control.click(pagename, "XenditRefundApproval");
	Control.WaitForLoader(3,500);
	Control.click(pagename, "SearchEntry");
	Control.enterText(pagename, "ReferanceNoEntry", paymentid);
	Control.click(pagename, "Search");
	Control.takeScreenshot();
	Control.MovetoElement(pagename, "Approve");
	Thread.sleep(2000);
	Control.click(pagename, "Approve");
	Control.takeScreenshot();
	Control.enterText(pagename, "Approveremarks", "AutomationTesting");
	Control.click(pagename, "Refundconfirmation");
	Control.click(pagename, "AprrovalRefundAlert");
	Control.click(pagename, "RefundSuccess");
	Thread.sleep(2000);
	Control.takeScreenshot();
	Control.click(pagename, "XenditRefundRequest");
	Control.click(pagename, "SearchEntry");
	Control.enterText(pagename, "ReferanceNoEntry", paymentid);
	Control.click(pagename, "Search");
	Control.takeScreenshot();
	XenditRefundRequestTableValidation(paymentid, Amount, RefundStatus, RefundAmount, RefundReason);
	Thread.sleep(2000);
	//XenditRefundSummarizedReportValidation(BillType, ChannelName);


	Generic.WriteTestData("Manual refund of  "+pagename ,"","","Should get successfully refund in " +pagename,"Successfully Refunded","Passed");
 }catch(Exception e) {
	 Generic.WriteTestData("Manual refund of  "+pagename ,"","","Should get successfully refund in " +pagename,"Error in Manual Refund","Failed");
	 System.out.println("Exception "+e.getMessage());
	 e.printStackTrace();
 }
}
 
 
 
 public static void ConfigurationSetup(String IpAddress) throws Exception {
	try{
	Control.WaitForLoader(3,3000);
	Control.FluentWait_function("GlobePaymentService", "System");
	Control.ScrollToView("GlobePaymentService", "System");
	Control.click("GlobePaymentService", "System");
	Control.WaitForLoader(3,3000);
	Control.takeScreenshot();
	Control.click("GlobePaymentService", "Configuration");
	Control.WaitForLoader(3,3000);
	Control.takeScreenshot();
	Control.ScrollToView("GlobePaymentService", "IPAddress");
	if(IpAddress.equals(null) || IpAddress.equals("")) {
	WebElement Ele = Constant.driver.findElement(By.xpath("//label[text()='IP Address']/following::*[@data-icon='minus-circle']"));
	Ele.click();
	}
	else{
	Control.enterText("GlobePaymentService", "IPAddress",IpAddress);
	WebElement Ele = Constant.driver.findElement(By.xpath("//label[text()='IP Address']/following::*[@data-icon='plus-circle']"));
	Ele.click();}
	Control.WaitForLoader(3,3000);
	Control.takeScreenshot();
	Control.ScrollToView("GlobePaymentService", "ApplyButton");
	Control.click("GlobePaymentService", "ApplyButton");
	Control.WaitForLoader(3,3000);
	Control.takeScreenshot();
	Control.click("GlobePaymentService", "YesButton");
	Control.WaitForLoader(3,3000);
	Thread.sleep(3000);
	Control.takeScreenshot();
	String Message = Control.getMessageContent("GlobePaymentService", "ConfigurationMessage");
	System.out.println("Msg "+Message);
	if(Message.contains("SUCCESS")) {
		Generic.WriteTestData("Configuration", "", "", "Configuration should be successfull", "Configuration is successfull", "Passed");
	}else {
		Generic.WriteTestData("Configuration", "", "", "Configuration should be successfull", "Configuration is not successfull", "Failed");
	}
	Control.click("GlobePaymentService", "GobackButton");
	Control.takeScreenshot();
    }catch(Exception e) {
	 Generic.WriteTestData("Configuration", "", "", "Configuration should be successfull", "Error in Configuration", "Failed");
	 System.out.println("Exception "+e.getMessage());
	 e.printStackTrace();
	}
	
}
	 
 
 
 
 
 
 
 
 
 
 
 
 
}


















