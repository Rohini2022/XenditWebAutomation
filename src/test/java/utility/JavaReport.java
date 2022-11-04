/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP-PC
 */
public class JavaReport {
	
	
    
    /*private static final String path_to_python_scripts_raw="C:\\Python27\\";
    private static final String path_to_input_excel="C:\\Python27\\Input\\";
    private static final String path_to_output_pdf="C:\\Python27\\Output\\";
    private static final String input_excel_name="GP_Menu_Validation.xlsx";
    private static final String output_pdf_name="GP_Menu_Validation.pdf";
    private static  String path_to_python_script=null;*/
   
    /*private static final String python_command_raw=path_to_python_scripts_raw+"python.exe RP3.py "+path_to_python_scripts_raw+" "+input_excel_name+" "+path_to_input_excel+" "+path_to_output_pdf+" "+output_pdf_name;
    private static  String python_command=null;
    private static  String line=null;*/
	
	
	//private static final String python_command_raw=path_to_python_scripts_raw+"python.exe RP3.py "+path_to_python_scripts_raw+" "+input_excel_name+" "+path_to_input_excel+" "+path_to_output_pdf+" "+output_pdf_name;
    
    public void GenerateReport_old(String path_to_python_scripts,String path_to_input_excel,String path_to_output_pdf,String input_excel_name,String output_pdf_name)
    {
    	//String python_command=path_to_python_scripts+"python.exe RP3.py "+path_to_python_scripts+" "+input_excel_name+" "+path_to_input_excel+" "+path_to_output_pdf+" "+output_pdf_name+" "+"PC Y "+qtestConstants.releaseId+" "+qtestConstants.releaseName+" "+qtestConstants.projectId+" "+qtestConstants.projectName+" "+qtestConstants.cycleId+" "+qtestConstants.cycleName;
    	String python_command=path_to_python_scripts+"python.exe run.py "+input_excel_name;
    	try
                    {
                	   
                	   	path_to_python_scripts=Constant.path_to_python_scripts;
                        path_to_python_scripts=URLDecoder.decode(path_to_python_scripts, "UTF-8");
                        System.out.println("Path to python script : "+path_to_python_scripts);
                        python_command=URLDecoder.decode(python_command, "UTF-8");
                         System.out.println("Python command: "+python_command);
                    }
                catch(Exception e)
                    {
                            System.out.println("Exception while setting Python Path : "+e.getMessage());
                            System.exit(-1);
                    }
        
        
                ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd "+path_to_python_scripts+" && "+python_command);
                builder.redirectErrorStream(true);
                try
                {
                							String line=null;
                							builder.directory(new File(path_to_python_scripts));
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
    
    public void GenerateReport(String path_to_python_scripts,String path_to_input_excel,String path_to_output_pdf,String input_excel_name,String output_pdf_name)
    {
    	String python_command=path_to_python_scripts+"python.exe RP3.py "+path_to_python_scripts+" "+input_excel_name+" "+path_to_input_excel+" "+path_to_output_pdf+" "+output_pdf_name+" "+"PC Y "+qtestConstants.releaseId+" "+qtestConstants.releaseName+" "+qtestConstants.projectId+" "+qtestConstants.projectName+" "+qtestConstants.cycleId+" "+qtestConstants.cycleName;
    	//String python_command=path_to_python_scripts+"python.exe run.py "+path_to_python_scripts+" "+input_excel_name;
    	try
                    {
                	   
                	   	path_to_python_scripts=Constant.path_to_python_scripts;
                        path_to_python_scripts=URLDecoder.decode(path_to_python_scripts, "UTF-8");
                        System.out.println("Path to python script : "+path_to_python_scripts);
                        python_command=URLDecoder.decode(python_command, "UTF-8");
                         System.out.println("Python command: "+python_command);
                    }
                catch(Exception e)
                    {
                            System.out.println("Exception while setting Python Path : "+e.getMessage());
                            System.exit(-1);
                    }
        
        
                ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd "+path_to_python_scripts+" && "+python_command);
                builder.redirectErrorStream(true);
                try
                {
                							String line=null;
                							builder.directory(new File(path_to_python_scripts));
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
    
    public static void GenerateJunitReport(String path_to_input_excel)
    {
    	String excel_path=Constant.ResultFilePath.substring(0,Constant.ResultFilePath.lastIndexOf("\\"))+"\\";
    	String python_command="python.exe createJUnitReport.py "+ Constant.ProjectName +" DevopsTCs "+ path_to_input_excel +" "+excel_path+"JunitReport.xml";
                   try
                    {               	   
                	   //Constant.WorkSpace=URLDecoder.decode(Constant.WorkSpace, "UTF-8");
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

    public void qTestReportUpdate(String excelpath) throws Exception
    {
    		
        	String Path = "pythonPathtoQtest";
        	String authHeader = "58ef1d93-d545-47d2-9330-c1dae5f41396";
        	String excelFileName = excelpath+"LMX.xlsx";
        	String projectId = "22423";
        	String projectName = "LMX";
        	String parentIdForModuleCreationForTestCases ="731350";//value which has to be changed
        	String parentIdForTestCycle ="279581";//value which has to be changed
        	String parentTypeForTestCycle = "test-cycle";
        	String uploadAttachments = "True";
        	String attachmentFile = excelpath+"LMX.docx";
        	String apiStructureConfig = "structureLMX";
        	String targetReleaseIdForTestCycleCreationInTestExecution ="306325";
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = new Date();
			String Date = dateFormat.format(date); 
			DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
			String Date2 = dateFormat1.format(date); 
			String plannedExecutionStartDate = Date+"T"+Date2+'+'+"00:00";
        	String plannedExecutionEndDate = Date+"T"+Date2+'+'+"00:00";
        	String actualExecutionStartDate= Date+"T"+Date2+'+'+"00:00";
        	String actualExecutionEndDate= Date+"T"+Date2+'+'+"00:00";
        	String deviceType="PC";
        	String path_to_python3=Constant.path_to_python_scripts;
        	String path_to_python_scripts=Constant.path_to_python_scripts;
        	String python_command=path_to_python3+"\\python.exe run.py "+authHeader+" "+excelFileName+" "+projectId+" "+projectName+" "+parentIdForModuleCreationForTestCases+" "+parentIdForTestCycle+" "+parentTypeForTestCycle+" "+uploadAttachments+" "+attachmentFile+" "+apiStructureConfig+" "+targetReleaseIdForTestCycleCreationInTestExecution+" "+ plannedExecutionStartDate+" "+plannedExecutionEndDate+" "+actualExecutionStartDate+" "+actualExecutionEndDate+" "+deviceType;
        	
        	System.out.println("Python command : "+python_command);
        	
        	try
                        {
                    	   
        					python_command=python_command.replaceAll("\\+", "%2b");
                            path_to_python_scripts=URLDecoder.decode(path_to_python_scripts, "UTF-8");
                            System.out.println("Path to python script : "+path_to_python_scripts);
                            python_command=URLDecoder.decode(python_command, "UTF-8");
                             System.out.println("Python command: "+python_command);
                        }
                    catch(Exception e)
                        {
                                System.out.println("Exception while setting Python Path : "+e.getMessage());
                                System.exit(-1);
                        }
            
            
                    ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd "+path_to_python_scripts+" && "+python_command);
                    builder.directory(new File(path_to_python_scripts));
                    builder.redirectErrorStream(true);
                    try
                    {
                    							String line=null;
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
    
}
