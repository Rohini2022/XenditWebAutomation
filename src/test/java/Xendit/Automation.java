package Xendit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
//import java.io.File;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Regression.RegressionEWallet;
import Regression.RegressionGcashAdyen;
import Sprint1.*;
import Sprint6.*;
import XenditWebFlow.WebValidation;
import utility.Constant;
import utility.Control;
//import utility.EmailLink;
import utility.Generic;
import utility.XenditFunction;

public class Automation {

	@BeforeClass
	public void setUp() throws Exception {
		String Dt = XenditFunction.CaptureDateTime("MMdd");
		Generic.ScriptStart("Xendit",Dt);
	}
	
	
	
	@Test
	public  void main() throws Exception {
	
			CXSApi.test();
		
		//RegressionGcashAdyen.test();;
		
		
		//RegressionEWallet.test();
	
		
		

	}	
		
		
	
	
	
	@AfterClass 
	public void close() throws Exception {   
		
		Control.GeneratePDFReport(); 
	}
}