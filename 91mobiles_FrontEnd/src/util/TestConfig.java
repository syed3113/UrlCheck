package util;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import testApps.DriverApp;
import testReports.TestReports;


public class TestConfig{


	
	
	
	
	public static String server="smtp.gmail.com";
	
	public static String from = "syed.gaadi@gmail.com";
	public static String password = "nbawpdsgazfbmilj";
	public static String[] to ={"syed@91mobiles.com"};
	public static String subject = "Test Report";
	public static String port="25";
	//public static String username="syed.gaadi@gmail.com";
	public static String subjectattachment = "Selenium3.0 report";
	public static String messageBody ="Monitoring script has been failed on production. Please check the logs report and attached screenshot for analyzing the root cause." +
			" <br><br><b>Link for this validation</b>"+"<br>"+"http://"+TestUtil.Handeler()+"/htmlpages/index"+DriverApp.strDate+".html"+"<br>"+
	"<b>Thanks,</b><br>QA Automation Team";
	
	public static StringBuffer testCaseLink=new StringBuffer();
	//public static String attachmentPath=DriverApp.mailscreenshotpath+".jpeg";
	//public static String attachmentName="Error.jpeg";
	
	
	
	
	
	//"<p> <b>To search for previous validation results</b><br>http://"+TestUtil.Handeler()+":8282"+"/ReportView.jsp </p>"+"<p> <b>Link to the CPV Guide</b><br></p>"//,long totaltimeTaken
	
	public static String getMessageBody(int totalTestCase,int passedTestCase,int failedTestCase,String startDate,String startTime,String endTime) {
		StringBuffer sb=new StringBuffer(); 
		
		sb.append("<html>\n");
		    sb.append("<body bgcolor=aliceblue>");
		    sb.append("<HEAD>\n");
		    sb.append(" <TITLE>Automation Test Results by QA Team</TITLE>\n");
		     sb.append("</HEAD>\n");
		     
		     sb.append("<body>\n");
		   
		   
		     sb.append("<table  border=0 cellspacing=0 cellpadding=0 >\n");
		     sb.append("<tr>\n");
		     
		    //sb.append("<td width=150 align=left><FONT COLOR=#E0E0E0 FACE=Arial SIZE=2.75> <img src=\"C:\\Users\\91mobiles\\Desktop\\91mobiles_logo.png\"  align=right></img></td>\n"); 
		     
		         
		     sb.append("</tr>\n");
		     
		     sb.append("</table>\n");
		     sb.append("<h2 align=center><FONT COLOR=660066 FACE=AriaL SIZE=6><b> Automation Test Results</b></h2>\n");
		     sb.append("<b>Hello QA Team,</b>\n");
		     sb.append("<br></br>\n");
		     sb.append("<b>PFB the daily automation test report summary:</b>");
		     
		     sb.append("<table  border=1 cellspacing=1 cellpadding=1 >\n");
		     sb.append("<tr>\n");
		     sb.append("<td><h4> <FONT COLOR=black FACE=Arial SIZE=4.5> <u>Test Summary</u></h4>\n</td>");
		     	
		           sb.append("<td><h4> <FONT COLOR=black FACE=Arial SIZE=4.5> <u></u></h4>\n</td>");
		           sb.append("<tr>\n");
		           sb.append("<td width=150 align=left ><FONT COLOR=black FACE=Arial SIZE=2.75><b>Execution Date</b></td>\n");
		           sb.append("<td width=150 align=left><FONT COLOR=black FACE=Arial SIZE=2.75><b>"+startDate+"</b></td>\n");
		     sb.append("</tr>\n");
		     sb.append("<tr>\n");
		           
		           sb.append("<td width=150 align=left><FONT COLOR=black FACE=Arial SIZE=2.75><b>Start Time</b></td>\n");

		           sb.append("<td width=150 align=left><FONT COLOR=black FACE=Arial SIZE=2.75><b>"+startTime+"</b></td>\n");
		     sb.append("</tr>\n");
		     sb.append("<tr>\n");
		    // out.newLine();   
		           sb.append("<td width=150 align= left  ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>End Time</b></td>\n");
		           sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"+endTime+"</b></td>\n");
		     sb.append("</tr>\n");
		     sb.append("<tr>\n");   
		     sb.append("<tr>\n");
		    // out.newLine();   
		/*
		 * sb.
		 * append("<td width=150 align= left  bgcolor=red><FONT COLOR=#E0E0E0 FACE= Arial  SIZE=2.75><b>Total Execution Time</b></td>\n"
		 * ); sb.
		 * append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"
		 * +totaltimeTaken+"</b></td>\n"); sb.append("</tr>\n"); sb.append("<tr>\n");
		 */
		   
		    sb.append("<td width=150 align= left  ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>Environment</b></td>\n");
		    sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>91mobiles Live</b></td>\n");
		     sb.append("</tr>\n");
		     sb.append("<tr>\n"); 
		      sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>Total Test Cases:</b></td>\n");
		      sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"+totalTestCase+"</b></td>\n");
		     sb.append("</tr>\n");
		     sb.append("<tr>\n");
		      sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>Passed Test Cases:</b></td>\n");
	           sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"+passedTestCase+"</b></td>\n");
	     sb.append("</tr>\n");
	     sb.append("<tr>\n");
	     sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>Failed Test Cases:</b></td>\n");
         sb.append("<td width=150 align= left ><FONT COLOR=black FACE= Arial  SIZE=2.75><b>"+failedTestCase+"</b></td>\n");
   sb.append("</tr>\n");
		     sb.append("</table>\n");
		     //sb.append("<h4> <FONT COLOR=black FACE= Arial  SIZE=4.5> <u> PFB the failed test cases:</u></h4>\n");
		     sb.append("<br></br>");
		     sb.append("<b> PFB the failed test cases:</b>\n");
		        sb.append("<table  border=1 cellspacing=1 cellpadding=1 width=100%>\n");
		    	sb.append("<tr>\n");
		        sb.append("<td width=10%  align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>Test Script#</b></td>\n");
		        sb.append("<td width=40% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>Test Case Name</b></td>\n");
		        sb.append("<td width=10% align= center ><FONT COLOR=black FACE= Arial  SIZE=2><b>Status</b></td>\n");
		        sb.append("</tr>\n");
		        sb.append(testCaseLink);
		        sb.append("</table>");
		     return sb.toString();
	}
	
	
	public static void addLinkDetail(int testScript,String link,String startime,String endtime,String result) {
		
		testCaseLink.append("<tr>\n");
		testCaseLink.append("<td width=10%  align= center  ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+testScript+"</b></td>\n");

		testCaseLink.append("<td width=40% align= center  ><FONT COLOR=black FACE= Arial  SIZE=2><b>"+link+"</b></td>\n");
		testCaseLink.append("<td width=10% align= center  ><FONT COLOR=red FACE= Arial  SIZE=2><b>"+result+"</b></td>\n");
		
		testCaseLink.append("</tr>\n");
	}
	
	
	
	
	
}
