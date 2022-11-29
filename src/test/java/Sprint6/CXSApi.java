package Sprint6;

import org.openqa.selenium.By;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.XenditFunction;

public class CXSApi {

public static void test() throws Exception {
		
//----------------------------------------------PROCEED TO PAY--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				
	if (System.getProperty("API").equalsIgnoreCase("CXSApiProceedToPay")){
		XenditFunction.CXSApiProceedtoPay(System.getProperty("Url"));
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
		XenditFunction.XenditDashTransactionValidation(System.getProperty("PaymentID"),System.getProperty("Status"),System.getProperty("Account"),System.getProperty("PaymentType"),System.getProperty("PaymentChannel"),System.getProperty("PaymentAmount"),System.getProperty("TransDate"));
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
//		for(int i=0;i<10;i++) {
//		Thread.sleep(100000);
//		System.out.println("Waiting for OR Report");
//		Constant.driver.findElement(By.xpath("(//div[contains(text(),'Channel Transactions')])[1]"));
//		}
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
	
		
		
}



}
