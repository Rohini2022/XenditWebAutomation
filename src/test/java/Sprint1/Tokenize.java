package Sprint1;

import java.net.UnknownHostException;

import utility.Control;
import utility.Generic;
import utility.XenditFunction;

public class Tokenize {

	public static void tokenize(String Amount, String CardNo) throws Exception {
	Control.OpenApplication("Chrome",Generic.ReadFromExcel("Tokenize", "TestData", 1),"Tokenize");
	Control.WaitForLoader(3,500);
	String PaymentMethodID = XenditFunction.Tokenize(Amount, CardNo);
	System.out.println("PaymentMethodID "+PaymentMethodID);
	}
}
