package Regression;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.XenditFunction;

public class RegressionGcashAdyen {



public static void test() throws Exception {
		

//-------------------------------------------BEECEPTOR------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//-------------------------------------------ENDPOINT CREATION------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	if (System.getProperty("API").equalsIgnoreCase("EndpointCreation")){
		XenditFunction.EndpointCreation(System.getProperty("Endpoint"));	
 	}

//-------------------------------------------GCASH PROCEED TO PAY------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	else if (System.getProperty("API").equalsIgnoreCase("GcashProceedToPay")){
		XenditFunction.GCashProceedtoPay(System.getProperty("PaymentID"),System.getProperty("Status"));
		Constant.driver.close();
	}
	
//-------------------------------------------ADYEN PROCEED TO PAY------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				
	else if (System.getProperty("API").equalsIgnoreCase("AdyenProceedToPay")){
		XenditFunction.AdyenProceedtoPay(System.getProperty("PaymentID"),System.getProperty("Status"),System.getProperty("TransType"));
		Constant.driver.close();
	}
	
//-------------------------------------------POST STATUS VALIDATION------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	else if (System.getProperty("API").equalsIgnoreCase("PostStatusValidation")){
		Control.WaitForLoader(3,500);
		XenditFunction.existbrowseropen("Beeceptor");
		Control.WaitForLoader(3,500);
		XenditFunction.POSTStatusValidation(System.getProperty("PaymentId"),System.getProperty("Status"));
		String CapturedDate = XenditFunction.CaptureDateTime("MM/dd/yyyy");
		System.out.println("[StoreForAPIPro]CapturedDate::"+CapturedDate);
		Constant.driver.close();
	}
			
//-------------------------------------------GLOBE PAYMENT SERVICE-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
	
//-------------------------------------------MANUAL REFUND------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
					
	else if (System.getProperty("API").equalsIgnoreCase("ManualRefund")) {
		Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
		Control.WaitForLoader(3,500);
		XenditFunction.GlobePaymentServicelogin();
		Control.WaitForLoader(3,500);
		XenditFunction.XenditRefund(System.getProperty("Type"), System.getProperty("PaymentID"), System.getProperty("Amount"), System.getProperty("Reason"));
		Constant.driver.close();
	}	
	
//-------------------------------------------TRANSACTION LOGS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		
	else if (System.getProperty("API").equalsIgnoreCase("TransactionLogs")) {
		Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
		Control.WaitForLoader(3,500);
		XenditFunction.GlobePaymentServicelogin();
		Control.WaitForLoader(3,500);
		Control.click("GlobePaymentService", "Reports");
		Control.WaitForLoader(3,500);
		XenditFunction.TransactionLogsValidation(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("ChannelName"), System.getProperty("EmailAddress"),  System.getProperty("PaymentMethod"), System.getProperty("MobileNumber"), System.getProperty("Status"), System.getProperty("Refund"), System.getProperty("RefundStatus"),  System.getProperty("RefundAmount"),  System.getProperty("Amount"),  System.getProperty("Date"),  System.getProperty("PaymentGateway"));
		Constant.driver.close();
	}
	
//-------------------------------------------GCASH REFUND REPORT------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
	else if (System.getProperty("API").equalsIgnoreCase("GcashRefundReport")) {
		Control.OpenApplication("Chrome", Generic.ReadFromExcel("GlobePaymentService", "TestData", 1), "GlobePaymentService");
		Control.WaitForLoader(3,500);
		XenditFunction.GlobePaymentServicelogin();
		Control.WaitForLoader(3,500);
		Control.click("GlobePaymentService", "Reports");
		Control.WaitForLoader(3,500);
		XenditFunction.GcashRefundDetailedReport(System.getProperty("PaymentID"), System.getProperty("AccountNo"), System.getProperty("MobileNumber"), System.getProperty("ChannelName"),System.getProperty("RefundReason"), System.getProperty("RefundAmount"));
		Constant.driver.close();
	}	
	
//--------------------------------------------DROPIN SIMULATOR---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
	else if (System.getProperty("API").equalsIgnoreCase("DropinSimulator")) {
		XenditFunction.DropInSimulator(System.getProperty("ChannelName"), System.getProperty("BillType"), System.getProperty("AccountNo"),System.getProperty("MobileNumber"), System.getProperty("EmailAddress"), System.getProperty("Amount"),System.getProperty("EndpointUrl"),System.getProperty("Status"));
		}

}


//--------------------------------------------END---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}