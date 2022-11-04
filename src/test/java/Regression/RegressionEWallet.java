package Regression;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.XenditFunction;

public class RegressionEWallet {

	


public static void test() throws Exception {
		
		
//-------------------------------------------BEECEPTOR------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				
	if (System.getProperty("API").equalsIgnoreCase("EndpointCreation")){
		XenditFunction.EndpointCreation(System.getProperty("Endpoint"));	
 	}
	
	else if (System.getProperty("API").equalsIgnoreCase("EWalletProceedToPay")){
		XenditFunction.eWalletProceedtoPay(System.getProperty("PaymentID"),System.getProperty("Status"),System.getProperty("Description"));
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
		for(int i=0;i<9;i++) {
		Thread.sleep(100000);
		System.out.println("Waiting for OR Report");}
		XenditFunction.existbrowseropen("GlobePaymentService");
		Control.WaitForLoader(3,3000);
		XenditFunction.ORReportValidation(System.getProperty("PaymentID"), System.getProperty("Date"), System.getProperty("ChannelName"), System.getProperty("Amount"), System.getProperty("PaymentGateway"), System.getProperty("Status"), System.getProperty("MobileNumber"), System.getProperty("ProductName"));
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
			
}

//--------------------------------------------END---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
}
