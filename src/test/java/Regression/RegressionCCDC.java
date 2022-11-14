package Regression;

import org.openqa.selenium.By;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.XenditFunction;

public class RegressionCCDC {

	
public static void test() throws Exception {
		
		
//-------------------------------------------BEECEPTOR -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				
	if (System.getProperty("API").equalsIgnoreCase("EndpointCreation")){
		XenditFunction.EndpointCreation(System.getProperty("Endpoint"));	
	}
	
	else if (System.getProperty("API").equalsIgnoreCase("PostStatusValidation")){
		Control.WaitForLoader(3,500);
		XenditFunction.existbrowseropen("Beeceptor");
		Control.WaitForLoader(3,500);
		XenditFunction.POSTStatusValidation(System.getProperty("PaymentId"),System.getProperty("Status"));
		String CapturedDate = XenditFunction.CaptureDateTime("MM/dd/yyyy");
		System.out.println("[StoreForAPIPro]CapturedDate::"+CapturedDate);
		Constant.driver.close();
	}
	
//-------------------------------------------TOKENIZE -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	else if (System.getProperty("API").equalsIgnoreCase("Tokenize")){
		String PaymentMethodID = XenditFunction.Tokenize(System.getProperty("Amount"),System.getProperty("CardNo"));
		PaymentMethodID = PaymentMethodID.trim();
		System.out.println("[StoreForAPIPro]PaymentMethodID::"+PaymentMethodID);
		Constant.driver.close();
	}

//----------------------------------------------XENDIT DASHBOARD-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	else if (System.getProperty("API").equalsIgnoreCase("XenditDashboardValidation")){
		Control.OpenApplication("Chrome", Generic.ReadFromExcel("XenditDashboard", "TestData", 1), "XenditDashboard");
		Control.WaitForLoader(3,3000);
		XenditFunction.XenditDashlogin();
		Control.WaitForLoader(3,3000);
		XenditFunction.XenditDashPaymentIDValidation(System.getProperty("PaymentID"),System.getProperty("PaymentType"),System.getProperty("PaymentStatus"),System.getProperty("PaymentChannel"),System.getProperty("PaymentAmount"),System.getProperty("Date"));
		Constant.driver.close();
		Control.OpenApplication("Chrome", Generic.ReadFromExcel("XenditDashboard", "TestData", 1), "XenditDashboard");
		Control.WaitForLoader(3,3000);
		XenditFunction.XenditDashlogin();
		Control.WaitForLoader(3,3000);
		XenditFunction.XenditDashTransactionValidation(System.getProperty("PaymentID"),System.getProperty("Status"),System.getProperty("Account"),System.getProperty("PaymentType"),System.getProperty("PaymentChannel"),System.getProperty("TransAmount"),System.getProperty("TransDate"));
		Constant.driver.close();
			
		}
		
//----------------------------------------------GLOBE PAYMENT SERVICE - REPORTS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
		else if (System.getProperty("API").equalsIgnoreCase("TransactionLogs")) {
			Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
			Control.WaitForLoader(3,3000);
			XenditFunction.GlobePaymentServicelogin();
			Control.WaitForLoader(3,3000);
			Control.FluentWait_function("GlobePaymentService", "Reports");
			Control.click("GlobePaymentService", "Reports");
			Control.WaitForLoader(3,3000);
			XenditFunction.TransactionLogsValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("ChannelName"), System.getProperty("EmailAddress"),  System.getProperty("PaymentMethod"), System.getProperty("MobileNumber"), System.getProperty("Status"), System.getProperty("Refund"), System.getProperty("RefundAmount"),  System.getProperty("RefundStatus"),  System.getProperty("Amount"),  System.getProperty("Date"),  System.getProperty("PaymentGateway"));
			Control.WaitForLoader(3,3000);
			//XenditFunction.NoLogsValidation(System.getProperty("PaymentID"), "XenditRefundDetailedReport");
			XenditFunction.XenditRefundDetailedReportValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("MobileNumber"), "NonBill", System.getProperty("PaymentMethod"), System.getProperty("ChannelName"), System.getProperty("Date"), "DUPLICATE", System.getProperty("RefundAmount"), System.getProperty("Refund"));
			//String PaymentID,String AccountNo, String MSISDN, String BillType,String PaymentMethod,String ChannelName, String RefundDate, String RefundReason, String RefundAmount, String RefundID) throws Exception {
			XenditFunction.XenditRefundSummarizedReportValidation("NonBill", System.getProperty("ChannelName"));
			Control.WaitForLoader(3,3000);
			Constant.driver.findElement(By.xpath("//button[contains(@class,'Export')]")).click();
			Control.takeScreenshot();
			Constant.driver.findElement(By.xpath("//div[contains(text(),'Yes')]")).click();
			Control.takeScreenshot();
			Constant.driver.close();
		}
			
		else if (System.getProperty("API").equalsIgnoreCase("PrepaidReports")) {
			Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
			Control.WaitForLoader(3,3000);
			XenditFunction.GlobePaymentServicelogin();
			Control.WaitForLoader(3,3000);
			Control.click("GlobePaymentService", "Reports");
			Control.WaitForLoader(3,3000);
			XenditFunction.TransactionLogsValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("ChannelName"), System.getProperty("EmailAddress"),  System.getProperty("PaymentMethod"), System.getProperty("MobileNumber"), System.getProperty("Status"), System.getProperty("Refund"), System.getProperty("RefundAmount"),  System.getProperty("RefundStatus"),  System.getProperty("Amount"),  System.getProperty("Date"),  System.getProperty("PaymentGateway"));
			Control.WaitForLoader(3,3000);
			XenditFunction.ChannelTransactionsValidation(System.getProperty("TransType"), System.getProperty("ChannelName"));
			Control.WaitForLoader(3,3000);
			for(int i=0;i<=10;i++) {
			Thread.sleep(100000);
			System.out.println("Waiting for OR Report");
			Constant.driver.findElement(By.xpath("(//div[contains(text(),'Channel Transactions')])[1]"));
			}
			XenditFunction.existbrowseropen("GlobePaymentService");
			Control.WaitForLoader(3,3000);
			XenditFunction.ORReportValidation(System.getProperty("PaymentID"), System.getProperty("Date"), System.getProperty("ChannelName"), System.getProperty("Amount"), System.getProperty("PaymentGateway"), System.getProperty("Status"), System.getProperty("MobileNumber"), System.getProperty("ProductName"));
			Constant.driver.close();
		}
		
		
		else if (System.getProperty("API").equalsIgnoreCase("PostpaidReports")) {
			Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
			Control.WaitForLoader(3,3000);
			XenditFunction.GlobePaymentServicelogin();
			Control.WaitForLoader(3,3000);
			Control.click("GlobePaymentService", "Reports");
			Control.WaitForLoader(3,3000);
			XenditFunction.TransactionLogsValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("ChannelName"), System.getProperty("EmailAddress"),  System.getProperty("PaymentMethod"), System.getProperty("MobileNumber"), System.getProperty("Status"), System.getProperty("Refund"), System.getProperty("RefundAmount"), System.getProperty("RefundStatus"),  System.getProperty("Amount"),  System.getProperty("Date"),  System.getProperty("PaymentGateway"));
			Control.WaitForLoader(3,3000);
			XenditFunction.ChannelTransactionsValidation(System.getProperty("TransType"), System.getProperty("ChannelName"));
			Control.WaitForLoader(3,3000);
			XenditFunction.GatewayOnlineReportValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("ChannelName"), System.getProperty("PaymentMethod"), System.getProperty("MobileNumber"), System.getProperty("Amount"), System.getProperty("Status"), System.getProperty("PaymentGateway"));
			Control.WaitForLoader(3,3000);
			XenditFunction.RevenueAccountingReportValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("PaymentMethod"),System.getProperty("Status"),System.getProperty("Refund"),System.getProperty("RefundAmount"),System.getProperty("RefundStatus"),System.getProperty("Amount"),System.getProperty("Date"));
			Constant.driver.close();
		}
			
		
	//-------------------------------------------MANUAL REFUND-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				
					
		else if (System.getProperty("API").equalsIgnoreCase("ManualRefund")) {
			Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
			Control.WaitForLoader(3,500);
			XenditFunction.GlobePaymentServicelogin();
			Control.WaitForLoader(3,500);
			XenditFunction.XenditRefund("Gcash", System.getProperty("PaymentID"), System.getProperty("Amount"), System.getProperty("Reason"));
			Constant.driver.close();
		}	
				
		
		else if (System.getProperty("API").equalsIgnoreCase("Refund")) {
			
		Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
		Control.WaitForLoader(3,3000);
		XenditFunction.GlobePaymentServicelogin();
		Control.WaitForLoader(3,3000);
		XenditFunction.XenditManualRefund("XenditRefund", "S121667980111473025", "100.00", "100.00", "Duplicate", "REQUESTED","PayBill-SIT12", "NonBill");
		Control.WaitForLoader(3,3000);
		//XenditFunction.XenditRefundSummarizedReportValidation("NonBill", "PayBill-SIT12");
		String CapturedDate = XenditFunction.CaptureDateTime("MM/dd/yyyy");
		System.out.println("[StoreForAPIPro]CapturedDate::"+CapturedDate);
		Constant.driver.close();	
		}
	

	

}
}



