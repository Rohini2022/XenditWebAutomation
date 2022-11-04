package utility;

import java.awt.Window;
import java.io.File;
import java.io.*;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class EmailLink {
	private static XSSFWorkbook workbook;
	private static XSSFSheet Worksheet;
	private static XSSFCell cell;
	
	public static String getcelldata(int rownum, int colnum) throws Exception
	{
		String celldata=null;
		DataFormatter formatter = new DataFormatter();
		try{
			celldata=formatter.formatCellValue(Worksheet.getRow(rownum).getCell(colnum));
		
		}catch (Exception e) {			
			System.out.println("Exception while getCellData : Row,Col"+rownum+","+colnum+e.getMessage());
			e.printStackTrace();
			
			//System.exit(-1);
		}
		return celldata;
	
	}
	
	public static File getLatestFilefromDir() throws Exception{
	    File dir = new File("C:\\Users\\Project\\Downloads\\");
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    Thread.sleep(500);
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	    }

	public static void EmailValidation(String User) throws Exception
	{
		Control.OpenApplication("Chrome",Generic.ReadFromExcel("EmailURL", "TestData", 1),User);
		Thread.sleep(10000);
		Control.click("EmailChecking", "email");
		Thread.sleep(3000);
		WebElement ele =Control.findElement("EmailChecking", "excellink");
		ele.click();
		Thread.sleep(15000);
		CreatePlanMap();
		String Reason=Constant.Value.get("Row1").get("Reason");
		Generic.WriteTestData("Verifying Reason", "", "", "File upload Failed", Reason, "Passed");
		//Constant.driver.close();
		//Generic.TestScriptEnds();
	}
	public static void CreatePlanMap()
	{
		String planName,Name,Value;
		//int totalRows;
		try {
			FileInputStream ExcelFile= new FileInputStream(getLatestFilefromDir());
			try{
				workbook = new XSSFWorkbook(ExcelFile);
				}
			catch (Exception exp)
			{
				exp.printStackTrace();
			}
			Worksheet =  workbook.getSheetAt(0);
			//totalRows = Worksheet.getLastRowNum(); 
			planName = null;			
			{				
				HashMap<String, String> pMap = new HashMap<String,String>();
				for(int k=0;k<42;k++) {
					Name = getcelldata(0,k);
					Value = getcelldata(1,k);
					if(Value==null) {
						Value="";
					}else {
						
						Value=Value.trim();
					}					
					//System.out.println("Adding '"+Name+"' as '"+Value+"'");
					pMap.put(Name, Value);
				}
				//pMap.put("Page", "0");
				//planName = getcelldata(1,0).trim();
				Constant.Value.put("Row1", pMap);
				//System.out.println("Adding '"+planName+"' as '"+pMap+"'");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(Constant.Value);
	}

}
